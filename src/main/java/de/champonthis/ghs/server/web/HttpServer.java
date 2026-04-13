package de.champonthis.ghs.server.web;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.tomcat.TomcatWebServerFactory;
import org.springframework.boot.tomcat.servlet.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.servlet.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class HttpServer {

	@Bean
	@Conditional(HttpServerCondition.class)
	@ConditionalOnProperty(name = "server.ssl.enabled")
	public ServletWebServerFactory servletContainer(@Value("${server.http.port:8081}") int httpPort) {
		Connector connector = new Connector(TomcatWebServerFactory.DEFAULT_PROTOCOL);
		connector.setPort(httpPort);

		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalConnectors(connector);
		return tomcat;
	}
}
