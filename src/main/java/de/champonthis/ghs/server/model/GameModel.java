/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.ArrayList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Game.
 */
public class GameModel {

	private String edition;
	@Required
	private ArrayList<String> figures = new ArrayList<String>();
	@Required
	private ArrayList<GameCharacterModel> characters = new ArrayList<GameCharacterModel>();
	@Required
	private ArrayList<GameMonsterModel> monsters = new ArrayList<GameMonsterModel>();
	@Required
	private ArrayList<GameObjectiveModel> objectives = new ArrayList<GameObjectiveModel>();
	@Required
	private GameState state = GameState.DRAW;
	private Scenario scenario;
	@Required
	private ArrayList<SectionData> sections = new ArrayList<SectionData>();
	@Required
	private int level = 1;
	@Required
	private int round = 0;
	@Required
	private int attackModifier = -1;
	@Required
	private ArrayList<AttackModifierType> attackModifiers = new ArrayList<AttackModifierType>();
	@Required
	private ArrayList<Element> newElements = new ArrayList<Element>();
	@Required
	private ArrayList<Element> strongElements = new ArrayList<Element>();
	@Required
	private ArrayList<Element> elements = new ArrayList<Element>();

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
	public ArrayList<String> getFigures() {
		return figures;
	}

	/**
	 * Sets the figures.
	 *
	 * @param figures the new figures
	 */
	public void setFigures(ArrayList<String> figures) {
		this.figures = figures;
	}

	/**
	 * Gets the characters.
	 *
	 * @return the characters
	 */
	public ArrayList<GameCharacterModel> getCharacters() {
		return characters;
	}

	/**
	 * Sets the characters.
	 *
	 * @param characters the new characters
	 */
	public void setCharacters(ArrayList<GameCharacterModel> characters) {
		this.characters = characters;
	}

	/**
	 * Gets the monsters.
	 *
	 * @return the monsters
	 */
	public ArrayList<GameMonsterModel> getMonsters() {
		return monsters;
	}

	/**
	 * Sets the monsters.
	 *
	 * @param monsters the new monsters
	 */
	public void setMonsters(ArrayList<GameMonsterModel> monsters) {
		this.monsters = monsters;
	}

	/**
	 * Gets the objectives.
	 *
	 * @return the objectives
	 */
	public ArrayList<GameObjectiveModel> getObjectives() {
		return objectives;
	}

	/**
	 * Sets the objectives.
	 *
	 * @param objectives the new objectives
	 */
	public void setObjectives(ArrayList<GameObjectiveModel> objectives) {
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
	 * Gets the attack modifier.
	 *
	 * @return the attack modifier
	 */
	public int getAttackModifier() {
		return attackModifier;
	}

	/**
	 * Sets the attack modifier.
	 *
	 * @param attackModifier the new attack modifier
	 */
	public void setAttackModifier(int attackModifier) {
		this.attackModifier = attackModifier;
	}

	/**
	 * Gets the attack modifiers.
	 *
	 * @return the attack modifiers
	 */
	public ArrayList<AttackModifierType> getAttackModifiers() {
		return attackModifiers;
	}

	/**
	 * Sets the attack modifiers.
	 *
	 * @param attackModifiers the new attack modifiers
	 */
	public void setAttackModifiers(ArrayList<AttackModifierType> attackModifiers) {
		this.attackModifiers = attackModifiers;
	}

	/**
	 * Gets the new elements.
	 *
	 * @return the new elements
	 */
	public ArrayList<Element> getNewElements() {
		return newElements;
	}

	/**
	 * Sets the new elements.
	 *
	 * @param newElements the new new elements
	 */
	public void setNewElements(ArrayList<Element> newElements) {
		this.newElements = newElements;
	}

	/**
	 * Gets the strong elements.
	 *
	 * @return the strong elements
	 */
	public ArrayList<Element> getStrongElements() {
		return strongElements;
	}

	/**
	 * Sets the strong elements.
	 *
	 * @param strongElements the new strong elements
	 */
	public void setStrongElements(ArrayList<Element> strongElements) {
		this.strongElements = strongElements;
	}

	/**
	 * Gets the elements.
	 *
	 * @return the elements
	 */
	public ArrayList<Element> getElements() {
		return elements;
	}

	/**
	 * Sets the elements.
	 *
	 * @param elements the new elements
	 */
	public void setElements(ArrayList<Element> elements) {
		this.elements = elements;
	}

}
