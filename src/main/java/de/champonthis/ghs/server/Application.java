/**
 * 
 */
package de.champonthis.ghs.server;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;

/**
 * The Class Application.
 */
@SpringBootApplication
@PropertySource("classpath:default.properties")
public class Application {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		if (!Arrays.asList(args).contains("-Djava.awt.headless=true")) {
			builder.headless(false);
		}
		builder.run(args);
	}

}
