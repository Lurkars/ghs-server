/**
 * 
 */
package de.champonthis.ghs.server.socket;

import java.util.ArrayList;
import java.util.Collections;
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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.champonthis.ghs.server.businesslogic.GameManager;
import de.champonthis.ghs.server.model.GameModel;
import de.champonthis.ghs.server.model.Settings;
import de.champonthis.ghs.server.socket.exception.SendErrorException;
import de.champonthis.ghs.server.socket.model.MessageType;
import de.champonthis.ghs.server.socket.model.WebSocketSessionContainer;

/**
 * The Class MessageHandler.
 */
@Component
public class MessageHandler extends TextWebSocketHandler {

	List<WebSocketSessionContainer> webSocketSessions = Collections.synchronizedList(new ArrayList<>());

	@Autowired
	private GameManager gameManager;
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

				Integer gameId = gameManager.getGameIdByPassword(password);

				if (gameId == null) {
					// if first password or public create new game for password
					if (gameManager.countPasswords() == 0 || isPublic) {
						gameId = gameManager.createGame(new GameModel());
						gameManager.createPassword(password, gameId);
					} else {
						sendError(session, "Invalid password '" + password + "'");
					}
				}

				GameModel game = gameManager.getGame(gameId);

				if (game == null) {
					sendError(session, "No game found for 'id=" + gameId + "'");
				}

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

					gameManager.setGame(gameId, gameUpdate);

					for (WebSocketSessionContainer container : webSocketSessions) {
						if (container.getSession() != session && container.getGameId() == gameId) {
							JsonObject gameResponse = new JsonObject();
							gameResponse.addProperty("type", "game");
							gameResponse.add("payload", gson.toJsonTree(gameUpdate));
							container.getSession().sendMessage(new TextMessage(gson.toJson(gameResponse)));
						}
					}
					break;
				case REQUEST_GAME:
					JsonObject gameResponse = new JsonObject();
					gameResponse.addProperty("type", "game");
					gameResponse.add("payload", gson.toJsonTree(game));
					session.sendMessage(new TextMessage(gson.toJson(gameResponse)));
					break;
				case REQUEST_SETTINGS:
					Settings settings = gameManager.getSettings(gameId);
					if (settings == null) {
						settings = new Settings();
						gameManager.createSettings(settings, gameId);
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

					if (gameManager.getSettings(gameId) == null) {
						gameManager.createSettings(settingsUpdate, gameId);
					} else {
						gameManager.setSettings(settingsUpdate, gameId);
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
