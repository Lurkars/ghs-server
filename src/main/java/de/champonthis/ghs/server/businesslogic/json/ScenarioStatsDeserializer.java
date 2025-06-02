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
import de.champonthis.ghs.server.model.ScenarioStats;
import de.champonthis.ghs.server.util.RequiredTypeAdapterFactory;

public class ScenarioStatsDeserializer implements JsonDeserializer<ScenarioStats> {

	private final Gson gson = new GsonBuilder().registerTypeAdapterFactory(new RequiredTypeAdapterFactory()).create();

	@Override
	public ScenarioStats deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
			throws JsonParseException {

		JsonObject jsonObject = jsonElement.getAsJsonObject();
		JsonObject lootJson = new JsonObject();

		if (jsonObject.has("loot")) {
			lootJson = jsonObject.getAsJsonObject("loot");
			jsonObject.add("loot", new JsonObject());
		}

		ScenarioStats stats = gson.fromJson(jsonObject, ScenarioStats.class);
		stats.setLoot(new HashMap<>());

		for (String key : lootJson.keySet()) {
			if (lootJson.get(key).isJsonPrimitive()) {
				stats.getLoot().put(LootType.valueOf(key.toUpperCase()), lootJson.get(key).getAsInt());
			} else {
				stats.getLoot().put(LootType.valueOf(key.toUpperCase()), 0);
			}
		}

		return stats;
	}

}
