/**
 * 
 */
package de.champonthis.ghs.server.socket;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.champonthis.ghs.server.businesslogic.Manager;
import de.champonthis.ghs.server.model.GameCharacterModel;
import de.champonthis.ghs.server.model.GameModel;
import de.champonthis.ghs.server.model.GameMonsterModel;
import de.champonthis.ghs.server.model.Identifier;
import de.champonthis.ghs.server.model.Party;
import de.champonthis.ghs.server.model.Permissions;
import de.champonthis.ghs.server.model.Settings;
import de.champonthis.ghs.server.socket.exception.SendErrorException;
import de.champonthis.ghs.server.socket.model.MessageType;
import de.champonthis.ghs.server.socket.model.WebSocketSessionContainer;

/**
 * The Class MessageHandler.
 */
@Component
public class MessageHandler extends TextWebSocketHandler {

	List<WebSocketSessionContainer> webSocketSessions = Collections.synchronizedList(new LinkedList<>());
	List<WebSocketSessionContainer> webSocketSessionsCleanUp = Collections.synchronizedList(new LinkedList<>());

	@Autowired
	private Manager manager;
	@Autowired
	private Gson gson;

	@Value("${ghs-server.public:false}")
	private boolean isPublic;

	@Value("${ghs-server.debug:false}")
	private boolean debug;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		webSocketSessions.add(new WebSocketSessionContainer(-1, session));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		WebSocketSessionContainer webSocketSessionContainer = null;
		for (WebSocketSessionContainer container : webSocketSessions) {
			if (container.getSession() == session) {
				webSocketSessionContainer = container;
				break;
			}
		}
		if (webSocketSessionContainer != null) {
			int gameId = webSocketSessionContainer.getGameId();
			webSocketSessionsCleanUp.add(webSocketSessionContainer);
			for (WebSocketSessionContainer container : webSocketSessions) {
				if (container.getGameId() == gameId && webSocketSessionsCleanUp.indexOf(container) == -1) {
					GameModel game = manager.getGame(gameId);
					if (game == null) {
						sendError(container.getSession(), "No game found for 'id=" + gameId + "'");
					} else {
						game.setServer(isServerSession(container.getSession(), gameId));
						JsonObject gameResponse = new JsonObject();
						gameResponse.addProperty("type", "game");
						gameResponse.add("payload", gson.toJsonTree(game));
						container.getSession().sendMessage(new TextMessage(gson.toJson(gameResponse)));
					}
				}
			}
		}
	}

	/**
	 * Clean up sessions.
	 */
	@Scheduled(fixedRate = 120000)
	public void cleanUpSessions() {
		for (WebSocketSessionContainer container : webSocketSessionsCleanUp) {
			webSocketSessions.remove(container);
		}
		webSocketSessionsCleanUp.clear();
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;

			try {
				JsonObject messageObject = JsonParser.parseString(textMessage.getPayload()).getAsJsonObject();

				if (messageObject.get("password") == null || messageObject.get("password").isJsonNull()) {
					sendError(session, "'password' missing");
				}

				String password = messageObject.get("password").getAsString();

				if (!StringUtils.hasText(password)) {
					sendError(session, "empty 'password'");
				}

				Integer gameId = manager.getGameIdByPassword(password);

				if (gameId == null) {
					// if first password or public create new game for password
					if (manager.countPasswords() == 0 || isPublic) {
						GameModel game = new GameModel();
						if (messageObject.get("payload") != null && !messageObject.get("payload").isJsonNull()) {
							game = gson.fromJson(messageObject.get("payload"), GameModel.class);
						}
						gameId = manager.createGame(game);
						manager.createPassword(password, gameId);
					} else {
						sendError(session, "Invalid password '" + password + "'");
					}
				}

				GameModel game = manager.getGame(gameId);

				if (game == null) {
					sendError(session, "No game found for 'id=" + gameId + "'");
				}

				if (game.getParty() == null) {
					game.setParty(new Party());
				}

				Permissions permissions = manager.getPermissionsByPassword(password);

				game.setServer(isServerSession(session, gameId));

				MessageType type = MessageType
						.valueOf(messageObject.get("type").getAsString().toUpperCase().replace("-", "_"));

				switch (type) {
				case ERROR:
					sendError(session, "cannot send errors to server!");
					break;
				case GAME:
					if (messageObject.get("payload") == null || messageObject.get("payload").isJsonNull()) {
						sendError(session, "'payload' missing");
					}

					GameModel gameUpdate = gson.fromJson(messageObject.get("payload"), GameModel.class);

					if (gameUpdate == null) {
						sendError(session, "invalid game payload");
					}

					// Migration: check if revision is set
					if (gameUpdate.getRevision() != null && game.getRevision() != null) {
						if (gameUpdate.getRevision() <= game.getRevision()) {
							sendError(session, "invalid revision");
						}
					}

					if (permissions != null) {

						if (!permissions.isScenario()
								&& !gson.toJson(gameUpdate.getScenario()).equals(gson.toJson(game.getScenario()))) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isScenario()
								&& !gson.toJson(gameUpdate.getSections()).equals(gson.toJson(game.getSections()))) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isScenario() && (gameUpdate.getEdition() != null
								&& !gameUpdate.getEdition().equals(game.getEdition())
								|| game.getEdition() != null && !game.getEdition().equals(gameUpdate.getEdition()))) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isElements() && !gson.toJson(gameUpdate.getElementBoard())
								.equals(gson.toJson(game.getElementBoard()))) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isLootDeck()
								&& !gson.toJson(gameUpdate.getLootDeck()).equals(gson.toJson(game.getLootDeck()))) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isRound() && gameUpdate.getRound() != game.getRound()) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isRound() && !gameUpdate.getState().equals(game.getState())) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isLevel() && gameUpdate.getLevel() != game.getLevel()) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isAttackModifiers() && !gson.toJson(gameUpdate.getMonsterAttackModifierDeck())
								.equals(gson.toJson(game.getMonsterAttackModifierDeck()))) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isAttackModifiers() && !gson.toJson(gameUpdate.getAllyAttackModifierDeck())
								.equals(gson.toJson(game.getAllyAttackModifierDeck()))) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isParty()
								&& (!gson.toJson(gameUpdate.getParty()).equals(gson.toJson(game.getParty())) || !gson
										.toJson(gameUpdate.getParties()).equals(gson.toJson(game.getParties())))) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isCharacters()) {
							for (GameCharacterModel updateCharacter : gameUpdate.getCharacters()) {
								boolean characterPermission = false;
								for (GameCharacterModel character : game.getCharacters()) {
									if (updateCharacter.getName().equals(character.getName())
											&& updateCharacter.getEdition().equals(character.getEdition())) {
										for (Identifier characterFigure : permissions.getCharacter()) {
											if (characterFigure.getName().equals(character.getName())
													&& characterFigure.getEdition().equals(character.getEdition())) {
												characterPermission = true;
												break;
											}
										}
										if (characterPermission) {
											break;
										} else if (gson.toJson(updateCharacter).equals(gson.toJson(character))) {
											characterPermission = true;
											break;
										}
									}
								}
								if (!characterPermission) {
									sendError(session, "Permission(s) missing");
								}
							}
						}
						if (!permissions.isMonsters()) {
							for (GameMonsterModel updateMonster : gameUpdate.getMonsters()) {
								boolean monsterPermission = false;
								for (GameMonsterModel monster : game.getMonsters()) {
									if (updateMonster.getName().equals(monster.getName())
											&& updateMonster.getEdition().equals(monster.getEdition())) {
										for (Identifier monsterFigure : permissions.getMonster()) {
											if (monsterFigure.getName().equals(monster.getName())
													&& monsterFigure.getEdition().equals(monster.getEdition())) {
												monsterPermission = true;
												break;
											}
										}
										if (monsterPermission) {
											break;
										} else if (gson.toJson(updateMonster).equals(gson.toJson(monster))) {
											monsterPermission = true;
											break;
										}
									}
								}
								if (!monsterPermission) {
									sendError(session, "Permission(s) missing");
								}
							}
						}
					}

					gameUpdate.setServer(false);
					manager.setGame(gameId, gameUpdate);

					for (WebSocketSessionContainer container : webSocketSessions) {
						if (!container.getSession().getId().equals(session.getId()) && container.getGameId() == gameId
								&& webSocketSessionsCleanUp.indexOf(container) == -1) {
							JsonObject gameResponse = new JsonObject();
							if (!game.isServer()) {
								gameUpdate.setServer(isServerSession(container.getSession(), gameId));
							}
							gameResponse.addProperty("type", "game");
							gameResponse.add("payload", gson.toJsonTree(gameUpdate));
							gameResponse.add("undoinfo", messageObject.get("undoinfo"));
							container.getSession().sendMessage(new TextMessage(gson.toJson(gameResponse)));
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
					if (!payload.isJsonObject() || !payload.getAsJsonObject().has("password")
							|| !payload.getAsJsonObject().has("permissions")) {
						sendError(session, "invalid 'payload'");
					}

					String permissionPassword = payload.getAsJsonObject().get("password").getAsString();

					Integer permissionGameId = manager.getGameIdByPassword(permissionPassword);

					if (permissionGameId != null && !permissionGameId.equals(gameId)
							|| permissionPassword.equals(password)) {
						sendError(session, "password already in use");
					}

					if (permissionGameId != null && manager.getPermissionsByPassword(permissionPassword) == null) {
						sendError(session, "cannot overwrite root permissions");
					}

					Permissions permissionPermissions = gson.fromJson(payload.getAsJsonObject().get("permissions"),
							Permissions.class);

					if (permissionPermissions.isCharacters()) {
						permissionPermissions.setCharacter(new LinkedList<Identifier>());
					}

					if (permissionPermissions.isMonsters()) {
						permissionPermissions.setMonster(new LinkedList<Identifier>());
					}

					manager.savePassword(permissionPassword, gson.toJson(permissionPermissions), gameId);
					break;
				case REQUEST_GAME:
					game.setServer(isServerSession(session, gameId));

					JsonObject gameResponse = new JsonObject();
					gameResponse.addProperty("type", "game");
					gameResponse.add("payload", gson.toJsonTree(game));
					session.sendMessage(new TextMessage(gson.toJson(gameResponse)));

					JsonObject permissionsResponse = new JsonObject();
					permissionsResponse.addProperty("type", "permissions");
					permissionsResponse.add("payload", gson.toJsonTree(permissions));
					session.sendMessage(new TextMessage(gson.toJson(permissionsResponse)));

					if (!game.isServer()) {
						for (WebSocketSessionContainer container : webSocketSessions) {
							if (container.getGameId() == gameId && webSocketSessionsCleanUp.indexOf(container) == -1) {
								JsonObject updateResponse = new JsonObject();
								updateResponse.addProperty("type", "requestUpdate");
								container.getSession().sendMessage(new TextMessage(gson.toJson(updateResponse)));
								break;
							}
						}
					}

					break;
				case REQUEST_SETTINGS:
					Settings settings = manager.getSettings(gameId);
					if (settings == null) {
						settings = new Settings();
						manager.createSettings(settings, gameId);
					}

					JsonObject settingsRequestResponse = new JsonObject();
					settingsRequestResponse.addProperty("type", "settings");
					settingsRequestResponse.add("payload", gson.toJsonTree(settings));
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

					for (WebSocketSessionContainer container : webSocketSessions) {
						if (container.getSession() != session && container.getGameId() == gameId
								&& webSocketSessionsCleanUp.indexOf(container) == -1) {
							JsonObject settingsResponse = new JsonObject();
							settingsResponse.addProperty("type", "settings");
							settingsResponse.add("payload", gson.toJsonTree(settingsUpdate));
							container.getSession().sendMessage(new TextMessage(gson.toJson(settingsResponse)));
						}
					}
					break;
				default:
					sendError(session, "invalid message type");
					break;
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

	/**
	 * Checks if is server session.
	 *
	 * @param session the session
	 * @param gameId  the game id
	 * @return true, if is server session
	 */
	protected boolean isServerSession(WebSocketSession session, Integer gameId) {
		int serverSessionIndex = Integer.MAX_VALUE;
		boolean isServer = false;
		for (WebSocketSessionContainer container : webSocketSessions) {
			if (webSocketSessionsCleanUp.indexOf(container) == -1) {
				int containerIndex = webSocketSessions.indexOf(container);
				if (container.getSession() == session) {
					if (containerIndex < serverSessionIndex) {
						serverSessionIndex = containerIndex;
						isServer = true;
					}
					container.setGameId(gameId);
					break;
				} else if (container.getGameId() == gameId && containerIndex < serverSessionIndex) {
					serverSessionIndex = containerIndex;
					isServer = false;
				}
			}
		}
		return isServer;
	}

	/**
	 * Send error.
	 *
	 * @param session the session
	 * @param message the message
	 * @throws Exception the exception
	 */
	protected void sendError(WebSocketSession session, String message) throws Exception {
		sendError(session, message, true);
	}

	/**
	 * Send error.
	 *
	 * @param session the session
	 * @param message the message
	 * @param stop    the stop
	 * @throws Exception the exception
	 */
	protected void sendError(WebSocketSession session, String message, boolean stop) throws Exception {
		JsonObject error = new JsonObject();
		error.addProperty("type", "error");
		error.addProperty("message", message);
		session.sendMessage(new TextMessage(gson.toJson(error)));
		if (stop) {
			throw new SendErrorException("Error: " + message);
		}
	}

}
