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

import de.champonthis.ghs.server.model.CharacterProgress;
import de.champonthis.ghs.server.model.LootType;
import de.champonthis.ghs.server.model.Party;
import de.champonthis.ghs.server.model.ScenarioStats;
import de.champonthis.ghs.server.util.RequiredTypeAdapterFactory;

public class PartyDeserializer implements JsonDeserializer<Party> {

	private Gson gson = new GsonBuilder()
			.registerTypeAdapter(CharacterProgress.class, new CharacterProgressDeserializer())
			.registerTypeAdapter(CharacterProgress.class, new CharacterProgressSerializer())
			.registerTypeAdapter(ScenarioStats.class, new ScenarioStatsDeserializer())
			.registerTypeAdapter(ScenarioStats.class, new ScenarioStatsSerializer())
			.registerTypeAdapterFactory(new RequiredTypeAdapterFactory()).create();

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
			if (lootJson.get(key).isJsonPrimitive()) {
				party.getLoot().put(LootType.valueOf(key.toUpperCase()), lootJson.get(key).getAsInt());
			} else {
				party.getLoot().put(LootType.valueOf(key.toUpperCase()), 0);
			}
		}

		return party;
	}

}
