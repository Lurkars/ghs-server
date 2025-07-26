package de.champonthis.ghs.server.socket;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.champonthis.ghs.server.businesslogic.Manager;
import de.champonthis.ghs.server.model.*;
import de.champonthis.ghs.server.socket.exception.SendErrorException;
import de.champonthis.ghs.server.socket.model.MessageType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Component
public class MessageHandler extends TextWebSocketHandler {

	private final Manager manager;
	private final WebSocketSessionsManager webSocketSessionsManager;
	private final Gson gson;

	private final String buildVersion;
	private final boolean isPublic;
	private final boolean debug;

	public MessageHandler(
			@Value("${build.version}") String buildVersion,
			@Value("${ghs-server.public:false}") boolean isPublic,
			@Value("${ghs-server.debug:false}") boolean debug,
			Manager manager,
			WebSocketSessionsManager webSocketSessionsManager,
			Gson gson
	) {
		this.manager = manager;
		this.webSocketSessionsManager = webSocketSessionsManager;
		this.gson = gson;
		this.buildVersion = buildVersion;
		this.isPublic = isPublic;
		this.debug = debug;
	}

	@Override
	public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		webSocketSessionsManager.addSession(-1L, session);
	}

	@Override
	public void afterConnectionClosed(@NonNull WebSocketSession session, @NonNull CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		String sessionId = session.getId();
		Long gameId = webSocketSessionsManager.getGameIdBySessionId(sessionId);
		webSocketSessionsManager.removeSessionById(sessionId);
		if (gameId == -1L) {
			return;
		}
		List<WebSocketSession> otherSessions = webSocketSessionsManager.getSessionsByGameId(gameId);
		if (CollectionUtils.isEmpty(otherSessions)) {
			return;
		}
		GameModel game = manager.getGame(gameId);
		if (game == null) {
			sendError(session, "No game found for 'id=" + gameId + "'");
			return;
		}
		game.setServer(webSocketSessionsManager.isServerSession(session, gameId));
		JsonObject gameResponse = new JsonObject();
		gameResponse.addProperty("type", "game-update");
		gameResponse.add("payload", gson.toJsonTree(game));
		gameResponse.addProperty("serverVersion", buildVersion);
		String jsonMessage = gson.toJson(gameResponse);
		otherSessions.forEach(s -> {
			try {
				s.sendMessage(new TextMessage(jsonMessage));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
	}

	@Override
	public void handleMessage(@NonNull WebSocketSession session, @NonNull WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		if (message instanceof TextMessage textMessage) {
			try {
				JsonObject messageObject = JsonParser.parseString(textMessage.getPayload()).getAsJsonObject();

				if ((messageObject.get("password") == null || messageObject.get("password").isJsonNull())
						&& (messageObject.get("code") == null || messageObject.get("code").isJsonNull())) {
					sendError(session, "'code' missing");
				}

				String gameCode = messageObject.has("code") && !messageObject.get("code").isJsonNull()
						? messageObject.get("code").getAsString()
						: messageObject.get("password").getAsString();

				if (StringUtils.isBlank(gameCode)) {
					sendError(session, "empty 'game code'");
				} else if (gameCode.length() > 1024) {
					sendError(session, "game code too long!");
				}

				Long gameId = manager.getGameIdByGameCode(gameCode);
				if (webSocketSessionsManager.getGameIdBySessionId(session.getId()) == -1L) {
					webSocketSessionsManager.updateSession(gameId, session);
				}

				if (gameId == null) {
					// if first game code or public create new game for game code
					if (manager.countGameCodes() == 0 || isPublic) {
						GameModel game = new GameModel();
						game.setRevision(-1L);
						if (messageObject.get("payload") != null && !messageObject.get("payload").isJsonNull()) {
							game = gson.fromJson(messageObject.get("payload"), GameModel.class);
						}
						gameId = manager.createGame(game);
						manager.createGameCode(gameCode, gameId);
					} else {
						sendError(session, "Invalid game code '" + gameCode + "'");
					}
				}

				if (gameId != null) {
					GameModel game = manager.getGame(gameId);

					if (game == null) {
						sendError(session, "No game found for 'id=" + gameId + "'");
					} else {

						if (game.getParty() == null) {
							game.setParty(new Party());
						}

						Permissions permissions = manager.getPermissionsByGameCode(gameCode);

						game.setServer(webSocketSessionsManager.isServerSession(session, gameId));

						MessageType type = MessageType
								.valueOf(messageObject.get("type").getAsString().toUpperCase().replace("-", "_"));

						switch (type) {
							case ERROR:
								sendError(session, "cannot send errors to server!");
								break;
							case PING:
								JsonObject pingMessage = new JsonObject();
								pingMessage.addProperty("type", "ping");
								pingMessage.addProperty("message", "pong");
								pingMessage.addProperty("serverVersion", buildVersion);
								session.sendMessage(new TextMessage(gson.toJson(pingMessage)));
								break;
							case GAME:
							case GAME_UNDO:
							case GAME_REDO:
								if (messageObject.get("payload") == null || messageObject.get("payload").isJsonNull()) {
									sendError(session, "'payload' missing");
								}

								GameModel gameUpdate = gson.fromJson(messageObject.get("payload"), GameModel.class);

								if (gameUpdate == null) {
									sendError(session, "invalid game payload");
								} else {
									if (Objects.equals(gameUpdate.getRevision(), game.getRevision())) {
										game.setPlaySeconds(gameUpdate.getPlaySeconds());
										gameUpdate = game;
									} else if (gameUpdate.getRevision() < game.getRevision()) {
										sendError(session, "invalid revision");
									}

									if (permissions != null) {

										if (!permissions.isScenario()
												&& !gson.toJson(gameUpdate.getScenario())
												.equals(gson.toJson(game.getScenario()))) {
											sendError(session, "Permission(s) missing: scenario");
										}
										if (!permissions.isScenario()
												&& !gson.toJson(gameUpdate.getSections())
												.equals(gson.toJson(game.getSections()))) {
											sendError(session, "Permission(s) missing: scenario");
										}
										if (!permissions.isScenario() && (gameUpdate.getEdition() != null
												&& !gameUpdate.getEdition().equals(game.getEdition())
												|| game.getEdition() != null
												&& !game.getEdition().equals(gameUpdate.getEdition()))) {
											sendError(session, "Permission(s) missing: scenario");
										}
										if (!permissions.isElements() && !gson.toJson(gameUpdate.getElementBoard())
												.equals(gson.toJson(game.getElementBoard()))) {
											sendError(session, "Permission(s) missing: elements");
										}
										if (!permissions.isLootDeck()
												&& !gson.toJson(gameUpdate.getLootDeck())
												.equals(gson.toJson(game.getLootDeck()))) {
											sendError(session, "Permission(s) missing: lootDeck");
										}
										if (!permissions.isRound() && gameUpdate.getRound() != game.getRound()) {
											sendError(session, "Permission(s) missing: round");
										}
										if (!permissions.isRound() && !gameUpdate.getState().equals(game.getState())) {
											sendError(session, "Permission(s) missing: round");
										}
										if (!permissions.isLevel() && gameUpdate.getLevel() != game.getLevel()) {
											sendError(session, "Permission(s) missing: level");
										}
										if (!permissions.isAttackModifiers()
												&& !gson.toJson(gameUpdate.getMonsterAttackModifierDeck())
												.equals(gson.toJson(game.getMonsterAttackModifierDeck()))) {
											sendError(session, "Permission(s) missing");
										}
										if (!permissions.isAttackModifiers()
												&& !gson.toJson(gameUpdate.getAllyAttackModifierDeck())
												.equals(gson.toJson(game.getAllyAttackModifierDeck()))) {
											sendError(session, "Permission(s) missing: attackModifiers");
										}
										if (!permissions.isParty()
												&& (!gson.toJson(gameUpdate.getParty())
												.equals(gson.toJson(game.getParty()))
												|| !gson
												.toJson(gameUpdate.getParties())
												.equals(gson.toJson(game.getParties())))) {
											sendError(session, "Permission(s) missing: party");
										}
										if (!permissions.isCharacters()) {
											for (GameCharacterModel updateCharacter : gameUpdate.getCharacters()) {
												boolean characterPermission = false;
												boolean roundPermissions = permissions.isRound()
														&& gameUpdate.getState() != game.getState();
												boolean lootDeckPermissions = permissions.isLootDeck() && !gson
														.toJson(gameUpdate.getLootDeck())
														.equals(gson.toJson(game.getLootDeck()));
												boolean scenarioPermissions = permissions.isScenario() && !gson
														.toJson(gameUpdate.getScenario())
														.equals(gson.toJson(game.getScenario()));

												for (GameCharacterModel character : game.getCharacters()) {
													if (updateCharacter.getName().equals(character.getName())
															&& updateCharacter.getEdition()
															.equals(character.getEdition())) {
														for (Identifier characterFigure : permissions.getCharacter()) {
															if (characterFigure.getName().equals(character.getName())
																	&& characterFigure.getEdition()
																	.equals(character.getEdition())) {
																characterPermission = true;
																break;
															}
														}
														if (characterPermission) {
															break;
														} else {
															updateCharacter.getAttackModifierDeck()
																	.setActive(
																			character.getAttackModifierDeck()
																					.isActive());

															if (permissions.isRound()) {
																character.setOff(updateCharacter.isOff());
																character.setActive(updateCharacter.isActive());
																character
																		.setEntityConditions(
																				updateCharacter.getEntityConditions());
															}

															if (roundPermissions || scenarioPermissions) {
																character.setOff(updateCharacter.isOff());
																character.setActive(updateCharacter.isActive());
																character
																		.setInitiative(updateCharacter.getInitiative());
																character
																		.setEntityConditions(
																				updateCharacter.getEntityConditions());
																character
																		.setAttackModifierDeck(
																				updateCharacter
																						.getAttackModifierDeck());
															}

															if (scenarioPermissions) {
																character.setHealth(updateCharacter.getHealth());
																character.setMaxHealth(updateCharacter.getMaxHealth());
																character.setLoot(updateCharacter.getLoot());
																character.setLootCards(updateCharacter.getLootCards());
																character.setTreasures(updateCharacter.getTreasures());
																character
																		.setExperience(updateCharacter.getExperience());
																character
																		.setEntityConditions(
																				updateCharacter.getEntityConditions());
																character.setSummons(updateCharacter.getSummons());
																character.setExhausted(updateCharacter.isExhausted());
																character.setToken(updateCharacter.getToken());
															}

															if (lootDeckPermissions) {
																character.setLoot(updateCharacter.getLoot());
																character.setLootCards(updateCharacter.getLootCards());
															}
															String characterJson = gson.toJson(character);
															String updateCharacterJson = gson.toJson(updateCharacter);
															if (characterJson.equals(updateCharacterJson)) {
																characterPermission = true;
																break;
															}
														}
													}
												}
												if (!characterPermission) {
													sendError(session, "Permission(s) missing: characters");
												}
											}
										}
										if (!permissions.isMonsters()) {
											for (GameMonsterModel updateMonster : gameUpdate.getMonsters()) {
												boolean monsterPermission = false;
												boolean roundPermissions = permissions.isRound()
														&& gameUpdate.getState() != game.getState();
												boolean scenarioPermissions = permissions.isScenario() && !gson
														.toJson(gameUpdate.getScenario())
														.equals(gson.toJson(game.getScenario()));
												for (GameMonsterModel monster : game.getMonsters()) {
													if (updateMonster.getName().equals(monster.getName())
															&& updateMonster.getEdition()
															.equals(monster.getEdition())) {
														for (Identifier monsterFigure : permissions.getMonster()) {
															if (monsterFigure.getName().equals(monster.getName())
																	&& monsterFigure.getEdition()
																	.equals(monster.getEdition())) {
																monsterPermission = true;
																break;
															}
														}
														if (monsterPermission) {
															break;
														} else {

															if (permissions.isRound()) {
																monster.setOff(updateMonster.isOff());
																monster.setActive(updateMonster.isActive());
																monster.setEntities(updateMonster.getEntities());
															}

															if (roundPermissions) {
																monster.setAbility(updateMonster.getAbility());
																monster.setAbilities(updateMonster.getAbilities());
																monster.setEntities(updateMonster.getEntities());
																monster.setActive(updateMonster.isActive());
																monster.setOff(updateMonster.isOff());
															}

															if (scenarioPermissions
																	|| gson.toJson(updateMonster)
																	.equals(gson.toJson(monster))) {
																monsterPermission = true;
																break;
															}
														}
													}
												}
												if (!monsterPermission && !game.getMonsters().isEmpty()
														&& !scenarioPermissions) {
													sendError(session, "Permission(s) missing: monsters");
												}
											}
										}
									}

									gameUpdate.setServer(false);
									manager.setGame(gameId, gameUpdate);

									List<WebSocketSession> otherSessions = webSocketSessionsManager
											.getOtherSessions(gameId, session.getId());
									if (!CollectionUtils.isEmpty(otherSessions)) {
										JsonObject gameResponse = new JsonObject();
										if (!game.isServer()) {
											gameUpdate.setServer(webSocketSessionsManager.isServerSession(session, gameId));
										}
										gameResponse.addProperty("type",
												type.toString().toLowerCase().replace('_', '-'));
										gameResponse.add("payload", gson.toJsonTree(gameUpdate));
										gameResponse.add("undoinfo", messageObject.get("undoinfo"));
										gameResponse.add("revision", messageObject.get("revision"));
										gameResponse.add("undolength", messageObject.get("undolength"));
										gameResponse.addProperty("serverVersion", buildVersion);
										String jsonMessage = gson.toJson(gameResponse);
										otherSessions.forEach(s -> {
											try {
												s.sendMessage(new TextMessage(jsonMessage));
											} catch (IOException e) {
												throw new RuntimeException(e);
											}
										});
									}
								}
								break;
							case GAME_UPDATE:
								if (messageObject.get("payload") == null || messageObject.get("payload").isJsonNull()) {
									sendError(session, "'payload' missing");
								}

								GameModel updateGame = gson.fromJson(messageObject.get("payload"), GameModel.class);

								if (updateGame == null) {
									sendError(session, "invalid game payload");
								} else {

									game.setPlaySeconds(updateGame.getPlaySeconds());
									updateGame = game;

									updateGame.setServer(false);
									manager.setGame(gameId, updateGame);

									List<WebSocketSession> otherSessions = webSocketSessionsManager
											.getOtherSessions(gameId, session.getId());
									if (!CollectionUtils.isEmpty(otherSessions)) {
										JsonObject gameResponse = new JsonObject();
										if (!game.isServer()) {
											updateGame.setServer(webSocketSessionsManager.isServerSession(session, gameId));
										}
										gameResponse.addProperty("type", "game-update");
										gameResponse.add("payload", gson.toJsonTree(updateGame));
										gameResponse.addProperty("serverVersion", buildVersion);
										String jsonMessage = gson.toJson(gameResponse);
										otherSessions.forEach(s -> {
											try {
												s.sendMessage(new TextMessage(jsonMessage));
											} catch (IOException e) {
												throw new RuntimeException(e);
											}
										});
									}
								}
								break;
							case PERMISSIONS:
								if (permissions != null) {
									sendError(session, "Cannot create permissions!");
								}

								if (messageObject.get("payload") == null || messageObject.get("payload").isJsonNull()) {
									sendError(session, "'payload' missing");
								}

								JsonElement payload = messageObject.get("payload");
								if (!payload.isJsonObject()
										|| !payload.getAsJsonObject().has("password")
										&& !payload.getAsJsonObject().has("code")
										|| !payload.getAsJsonObject().has("permissions")) {
									sendError(session, "invalid 'payload'");
								}

								String permissionGameCode = payload.getAsJsonObject().has("code")
										&& !payload.getAsJsonObject().get("code").isJsonNull()
										? payload.getAsJsonObject().get("code").getAsString()
										: payload.getAsJsonObject().get("password").getAsString();

								Long permissionGameId = manager.getGameIdByGameCode(permissionGameCode);

								if (permissionGameId != null && !permissionGameId.equals(gameId)
										|| permissionGameCode.equals(gameCode)) {
									sendError(session, "'game code' already in use");
								}

								if (permissionGameId != null
										&& manager.getPermissionsByGameCode(permissionGameCode) == null) {
									sendError(session, "cannot overwrite root permissions");
								}

								Permissions permissionPermissions = gson.fromJson(
										payload.getAsJsonObject().get("permissions"),
										Permissions.class);

								if (permissionPermissions.isCharacters()) {
									permissionPermissions.setCharacter(new LinkedList<Identifier>());
								}

								if (permissionPermissions.isMonsters()) {
									permissionPermissions.setMonster(new LinkedList<Identifier>());
								}

								manager.saveGameCode(permissionGameCode, gson.toJson(permissionPermissions), gameId);
								break;
							case REQUEST_GAME:
								game.setServer(webSocketSessionsManager.isServerSession(session, gameId));

								JsonObject gameResponse = new JsonObject();
								gameResponse.addProperty("type", "game");
								gameResponse.add("payload", gson.toJsonTree(game));
								gameResponse.addProperty("serverVersion", buildVersion);
								session.sendMessage(new TextMessage(gson.toJson(gameResponse)));

								JsonObject permissionsResponse = new JsonObject();
								permissionsResponse.addProperty("type", "permissions");
								permissionsResponse.add("payload", gson.toJsonTree(permissions));
								permissionsResponse.addProperty("serverVersion", buildVersion);
								session.sendMessage(new TextMessage(gson.toJson(permissionsResponse)));

								if (!game.isServer()) {
									WebSocketSession requestUpdateSession = webSocketSessionsManager.getSessionsByGameId(gameId).stream().findFirst().orElse(null);
									if (requestUpdateSession != null) {
										JsonObject requestUpdateResponse = new JsonObject();
										requestUpdateResponse.addProperty("type", "requestUpdate");
										requestUpdateResponse.addProperty("serverVersion", buildVersion);
										requestUpdateSession.sendMessage(new TextMessage(gson.toJson(requestUpdateResponse)));
									}
								}

								break;
							case REQUEST_SETTINGS:
								Settings settings = manager.getSettings(gameId);
								JsonObject settingsRequestResponse = new JsonObject();
								settingsRequestResponse.addProperty("type", "settings");

								// migration
								if (settings == null && !messageObject.has("allow-empty")) {
									settings = new Settings();
									manager.createSettings(settings, gameId);
								}

								if (settings != null) {
									settingsRequestResponse.add("payload", gson.toJsonTree(settings));
								}
								settingsRequestResponse.addProperty("serverVersion", buildVersion);
								session.sendMessage(new TextMessage(gson.toJson(settingsRequestResponse)));
								break;
							case SETTINGS:
								if (messageObject.get("payload") == null || messageObject.get("payload").isJsonNull()) {
									sendError(session, "'payload' missing");
								}

								Settings settingsUpdate = gson.fromJson(messageObject.get("payload"), Settings.class);

								if (settingsUpdate == null) {
									sendError(session, "invalid settings payload");
								}

								if (manager.getSettings(gameId) == null) {
									manager.createSettings(settingsUpdate, gameId);
								} else {
									manager.setSettings(settingsUpdate, gameId);
								}

								List<WebSocketSession> otherSessions = webSocketSessionsManager
										.getOtherSessions(gameId, session.getId());
								if (!CollectionUtils.isEmpty(otherSessions)) {
									JsonObject settingsResponse = new JsonObject();
									settingsResponse.addProperty("type", "settings");
									settingsResponse.add("payload", gson.toJsonTree(settingsUpdate));
									settingsResponse.addProperty("serverVersion", buildVersion);
									String jsonMessage = gson.toJson(settingsResponse);
									otherSessions.forEach(s -> {
										try {
											s.sendMessage(new TextMessage(jsonMessage));
										} catch (IOException e) {
											throw new RuntimeException(e);
										}
									});
								}
								break;
							default:
								sendError(session, "invalid message type");
								break;
						}
					}
				}
			} catch (Exception e) {
				if (!(e instanceof SendErrorException)) {
					sendError(session, e.getMessage(), false);
					if (debug) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	protected void sendError(WebSocketSession session, String message) throws Exception {
		sendError(session, message, true);
	}

	protected void sendError(WebSocketSession session, String message, boolean stop) throws Exception {
		JsonObject error = new JsonObject();
		error.addProperty("type", "error");
		error.addProperty("message", message);
		error.addProperty("serverVersion", buildVersion);
		session.sendMessage(new TextMessage(gson.toJson(error)));
		if (stop) {
			throw new SendErrorException("Error: " + message);
		}
	}

}
