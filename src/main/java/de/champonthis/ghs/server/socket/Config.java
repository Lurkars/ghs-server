/**
 * 
 */
package de.champonthis.ghs.server.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * The Class Config.
 */
@Configuration
@EnableWebSocket
public class Config implements WebSocketConfigurer {

	@Autowired
	private MessageHandler messageHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
		webSocketHandlerRegistry.addHandler(messageHandler, "/").setAllowedOrigins("*");
	}

}
