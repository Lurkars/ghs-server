package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

public class GameModel {

	@Required
	private Long revision;
	private int revisionOffset = 0;
	private String edition;
	@Required
	private LinkedList<ConditionName> conditions = new LinkedList<>();
	@Required
	private LinkedList<String> battleGoalEditions = new LinkedList<>();
	@Required
	private LinkedList<Identifier> filteredBattleGoals = new LinkedList<>();
	@Required
	private LinkedList<String> figures = new LinkedList<>();
	@Required
	private LinkedList<EntityCounter> entitiesCounter = new LinkedList<>();
	@Required
	private LinkedList<GameCharacterModel> characters = new LinkedList<>();
	@Required
	private LinkedList<GameMonsterModel> monsters = new LinkedList<>();
	private LinkedList<GameObjectiveContainerModel> objectiveContainers = new LinkedList<>();
	@Required
	private GameState state = GameState.DRAW;
	private GameScenarioModel scenario;
	@Required
	private LinkedList<GameScenarioModel> sections = new LinkedList<>();
	@Required
	private LinkedList<ScenarioRuleIdentifier> scenarioRules = new LinkedList<>();
	@Required
	private LinkedList<ScenarioRuleIdentifier> appliedScenarioRules = new LinkedList<>();
	@Required
	private LinkedList<ScenarioRuleIdentifier> disgardedScenarioRules = new LinkedList<>();
	@Required
	private int level = 1;
	@Required
	private boolean levelCalculation = true;
	@Required
	private int levelAdjustment = 0;
	@Required
	private int bonusAdjustment = 0;
	@Required
	private boolean ge5Player = true;
	@Required
	private int playerCount = 0;
	@Required
	private int round = 0;
	@Required
	private LinkedList<Integer> roundResets = new LinkedList<>();
	@Required
	private LinkedList<Integer> roundResetsHidden = new LinkedList<>();
	@Required
	private long playSeconds = 0;
	@Required
	private long totalSeconds = 0;
	@Required
	private GameAttackModifierDeckModel monsterAttackModifierDeck = new GameAttackModifierDeckModel();
	@Required
	private GameAttackModifierDeckModel allyAttackModifierDeck = new GameAttackModifierDeckModel();
	@Required
	private LinkedList<ElementModel> elementBoard = new LinkedList<>();
	@Required
	private boolean solo = false;
	@Required
	private Party party = new Party();
	@Required
	private LinkedList<Party> parties = new LinkedList<>();
	@Required
	private LootDeck lootDeck = new LootDeck();
	@Required
	private LinkedList<Loot> lootDeckEnhancements = new LinkedList<>();
	@Required
	private LinkedList<LootType> lootDeckFixed = new LinkedList<>();
	@Required
	private LinkedList<String> lootDeckSections = new LinkedList<>();
	@Required
	private LinkedList<String> unlockedCharacters = new LinkedList<>();
	@Required
	private boolean server = false;
	private ScenarioFinish finish;
	@Required
	private LinkedList<GameClockTimestamp> gameClock = new LinkedList<>();
	private GameChallengeDeckModel challengeDeck = new GameChallengeDeckModel();
	@Required
	private LinkedList<Identifier> favors = new LinkedList<>();
	@Required
	private LinkedList<Integer> favorPoints = new LinkedList<>();
	private Boolean keepFavors = false;

	public Long getRevision() {
		return revision;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	public int getRevisionOffset() {
		return revisionOffset;
	}

	public void setRevisionOffset(int revisionOffset) {
		this.revisionOffset = revisionOffset;
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

	public LinkedList<String> getFigures() {
		return figures;
	}

	public void setFigures(LinkedList<String> figures) {
		this.figures = figures;
	}

	public LinkedList<EntityCounter> getEntitiesCounter() {
		return entitiesCounter;
	}

	public void setEntitiesCounter(LinkedList<EntityCounter> entitiesCounter) {
		this.entitiesCounter = entitiesCounter;
	}

	public LinkedList<GameCharacterModel> getCharacters() {
		return characters;
	}

	public void setCharacters(LinkedList<GameCharacterModel> characters) {
		this.characters = characters;
	}

	public LinkedList<GameMonsterModel> getMonsters() {
		return monsters;
	}

	public void setMonsters(LinkedList<GameMonsterModel> monsters) {
		this.monsters = monsters;
	}

	public LinkedList<GameObjectiveContainerModel> getObjectiveContainers() {
		return objectiveContainers;
	}

	public void setObjectiveContainers(LinkedList<GameObjectiveContainerModel> objectiveContainers) {
		this.objectiveContainers = objectiveContainers;
	}

	public GameState getState() {
		return state;
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public GameScenarioModel getScenario() {
		return scenario;
	}

	public void setScenario(GameScenarioModel scenario) {
		this.scenario = scenario;
	}

	public LinkedList<GameScenarioModel> getSections() {
		return sections;
	}

	public void setSections(LinkedList<GameScenarioModel> sections) {
		this.sections = sections;
	}

	public LinkedList<ScenarioRuleIdentifier> getScenarioRules() {
		return scenarioRules;
	}

	public void setScenarioRules(LinkedList<ScenarioRuleIdentifier> scenarioRules) {
		this.scenarioRules = scenarioRules;
	}

	public LinkedList<ScenarioRuleIdentifier> getAppliedScenarioRules() {
		return appliedScenarioRules;
	}

	public void setAppliedScenarioRules(LinkedList<ScenarioRuleIdentifier> appliedScenarioRules) {
		this.appliedScenarioRules = appliedScenarioRules;
	}

	public LinkedList<ScenarioRuleIdentifier> getDisgardedScenarioRules() {
		return disgardedScenarioRules;
	}

	public void setDisgardedScenarioRules(LinkedList<ScenarioRuleIdentifier> disgardedScenarioRules) {
		this.disgardedScenarioRules = disgardedScenarioRules;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isLevelCalculation() {
		return levelCalculation;
	}

	public void setLevelCalculation(boolean levelCalculation) {
		this.levelCalculation = levelCalculation;
	}

	public int getLevelAdjustment() {
		return levelAdjustment;
	}

	public void setLevelAdjustment(int levelAdjustment) {
		this.levelAdjustment = levelAdjustment;
	}

	public int getBonusAdjustment() {
		return bonusAdjustment;
	}

	public void setBonusAdjustment(int bonusAdjustment) {
		this.bonusAdjustment = bonusAdjustment;
	}

	public boolean isGe5Player() {
		return ge5Player;
	}

	public void setGe5Player(boolean ge5Player) {
		this.ge5Player = ge5Player;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public LinkedList<Integer> getRoundResets() {
		return roundResets;
	}

	public void setRoundResets(LinkedList<Integer> roundResets) {
		this.roundResets = roundResets;
	}

	public LinkedList<Integer> getRoundResetsHidden() {
		return roundResetsHidden;
	}

	public void setRoundResetsHidden(LinkedList<Integer> roundResetsHidden) {
		this.roundResetsHidden = roundResetsHidden;
	}

	public long getPlaySeconds() {
		return playSeconds;
	}

	public void setPlaySeconds(long playSeconds) {
		this.playSeconds = playSeconds;
	}

	public long getTotalSeconds() {
		return totalSeconds;
	}

	public void setTotalSeconds(long totalSeconds) {
		this.totalSeconds = totalSeconds;
	}

	public GameAttackModifierDeckModel getMonsterAttackModifierDeck() {
		return monsterAttackModifierDeck;
	}

	public void setMonsterAttackModifierDeck(GameAttackModifierDeckModel monsterAttackModifierDeck) {
		this.monsterAttackModifierDeck = monsterAttackModifierDeck;
	}

	public GameAttackModifierDeckModel getAllyAttackModifierDeck() {
		return allyAttackModifierDeck;
	}

	public void setAllyAttackModifierDeck(GameAttackModifierDeckModel allyAttackModifierDeck) {
		this.allyAttackModifierDeck = allyAttackModifierDeck;
	}

	public LinkedList<ElementModel> getElementBoard() {
		return elementBoard;
	}

	public void setElementBoard(LinkedList<ElementModel> elementBoard) {
		this.elementBoard = elementBoard;
	}

	public boolean isSolo() {
		return solo;
	}

	public void setSolo(boolean solo) {
		this.solo = solo;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public LinkedList<Party> getParties() {
		return parties;
	}

	public void setParties(LinkedList<Party> parties) {
		this.parties = parties;
	}

	public LootDeck getLootDeck() {
		return lootDeck;
	}

	public void setLootDeck(LootDeck lootDeck) {
		this.lootDeck = lootDeck;
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

	public LinkedList<String> getUnlockedCharacters() {
		return unlockedCharacters;
	}

	public void setUnlockedCharacters(LinkedList<String> unlockedCharacters) {
		this.unlockedCharacters = unlockedCharacters;
	}

	public boolean isServer() {
		return server;
	}

	public void setServer(boolean server) {
		this.server = server;
	}

	public ScenarioFinish getFinish() {
		return finish;
	}

	public void setFinish(ScenarioFinish finish) {
		this.finish = finish;
	}

	public LinkedList<GameClockTimestamp> getGameClock() {
		return gameClock;
	}

	public void setGameClock(LinkedList<GameClockTimestamp> gameClock) {
		this.gameClock = gameClock;
	}

	public GameChallengeDeckModel getChallengeDeck() {
		return challengeDeck;
	}

	public void setChallengeDeck(GameChallengeDeckModel challengeDeck) {
		this.challengeDeck = challengeDeck;
	}

	public LinkedList<Identifier> getFavors() {
		return favors;
	}

	public void setFavors(LinkedList<Identifier> favors) {
		this.favors = favors;
	}

	public LinkedList<Integer> getFavorPoints() {
		return favorPoints;
	}

	public void setFavorPoints(LinkedList<Integer> favorPoints) {
		this.favorPoints = favorPoints;
	}

	public Boolean getKeepFavors() {
		return keepFavors;
	}

	public void setKeepFavors(Boolean keepFavors) {
		this.keepFavors = keepFavors;
	}

}
