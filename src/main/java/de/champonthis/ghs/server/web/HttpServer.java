/**
 * 
 */
package de.champonthis.ghs.server.web;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * The Class HttpServer.
 */
@Component
public class HttpServer {

	/**
	 * Servlet container.
	 *
	 * @param httpPort the http port
	 * @return the servlet web server factory
	 */
	@Bean
	@Conditional(HttpServerCondition.class)
	public ServletWebServerFactory servletContainer(@Value("${server.http.port:8081}") int httpPort) {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setPort(httpPort);

		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(connector);
		return tomcat;
	}
}
