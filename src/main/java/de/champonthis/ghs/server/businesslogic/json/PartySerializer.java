/**
 * 
 */
package de.champonthis.ghs.server.businesslogic.json;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import de.champonthis.ghs.server.model.LootType;
import de.champonthis.ghs.server.model.Party;
import de.champonthis.ghs.server.util.RequiredTypeAdapterFactory;

/**
 * The Class PartySerializer.
 */
public class PartySerializer implements JsonSerializer<Party> {

	private Gson gson = new GsonBuilder().registerTypeAdapterFactory(new RequiredTypeAdapterFactory()).create();

	@Override
	public JsonElement serialize(Party src, Type typeOfSrc, JsonSerializationContext context) {

		Map<LootType, Integer> loot = src.getLoot();

		src.setLoot(new HashMap<>());
		JsonObject result = gson.toJsonTree(src, Party.class).getAsJsonObject();
		src.setLoot(loot);

		JsonObject lootJson = new JsonObject();

		if (loot != null) {
			for (Entry<LootType, Integer> entry : loot.entrySet()) {
				lootJson.addProperty(entry.getKey().name().toLowerCase(),
						entry.getValue() != null ? entry.getValue() : 0);
			}
		}

		result.add("loot", lootJson);

		return result;
	}

}
