package de.champonthis.ghs.server.socket.model;

import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebSocketSessionContainer {

	private long gameId;
	private WebSocketSession session;

}
