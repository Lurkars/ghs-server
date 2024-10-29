package de.champonthis.ghs.server.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;

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
	private LinkedList<GameCharacterModel> availableCharacters = new LinkedList<>();
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
	private Integer trials;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public LinkedList<ConditionName> getConditions() {
		return conditions;
	}

	public void setConditions(LinkedList<ConditionName> conditions) {
		this.conditions = conditions;
	}

	public LinkedList<String> getBattleGoalEditions() {
		return battleGoalEditions;
	}

	public void setBattleGoalEditions(LinkedList<String> battleGoalEditions) {
		this.battleGoalEditions = battleGoalEditions;
	}

	public LinkedList<Identifier> getFilteredBattleGoals() {
		return filteredBattleGoals;
	}

	public void setFilteredBattleGoals(LinkedList<Identifier> filteredBattleGoals) {
		this.filteredBattleGoals = filteredBattleGoals;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAchievements() {
		return achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	public LinkedList<String> getAchievementsList() {
		return achievementsList;
	}

	public void setAchievementsList(LinkedList<String> achievementsList) {
		this.achievementsList = achievementsList;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public int getProsperity() {
		return prosperity;
	}

	public void setProsperity(int prosperity) {
		this.prosperity = prosperity;
	}

	public LinkedList<GameScenarioModel> getScenarios() {
		return scenarios;
	}

	public void setScenarios(LinkedList<GameScenarioModel> scenarios) {
		this.scenarios = scenarios;
	}

	public LinkedList<GameScenarioModel> getConclusions() {
		return conclusions;
	}

	public void setConclusions(LinkedList<GameScenarioModel> conclusions) {
		this.conclusions = conclusions;
	}

	public LinkedList<GameScenarioModel> getCasualScenarios() {
		return casualScenarios;
	}

	public void setCasualScenarios(LinkedList<GameScenarioModel> casualScenarios) {
		this.casualScenarios = casualScenarios;
	}

	public LinkedList<GameScenarioModel> getManualScenarios() {
		return manualScenarios;
	}

	public void setManualScenarios(LinkedList<GameScenarioModel> manualScenarios) {
		this.manualScenarios = manualScenarios;
	}

	public boolean isCampaignMode() {
		return campaignMode;
	}

	public void setCampaignMode(boolean campaignMode) {
		this.campaignMode = campaignMode;
	}

	public String getGlobalAchievements() {
		return globalAchievements;
	}

	public void setGlobalAchievements(String globalAchievements) {
		this.globalAchievements = globalAchievements;
	}

	public LinkedList<String> getGlobalAchievementsList() {
		return globalAchievementsList;
	}

	public void setGlobalAchievementsList(LinkedList<String> globalAchievementsList) {
		this.globalAchievementsList = globalAchievementsList;
	}

	public LinkedList<Identifier> getTreasures() {
		return treasures;
	}

	public void setTreasures(LinkedList<Identifier> treasures) {
		this.treasures = treasures;
	}

	public int getDonations() {
		return donations;
	}

	public void setDonations(int donations) {
		this.donations = donations;
	}

	public LinkedList<String> getPlayers() {
		return players;
	}

	public void setPlayers(LinkedList<String> players) {
		this.players = players;
	}

	public LinkedList<GameCharacterModel> getCharacters() {
		return characters;
	}

	public void setCharacters(LinkedList<GameCharacterModel> characters) {
		this.characters = characters;
	}

	public LinkedList<GameCharacterModel> getAvailableCharacters() {
		return availableCharacters;
	}

	public void setAvailableCharacters(LinkedList<GameCharacterModel> availableCharacters) {
		this.availableCharacters = availableCharacters;
	}

	public int getWeeks() {
		return weeks;
	}

	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}

	public Map<Integer, LinkedList<String>> getWeekSections() {
		return weekSections;
	}

	public void setWeekSections(Map<Integer, LinkedList<String>> weekSections) {
		this.weekSections = weekSections;
	}

	public Map<LootType, Integer> getLoot() {
		return loot;
	}

	public void setLoot(Map<LootType, Integer> loot) {
		this.loot = loot;
	}

	public LinkedList<GameScenarioModel> getRandomItemLooted() {
		return randomItemLooted;
	}

	public void setRandomItemLooted(LinkedList<GameScenarioModel> randomItemLooted) {
		this.randomItemLooted = randomItemLooted;
	}

	public int getInspiration() {
		return inspiration;
	}

	public void setInspiration(int inspiration) {
		this.inspiration = inspiration;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSoldiers() {
		return soldiers;
	}

	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}

	public int getMorale() {
		return morale;
	}

	public void setMorale(int morale) {
		this.morale = morale;
	}

	public int getTownGuardPerks() {
		return townGuardPerks;
	}

	public void setTownGuardPerks(int townGuardPerks) {
		this.townGuardPerks = townGuardPerks;
	}

	public LinkedList<GameCharacterModel> getRetirements() {
		return retirements;
	}

	public void setRetirements(LinkedList<GameCharacterModel> retirements) {
		this.retirements = retirements;
	}

	public LinkedList<CountIdentifier> getUnlockedItems() {
		return unlockedItems;
	}

	public void setUnlockedItems(LinkedList<CountIdentifier> unlockedItems) {
		this.unlockedItems = unlockedItems;
	}

	public LinkedList<String> getUnlockedCharacters() {
		return unlockedCharacters;
	}

	public void setUnlockedCharacters(LinkedList<String> unlockedCharacters) {
		this.unlockedCharacters = unlockedCharacters;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean getLevelCalculation() {
		return levelCalculation;
	}

	public void setLevelCalculation(Boolean levelCalculation) {
		this.levelCalculation = levelCalculation;
	}

	public Integer getLevelAdjustment() {
		return levelAdjustment;
	}

	public void setLevelAdjustment(Integer levelAdjustment) {
		this.levelAdjustment = levelAdjustment;
	}

	public Integer getBonusAdjustment() {
		return bonusAdjustment;
	}

	public void setBonusAdjustment(Integer bonusAdjustment) {
		this.bonusAdjustment = bonusAdjustment;
	}

	public Boolean getGe5Player() {
		return ge5Player;
	}

	public void setGe5Player(Boolean ge5Player) {
		this.ge5Player = ge5Player;
	}

	public Integer getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(Integer playerCount) {
		this.playerCount = playerCount;
	}

	public Boolean getSolo() {
		return solo;
	}

	public void setSolo(Boolean solo) {
		this.solo = solo;
	}

	public LinkedList<String> getTownGuardPerkSections() {
		return townGuardPerkSections;
	}

	public void setTownGuardPerkSections(LinkedList<String> townGuardPerkSections) {
		this.townGuardPerkSections = townGuardPerkSections;
	}

	public LinkedList<String> getCampaignStickers() {
		return campaignStickers;
	}

	public void setCampaignStickers(LinkedList<String> campaignStickers) {
		this.campaignStickers = campaignStickers;
	}

	public GameAttackModifierDeckModel getTownGuardDeck() {
		return townGuardDeck;
	}

	public void setTownGuardDeck(GameAttackModifierDeckModel townGuardDeck) {
		this.townGuardDeck = townGuardDeck;
	}

	public LinkedList<BuildingModel> getBuildings() {
		return buildings;
	}

	public void setBuildings(LinkedList<BuildingModel> buildings) {
		this.buildings = buildings;
	}

	public LinkedList<Loot> getLootDeckEnhancements() {
		return lootDeckEnhancements;
	}

	public void setLootDeckEnhancements(LinkedList<Loot> lootDeckEnhancements) {
		this.lootDeckEnhancements = lootDeckEnhancements;
	}

	public LinkedList<LootType> getLootDeckFixed() {
		return lootDeckFixed;
	}

	public void setLootDeckFixed(LinkedList<LootType> lootDeckFixed) {
		this.lootDeckFixed = lootDeckFixed;
	}

	public LinkedList<String> getLootDeckSections() {
		return lootDeckSections;
	}

	public void setLootDeckSections(LinkedList<String> lootDeckSections) {
		this.lootDeckSections = lootDeckSections;
	}

	public Boolean getEnvelopeB() {
		return envelopeB;
	}

	public void setEnvelopeB(Boolean envelopeB) {
		this.envelopeB = envelopeB;
	}

	public Integer getTrials() {
		return trials;
	}

	public void setTrials(Integer trials) {
		this.trials = trials;
	}

}
