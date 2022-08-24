/**
 * 
 */
package de.champonthis.ghs.server.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

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

	/**
	 * Creates the servlet server container factory bean.
	 *
	 * @return the servlet server container factory bean
	 */
	@Bean
	public ServletServerContainerFactoryBean createServletServerContainerFactoryBean() {
	    ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
	    container.setMaxTextMessageBufferSize(64000);
	    container.setMaxBinaryMessageBufferSize(64000);
	    return container;
	}
	
}
