package de.champonthis.ghs.server.businesslogic.json;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.champonthis.ghs.server.model.CharacterProgress;
import de.champonthis.ghs.server.model.RpgPowerState;

class CharacterProgressRpgTests {

	private final Gson gson = new GsonBuilder()
			.registerTypeAdapter(CharacterProgress.class, new CharacterProgressDeserializer())
			.registerTypeAdapter(CharacterProgress.class, new CharacterProgressSerializer()).create();

	@Test
	void roundTripsRpgProgress() {
		String json = "{\"loot\":{},\"items\":[],\"equippedItems\":[],\"personalQuestProgress\":[],\"perks\":[],\"masteries\":[],"
				+ "\"scenarioStats\":[],\"deck\":[],\"enhancements\":[],"
				+ "\"rpg\":{\"attributes\":{\"grit\":3,\"logic\":1},\"pronouns\":\"she/her\",\"playerName\":\"Alex\","
				+ "\"ancestry\":\"Inox\",\"backgrounds\":\"Pit fighter\",\"personalGoal\":\"Retire rich\","
				+ "\"items\":[{\"equipped\":true,\"slot\":\"Hand\",\"name\":\"Battle Axe\",\"initiative\":\"40\",\"effect\":\"Attack 3\",\"spent\":false}],"
				+ "\"factions\":[{\"name\":\"The Shields\",\"tier\":2,\"benefits\":[\"Discount\"]}],"
				+ "\"talents\":[{\"gained\":true,\"name\":\"Berserk\",\"initiative\":\"\",\"bonus\":\"\",\"primary\":\"Passive\",\"secondary\":\"\"}],"
				+ "\"ancestrySkills\":[],"
				+ "\"classSkills\":[{\"gained\":true,\"prepared\":true,\"name\":\"Into the Fight\",\"initiative\":\"15\",\"bonus\":\"1\",\"primary\":\"Attack 3\",\"secondary\":\"Move 2\",\"state\":\"expended\"}]}}";

		CharacterProgress progress = gson.fromJson(json, CharacterProgress.class);

		assertThat(progress.getRpg().getAttributes()).containsEntry("grit", 3).containsEntry("logic", 1);
		assertThat(progress.getRpg().getItems().getFirst().getName()).isEqualTo("Battle Axe");
		assertThat(progress.getRpg().getFactions().getFirst().getTier()).isEqualTo(2);
		assertThat(progress.getRpg().getClassSkills().getFirst().getState()).isEqualTo(RpgPowerState.EXPENDED);
		assertThat(progress.getRpg().getClassSkills().getFirst().isPrepared()).isTrue();
		assertThat(progress.getRpg().getTalents().getFirst().isPrepared()).isFalse();
		assertThat(progress.getRpg().getTalents().getFirst().getState()).isNull();

		JsonObject rpg = JsonParser.parseString(gson.toJson(progress)).getAsJsonObject().getAsJsonObject("rpg");
		assertThat(rpg.getAsJsonObject("attributes").get("grit").getAsInt()).isEqualTo(3);
		assertThat(rpg.getAsJsonArray("classSkills").get(0).getAsJsonObject().get("state").getAsString()).isEqualTo("expended");
		assertThat(rpg.getAsJsonArray("factions").get(0).getAsJsonObject().getAsJsonArray("benefits").get(0).getAsString())
				.isEqualTo("Discount");
	}

	@Test
	void keepsRpgAbsentForNonRpgCharacters() {
		String json = "{\"loot\":{},\"items\":[],\"equippedItems\":[],\"personalQuestProgress\":[],\"perks\":[],\"masteries\":[],"
				+ "\"scenarioStats\":[],\"deck\":[],\"enhancements\":[]}";

		CharacterProgress progress = gson.fromJson(json, CharacterProgress.class);

		assertThat(progress.getRpg()).isNull();
		assertThat(JsonParser.parseString(gson.toJson(progress)).getAsJsonObject().has("rpg")).isFalse();
	}
}
