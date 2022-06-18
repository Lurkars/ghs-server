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
import de.champonthis.ghs.server.model.Game;
import de.champonthis.ghs.server.socket.exception.SendErrorException;
import de.champonthis.ghs.server.socket.model.MessageType;

/**
 * The Class MessageHandler.
 */
@Component
public class MessageHandler extends TextWebSocketHandler {

	List<WebSocketSession> webSocketSessions = Collections.synchronizedList(new ArrayList<>());

	@Autowired
	private GameManager gameManager;
	@Autowired
	private Gson gson;

	@Value("${ghs-server.public:false}")
	private boolean isPublic;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		webSocketSessions.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		webSocketSessions.remove(session);
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
						gameId = gameManager.createGame(new Game());
						gameManager.createPassword(password, gameId);
					} else {
						sendError(session, "Invalid password '" + password + "'");
					}
				}

				Game game = gameManager.getGame(gameId);

				if (game == null) {
					sendError(session, "No game found for 'id=" + gameId + "'");
				}

				MessageType type = MessageType.valueOf(messageObject.get("type").getAsString().toUpperCase());
				if (MessageType.GAME.equals(type)) {

					if (messageObject.get("payload") == null || messageObject.get("payload").isJsonNull()) {
						sendError(session, "'payload' missing");
					}

					Game gameUpdate = gson.fromJson(messageObject.get("payload"), Game.class);

					if (gameUpdate == null) {
						sendError(session, "invalid game payload");
					}

					gameManager.setGame(gameId, gameUpdate);

					for (WebSocketSession webSocketSession : webSocketSessions) {
						if (webSocketSession != session) {
							webSocketSession.sendMessage(new TextMessage(gson.toJson(gameUpdate)));
						}
					}
				} else if (MessageType.REQUEST.equals(type)) {
					session.sendMessage(new TextMessage(gson.toJson(game)));
				} else {
					sendError(session, "invalid message type");
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
		session.sendMessage(new TextMessage("Error: " + message));
		if (stop) {
			throw new SendErrorException("Error: " + message);
		}
	}

}
