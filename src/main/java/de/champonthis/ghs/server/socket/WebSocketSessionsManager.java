package de.champonthis.ghs.server.socket;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketSessionsManager {
	private final Map<Long, List<WebSocketSession>> sessionsByGameId = new ConcurrentHashMap<>();
	private final Map<String, WebSocketSession> sessionsBySessionId = new ConcurrentHashMap<>();
	private final Map<String, Long> sessionIdToGameId = new ConcurrentHashMap<>();

	/**
	 * Adds a WebSocket session to the manager, associating it with a game ID.
	 *
	 * @param gameId  the ID of the game
	 * @param session the WebSocket session to add
	 */
	public void addSession(long gameId, WebSocketSession session) {
		sessionsByGameId.computeIfAbsent(gameId, k -> new ArrayList<>()).add(session);
		sessionsBySessionId.put(session.getId(), session);
		sessionIdToGameId.put(session.getId(), gameId);
	}

	/**
	 * Retrieves a WebSocket session by its sessionId.
	 *
	 * @param sessionId the ID of the WebSocket session
	 * @return the WebSocket session, or null if not found
	 */
	public WebSocketSession getSessionById(String sessionId) {
		return sessionsBySessionId.get(sessionId);
	}

	/**
	 * Retrieves all WebSocket sessions associated with a gameId.
	 *
	 * @param gameId the ID of the game
	 * @return a list of WebSocket sessions associated with the gameId, or an empty list if no sessions exist for that gameId.
	 */
	public List<WebSocketSession> getSessionsByGameId(long gameId) {
		return sessionsByGameId.getOrDefault(gameId, Collections.emptyList());
	}

	/**
	 * Retrieves a WebSocket session by its sessionId.
	 *
	 * @param sessionId the WebSocket sessionId
	 * @return the gameId associated with the sessionId, or null if not found
	 */
	public Long getGameIdBySessionId(String sessionId) {
		return sessionIdToGameId.get(sessionId);
	}

	/**
	 * Retrieves the gameId associated with a WebSocket session.
	 *
	 * @param session the WebSocket session
	 * @return the gameId associated with the session, or null if not found
	 */
	public Long getGameIdBySession(WebSocketSession session) {
		return sessionIdToGameId.get(session.getId());
	}

	/**
	 * Retrieves all WebSocket sessions associated with a gameId, excluding the session with the specified sessionId.
	 *
	 * @param gameId    the ID of the game
	 * @param sessionId the ID of the session to search by and exclude
	 * @return a list of WebSocket sessions associated with the gameId, excluding the specified sessionId
	 */
	public List<WebSocketSession> getOtherSessions(Long gameId, String sessionId) {
		return sessionsByGameId.getOrDefault(gameId, Collections.emptyList())
				.stream()
				.filter(s -> !StringUtils.equals(s.getId(), sessionId))
				.toList();
	}

	/**
	 * Removes a WebSocket session by its sessionId.
	 *
	 * @param sessionId the ID of the WebSocket session to remove
	 */
	public void removeSessionById(String sessionId) {
		Long gameId = sessionIdToGameId.remove(sessionId);
		if (gameId != null) {
			List<WebSocketSession> sessions = sessionsByGameId.get(gameId);
			if (!CollectionUtils.isEmpty(sessions)) {
				sessions.removeIf(s -> StringUtils.equals(s.getId(), sessionId));
				if (CollectionUtils.isEmpty(sessions)) {
					sessionsByGameId.remove(gameId);
				}
			}
		}
	}

	/**
	 * Removes a WebSocket session from the manager.
	 *
	 * @param session the WebSocket session to remove
	 */
	public void removeSession(WebSocketSession session) {
		removeSessionById(session.getId());
	}

	/**
	 * Retrieves the server session ID for a given game ID.
	 *
	 * @param gameId the ID of the game
	 * @return the server session ID, or null if no sessions exist for that game ID
	 */
	public String getServerSessionId(Long gameId) {
		List<WebSocketSession> sessions = getSessionsByGameId(gameId);
		if (CollectionUtils.isEmpty(sessions)) {
			return null;
		}
		WebSocketSession firstSession = sessions.get(0);
		return firstSession.getId();
	}

	/**
	 * Checks if the given WebSocket session is the server session for the specified game ID.
	 *
	 * @param session the WebSocket session to check
	 * @param gameId  the ID of the game
	 * @return true if the session is the server session for the game ID, false otherwise
	 */
	public boolean isServerSession(WebSocketSession session, Long gameId) {
		return StringUtils.equals(getServerSessionId(gameId), session.getId());
	}

	/**
	 * When a session connects for the first time, it gets a gameId of -1L. When it sends a message for the first time, it needs to be associated with a real gameId.
	 *
	 * @param gameId  the ID of the game
	 * @param session the new WebSocket session to associate with the game ID
	 */
	public void updateSession(Long gameId, WebSocketSession session) {
		removeSession(session);
		addSession(gameId, session);
	}
}
