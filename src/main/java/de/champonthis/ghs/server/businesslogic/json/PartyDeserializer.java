/**
 * 
 */
package de.champonthis.ghs.server.businesslogic.json;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import de.champonthis.ghs.server.model.LootType;
import de.champonthis.ghs.server.model.Party;
import de.champonthis.ghs.server.util.RequiredTypeAdapterFactory;

/**
 * The Class PartyDeserializer.
 */
public class PartyDeserializer implements JsonDeserializer<Party> {

	private Gson gson = new GsonBuilder().registerTypeAdapterFactory(new RequiredTypeAdapterFactory()).create();

	@Override
	public Party deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
			throws JsonParseException {

		JsonObject jsonObject = jsonElement.getAsJsonObject();
		JsonObject lootJson = new JsonObject();

		if (jsonObject.has("loot")) {
			lootJson = jsonObject.getAsJsonObject("loot");
			jsonObject.add("loot", new JsonObject());
		}

		Party party = gson.fromJson(jsonObject, Party.class);
		party.setLoot(new HashMap<>());

		for (String key : lootJson.keySet()) {
			party.getLoot().put(LootType.valueOf(key.toUpperCase()), lootJson.get(key).getAsInt());
		}

		return party;
	}

}
