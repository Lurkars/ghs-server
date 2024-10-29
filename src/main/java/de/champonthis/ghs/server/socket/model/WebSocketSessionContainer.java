package de.champonthis.ghs.server.socket.model;

import org.springframework.web.socket.WebSocketSession;

public class WebSocketSessionContainer {

	private long gameId;
	private WebSocketSession session;

	public WebSocketSessionContainer(long gameId, WebSocketSession session) {
		this.gameId = gameId;
		this.session = session;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public WebSocketSession getSession() {
		return session;
	}

	public void setSession(WebSocketSession session) {
		this.session = session;
	}

}
