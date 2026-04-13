package de.champonthis.ghs.server;

import static de.champonthis.ghs.server.TestUtils.assertRevisionViaRest;
import static de.champonthis.ghs.server.TestUtils.buildMinimalCharacter;
import static de.champonthis.ghs.server.TestUtils.connectAndRequestGame;
import static de.champonthis.ghs.server.TestUtils.sendGameUpdate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.champonthis.ghs.server.TestUtils.TestHandler;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ServerTests {

	@LocalServerPort
	private int port;

	private RestTemplate restTemplate;

	private StandardWebSocketClient wsClient;
	private String wsUrl;

	// Each test uses a unique code to avoid cross-test state
	private String gameCode;

	// websocket timeouts
	private final int defaultTimeout = 5;
	private final int shortTimeout = 1;

	@BeforeEach
	void setUp() {
		wsUrl = "ws://localhost:" + port + "/";
		wsClient = new StandardWebSocketClient();
		gameCode = "happy-" + UUID.randomUUID();

		restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:" + port));
		restTemplate.setErrorHandler(new org.springframework.web.client.DefaultResponseErrorHandler() {
			@Override
			public boolean hasError(org.springframework.http.client.ClientHttpResponse response) {
				return false;
			}
		});
	}

	@AfterEach
	void tearDown() {
	}

	/**
	 * The core client loop: connect, get game, send several updates with
	 * increasing revisions. Each update must be accepted and the
	 * final state must reflect the last write.
	 */
	@Test
	void sequentialGameUpdatesAreAccepted() throws Exception {
		TestUtils.TestHandler handler = connectAndRequestGame(gameCode, wsClient, wsUrl);

		JsonObject game = handler.waitForType("game", defaultTimeout);
		assertThat(game).isNotNull();

		JsonObject payload = game.getAsJsonObject("payload").deepCopy();
		long revision = payload.get("revision").getAsLong();

		// Send three sequential updates (sender does not receive its own broadcast)
		for (int i = 1; i <= 3; i++) {
			payload.addProperty("revision", revision + i);
			sendGameUpdate(handler.session, gameCode, payload);
			Thread.sleep(100);
		}

		// Use REST GET (synchronous) to verify the persisted revision
		assertRevisionViaRest(gameCode, revision + 3, restTemplate);

		handler.session.close();
	}

	/**
	 * When a client sends a game payload whose revision equals the server's current
	 * revision, the server treats it as a time-sync (ping): it updates playSeconds
	 * but does not store the payload's other fields, and does not advance the
	 * revision.
	 */
	@Test
	void sameRevisionUpdateOnlyRefreshesPlaySeconds() throws Exception {
		TestHandler handler = connectAndRequestGame(gameCode, wsClient, wsUrl);

		JsonObject game = handler.waitForType("game", defaultTimeout);
		assertThat(game).isNotNull();

		JsonObject payload = game.getAsJsonObject("payload").deepCopy();
		long revision = payload.get("revision").getAsLong();
		long originalPlaySeconds = payload.get("playSeconds").getAsLong();
		int originalRound = payload.get("round").getAsInt();

		// Send with the same revision, a changed playSeconds, and a changed round
		long updatedPlaySeconds = originalPlaySeconds + 60;
		payload.addProperty("revision", revision); // same — ping
		payload.addProperty("playSeconds", updatedPlaySeconds);
		payload.addProperty("round", originalRound + 5); // must be ignored
		sendGameUpdate(handler.session, gameCode, payload);

		// Wait for the server to process the ping, then verify via REST GET
		// (synchronous)
		Thread.sleep(300);

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		ResponseEntity<String> resp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertNotNull(resp.getBody());
		JsonObject updatedPayload = JsonParser.parseString(resp.getBody()).getAsJsonObject();
		assertThat(updatedPayload.get("revision").getAsLong())
				.as("Revision must not advance for a ping update")
				.isEqualTo(revision);
		assertThat(updatedPayload.get("playSeconds").getAsLong())
				.as("playSeconds must be refreshed by the ping")
				.isEqualTo(updatedPlaySeconds);
		assertThat(updatedPayload.get("round").getAsInt())
				.as("Other fields must not change for a ping update")
				.isEqualTo(originalRound);

		handler.session.close();
	}

	/**
	 * Disconnect a client, reconnect with the same game code, and verify the
	 * server still returns the correct persisted state.
	 */
	@Test
	void gameStateIsPersistedAcrossDisconnect() throws Exception {
		TestHandler handler = connectAndRequestGame(gameCode, wsClient, wsUrl);

		JsonObject game = handler.waitForType("game", defaultTimeout);
		assertThat(game).isNotNull();

		JsonObject payload = game.getAsJsonObject("payload").deepCopy();
		long revision = payload.get("revision").getAsLong();
		int round = 7;
		int level = 4;
		String edition = "gh";
		payload.addProperty("revision", revision + 1);
		payload.addProperty("round", round);
		payload.addProperty("level", level);
		payload.addProperty("edition", edition);
		sendGameUpdate(handler.session, gameCode, payload);
		Thread.sleep(200);

		// Disconnect and verify via REST (no session state involved, purely DB)
		handler.session.close();
		Thread.sleep(300);

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		ResponseEntity<String> resp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertNotNull(resp.getBody());
		JsonObject persisted = JsonParser.parseString(resp.getBody()).getAsJsonObject();
		assertThat(persisted.get("revision").getAsLong()).isEqualTo(revision + 1);
		assertThat(persisted.get("round").getAsInt()).isEqualTo(round);
		assertThat(persisted.get("level").getAsInt()).isEqualTo(level);
		assertThat(persisted.get("edition").getAsString()).isEqualTo(edition);
	}

	/**
	 * When client A sends a game update, client B (connected to the same game) must
	 * receive it.
	 */
	@Test
	void gameUpdateIsBroadcastToAllClients() throws Exception {
		TestHandler clientA = connectAndRequestGame(gameCode, wsClient, wsUrl);
		JsonObject gameA = clientA.waitForType("game", defaultTimeout);
		assertThat(gameA).isNotNull();

		TestHandler clientB = connectAndRequestGame(gameCode, wsClient, wsUrl);
		clientB.waitForType("game", defaultTimeout); // discard initial state

		// Client B sends an update
		JsonObject payload = gameA.getAsJsonObject("payload").deepCopy();
		long revision = payload.get("revision").getAsLong();
		int round = 5;
		payload.addProperty("revision", revision + 1);
		payload.addProperty("round", round);
		sendGameUpdate(clientB.session, gameCode, payload);

		// Client A must receive the broadcast (skip any "requestUpdate" message)
		JsonObject broadcast = clientA.waitForType("game", defaultTimeout);
		assertThat(broadcast).isNotNull();
		assertThat(broadcast.getAsJsonObject("payload").get("revision").getAsLong())
				.isEqualTo(revision + 1);
		assertThat(broadcast.getAsJsonObject("payload").get("round").getAsInt())
				.isEqualTo(round);

		clientA.session.close();
		clientB.session.close();
	}

	/**
	 * A full-access code creates a restricted child code that may only modify
	 * the round/state. Attempting to change the scenario via the restricted code
	 * must be rejected with an error.
	 */
	@Test
	void restrictedCodeCannotUpdateForbiddenFields() throws Exception {
		String restrictedCode = "restricted-" + UUID.randomUUID();

		// Full-access client creates the game
		TestHandler admin = connectAndRequestGame(gameCode, wsClient, wsUrl);
		JsonObject gameMsg = admin.waitForType("game", defaultTimeout);
		assertThat(gameMsg).isNotNull();

		// Admin issues a restricted permission code (round=true, scenario=false)
		JsonObject permissionsPayload = new JsonObject();
		permissionsPayload.addProperty("code", restrictedCode);
		JsonObject permissions = new JsonObject();
		permissions.addProperty("round", true);
		permissions.addProperty("scenario", false);
		permissions.addProperty("characters", true);
		permissions.addProperty("monsters", true);
		permissions.addProperty("elements", true);
		permissions.addProperty("lootDeck", true);
		permissions.addProperty("level", true);
		permissions.addProperty("attackModifiers", true);
		permissions.addProperty("party", true);
		permissionsPayload.add("permissions", permissions);

		JsonObject permMsg = new JsonObject();
		permMsg.addProperty("type", "permissions");
		permMsg.addProperty("code", gameCode);
		permMsg.add("payload", permissionsPayload);
		admin.session.sendMessage(new TextMessage(permMsg.toString()));
		Thread.sleep(200);

		// Restricted client connects and tries to change the scenario
		TestHandler restricted = connectAndRequestGame(restrictedCode, wsClient, wsUrl);
		JsonObject restrictedGame = restricted.waitForType("game", defaultTimeout);
		assertThat(restrictedGame).isNotNull();

		JsonObject restrictedPayload = restrictedGame.getAsJsonObject("payload").deepCopy();
		long revision = restrictedPayload.get("revision").getAsLong();
		restrictedPayload.addProperty("revision", revision + 1);

		// Set a non-null scenario object to trigger the scenario-permission check
		JsonObject fakeScenario = new JsonObject();
		fakeScenario.addProperty("index", 1);
		fakeScenario.addProperty("edition", "gh");
		restrictedPayload.add("scenario", fakeScenario);

		sendGameUpdate(restricted.session, restrictedCode, restrictedPayload);

		JsonObject errorResponse = restricted.waitForType("error", shortTimeout);
		assertThat(errorResponse).as("Restricted client must receive a permission error").isNotNull();
		assertThat(errorResponse.get("message").getAsString()).contains("Permission");

		admin.session.close();
		restricted.session.close();
	}

	/**
	 * A client can write settings and read them back.
	 */
	@Test
	void settingsCanBeWrittenAndRead() throws Exception {
		TestHandler handler = connectAndRequestGame(gameCode, wsClient, wsUrl);
		handler.waitForType("game", defaultTimeout);

		// Write settings using real field names from the Settings model
		JsonObject settingsPayload = new JsonObject();
		settingsPayload.addProperty("battleGoals", true); // default is false
		settingsPayload.addProperty("locale", "de"); // default is "en"

		JsonObject settingsMsg = new JsonObject();
		settingsMsg.addProperty("type", "settings");
		settingsMsg.addProperty("code", gameCode);
		settingsMsg.add("payload", settingsPayload);
		handler.session.sendMessage(new TextMessage(settingsMsg.toString()));
		Thread.sleep(200);

		// Read them back
		JsonObject requestSettings = new JsonObject();
		requestSettings.addProperty("type", "request-settings");
		requestSettings.addProperty("code", gameCode);
		handler.session.sendMessage(new TextMessage(requestSettings.toString()));

		JsonObject settingsResponse = handler.waitForType("settings", defaultTimeout);
		assertThat(settingsResponse).isNotNull();
		assertThat(settingsResponse.getAsJsonObject("payload").get("battleGoals").getAsBoolean())
				.isTrue();
		assertThat(settingsResponse.getAsJsonObject("payload").get("locale").getAsString())
				.isEqualTo("de");

		handler.session.close();
	}

	/**
	 * The REST API path: POST /game with incrementing revisions must be accepted.
	 * This verifies the @Version change doesn't disrupt normal sequential writes
	 * where each client always reads-then-writes without concurrent contention.
	 */
	@Test
	void restSequentialUpdatesAreAccepted() throws Exception {
		// Create the game via WebSocket (so revision is correctly initialized)
		TestHandler wsHandler = connectAndRequestGame(gameCode, wsClient, wsUrl);
		JsonObject wsGame = wsHandler.waitForType("game", defaultTimeout);
		assertThat(wsGame).isNotNull();
		wsHandler.session.close();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		headers.setContentType(MediaType.APPLICATION_JSON);

		// GET the current state
		ResponseEntity<String> getResp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(getResp.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertNotNull(getResp.getBody());
		JsonObject game = JsonParser.parseString(getResp.getBody()).getAsJsonObject();
		long revision = game.get("revision").getAsLong();

		// POST three sequential updates
		for (int i = 1; i <= 3; i++) {
			game.addProperty("revision", revision + i);
			ResponseEntity<String> postResp = restTemplate.exchange(
					"/game", HttpMethod.POST,
					new HttpEntity<>(game.toString(), headers), String.class);
			assertThat(postResp.getStatusCode())
					.as("Sequential REST update %d should succeed", i)
					.isEqualTo(HttpStatus.OK);
		}

		// Final GET must reflect last revision
		ResponseEntity<String> finalGet = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(finalGet.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertNotNull(finalGet.getBody());
		assertThat(JsonParser.parseString(finalGet.getBody())
				.getAsJsonObject().get("revision").getAsLong())
				.isEqualTo(revision + 3);
	}

	/**
	 * Sends a game update with specific primitive field values via WebSocket and
	 * verifies that those exact values are returned by a subsequent REST GET.
	 */
	@Test
	void wsGameFieldsArePersisted() throws Exception {
		TestHandler handler = connectAndRequestGame(gameCode, wsClient, wsUrl);

		JsonObject game = handler.waitForType("game", defaultTimeout);
		assertThat(game).isNotNull();

		JsonObject payload = game.getAsJsonObject("payload").deepCopy();
		long revision = payload.get("revision").getAsLong();
		int round = 5;
		int level = 3;
		boolean solo = true;
		int playerCount = 4;
		String edition = "gh";

		payload.addProperty("revision", revision + 1);
		payload.addProperty("round", round);
		payload.addProperty("level", level);
		payload.addProperty("solo", solo);
		payload.addProperty("playerCount", playerCount);
		payload.addProperty("edition", edition);
		sendGameUpdate(handler.session, gameCode, payload);

		Thread.sleep(200);

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		ResponseEntity<String> resp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertNotNull(resp.getBody());
		JsonObject persisted = JsonParser.parseString(resp.getBody()).getAsJsonObject();
		assertThat(persisted.get("revision").getAsLong()).isEqualTo(revision + 1);
		assertThat(persisted.get("round").getAsInt()).isEqualTo(round);
		assertThat(persisted.get("level").getAsInt()).isEqualTo(level);
		assertThat(persisted.get("solo").getAsBoolean()).isEqualTo(solo);
		assertThat(persisted.get("playerCount").getAsInt()).isEqualTo(playerCount);
		assertThat(persisted.get("edition").getAsString()).isEqualTo(edition);

		handler.session.close();
	}

	/**
	 * Posts a game update with specific primitive field values via REST and
	 * verifies that those exact values are returned by a subsequent REST GET.
	 * This is the REST-path equivalent of wsGameFieldsArePersisted, ensuring
	 * both write paths exercise the same persistence logic correctly.
	 */
	@Test
	void restGameFieldsArePersisted() throws Exception {
		// Create the game via WebSocket so revision is correctly initialized
		TestHandler wsHandler = connectAndRequestGame(gameCode, wsClient, wsUrl);
		wsHandler.waitForType("game", defaultTimeout);
		wsHandler.session.close();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<String> getResp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(getResp.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertNotNull(getResp.getBody());
		JsonObject game = JsonParser.parseString(getResp.getBody()).getAsJsonObject();
		long revision = game.get("revision").getAsLong();
		int round = 7;
		int level = 2;
		boolean solo = true;
		int playerCount = 3;
		String edition = "jotl";

		game.addProperty("revision", revision + 1);
		game.addProperty("round", round);
		game.addProperty("level", level);
		game.addProperty("solo", solo);
		game.addProperty("playerCount", playerCount);
		game.addProperty("edition", edition);

		ResponseEntity<String> postResp = restTemplate.exchange(
				"/game", HttpMethod.POST,
				new HttpEntity<>(game.toString(), headers), String.class);
		assertThat(postResp.getStatusCode()).isEqualTo(HttpStatus.OK);

		ResponseEntity<String> finalGet = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(finalGet.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertNotNull(finalGet.getBody());
		JsonObject persisted = JsonParser.parseString(finalGet.getBody()).getAsJsonObject();
		assertThat(persisted.get("revision").getAsLong()).isEqualTo(revision + 1);
		assertThat(persisted.get("round").getAsInt()).isEqualTo(round);
		assertThat(persisted.get("level").getAsInt()).isEqualTo(level);
		assertThat(persisted.get("solo").getAsBoolean()).isEqualTo(solo);
		assertThat(persisted.get("playerCount").getAsInt()).isEqualTo(playerCount);
		assertThat(persisted.get("edition").getAsString()).isEqualTo(edition);
	}

	/**
	 * A ping message must elicit a pong response on the same session, containing
	 * "message":"pong" and a "serverVersion" field.
	 */
	@Test
	void pingReturnsPong() throws Exception {
		TestHandler handler = connectAndRequestGame(gameCode, wsClient, wsUrl);
		handler.waitForType("game", defaultTimeout);

		JsonObject ping = new JsonObject();
		ping.addProperty("type", "ping");
		ping.addProperty("code", gameCode);
		handler.session.sendMessage(new TextMessage(ping.toString()));

		JsonObject pong = handler.waitForType("ping", defaultTimeout);
		assertThat(pong).isNotNull();
		assertThat(pong.get("message").getAsString()).isEqualTo("pong");
		assertThat(pong.has("serverVersion")).isTrue();

		handler.session.close();
	}

	/**
	 * Simulates the client-side undo flow: set some fields, advance them, then
	 * send the previous state as a game-undo. Verifies that:
	 * - the state is reverted to the pre-change values
	 * - the broadcast arrives on other clients with type "game-undo" (not "game")
	 * - the undoinfo field is forwarded in the broadcast
	 * Note: the server does not implement undo logic itself — it stores whatever
	 * payload arrives and re-broadcasts it with the "game-undo" type. The client
	 * is responsible for sending the correct previous state.
	 */
	@Test
	void gameUndoRevertsStateAndBroadcastsWithCorrectType() throws Exception {
		TestHandler clientA = connectAndRequestGame(gameCode, wsClient, wsUrl);
		clientA.waitForType("game", defaultTimeout);

		TestHandler clientB = connectAndRequestGame(gameCode, wsClient, wsUrl);
		JsonObject initial = clientB.waitForType("game", defaultTimeout);
		assertThat(initial).isNotNull();

		JsonObject base = initial.getAsJsonObject("payload").deepCopy();
		long revision = base.get("revision").getAsLong();
		int round1 = 5;
		int level1 = 3;
		int round2 = 8;
		int level2 = 6;

		// Update 1: set round1/level1 — this becomes the "snapshot" to restore
		JsonObject update1 = base.deepCopy();
		update1.addProperty("revision", revision + 1);
		update1.addProperty("round", round1);
		update1.addProperty("level", level1);
		sendGameUpdate(clientB.session, gameCode, update1);
		Thread.sleep(100);

		// Update 2: advance to round2/level2
		JsonObject update2 = base.deepCopy();
		update2.addProperty("revision", revision + 2);
		update2.addProperty("round", round2);
		update2.addProperty("level", level2);
		sendGameUpdate(clientB.session, gameCode, update2);
		Thread.sleep(100);

		// Verify update 2 is current
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		ResponseEntity<String> afterUpdate2 = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(afterUpdate2.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertNotNull(afterUpdate2.getBody());
		JsonObject state2 = JsonParser.parseString(afterUpdate2.getBody()).getAsJsonObject();
		assertThat(state2.get("round").getAsInt()).isEqualTo(round2);
		assertThat(state2.get("level").getAsInt()).isEqualTo(level2);

		// Undo: send update1's state with a new revision
		JsonObject undoPayload = update1.deepCopy();
		undoPayload.addProperty("revision", revision + 3);

		JsonArray undoInfo = new JsonArray();
		undoInfo.add("serverSync");
		undoInfo.add("undo");

		JsonObject undoMsg = new JsonObject();
		undoMsg.addProperty("type", "game-undo");
		undoMsg.addProperty("code", gameCode);
		undoMsg.add("payload", undoPayload);
		undoMsg.add("undoinfo", undoInfo);
		clientB.session.sendMessage(new TextMessage(undoMsg.toString()));

		// clientA must receive the undo broadcast with the correct type and reverted
		// values
		JsonObject broadcast = clientA.waitForType("game-undo", defaultTimeout);
		assertThat(broadcast).as("Client A must receive a game-undo broadcast").isNotNull();
		assertThat(broadcast.getAsJsonArray("undoinfo").get(1).getAsString()).isEqualTo("undo");
		assertThat(broadcast.getAsJsonObject("payload").get("round").getAsInt()).isEqualTo(round1);
		assertThat(broadcast.getAsJsonObject("payload").get("level").getAsInt()).isEqualTo(level1);

		// Verify the reverted state is persisted
		ResponseEntity<String> afterUndo = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(afterUndo.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertNotNull(afterUndo.getBody());
		JsonObject reverted = JsonParser.parseString(afterUndo.getBody()).getAsJsonObject();
		assertThat(reverted.get("revision").getAsLong()).isEqualTo(revision + 3);
		assertThat(reverted.get("round").getAsInt()).as("round must be reverted by undo").isEqualTo(round1);
		assertThat(reverted.get("level").getAsInt()).as("level must be reverted by undo").isEqualTo(level1);

		clientA.session.close();
		clientB.session.close();
	}

	/**
	 * Simulates the client-side redo flow: set some fields, undo them, then redo
	 * to restore the undone state. Verifies that:
	 * - the state is restored to the post-change values after redo
	 * - the broadcast arrives on other clients with type "game-redo" (not "game")
	 * - the undoinfo field is forwarded in the broadcast
	 * Like undo, the server is a pass-through — the client sends the "future" state
	 * as the redo payload.
	 */
	@Test
	void gameRedoRestoresStateAndBroadcastsWithCorrectType() throws Exception {
		TestHandler clientA = connectAndRequestGame(gameCode, wsClient, wsUrl);
		clientA.waitForType("game", defaultTimeout);

		TestHandler clientB = connectAndRequestGame(gameCode, wsClient, wsUrl);
		JsonObject initial = clientB.waitForType("game", defaultTimeout);
		assertThat(initial).isNotNull();

		JsonObject base = initial.getAsJsonObject("payload").deepCopy();
		long revision = base.get("revision").getAsLong();
		int baseRound = base.get("round").getAsInt();
		int baseLevel = base.get("level").getAsInt();
		int round1 = 5;
		int level1 = 3;

		// Update 1: set round1/level1
		JsonObject update1 = base.deepCopy();
		update1.addProperty("revision", revision + 1);
		update1.addProperty("round", round1);
		update1.addProperty("level", level1);
		sendGameUpdate(clientB.session, gameCode, update1);
		Thread.sleep(100);

		// Undo: revert to base state
		JsonObject undoPayload = base.deepCopy();
		undoPayload.addProperty("revision", revision + 2);

		JsonObject undoMsg = new JsonObject();
		undoMsg.addProperty("type", "game-undo");
		undoMsg.addProperty("code", gameCode);
		undoMsg.add("payload", undoPayload);
		clientB.session.sendMessage(new TextMessage(undoMsg.toString()));
		Thread.sleep(100);

		// Verify undo is current
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		ResponseEntity<String> afterUndo = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(afterUndo.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertNotNull(afterUndo.getBody());
		JsonObject stateAfterUndo = JsonParser.parseString(afterUndo.getBody()).getAsJsonObject();
		assertThat(stateAfterUndo.get("round").getAsInt()).isEqualTo(baseRound);
		assertThat(stateAfterUndo.get("level").getAsInt()).isEqualTo(baseLevel);

		// Redo: re-apply update1's state
		JsonObject redoPayload = update1.deepCopy();
		redoPayload.addProperty("revision", revision + 3);

		JsonArray redoInfo = new JsonArray();
		redoInfo.add("serverSync");
		redoInfo.add("redo");

		JsonObject redoMsg = new JsonObject();
		redoMsg.addProperty("type", "game-redo");
		redoMsg.addProperty("code", gameCode);
		redoMsg.add("payload", redoPayload);
		redoMsg.add("undoinfo", redoInfo);
		clientB.session.sendMessage(new TextMessage(redoMsg.toString()));

		// clientA must receive the redo broadcast with the correct type and restored
		// values
		JsonObject broadcast = clientA.waitForType("game-redo", defaultTimeout);
		assertThat(broadcast).as("Client A must receive a game-redo broadcast").isNotNull();
		assertThat(broadcast.getAsJsonArray("undoinfo").get(1).getAsString()).isEqualTo("redo");
		assertThat(broadcast.getAsJsonObject("payload").get("round").getAsInt()).isEqualTo(round1);
		assertThat(broadcast.getAsJsonObject("payload").get("level").getAsInt()).isEqualTo(level1);

		// Verify the restored state is persisted
		ResponseEntity<String> afterRedo = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(afterRedo.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertNotNull(afterRedo.getBody());
		JsonObject restored = JsonParser.parseString(afterRedo.getBody()).getAsJsonObject();
		assertThat(restored.get("revision").getAsLong()).isEqualTo(revision + 3);
		assertThat(restored.get("round").getAsInt()).as("round must be restored by redo").isEqualTo(round1);
		assertThat(restored.get("level").getAsInt()).as("level must be restored by redo").isEqualTo(level1);

		clientA.session.close();
		clientB.session.close();
	}

	/**
	 * The "game-update" message type overwrites playSeconds but ignores all other
	 * payload fields and never advances the revision. This is a distinct server
	 * code path from the same-revision ping handled by the "game" type.
	 */
	@Test
	void gameUpdateTypeOnlySyncsPlaySeconds() throws Exception {
		TestHandler handler = connectAndRequestGame(gameCode, wsClient, wsUrl);
		JsonObject initial = handler.waitForType("game", defaultTimeout);
		assertThat(initial).isNotNull();

		JsonObject payload = initial.getAsJsonObject("payload").deepCopy();
		long revision = payload.get("revision").getAsLong();
		long originalPlaySeconds = payload.get("playSeconds").getAsLong();
		int originalRound = 0;
		int originalLevel = 1;
		int newPlaySeconds = 120;
		int newRound = 99;
		int newLevel = 9;

		// Change several fields — only playSeconds must take effect
		long updatedPlaySeconds = originalPlaySeconds + newPlaySeconds;
		payload.addProperty("round", newRound);
		payload.addProperty("level", newLevel);
		payload.addProperty("playSeconds", updatedPlaySeconds);

		JsonObject msg = new JsonObject();
		msg.addProperty("type", "game-update");
		msg.addProperty("code", gameCode);
		msg.add("payload", payload);
		handler.session.sendMessage(new TextMessage(msg.toString()));

		Thread.sleep(200);

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		ResponseEntity<String> resp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertNotNull(resp.getBody());
		JsonObject persisted = JsonParser.parseString(resp.getBody()).getAsJsonObject();
		assertThat(persisted.get("revision").getAsLong()).as("revision must not advance").isEqualTo(revision);
		assertThat(persisted.get("round").getAsInt()).as("round must not change").isEqualTo(originalRound);
		assertThat(persisted.get("level").getAsInt()).as("level must not change").isEqualTo(originalLevel);
		assertThat(persisted.get("playSeconds").getAsLong()).as("playSeconds must be updated")
				.isEqualTo(updatedPlaySeconds);

		handler.session.close();
	}

	/**
	 * When client A sends a "settings" update, all other clients connected to the
	 * same game must receive a "settings" push with the new values.
	 */
	@Test
	void settingsUpdateIsBroadcastToOtherClients() throws Exception {
		TestHandler clientA = connectAndRequestGame(gameCode, wsClient, wsUrl);
		clientA.waitForType("game", defaultTimeout);

		TestHandler clientB = connectAndRequestGame(gameCode, wsClient, wsUrl);
		clientB.waitForType("game", defaultTimeout);

		JsonObject settingsPayload = new JsonObject();
		settingsPayload.addProperty("battleGoals", true);
		settingsPayload.addProperty("locale", "fr");

		JsonObject settingsMsg = new JsonObject();
		settingsMsg.addProperty("type", "settings");
		settingsMsg.addProperty("code", gameCode);
		settingsMsg.add("payload", settingsPayload);
		clientA.session.sendMessage(new TextMessage(settingsMsg.toString()));

		JsonObject broadcast = clientB.waitForType("settings", defaultTimeout);
		assertThat(broadcast).as("Client B must receive the settings broadcast").isNotNull();
		assertThat(broadcast.getAsJsonObject("payload").get("battleGoals").getAsBoolean()).isTrue();
		assertThat(broadcast.getAsJsonObject("payload").get("locale").getAsString()).isEqualTo("fr");

		clientA.session.close();
		clientB.session.close();
	}

	/**
	 * A root (unrestricted) game code gets a null permissions payload on
	 * request-game. This verifies the permissions message is sent and contains the
	 * expected shape for a root code.
	 */
	@Test
	void requestGameReturnsNullPermissionsForRootCode() throws Exception {
		TestHandler handler = connectAndRequestGame(gameCode, wsClient, wsUrl);
		handler.waitForType("game", defaultTimeout);

		JsonObject permissionsMsg = handler.waitForType("permissions", defaultTimeout);
		assertThat(permissionsMsg).isNotNull();
		assertThat(!permissionsMsg.has("payload") || permissionsMsg.get("payload").isJsonNull())
				.as("Root code must have null or absent permissions payload")
				.isTrue();

		handler.session.close();
	}

	/**
	 * A restricted game code gets its Permissions object back in the permissions
	 * payload on request-game, matching what was set by the admin.
	 */
	@Test
	void requestGameReturnsPermissionsForRestrictedCode() throws Exception {
		String restrictedCode = "restricted-" + UUID.randomUUID();

		TestHandler admin = connectAndRequestGame(gameCode, wsClient, wsUrl);
		admin.waitForType("game", defaultTimeout);
		admin.waitForType("permissions", defaultTimeout);

		JsonObject permissionsPayload = new JsonObject();
		permissionsPayload.addProperty("code", restrictedCode);
		JsonObject permissions = new JsonObject();
		permissions.addProperty("round", true);
		permissions.addProperty("scenario", false);
		permissions.addProperty("characters", false);
		permissions.addProperty("monsters", false);
		permissions.addProperty("elements", false);
		permissions.addProperty("lootDeck", false);
		permissions.addProperty("level", false);
		permissions.addProperty("attackModifiers", false);
		permissions.addProperty("party", false);
		permissionsPayload.add("permissions", permissions);

		JsonObject permMsg = new JsonObject();
		permMsg.addProperty("type", "permissions");
		permMsg.addProperty("code", gameCode);
		permMsg.add("payload", permissionsPayload);
		admin.session.sendMessage(new TextMessage(permMsg.toString()));
		Thread.sleep(200);

		TestHandler restricted = connectAndRequestGame(restrictedCode, wsClient, wsUrl);
		restricted.waitForType("game", defaultTimeout);

		JsonObject permissionsMsg = restricted.waitForType("permissions", defaultTimeout);
		assertThat(permissionsMsg).isNotNull();
		assertThat(permissionsMsg.get("payload").isJsonNull())
				.as("Restricted code must have a non-null permissions payload")
				.isFalse();

		JsonObject receivedPerms = permissionsMsg.getAsJsonObject("payload");
		assertThat(receivedPerms.get("round").getAsBoolean()).isTrue();
		assertThat(receivedPerms.get("scenario").getAsBoolean()).isFalse();

		admin.session.close();
		restricted.session.close();
	}

	/**
	 * The companion to restrictedCodeCannotUpdateForbiddenFields: a restricted code
	 * with round=true must be able to send an update that changes only the round
	 * field without receiving a permission error.
	 */
	@Test
	void restrictedCodeCanUpdateAllowedFields() throws Exception {
		String restrictedCode = "restricted-allowed-" + UUID.randomUUID();

		TestHandler admin = connectAndRequestGame(gameCode, wsClient, wsUrl);
		admin.waitForType("game", defaultTimeout);
		admin.waitForType("permissions", defaultTimeout);

		JsonObject permissionsPayload = new JsonObject();
		permissionsPayload.addProperty("code", restrictedCode);
		JsonObject permissions = new JsonObject();
		permissions.addProperty("round", true);
		permissions.addProperty("scenario", false);
		permissions.addProperty("characters", false);
		permissions.addProperty("monsters", false);
		permissions.addProperty("elements", false);
		permissions.addProperty("lootDeck", false);
		permissions.addProperty("level", false);
		permissions.addProperty("attackModifiers", false);
		permissions.addProperty("party", false);
		permissionsPayload.add("permissions", permissions);

		JsonObject permMsg = new JsonObject();
		permMsg.addProperty("type", "permissions");
		permMsg.addProperty("code", gameCode);
		permMsg.add("payload", permissionsPayload);
		admin.session.sendMessage(new TextMessage(permMsg.toString()));
		Thread.sleep(200);

		TestHandler restricted = connectAndRequestGame(restrictedCode, wsClient, wsUrl);
		JsonObject restrictedGame = restricted.waitForType("game", defaultTimeout);
		assertThat(restrictedGame).isNotNull();
		restricted.waitForType("permissions", defaultTimeout);

		JsonObject payload = restrictedGame.getAsJsonObject("payload").deepCopy();
		long revision = payload.get("revision").getAsLong();
		payload.addProperty("revision", revision + 1);
		payload.addProperty("round", 3); // allowed by permissions

		sendGameUpdate(restricted.session, restrictedCode, payload);

		// Must NOT receive a permission error
		JsonObject error = restricted.waitForType("error", shortTimeout);
		assertThat(error).as("Restricted code with round=true must not get a permission error").isNull();

		assertRevisionViaRest(gameCode, revision + 1, restTemplate);

		admin.session.close();
		restricted.session.close();
	}

	/**
	 * POST /game?silent=true must persist the update but must NOT push a "game"
	 * broadcast to connected WebSocket clients.
	 */
	@Test
	void restSilentUpdateDoesNotBroadcast() throws Exception {
		TestHandler listener = connectAndRequestGame(gameCode, wsClient, wsUrl);
		listener.waitForType("game", defaultTimeout);

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<String> getResp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(getResp.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertNotNull(getResp.getBody());
		JsonObject game = JsonParser.parseString(getResp.getBody()).getAsJsonObject();
		long revision = game.get("revision").getAsLong();
		game.addProperty("revision", revision + 1);
		game.addProperty("round", 4);

		ResponseEntity<String> postResp = restTemplate.exchange(
				"/game?silent=true", HttpMethod.POST,
				new HttpEntity<>(game.toString(), headers), String.class);
		assertThat(postResp.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Listener must NOT receive a broadcast
		JsonObject broadcast = listener.waitForType("game", shortTimeout);
		assertThat(broadcast).as("silent=true must not broadcast to WS clients").isNull();

		// But the update must be persisted
		assertRevisionViaRest(gameCode, revision + 1, restTemplate);

		listener.session.close();
	}

	/**
	 * POST /game/initiative must update the named character's initiative, advance
	 * the game revision by 1, and persist the change.
	 */
	@Test
	void restInitiativeUpdatesCharacterAndAdvancesRevision() throws Exception {
		TestHandler wsHandler = connectAndRequestGame(gameCode, wsClient, wsUrl);
		wsHandler.waitForType("game", defaultTimeout);
		wsHandler.session.close();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<String> getResp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(getResp.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertNotNull(getResp.getBody());
		JsonObject game = JsonParser.parseString(getResp.getBody()).getAsJsonObject();
		long revision = game.get("revision").getAsLong();

		// Add a character and save
		game.getAsJsonArray("characters").add(buildMinimalCharacter());
		game.addProperty("revision", revision + 1);

		ResponseEntity<String> setupResp = restTemplate.exchange(
				"/game", HttpMethod.POST,
				new HttpEntity<>(game.toString(), headers), String.class);
		assertThat(setupResp.getStatusCode()).isEqualTo(HttpStatus.OK);

		// POST initiative for player number 1
		JsonObject initiativePayload = new JsonObject();
		initiativePayload.addProperty("playerNumber", 1);
		initiativePayload.addProperty("initiative", 25);

		ResponseEntity<String> initResp = restTemplate.exchange(
				"/game/initiative", HttpMethod.POST,
				new HttpEntity<>(initiativePayload.toString(), headers), String.class);
		assertThat(initResp.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Verify revision advanced and initiative was persisted
		ResponseEntity<String> finalGet = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(finalGet.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertNotNull(finalGet.getBody());
		JsonObject persisted = JsonParser.parseString(finalGet.getBody()).getAsJsonObject();
		assertThat(persisted.get("revision").getAsLong()).isEqualTo(revision + 2);
		assertThat(persisted.getAsJsonArray("characters").get(0).getAsJsonObject()
				.get("initiative").getAsInt()).isEqualTo(25);
	}

	/**
	 * A POST /game with a revision lower than the server's current revision must be
	 * rejected with 400 Bad Request.
	 */
	@Test
	void restStaleRevisionIsRejected() throws Exception {
		TestHandler wsHandler = connectAndRequestGame(gameCode, wsClient, wsUrl);
		wsHandler.waitForType("game", defaultTimeout);
		wsHandler.session.close();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<String> getResp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		JsonObject game = JsonParser.parseString(getResp.getBody()).getAsJsonObject();
		long revision = game.get("revision").getAsLong();

		// Advance the server's revision
		game.addProperty("revision", revision + 1);
		restTemplate.exchange("/game", HttpMethod.POST,
				new HttpEntity<>(game.toString(), headers), String.class);

		// Now POST with the old (stale) revision
		game.addProperty("revision", revision);
		ResponseEntity<String> staleResp = restTemplate.exchange(
				"/game", HttpMethod.POST,
				new HttpEntity<>(game.toString(), headers), String.class);
		assertThat(staleResp.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}

	/**
	 * The backup endpoint requires ghs-server.backup.path to be set. Without it,
	 * any POST /backup/{filename} must return 501 Not Implemented.
	 */
	@Test
	void backupEndpointReturnsNotImplementedWithoutConfig() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<String> resp = restTemplate.exchange(
				"/backup/test.json", HttpMethod.POST,
				new HttpEntity<>("{}", headers), String.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * A WS game update whose revision is lower than the server's current revision
	 * must produce an error message back to the sending session.
	 */
	@Test
	void wsStaleRevisionProducesError() throws Exception {
		TestHandler handler = connectAndRequestGame(gameCode, wsClient, wsUrl);
		JsonObject game = handler.waitForType("game", defaultTimeout);
		assertThat(game).isNotNull();

		JsonObject payload = game.getAsJsonObject("payload").deepCopy();
		long revision = payload.get("revision").getAsLong();

		// Advance the server revision via a second WS client so we can still receive
		// the error on the first client
		TestHandler advancer = connectAndRequestGame(gameCode, wsClient, wsUrl);
		advancer.waitForType("game", defaultTimeout);
		JsonObject advPayload = payload.deepCopy();
		advPayload.addProperty("revision", revision + 1);
		sendGameUpdate(advancer.session, gameCode, advPayload);
		Thread.sleep(150);
		advancer.session.close();

		// Drain the requestUpdate that handler received when advancer joined
		handler.waitForType("requestUpdate", shortTimeout);

		// Now send the old (stale) revision — must produce an error
		sendGameUpdate(handler.session, gameCode, payload); // revision = original

		JsonObject error = handler.waitForType("error", defaultTimeout);
		assertThat(error).as("Stale WS revision must produce an error").isNotNull();
		assertThat(error.get("message").getAsString()).containsIgnoringCase("revision");

		handler.session.close();
	}

	/**
	 * When a second (non-server) client joins a game, the server sends a
	 * "requestUpdate" message to the first (server) client, asking it to push
	 * a fresh game state.
	 */
	@Test
	void newClientJoinTriggersRequestUpdateToServerSession() throws Exception {
		TestHandler clientA = connectAndRequestGame(gameCode, wsClient, wsUrl);
		clientA.waitForType("game", defaultTimeout);
		clientA.waitForType("permissions", defaultTimeout);

		// Client B joins the same game
		TestHandler clientB = connectAndRequestGame(gameCode, wsClient, wsUrl);
		clientB.waitForType("game", defaultTimeout);

		// Client A (server session) must receive requestUpdate
		JsonObject requestUpdate = clientA.waitForType("requestUpdate", defaultTimeout);
		assertThat(requestUpdate).as("Server session must receive requestUpdate when a new client joins").isNotNull();

		clientA.session.close();
		clientB.session.close();
	}

	/**
	 * A "game-update" message sent by one client must be broadcast with the same
	 * type to all other connected clients, carrying the updated playSeconds.
	 */
	@Test
	void gameUpdateTypeIsBroadcastToOtherClients() throws Exception {
		TestHandler clientA = connectAndRequestGame(gameCode, wsClient, wsUrl);
		JsonObject initial = clientA.waitForType("game", defaultTimeout);
		assertThat(initial).isNotNull();
		long originalPlaySeconds = initial.getAsJsonObject("payload").get("playSeconds").getAsLong();

		TestHandler clientB = connectAndRequestGame(gameCode, wsClient, wsUrl);
		clientB.waitForType("game", defaultTimeout);

		// Client A sends game-update with updated playSeconds
		long updatedPlaySeconds = originalPlaySeconds + 120;
		JsonObject payload = initial.getAsJsonObject("payload").deepCopy();
		payload.addProperty("playSeconds", updatedPlaySeconds);

		JsonObject msg = new JsonObject();
		msg.addProperty("type", "game-update");
		msg.addProperty("code", gameCode);
		msg.add("payload", payload);
		clientA.session.sendMessage(new TextMessage(msg.toString()));

		// Client B must receive the game-update broadcast
		JsonObject broadcast = clientB.waitForType("game-update", defaultTimeout);
		assertThat(broadcast).as("Client B must receive game-update broadcast").isNotNull();
		assertThat(broadcast.getAsJsonObject("payload").get("playSeconds").getAsLong())
				.isEqualTo(updatedPlaySeconds);

		clientA.session.close();
		clientB.session.close();
	}

	/**
	 * POST /game/command with a valid root code must broadcast a "remoteCommand"
	 * message to all connected WebSocket clients.
	 */
	@Test
	void remoteCommandIsBroadcastToWsClients() throws Exception {
		TestHandler listener = connectAndRequestGame(gameCode, wsClient, wsUrl);
		listener.waitForType("game", defaultTimeout);

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		headers.setContentType(MediaType.APPLICATION_JSON);

		String commandId = "scroll";
		int commandX = 100;
		int commandY = 200;
		JsonObject command = new JsonObject();
		command.addProperty("id", commandId);
		command.addProperty("x", commandX);
		command.addProperty("y", commandY);

		ResponseEntity<String> resp = restTemplate.exchange(
				"/game/command", HttpMethod.POST,
				new HttpEntity<>(command.toString(), headers), String.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);

		JsonObject broadcast = listener.waitForType("remoteCommand", defaultTimeout);
		assertThat(broadcast).as("WS listener must receive remoteCommand broadcast").isNotNull();
		assertThat(broadcast.getAsJsonObject("payload").get("id").getAsString()).isEqualTo(commandId);
		assertThat(broadcast.getAsJsonObject("payload").get("x").getAsInt()).isEqualTo(commandX);

		listener.session.close();
	}

	/**
	 * POST /game/command sent using a restricted (non-root) code must be rejected
	 * with 403 Forbidden.
	 */
	@Test
	void remoteCommandForbiddenForRestrictedCode() throws Exception {
		String restrictedCode = "cmd-restricted-" + UUID.randomUUID();

		TestHandler admin = connectAndRequestGame(gameCode, wsClient, wsUrl);
		admin.waitForType("game", defaultTimeout);

		JsonObject permissionsPayload = new JsonObject();
		permissionsPayload.addProperty("code", restrictedCode);
		JsonObject permissions = new JsonObject();
		permissions.addProperty("round", true);
		permissions.addProperty("scenario", false);
		permissions.addProperty("characters", false);
		permissions.addProperty("monsters", false);
		permissions.addProperty("elements", false);
		permissions.addProperty("lootDeck", false);
		permissions.addProperty("level", false);
		permissions.addProperty("attackModifiers", false);
		permissions.addProperty("party", false);
		permissionsPayload.add("permissions", permissions);

		JsonObject permMsg = new JsonObject();
		permMsg.addProperty("type", "permissions");
		permMsg.addProperty("code", gameCode);
		permMsg.add("payload", permissionsPayload);
		admin.session.sendMessage(new TextMessage(permMsg.toString()));
		Thread.sleep(200);

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, restrictedCode);
		headers.setContentType(MediaType.APPLICATION_JSON);

		JsonObject command = new JsonObject();
		command.addProperty("id", "scroll");

		ResponseEntity<String> resp = restTemplate.exchange(
				"/game/command", HttpMethod.POST,
				new HttpEntity<>(command.toString(), headers), String.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

		admin.session.close();
	}

	/**
	 * POST /game/initiative must return 304 Not Modified when the character's
	 * initiative is already set to the requested value.
	 */
	@Test
	void restInitiativeNotModifiedWhenUnchanged() throws Exception {
		TestHandler wsHandler = connectAndRequestGame(gameCode, wsClient, wsUrl);
		wsHandler.waitForType("game", defaultTimeout);
		wsHandler.session.close();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, gameCode);
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<String> getResp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertNotNull(getResp.getBody());
		JsonObject game = JsonParser.parseString(getResp.getBody()).getAsJsonObject();
		long revision = game.get("revision").getAsLong();

		// Add a character
		game.getAsJsonArray("characters").add(buildMinimalCharacter());
		game.addProperty("revision", revision + 1);
		restTemplate.exchange("/game", HttpMethod.POST, new HttpEntity<>(game.toString(), headers), String.class);

		JsonObject initiativePayload = new JsonObject();
		initiativePayload.addProperty("playerNumber", 1);
		initiativePayload.addProperty("initiative", 25);

		// First call must succeed and advance the revision
		ResponseEntity<String> firstResp = restTemplate.exchange(
				"/game/initiative", HttpMethod.POST,
				new HttpEntity<>(initiativePayload.toString(), headers), String.class);
		assertThat(firstResp.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Second call with identical initiative must return 304 Not Modified
		ResponseEntity<String> secondResp = restTemplate.exchange(
				"/game/initiative", HttpMethod.POST,
				new HttpEntity<>(initiativePayload.toString(), headers), String.class);
		assertThat(secondResp.getStatusCode()).isEqualTo(HttpStatus.NOT_MODIFIED);
	}
}
