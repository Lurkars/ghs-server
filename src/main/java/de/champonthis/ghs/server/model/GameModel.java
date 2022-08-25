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

	private String edition;
	@Required
	private LinkedList<String> figures = new LinkedList<String>();
	@Required
	private LinkedList<GameCharacterModel> characters = new LinkedList<GameCharacterModel>();
	@Required
	private LinkedList<GameMonsterModel> monsters = new LinkedList<GameMonsterModel>();
	@Required
	private LinkedList<GameObjectiveModel> objectives = new LinkedList<GameObjectiveModel>();
	@Required
	private GameState state = GameState.DRAW;
	private Scenario scenario;
	@Required
	private LinkedList<SectionData> sections = new LinkedList<SectionData>();
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
	private int round = 0;
	@Required
	private long playSeconds = 0;
	@Required
	private long totalSeconds = 0;
	@Required
	private GameAttackModifierDeckModel monsterAttackModifierDeck = new GameAttackModifierDeckModel();
	@Required
	private LinkedList<Element> newElements = new LinkedList<Element>();
	@Required
	private LinkedList<Element> strongElements = new LinkedList<Element>();
	@Required
	private LinkedList<Element> elements = new LinkedList<Element>();
	@Required
	private boolean solo = false;
	private Party party;

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
	 * Gets the objectives.
	 *
	 * @return the objectives
	 */
	public LinkedList<GameObjectiveModel> getObjectives() {
		return objectives;
	}

	/**
	 * Sets the objectives.
	 *
	 * @param objectives the new objectives
	 */
	public void setObjectives(LinkedList<GameObjectiveModel> objectives) {
		this.objectives = objectives;
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
	public Scenario getScenario() {
		return scenario;
	}

	/**
	 * Sets the scenario.
	 *
	 * @param scenario the new scenario
	 */
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	/**
	 * Gets the sections.
	 *
	 * @return the sections
	 */
	public LinkedList<SectionData> getSections() {
		return sections;
	}

	/**
	 * Sets the sections.
	 *
	 * @param sections the new sections
	 */
	public void setSections(LinkedList<SectionData> sections) {
		this.sections = sections;
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
	 * Gets the new elements.
	 *
	 * @return the new elements
	 */
	public LinkedList<Element> getNewElements() {
		return newElements;
	}

	/**
	 * Sets the new elements.
	 *
	 * @param newElements the new new elements
	 */
	public void setNewElements(LinkedList<Element> newElements) {
		this.newElements = newElements;
	}

	/**
	 * Gets the strong elements.
	 *
	 * @return the strong elements
	 */
	public LinkedList<Element> getStrongElements() {
		return strongElements;
	}

	/**
	 * Sets the strong elements.
	 *
	 * @param strongElements the new strong elements
	 */
	public void setStrongElements(LinkedList<Element> strongElements) {
		this.strongElements = strongElements;
	}

	/**
	 * Gets the elements.
	 *
	 * @return the elements
	 */
	public LinkedList<Element> getElements() {
		return elements;
	}

	/**
	 * Sets the elements.
	 *
	 * @param elements the new elements
	 */
	public void setElements(LinkedList<Element> elements) {
		this.elements = elements;
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

}
