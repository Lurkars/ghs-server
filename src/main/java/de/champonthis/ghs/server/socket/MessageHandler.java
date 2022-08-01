/**
 * 
 */
package de.champonthis.ghs.server.socket;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import de.champonthis.ghs.server.model.FigureIdentifier;
import de.champonthis.ghs.server.model.GameCharacterModel;
import de.champonthis.ghs.server.model.GameModel;
import de.champonthis.ghs.server.model.GameMonsterModel;
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

	@Autowired
	private Manager manager;
	@Autowired
	private Gson gson;

	@Value("${ghs-server.public:false}")
	private boolean isPublic;

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
			webSocketSessions.remove(webSocketSessionContainer);
		}
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
						gameId = manager.createGame(new GameModel());
						manager.createPassword(password, gameId);
					} else {
						sendError(session, "Invalid password '" + password + "'");
					}
				}

				GameModel game = manager.getGame(gameId);

				if (game == null) {
					sendError(session, "No game found for 'id=" + gameId + "'");
				}

				Permissions permissions = manager.getPermissionsByPassword(password);

				for (WebSocketSessionContainer container : webSocketSessions) {
					if (container.getSession() == session) {
						container.setGameId(gameId);
						break;
					}
				}

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

					if (permissions != null) {

						if (!permissions.isScenario()
								&& !gson.toJson(gameUpdate.getScenario()).equals(gson.toJson(game.getScenario()))) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isScenario()
								&& !gson.toJson(gameUpdate.getSections()).equals(gson.toJson(game.getSections()))) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isScenario() && !gameUpdate.getEdition().equals(game.getEdition())) {
							sendError(session, "Permission(s) missing");
						}
						if (!permissions.isElements()
								&& !gson.toJson(gameUpdate.getElements()).equals(gson.toJson(game.getElements()))) {
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
						if (!permissions.isCharacters()) {
							for (GameCharacterModel updateCharacter : gameUpdate.getCharacters()) {
								boolean characterPermission = false;
								for (GameCharacterModel character : game.getCharacters()) {
									if (updateCharacter.getName().equals(character.getName())
											&& updateCharacter.getEdition().equals(character.getEdition())) {
										for (FigureIdentifier characterFigure : permissions.getCharacter()) {
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
										for (FigureIdentifier monsterFigure : permissions.getMonster()) {
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

					manager.setGame(gameId, gameUpdate);

					for (WebSocketSessionContainer container : webSocketSessions) {
						if (!container.getSession().getId().equals(session.getId())
								&& container.getGameId() == gameId) {
							JsonObject gameResponse = new JsonObject();
							gameResponse.addProperty("type", "game");
							gameResponse.add("payload", gson.toJsonTree(gameUpdate));
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

					if (permissionGameId != null && permissionGameId != gameId) {
						sendError(session, "password already in use");
					}

					if (permissionGameId != null && manager.getPermissionsByPassword(permissionPassword) == null) {
						sendError(session, "cannot overwrite root permissions");
					}

					Permissions permissionPermissions = gson.fromJson(payload.getAsJsonObject().get("permissions"),
							Permissions.class);

					if (permissionPermissions.isCharacters()) {
						permissionPermissions.setCharacter(new LinkedList<FigureIdentifier>());
					}
					
					if (permissionPermissions.isMonsters()) {
						permissionPermissions.setMonster(new LinkedList<FigureIdentifier>());
					}

					manager.savePassword(permissionPassword, gson.toJson(permissionPermissions), gameId);
					break;
				case REQUEST_GAME:
					JsonObject gameResponse = new JsonObject();
					gameResponse.addProperty("type", "game");
					gameResponse.add("payload", gson.toJsonTree(game));
					session.sendMessage(new TextMessage(gson.toJson(gameResponse)));

					JsonObject permissionsResponse = new JsonObject();
					permissionsResponse.addProperty("type", "permissions");
					permissionsResponse.add("payload", gson.toJsonTree(permissions));
					session.sendMessage(new TextMessage(gson.toJson(permissionsResponse)));

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
						if (container.getSession() != session && container.getGameId() == gameId) {
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
				}
			}
		}
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
