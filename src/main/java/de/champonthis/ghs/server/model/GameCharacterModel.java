package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

public class GameCharacterModel {

	@Required
	private String name;
	@Required
	private String edition;
	@Required
	private boolean marker;
	private String title;
	@Required
	private int initiative;
	@Required
	private int experience;
	@Required
	private int loot;
	@Required
	private LinkedList<Integer> lootCards = new LinkedList<>();
	@Required
	private LinkedList<String> treasures = new LinkedList<>();
	@Required
	private boolean exhausted;
	@Required
	private int level;
	@Required
	private boolean off;
	@Required
	private boolean active;
	@Required
	private int health;
	@Required
	private int maxHealth;
	@Required
	private LinkedList<GameEntityConditionModel> entityConditions = new LinkedList<>();
	private LinkedList<ConditionName> immunities = new LinkedList<>();
	@Required
	private LinkedList<String> markers = new LinkedList<>();
	@Required
	private LinkedList<String> tags = new LinkedList<>();
	@Required
	private int identity;
	@Required
	private LinkedList<GameSummonModel> summons = new LinkedList<>();
	private CharacterProgress progress;
	private ScenarioStats scenarioStats;
	@Required
	private int number;
	@Required
	private GameAttackModifierDeckModel attackModifierDeck = new GameAttackModifierDeckModel();
	@Required
	private int donations;
	@Required
	private int token;
	@Required
	private LinkedList<Integer> tokenValues = new LinkedList<>();
	@Required
	private boolean absent;
	@Required
	private boolean longRest;
	@Required
	private LinkedList<Identifier> battleGoals = new LinkedList<>();
	private Boolean battleGoal = false;
	private String shield;
	private String shieldPersistent;
	@Required
	private LinkedList<String> retaliate = new LinkedList<>();
	@Required
	private LinkedList<String> retaliatePersistent = new LinkedList<>();

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

	public boolean isMarker() {
		return marker;
	}

	public void setMarker(boolean marker) {
		this.marker = marker;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getLoot() {
		return loot;
	}

	public void setLoot(int loot) {
		this.loot = loot;
	}

	public LinkedList<Integer> getLootCards() {
		return lootCards;
	}

	public void setLootCards(LinkedList<Integer> lootCards) {
		this.lootCards = lootCards;
	}

	public LinkedList<String> getTreasures() {
		return treasures;
	}

	public void setTreasures(LinkedList<String> treasures) {
		this.treasures = treasures;
	}

	public boolean isExhausted() {
		return exhausted;
	}

	public void setExhausted(boolean exhausted) {
		this.exhausted = exhausted;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isOff() {
		return off;
	}

	public void setOff(boolean off) {
		this.off = off;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public LinkedList<GameEntityConditionModel> getEntityConditions() {
		return entityConditions;
	}

	public void setEntityConditions(LinkedList<GameEntityConditionModel> entityConditions) {
		this.entityConditions = entityConditions;
	}

	public LinkedList<ConditionName> getImmunities() {
		return immunities;
	}

	public void setImmunities(LinkedList<ConditionName> immunities) {
		this.immunities = immunities;
	}

	public LinkedList<String> getMarkers() {
		return markers;
	}

	public void setMarkers(LinkedList<String> markers) {
		this.markers = markers;
	}

	public LinkedList<String> getTags() {
		return tags;
	}

	public void setTags(LinkedList<String> tags) {
		this.tags = tags;
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public LinkedList<GameSummonModel> getSummons() {
		return summons;
	}

	public void setSummons(LinkedList<GameSummonModel> summons) {
		this.summons = summons;
	}

	public CharacterProgress getProgress() {
		return progress;
	}

	public void setProgress(CharacterProgress progress) {
		this.progress = progress;
	}

	public ScenarioStats getScenarioStats() {
		return scenarioStats;
	}

	public void setScenarioStats(ScenarioStats scenarioStats) {
		this.scenarioStats = scenarioStats;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public GameAttackModifierDeckModel getAttackModifierDeck() {
		return attackModifierDeck;
	}

	public void setAttackModifierDeck(GameAttackModifierDeckModel attackModifierDeck) {
		this.attackModifierDeck = attackModifierDeck;
	}

	public int getDonations() {
		return donations;
	}

	public void setDonations(int donations) {
		this.donations = donations;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public LinkedList<Integer> getTokenValues() {
		return tokenValues;
	}

	public void setTokenValues(LinkedList<Integer> tokenValues) {
		this.tokenValues = tokenValues;
	}

	public boolean isAbsent() {
		return absent;
	}

	public void setAbsent(boolean absent) {
		this.absent = absent;
	}

	public boolean isLongRest() {
		return longRest;
	}

	public void setLongRest(boolean longRest) {
		this.longRest = longRest;
	}

	public LinkedList<Identifier> getBattleGoals() {
		return battleGoals;
	}

	public void setBattleGoals(LinkedList<Identifier> battleGoals) {
		this.battleGoals = battleGoals;
	}

	public Boolean getBattleGoal() {
		return battleGoal;
	}

	public void setBattleGoal(Boolean battleGoal) {
		this.battleGoal = battleGoal;
	}

	public String getShield() {
		return shield;
	}

	public void setShield(String shield) {
		this.shield = shield;
	}

	public String getShieldPersistent() {
		return shieldPersistent;
	}

	public void setShieldPersistent(String shieldPersistent) {
		this.shieldPersistent = shieldPersistent;
	}

	public LinkedList<String> getRetaliate() {
		return retaliate;
	}

	public void setRetaliate(LinkedList<String> retaliate) {
		this.retaliate = retaliate;
	}

	public LinkedList<String> getRetaliatePersistent() {
		return retaliatePersistent;
	}

	public void setRetaliatePersistent(LinkedList<String> retaliatePersistent) {
		this.retaliatePersistent = retaliatePersistent;
	}

}
