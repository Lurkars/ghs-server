package de.champonthis.ghs.server.businesslogic.json;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.champonthis.ghs.server.model.Party;
import de.champonthis.ghs.server.model.ScenarioFinish;
import de.champonthis.ghs.server.util.GsonConfig;

class PartyOutpostAttackTests {

	private final Gson gson = new GsonConfig().gson();

	@Test
	void roundTripsOutpostAttack() {
		String json = "{\"loot\":{},\"factionUnlocks\":[\"a\"],\"outpostAttack\":{"
				+ "\"attack\":{\"attackValue\":\"30 +5\",\"targetNumber\":2,\"target\":{\"parity\":\"even\",\"distance\":{\"x\":1.5,\"y\":2}},\"effects\":[]},"
				+ "\"effects\":[{\"type\":\"outpostAttack\",\"values\":[5]}],"
				+ "\"manualAttackValue\":50,\"manualTargetNumber\":4,\"target\":{\"parity\":0,\"level\":\"low\",\"distance\":\"previousTarget\"},"
				+ "\"buildings\":[\"mining-camp\",\"barracks\"],\"others\":[\"garden\"],\"attacks\":1,\"soldiers\":2,"
				+ "\"drawnBefore\":3,\"attackResult\":4,"
				+ "\"resources\":[{\"effect\":{\"type\":\"collectiveResource\",\"values\":[1,\"hide\"]},\"enabled\":false}]}}";

		Party party = gson.fromJson(json, Party.class);
		assertThat(party.getOutpostAttack().getBuildings()).containsExactly("mining-camp", "barracks");
		assertThat(party.getOutpostAttack().getResources().getFirst().isEnabled()).isFalse();
		assertThat(party.getFactionUnlocks()).containsExactly("a");

		JsonObject result = JsonParser.parseString(gson.toJson(party)).getAsJsonObject();
		JsonObject expected = JsonParser.parseString(json).getAsJsonObject().getAsJsonObject("outpostAttack");
		assertThat(result.getAsJsonObject("outpostAttack")).isEqualTo(expected);
	}

	@Test
	void keepsOutpostAttackAbsent() {
		Party party = gson.fromJson("{\"loot\":{}}", Party.class);
		assertThat(party.getOutpostAttack()).isNull();
		assertThat(JsonParser.parseString(gson.toJson(party)).getAsJsonObject().has("outpostAttack")).isFalse();
	}

	@Test
	void roundTripsScenarioFinishTexts() {
		ScenarioFinish finish = gson.fromJson("{\"overlayCustomText\":\"text\",\"calendarSectionConditional\":[true,false]}",
				ScenarioFinish.class);
		JsonObject result = JsonParser.parseString(gson.toJson(finish)).getAsJsonObject();
		assertThat(result.get("overlayCustomText").getAsString()).isEqualTo("text");
		assertThat(result.getAsJsonArray("calendarSectionConditional").get(1).getAsBoolean()).isFalse();
	}
}
