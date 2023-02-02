/**
 * 
 */
package de.champonthis.ghs.server.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.champonthis.ghs.server.businesslogic.json.CharacterProgressDeserializer;
import de.champonthis.ghs.server.businesslogic.json.CharacterProgressSerializer;
import de.champonthis.ghs.server.model.CharacterProgress;

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
		return new GsonBuilder().registerTypeAdapter(CharacterProgress.class, new CharacterProgressDeserializer())
				.registerTypeAdapter(CharacterProgress.class, new CharacterProgressSerializer())
				.registerTypeAdapterFactory(new RequiredTypeAdapterFactory()).create();
	}
}
