/**
 * 
 */
package de.champonthis.ghs.server.socket.model;

import org.springframework.web.socket.WebSocketSession;

/**
 * The Class WebSocketSessionContainer.
 */
public class WebSocketSessionContainer {

	private long gameId;
	private WebSocketSession session;

	/**
	 * Instantiates a new web socket session container.
	 *
	 * @param gameId  the game id
	 * @param session the session
	 */
	public WebSocketSessionContainer(long gameId, WebSocketSession session) {
		this.gameId = gameId;
		this.session = session;
	}

	/**
	 * Gets the game id.
	 *
	 * @return the game id
	 */
	public long getGameId() {
		return gameId;
	}

	/**
	 * Sets the game id.
	 *
	 * @param gameId the new game id
	 */
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public WebSocketSession getSession() {
		return session;
	}

	/**
	 * Sets the session.
	 *
	 * @param session the new session
	 */
	public void setSession(WebSocketSession session) {
		this.session = session;
	}

}
