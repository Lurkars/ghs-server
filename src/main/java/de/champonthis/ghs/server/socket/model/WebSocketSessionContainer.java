package de.champonthis.ghs.server.socket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

@Data
@AllArgsConstructor
public class WebSocketSessionContainer {

	private long gameId;
	private WebSocketSession session;

}
