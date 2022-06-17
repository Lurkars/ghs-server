/**
 * 
 */
package de.champonthis.ghs.server.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The Class GsonConfig.
 */
@Configuration
public class GsonConfig {

	/**
	 * Gson.
	 *
	 * @return the gson
	 */
	@Bean
	public Gson gson() {
		return new GsonBuilder().registerTypeAdapterFactory(new RequiredTypeAdapterFactory()).create();
	}
}
