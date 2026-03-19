package de.champonthis.ghs.server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.lang.NonNull;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestUtils {

	public static void assertRevisionViaRest(String code, long expectedRevision, TestRestTemplate restTemplate) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, code);
		ResponseEntity<String> resp = restTemplate.exchange(
				"/game", HttpMethod.GET, new HttpEntity<>(headers), String.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertNotNull(resp.getBody());
		long actual = JsonParser.parseString(resp.getBody())
				.getAsJsonObject().get("revision").getAsLong();
		assertThat(actual).as("revision via REST GET").isEqualTo(expectedRevision);
	}

	/** Connects a WS client and immediately sends request-game. */
	public static TestHandler connectAndRequestGame(String code, StandardWebSocketClient wsClient, String wsUrl) throws Exception {
		TestHandler handler = new TestHandler();
		WebSocketSession session = wsClient.execute(handler, wsUrl).get(5, TimeUnit.SECONDS);
		handler.session = session;

		JsonObject req = new JsonObject();
		req.addProperty("type", "request-game");
		req.addProperty("code", code);
		session.sendMessage(new TextMessage(req.toString()));
		return handler;
	}

	public static void sendGameUpdate(WebSocketSession session, String code, JsonObject payload)
			throws IOException {
		JsonObject msg = new JsonObject();
		msg.addProperty("type", "game");
		msg.addProperty("code", code);
		msg.add("payload", payload);
		session.sendMessage(new TextMessage(msg.toString()));
	}

	/**
	 * Builds a minimal GameCharacterModel JSON with all @Required fields populated
	 * so that the server can serialize it back without validation errors.
	 */
	public static JsonObject buildMinimalCharacter() {
		JsonObject c = new JsonObject();
		c.addProperty("name", "Brute");
		c.addProperty("edition", "gh");
		c.addProperty("number", 1);
		c.addProperty("marker", false);
		c.addProperty("initiative", 0);
		c.addProperty("experience", 0);
		c.addProperty("loot", 0);
		c.add("lootCards", new JsonArray());
		c.add("treasures", new JsonArray());
		c.addProperty("exhausted", false);
		c.addProperty("level", 1);
		c.addProperty("off", false);
		c.addProperty("active", false);
		c.addProperty("health", 10);
		c.addProperty("maxHealth", 10);
		c.add("entityConditions", new JsonArray());
		c.add("markers", new JsonArray());
		c.add("tags", new JsonArray());
		c.addProperty("identity", 0);
		c.add("summons", new JsonArray());
		JsonObject amd = new JsonObject();
		amd.addProperty("current", 0);
		amd.add("cards", new JsonArray());
		amd.add("discarded", new JsonArray());
		amd.addProperty("active", true);
		c.add("attackModifierDeck", amd);
		c.addProperty("donations", 0);
		c.addProperty("token", 0);
		c.add("tokenValues", new JsonArray());
		c.addProperty("absent", false);
		c.addProperty("longRest", false);
		c.add("battleGoals", new JsonArray());
		c.add("retaliate", new JsonArray());
		c.add("retaliatePersistent", new JsonArray());
		return c;
	}

	public static class TestHandler extends TextWebSocketHandler {

		WebSocketSession session;
		private final BlockingQueue<JsonObject> received = new LinkedBlockingQueue<>();

		@Override
		protected void handleTextMessage(@NonNull WebSocketSession session, @NonNull TextMessage message) {
			try {
				received.add(JsonParser.parseString(message.getPayload()).getAsJsonObject());
			} catch (Exception ignored) {
			}
		}

		/**
		 * Drains messages until one matching {@code type} arrives, or the timeout
		 * expires. Messages of other types are discarded (e.g. "requestUpdate",
		 * "permissions" signals that arrive interleaved with "game" messages).
		 */
		JsonObject waitForType(String type, long timeout) throws InterruptedException {
			long deadline = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(timeout);
			while (true) {
				long remaining = deadline - System.currentTimeMillis();
				if (remaining <= 0) return null;
				JsonObject msg = received.poll(remaining, TimeUnit.MILLISECONDS);
				if (msg == null) return null;
				if (type.equals(msg.get("type").getAsString())) return msg;
			}
		}
	}
}
