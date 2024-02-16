/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Party.
 */
public class Party {

	private int id = 0;
	private String name;
	private String edition;
	private LinkedList<ConditionName> conditions = new LinkedList<>();
	private LinkedList<String> battleGoalEditions = new LinkedList<>();
	private LinkedList<Identifier> filteredBattleGoals = new LinkedList<>();
	private String location;
	private String notes;
	private String achievements;
	@Required
	private LinkedList<String> achievementsList = new LinkedList<>();
	private int reputation = 0;
	private int prosperity = 0;
	@Required
	private LinkedList<GameScenarioModel> scenarios = new LinkedList<>();
	@Required
	private LinkedList<GameScenarioModel> conclusions = new LinkedList<>();
	@Required
	private LinkedList<GameScenarioModel> casualScenarios = new LinkedList<>();
	@Required
	private LinkedList<GameScenarioModel> manualScenarios = new LinkedList<>();
	private boolean campaignMode = false;
	private String globalAchievements;
	@Required
	private LinkedList<String> globalAchievementsList = new LinkedList<>();
	@Required
	private LinkedList<Identifier> treasures = new LinkedList<>();
	private int donations = 0;
	@Required
	private LinkedList<String> players = new LinkedList<>();
	@Required
	private LinkedList<GameCharacterModel> characters = new LinkedList<>();
	@Required
	private LinkedList<GameCharacterModel> retirements = new LinkedList<>();
	@Required
	private LinkedList<CountIdentifier> unlockedItems = new LinkedList<>();
	@Required
	private LinkedList<String> unlockedCharacters = new LinkedList<>();
	private Integer level;
	private Boolean levelCalculation;
	private Integer levelAdjustment;
	private Integer bonusAdjustment;
	private Boolean ge5Player;
	private Integer playerCount;
	private Boolean solo;
	private int weeks = 0;
	@Required
	private Map<Integer, LinkedList<String>> weekSections = new HashMap<>();
	@Required
	private Map<LootType, Integer> loot = new HashMap<>();
	@Required
	private LinkedList<GameScenarioModel> randomItemLooted = new LinkedList<>();
	private int inspiration = 0;
	private int defense = 0;
	private int soldiers = 0;
	private int morale = 0;
	private int townGuardPerks = 0;
	@Required
	private LinkedList<String> townGuardPerkSections = new LinkedList<>();
	@Required
	private LinkedList<String> campaignStickers = new LinkedList<>();
	@Required
	private GameAttackModifierDeckModel townGuardDeck = new GameAttackModifierDeckModel();
	@Required
	private LinkedList<BuildingModel> buildings = new LinkedList<>();
	@Required
	private LinkedList<Loot> lootDeckEnhancements = new LinkedList<>();
	@Required
	private LinkedList<LootType> lootDeckFixed = new LinkedList<>();
	@Required
	private LinkedList<String> lootDeckSections = new LinkedList<>();
	private Boolean envelopeB;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the edition.
	 *
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * Sets the edition.
	 *
	 * @param edition the new edition
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * Gets the conditions.
	 *
	 * @return the conditions
	 */
	public LinkedList<ConditionName> getConditions() {
		return conditions;
	}

	/**
	 * Sets the conditions.
	 *
	 * @param conditions the new conditions
	 */
	public void setConditions(LinkedList<ConditionName> conditions) {
		this.conditions = conditions;
	}

	/**
	 * Gets the battle goal editions.
	 *
	 * @return the battle goal editions
	 */
	public LinkedList<String> getBattleGoalEditions() {
		return battleGoalEditions;
	}

	/**
	 * Sets the battle goal editions.
	 *
	 * @param battleGoalEditions the new battle goal editions
	 */
	public void setBattleGoalEditions(LinkedList<String> battleGoalEditions) {
		this.battleGoalEditions = battleGoalEditions;
	}

	/**
	 * Gets the filtered battle goals.
	 *
	 * @return the filtered battle goals
	 */
	public LinkedList<Identifier> getFilteredBattleGoals() {
		return filteredBattleGoals;
	}

	/**
	 * Sets the filtered battle goals.
	 *
	 * @param filteredBattleGoals the new filtered battle goals
	 */
	public void setFilteredBattleGoals(LinkedList<Identifier> filteredBattleGoals) {
		this.filteredBattleGoals = filteredBattleGoals;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the notes.
	 *
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Sets the notes.
	 *
	 * @param notes the new notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Gets the achievements.
	 *
	 * @return the achievements
	 */
	public String getAchievements() {
		return achievements;
	}

	/**
	 * Sets the achievements.
	 *
	 * @param achievements the new achievements
	 */
	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	/**
	 * Gets the achievements list.
	 *
	 * @return the achievements list
	 */
	public LinkedList<String> getAchievementsList() {
		return achievementsList;
	}

	/**
	 * Sets the achievements list.
	 *
	 * @param achievementsList the new achievements list
	 */
	public void setAchievementsList(LinkedList<String> achievementsList) {
		this.achievementsList = achievementsList;
	}

	/**
	 * Gets the reputation.
	 *
	 * @return the reputation
	 */
	public int getReputation() {
		return reputation;
	}

	/**
	 * Sets the reputation.
	 *
	 * @param reputation the new reputation
	 */
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	/**
	 * Gets the prosperity.
	 *
	 * @return the prosperity
	 */
	public int getProsperity() {
		return prosperity;
	}

	/**
	 * Sets the prosperity.
	 *
	 * @param prosperity the new prosperity
	 */
	public void setProsperity(int prosperity) {
		this.prosperity = prosperity;
	}

	/**
	 * Gets the scenarios.
	 *
	 * @return the scenarios
	 */
	public LinkedList<GameScenarioModel> getScenarios() {
		return scenarios;
	}

	/**
	 * Sets the scenarios.
	 *
	 * @param scenarios the new scenarios
	 */
	public void setScenarios(LinkedList<GameScenarioModel> scenarios) {
		this.scenarios = scenarios;
	}

	/**
	 * Gets the conclusions.
	 *
	 * @return the conclusions
	 */
	public LinkedList<GameScenarioModel> getConclusions() {
		return conclusions;
	}

	/**
	 * Sets the conclusions.
	 *
	 * @param conclusions the new conclusions
	 */
	public void setConclusions(LinkedList<GameScenarioModel> conclusions) {
		this.conclusions = conclusions;
	}

	/**
	 * Gets the casual scenarios.
	 *
	 * @return the casual scenarios
	 */
	public LinkedList<GameScenarioModel> getCasualScenarios() {
		return casualScenarios;
	}

	/**
	 * Sets the casual scenarios.
	 *
	 * @param casualScenarios the new casual scenarios
	 */
	public void setCasualScenarios(LinkedList<GameScenarioModel> casualScenarios) {
		this.casualScenarios = casualScenarios;
	}

	/**
	 * Gets the manual scenarios.
	 *
	 * @return the manual scenarios
	 */
	public LinkedList<GameScenarioModel> getManualScenarios() {
		return manualScenarios;
	}

	/**
	 * Sets the manual scenarios.
	 *
	 * @param manualScenarios the new manual scenarios
	 */
	public void setManualScenarios(LinkedList<GameScenarioModel> manualScenarios) {
		this.manualScenarios = manualScenarios;
	}

	/**
	 * Checks if is campaign mode.
	 *
	 * @return true, if is campaign mode
	 */
	public boolean isCampaignMode() {
		return campaignMode;
	}

	/**
	 * Sets the campaign mode.
	 *
	 * @param campaignMode the new campaign mode
	 */
	public void setCampaignMode(boolean campaignMode) {
		this.campaignMode = campaignMode;
	}

	/**
	 * Gets the global achievements.
	 *
	 * @return the global achievements
	 */
	public String getGlobalAchievements() {
		return globalAchievements;
	}

	/**
	 * Sets the global achievements.
	 *
	 * @param globalAchievements the new global achievements
	 */
	public void setGlobalAchievements(String globalAchievements) {
		this.globalAchievements = globalAchievements;
	}

	/**
	 * Gets the global achievements list.
	 *
	 * @return the global achievements list
	 */
	public LinkedList<String> getGlobalAchievementsList() {
		return globalAchievementsList;
	}

	/**
	 * Sets the global achievements list.
	 *
	 * @param globalAchievementsList the new global achievements list
	 */
	public void setGlobalAchievementsList(LinkedList<String> globalAchievementsList) {
		this.globalAchievementsList = globalAchievementsList;
	}

	/**
	 * Gets the treasures.
	 *
	 * @return the treasures
	 */
	public LinkedList<Identifier> getTreasures() {
		return treasures;
	}

	/**
	 * Sets the treasures.
	 *
	 * @param treasures the new treasures
	 */
	public void setTreasures(LinkedList<Identifier> treasures) {
		this.treasures = treasures;
	}

	/**
	 * Gets the donations.
	 *
	 * @return the donations
	 */
	public int getDonations() {
		return donations;
	}

	/**
	 * Sets the donations.
	 *
	 * @param donations the new donations
	 */
	public void setDonations(int donations) {
		this.donations = donations;
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public LinkedList<String> getPlayers() {
		return players;
	}

	/**
	 * Sets the players.
	 *
	 * @param players the new players
	 */
	public void setPlayers(LinkedList<String> players) {
		this.players = players;
	}

	/**
	 * Gets the characters.
	 *
	 * @return the characters
	 */
	public LinkedList<GameCharacterModel> getCharacters() {
		return characters;
	}

	/**
	 * Sets the characters.
	 *
	 * @param characters the new characters
	 */
	public void setCharacters(LinkedList<GameCharacterModel> characters) {
		this.characters = characters;
	}

	/**
	 * Gets the weeks.
	 *
	 * @return the weeks
	 */
	public int getWeeks() {
		return weeks;
	}

	/**
	 * Sets the weeks.
	 *
	 * @param weeks the new weeks
	 */
	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}

	/**
	 * Gets the week sections.
	 *
	 * @return the week sections
	 */
	public Map<Integer, LinkedList<String>> getWeekSections() {
		return weekSections;
	}

	/**
	 * Sets the week sections.
	 *
	 * @param weekSections the week sections
	 */
	public void setWeekSections(Map<Integer, LinkedList<String>> weekSections) {
		this.weekSections = weekSections;
	}

	/**
	 * Gets the loot.
	 *
	 * @return the loot
	 */
	public Map<LootType, Integer> getLoot() {
		return loot;
	}

	/**
	 * Sets the loot.
	 *
	 * @param loot the loot
	 */
	public void setLoot(Map<LootType, Integer> loot) {
		this.loot = loot;
	}

	/**
	 * Gets the random item looted.
	 *
	 * @return the random item looted
	 */
	public LinkedList<GameScenarioModel> getRandomItemLooted() {
		return randomItemLooted;
	}

	/**
	 * Sets the random item looted.
	 *
	 * @param randomItemLooted the new random item looted
	 */
	public void setRandomItemLooted(LinkedList<GameScenarioModel> randomItemLooted) {
		this.randomItemLooted = randomItemLooted;
	}

	/**
	 * Gets the inspiration.
	 *
	 * @return the inspiration
	 */
	public int getInspiration() {
		return inspiration;
	}

	/**
	 * Sets the inspiration.
	 *
	 * @param inspiration the new inspiration
	 */
	public void setInspiration(int inspiration) {
		this.inspiration = inspiration;
	}

	/**
	 * Gets the defense.
	 *
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Sets the defense.
	 *
	 * @param defense the new defense
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * Gets the soldiers.
	 *
	 * @return the soldiers
	 */
	public int getSoldiers() {
		return soldiers;
	}

	/**
	 * Sets the soldiers.
	 *
	 * @param soldiers the new soldiers
	 */
	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}

	/**
	 * Gets the morale.
	 *
	 * @return the morale
	 */
	public int getMorale() {
		return morale;
	}

	/**
	 * Sets the morale.
	 *
	 * @param morale the new morale
	 */
	public void setMorale(int morale) {
		this.morale = morale;
	}

	/**
	 * Gets the town guard perks.
	 *
	 * @return the town guard perks
	 */
	public int getTownGuardPerks() {
		return townGuardPerks;
	}

	/**
	 * Sets the town guard perks.
	 *
	 * @param townGuardPerks the new town guard perks
	 */
	public void setTownGuardPerks(int townGuardPerks) {
		this.townGuardPerks = townGuardPerks;
	}

	/**
	 * Gets the retirements.
	 *
	 * @return the retirements
	 */
	public LinkedList<GameCharacterModel> getRetirements() {
		return retirements;
	}

	/**
	 * Sets the retirements.
	 *
	 * @param retirements the new retirements
	 */
	public void setRetirements(LinkedList<GameCharacterModel> retirements) {
		this.retirements = retirements;
	}

	/**
	 * Gets the unlocked items.
	 *
	 * @return the unlocked items
	 */
	public LinkedList<CountIdentifier> getUnlockedItems() {
		return unlockedItems;
	}

	/**
	 * Sets the unlocked items.
	 *
	 * @param unlockedItems the new unlocked items
	 */
	public void setUnlockedItems(LinkedList<CountIdentifier> unlockedItems) {
		this.unlockedItems = unlockedItems;
	}

	/**
	 * Gets the unlocked characters.
	 *
	 * @return the unlocked characters
	 */
	public LinkedList<String> getUnlockedCharacters() {
		return unlockedCharacters;
	}

	/**
	 * Sets the unlocked characters.
	 *
	 * @param unlockedCharacters the new unlocked characters
	 */
	public void setUnlockedCharacters(LinkedList<String> unlockedCharacters) {
		this.unlockedCharacters = unlockedCharacters;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * Gets the level calculation.
	 *
	 * @return the level calculation
	 */
	public Boolean getLevelCalculation() {
		return levelCalculation;
	}

	/**
	 * Sets the level calculation.
	 *
	 * @param levelCalculation the new level calculation
	 */
	public void setLevelCalculation(Boolean levelCalculation) {
		this.levelCalculation = levelCalculation;
	}

	/**
	 * Gets the level adjustment.
	 *
	 * @return the level adjustment
	 */
	public Integer getLevelAdjustment() {
		return levelAdjustment;
	}

	/**
	 * Sets the level adjustment.
	 *
	 * @param levelAdjustment the new level adjustment
	 */
	public void setLevelAdjustment(Integer levelAdjustment) {
		this.levelAdjustment = levelAdjustment;
	}

	/**
	 * Gets the bonus adjustment.
	 *
	 * @return the bonus adjustment
	 */
	public Integer getBonusAdjustment() {
		return bonusAdjustment;
	}

	/**
	 * Sets the bonus adjustment.
	 *
	 * @param bonusAdjustment the new bonus adjustment
	 */
	public void setBonusAdjustment(Integer bonusAdjustment) {
		this.bonusAdjustment = bonusAdjustment;
	}

	/**
	 * Gets the ge 5 player.
	 *
	 * @return the ge 5 player
	 */
	public Boolean getGe5Player() {
		return ge5Player;
	}

	/**
	 * Sets the ge 5 player.
	 *
	 * @param ge5Player the new ge 5 player
	 */
	public void setGe5Player(Boolean ge5Player) {
		this.ge5Player = ge5Player;
	}

	/**
	 * Gets the player count.
	 *
	 * @return the player count
	 */
	public Integer getPlayerCount() {
		return playerCount;
	}

	/**
	 * Sets the player count.
	 *
	 * @param playerCount the new player count
	 */
	public void setPlayerCount(Integer playerCount) {
		this.playerCount = playerCount;
	}

	/**
	 * Gets the solo.
	 *
	 * @return the solo
	 */
	public Boolean getSolo() {
		return solo;
	}

	/**
	 * Sets the solo.
	 *
	 * @param solo the new solo
	 */
	public void setSolo(Boolean solo) {
		this.solo = solo;
	}

	/**
	 * Gets the town guard perk sections.
	 *
	 * @return the town guard perk sections
	 */
	public LinkedList<String> getTownGuardPerkSections() {
		return townGuardPerkSections;
	}

	/**
	 * Sets the town guard perk sections.
	 *
	 * @param townGuardPerkSections the new town guard perk sections
	 */
	public void setTownGuardPerkSections(LinkedList<String> townGuardPerkSections) {
		this.townGuardPerkSections = townGuardPerkSections;
	}

	/**
	 * Gets the campaign stickers.
	 *
	 * @return the campaign stickers
	 */
	public LinkedList<String> getCampaignStickers() {
		return campaignStickers;
	}

	/**
	 * Sets the campaign stickers.
	 *
	 * @param campaignStickers the new campaign stickers
	 */
	public void setCampaignStickers(LinkedList<String> campaignStickers) {
		this.campaignStickers = campaignStickers;
	}

	/**
	 * Gets the town guard deck.
	 *
	 * @return the town guard deck
	 */
	public GameAttackModifierDeckModel getTownGuardDeck() {
		return townGuardDeck;
	}

	/**
	 * Sets the town guard deck.
	 *
	 * @param townGuardDeck the new town guard deck
	 */
	public void setTownGuardDeck(GameAttackModifierDeckModel townGuardDeck) {
		this.townGuardDeck = townGuardDeck;
	}

	/**
	 * Gets the buildings.
	 *
	 * @return the buildings
	 */
	public LinkedList<BuildingModel> getBuildings() {
		return buildings;
	}

	/**
	 * Sets the buildings.
	 *
	 * @param buildings the new buildings
	 */
	public void setBuildings(LinkedList<BuildingModel> buildings) {
		this.buildings = buildings;
	}

	/**
	 * Gets the loot deck enhancements.
	 *
	 * @return the loot deck enhancements
	 */
	public LinkedList<Loot> getLootDeckEnhancements() {
		return lootDeckEnhancements;
	}

	/**
	 * Sets the loot deck enhancements.
	 *
	 * @param lootDeckEnhancements the new loot deck enhancements
	 */
	public void setLootDeckEnhancements(LinkedList<Loot> lootDeckEnhancements) {
		this.lootDeckEnhancements = lootDeckEnhancements;
	}

	/**
	 * Gets the loot deck fixed.
	 *
	 * @return the loot deck fixed
	 */
	public LinkedList<LootType> getLootDeckFixed() {
		return lootDeckFixed;
	}

	/**
	 * Sets the loot deck fixed.
	 *
	 * @param lootDeckFixed the new loot deck fixed
	 */
	public void setLootDeckFixed(LinkedList<LootType> lootDeckFixed) {
		this.lootDeckFixed = lootDeckFixed;
	}

	/**
	 * Gets the loot deck sections.
	 *
	 * @return the loot deck sections
	 */
	public LinkedList<String> getLootDeckSections() {
		return lootDeckSections;
	}

	/**
	 * Sets the loot deck sections.
	 *
	 * @param lootDeckSections the new loot deck sections
	 */
	public void setLootDeckSections(LinkedList<String> lootDeckSections) {
		this.lootDeckSections = lootDeckSections;
	}

	/**
	 * Gets the envelope b.
	 *
	 * @return the envelope b
	 */
	public Boolean getEnvelopeB() {
		return envelopeB;
	}

	/**
	 * Sets the envelope b.
	 *
	 * @param envelopeB the new envelope b
	 */
	public void setEnvelopeB(Boolean envelopeB) {
		this.envelopeB = envelopeB;
	}

}
