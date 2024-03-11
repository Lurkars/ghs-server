/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameModel.
 */
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

	/**
	 * Gets the revision.
	 *
	 * @return the revision
	 */
	public Long getRevision() {
		return revision;
	}

	/**
	 * Sets the revision.
	 *
	 * @param revision the new revision
	 */
	public void setRevision(Long revision) {
		this.revision = revision;
	}

	/**
	 * Gets the revision offset.
	 *
	 * @return the revision offset
	 */
	public int getRevisionOffset() {
		return revisionOffset;
	}

	/**
	 * Sets the revision offset.
	 *
	 * @param revisionOffset the new revision offset
	 */
	public void setRevisionOffset(int revisionOffset) {
		this.revisionOffset = revisionOffset;
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
	 * Gets the figures.
	 *
	 * @return the figures
	 */
	public LinkedList<String> getFigures() {
		return figures;
	}

	/**
	 * Sets the figures.
	 *
	 * @param figures the new figures
	 */
	public void setFigures(LinkedList<String> figures) {
		this.figures = figures;
	}

	/**
	 * Gets the entities counter.
	 *
	 * @return the entities counter
	 */
	public LinkedList<EntityCounter> getEntitiesCounter() {
		return entitiesCounter;
	}

	/**
	 * Sets the entities counter.
	 *
	 * @param entitiesCounter the new entities counter
	 */
	public void setEntitiesCounter(LinkedList<EntityCounter> entitiesCounter) {
		this.entitiesCounter = entitiesCounter;
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
	 * Gets the monsters.
	 *
	 * @return the monsters
	 */
	public LinkedList<GameMonsterModel> getMonsters() {
		return monsters;
	}

	/**
	 * Sets the monsters.
	 *
	 * @param monsters the new monsters
	 */
	public void setMonsters(LinkedList<GameMonsterModel> monsters) {
		this.monsters = monsters;
	}

	/**
	 * Gets the objective containers.
	 *
	 * @return the objective containers
	 */
	public LinkedList<GameObjectiveContainerModel> getObjectiveContainers() {
		return objectiveContainers;
	}

	/**
	 * Sets the objective containers.
	 *
	 * @param objectiveContainers the new objective containers
	 */
	public void setObjectiveContainers(LinkedList<GameObjectiveContainerModel> objectiveContainers) {
		this.objectiveContainers = objectiveContainers;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public GameState getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(GameState state) {
		this.state = state;
	}

	/**
	 * Gets the scenario.
	 *
	 * @return the scenario
	 */
	public GameScenarioModel getScenario() {
		return scenario;
	}

	/**
	 * Sets the scenario.
	 *
	 * @param scenario the new scenario
	 */
	public void setScenario(GameScenarioModel scenario) {
		this.scenario = scenario;
	}

	/**
	 * Gets the sections.
	 *
	 * @return the sections
	 */
	public LinkedList<GameScenarioModel> getSections() {
		return sections;
	}

	/**
	 * Sets the sections.
	 *
	 * @param sections the new sections
	 */
	public void setSections(LinkedList<GameScenarioModel> sections) {
		this.sections = sections;
	}

	/**
	 * Gets the scenario rules.
	 *
	 * @return the scenario rules
	 */
	public LinkedList<ScenarioRuleIdentifier> getScenarioRules() {
		return scenarioRules;
	}

	/**
	 * Sets the scenario rules.
	 *
	 * @param scenarioRules the new scenario rules
	 */
	public void setScenarioRules(LinkedList<ScenarioRuleIdentifier> scenarioRules) {
		this.scenarioRules = scenarioRules;
	}

	/**
	 * Gets the disgarded scenario rules.
	 *
	 * @return the disgarded scenario rules
	 */
	public LinkedList<ScenarioRuleIdentifier> getDisgardedScenarioRules() {
		return disgardedScenarioRules;
	}

	/**
	 * Sets the disgarded scenario rules.
	 *
	 * @param disgardedScenarioRules the new disgarded scenario rules
	 */
	public void setDisgardedScenarioRules(LinkedList<ScenarioRuleIdentifier> disgardedScenarioRules) {
		this.disgardedScenarioRules = disgardedScenarioRules;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Checks if is level calculation.
	 *
	 * @return true, if is level calculation
	 */
	public boolean isLevelCalculation() {
		return levelCalculation;
	}

	/**
	 * Sets the level calculation.
	 *
	 * @param levelCalculation the new level calculation
	 */
	public void setLevelCalculation(boolean levelCalculation) {
		this.levelCalculation = levelCalculation;
	}

	/**
	 * Gets the level adjustment.
	 *
	 * @return the level adjustment
	 */
	public int getLevelAdjustment() {
		return levelAdjustment;
	}

	/**
	 * Sets the level adjustment.
	 *
	 * @param levelAdjustment the new level adjustment
	 */
	public void setLevelAdjustment(int levelAdjustment) {
		this.levelAdjustment = levelAdjustment;
	}

	/**
	 * Gets the bonus adjustment.
	 *
	 * @return the bonus adjustment
	 */
	public int getBonusAdjustment() {
		return bonusAdjustment;
	}

	/**
	 * Sets the bonus adjustment.
	 *
	 * @param bonusAdjustment the new bonus adjustment
	 */
	public void setBonusAdjustment(int bonusAdjustment) {
		this.bonusAdjustment = bonusAdjustment;
	}

	/**
	 * Checks if is ge 5 player.
	 *
	 * @return true, if is ge 5 player
	 */
	public boolean isGe5Player() {
		return ge5Player;
	}

	/**
	 * Sets the ge 5 player.
	 *
	 * @param ge5Player the new ge 5 player
	 */
	public void setGe5Player(boolean ge5Player) {
		this.ge5Player = ge5Player;
	}

	/**
	 * Gets the player count.
	 *
	 * @return the player count
	 */
	public int getPlayerCount() {
		return playerCount;
	}

	/**
	 * Sets the player count.
	 *
	 * @param playerCount the new player count
	 */
	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	/**
	 * Gets the round.
	 *
	 * @return the round
	 */
	public int getRound() {
		return round;
	}

	/**
	 * Sets the round.
	 *
	 * @param round the new round
	 */
	public void setRound(int round) {
		this.round = round;
	}

	/**
	 * Gets the round resets.
	 *
	 * @return the round resets
	 */
	public LinkedList<Integer> getRoundResets() {
		return roundResets;
	}

	/**
	 * Sets the round resets.
	 *
	 * @param roundResets the new round resets
	 */
	public void setRoundResets(LinkedList<Integer> roundResets) {
		this.roundResets = roundResets;
	}

	/**
	 * Gets the round resets hidden.
	 *
	 * @return the round resets hidden
	 */
	public LinkedList<Integer> getRoundResetsHidden() {
		return roundResetsHidden;
	}

	/**
	 * Sets the round resets hidden.
	 *
	 * @param roundResetsHidden the new round resets hidden
	 */
	public void setRoundResetsHidden(LinkedList<Integer> roundResetsHidden) {
		this.roundResetsHidden = roundResetsHidden;
	}

	/**
	 * Gets the play seconds.
	 *
	 * @return the play seconds
	 */
	public long getPlaySeconds() {
		return playSeconds;
	}

	/**
	 * Sets the play seconds.
	 *
	 * @param playSeconds the new play seconds
	 */
	public void setPlaySeconds(long playSeconds) {
		this.playSeconds = playSeconds;
	}

	/**
	 * Gets the total seconds.
	 *
	 * @return the total seconds
	 */
	public long getTotalSeconds() {
		return totalSeconds;
	}

	/**
	 * Sets the total seconds.
	 *
	 * @param totalSeconds the new total seconds
	 */
	public void setTotalSeconds(long totalSeconds) {
		this.totalSeconds = totalSeconds;
	}

	/**
	 * Gets the monster attack modifier deck.
	 *
	 * @return the monster attack modifier deck
	 */
	public GameAttackModifierDeckModel getMonsterAttackModifierDeck() {
		return monsterAttackModifierDeck;
	}

	/**
	 * Sets the monster attack modifier deck.
	 *
	 * @param monsterAttackModifierDeck the new monster attack modifier deck
	 */
	public void setMonsterAttackModifierDeck(GameAttackModifierDeckModel monsterAttackModifierDeck) {
		this.monsterAttackModifierDeck = monsterAttackModifierDeck;
	}

	/**
	 * Gets the ally attack modifier deck.
	 *
	 * @return the ally attack modifier deck
	 */
	public GameAttackModifierDeckModel getAllyAttackModifierDeck() {
		return allyAttackModifierDeck;
	}

	/**
	 * Sets the ally attack modifier deck.
	 *
	 * @param allyAttackModifierDeck the new ally attack modifier deck
	 */
	public void setAllyAttackModifierDeck(GameAttackModifierDeckModel allyAttackModifierDeck) {
		this.allyAttackModifierDeck = allyAttackModifierDeck;
	}

	/**
	 * Gets the element board.
	 *
	 * @return the element board
	 */
	public LinkedList<ElementModel> getElementBoard() {
		return elementBoard;
	}

	/**
	 * Sets the element board.
	 *
	 * @param elementBoard the new element board
	 */
	public void setElementBoard(LinkedList<ElementModel> elementBoard) {
		this.elementBoard = elementBoard;
	}

	/**
	 * Checks if is solo.
	 *
	 * @return true, if is solo
	 */
	public boolean isSolo() {
		return solo;
	}

	/**
	 * Sets the solo.
	 *
	 * @param solo the new solo
	 */
	public void setSolo(boolean solo) {
		this.solo = solo;
	}

	/**
	 * Gets the party.
	 *
	 * @return the party
	 */
	public Party getParty() {
		return party;
	}

	/**
	 * Sets the party.
	 *
	 * @param party the new party
	 */
	public void setParty(Party party) {
		this.party = party;
	}

	/**
	 * Gets the parties.
	 *
	 * @return the parties
	 */
	public LinkedList<Party> getParties() {
		return parties;
	}

	/**
	 * Sets the parties.
	 *
	 * @param parties the new parties
	 */
	public void setParties(LinkedList<Party> parties) {
		this.parties = parties;
	}

	/**
	 * Gets the loot deck.
	 *
	 * @return the loot deck
	 */
	public LootDeck getLootDeck() {
		return lootDeck;
	}

	/**
	 * Sets the loot deck.
	 *
	 * @param lootDeck the new loot deck
	 */
	public void setLootDeck(LootDeck lootDeck) {
		this.lootDeck = lootDeck;
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
	 * Checks if is server.
	 *
	 * @return true, if is server
	 */
	public boolean isServer() {
		return server;
	}

	/**
	 * Sets the server.
	 *
	 * @param server the new server
	 */
	public void setServer(boolean server) {
		this.server = server;
	}

	/**
	 * Gets the finish.
	 *
	 * @return the finish
	 */
	public ScenarioFinish getFinish() {
		return finish;
	}

	/**
	 * Sets the finish.
	 *
	 * @param finish the new finish
	 */
	public void setFinish(ScenarioFinish finish) {
		this.finish = finish;
	}

	/**
	 * Gets the game clock.
	 *
	 * @return the game clock
	 */
	public LinkedList<GameClockTimestamp> getGameClock() {
		return gameClock;
	}

	/**
	 * Sets the game clock.
	 *
	 * @param gameClock the new game clock
	 */
	public void setGameClock(LinkedList<GameClockTimestamp> gameClock) {
		this.gameClock = gameClock;
	}

}
