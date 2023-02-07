/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Permissions.
 */
public class Permissions {

	@Required
	private boolean characters = false;
	@Required
	private LinkedList<Identifier> character = new LinkedList<>();
	@Required
	private boolean monsters = false;
	@Required
	private LinkedList<Identifier> monster = new LinkedList<>();
	@Required
	private boolean scenario = false;
	@Required
	private boolean elements = false;
	@Required
	private boolean round = false;
	@Required
	private boolean level = false;
	@Required
	private boolean attackModifiers = false;
	@Required
	private boolean lootDeck = false;
	@Required
	private boolean party = false;

	/**
	 * Checks if is characters.
	 *
	 * @return true, if is characters
	 */
	public boolean isCharacters() {
		return characters;
	}

	/**
	 * Sets the characters.
	 *
	 * @param characters the new characters
	 */
	public void setCharacters(boolean characters) {
		this.characters = characters;
	}

	/**
	 * Gets the character.
	 *
	 * @return the character
	 */
	public LinkedList<Identifier> getCharacter() {
		return character;
	}

	/**
	 * Sets the character.
	 *
	 * @param character the new character
	 */
	public void setCharacter(LinkedList<Identifier> character) {
		this.character = character;
	}

	/**
	 * Checks if is monsters.
	 *
	 * @return true, if is monsters
	 */
	public boolean isMonsters() {
		return monsters;
	}

	/**
	 * Sets the monsters.
	 *
	 * @param monsters the new monsters
	 */
	public void setMonsters(boolean monsters) {
		this.monsters = monsters;
	}

	/**
	 * Gets the monster.
	 *
	 * @return the monster
	 */
	public LinkedList<Identifier> getMonster() {
		return monster;
	}

	/**
	 * Sets the monster.
	 *
	 * @param monster the new monster
	 */
	public void setMonster(LinkedList<Identifier> monster) {
		this.monster = monster;
	}

	/**
	 * Checks if is scenario.
	 *
	 * @return true, if is scenario
	 */
	public boolean isScenario() {
		return scenario;
	}

	/**
	 * Sets the scenario.
	 *
	 * @param scenario the new scenario
	 */
	public void setScenario(boolean scenario) {
		this.scenario = scenario;
	}

	/**
	 * Checks if is elements.
	 *
	 * @return true, if is elements
	 */
	public boolean isElements() {
		return elements;
	}

	/**
	 * Sets the elements.
	 *
	 * @param elements the new elements
	 */
	public void setElements(boolean elements) {
		this.elements = elements;
	}

	/**
	 * Checks if is round.
	 *
	 * @return true, if is round
	 */
	public boolean isRound() {
		return round;
	}

	/**
	 * Sets the round.
	 *
	 * @param round the new round
	 */
	public void setRound(boolean round) {
		this.round = round;
	}

	/**
	 * Checks if is level.
	 *
	 * @return true, if is level
	 */
	public boolean isLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(boolean level) {
		this.level = level;
	}

	/**
	 * Checks if is attack modifiers.
	 *
	 * @return true, if is attack modifiers
	 */
	public boolean isAttackModifiers() {
		return attackModifiers;
	}

	/**
	 * Sets the attack modifiers.
	 *
	 * @param attackModifiers the new attack modifiers
	 */
	public void setAttackModifiers(boolean attackModifiers) {
		this.attackModifiers = attackModifiers;
	}

	/**
	 * Checks if is loot deck.
	 *
	 * @return true, if is loot deck
	 */
	public boolean isLootDeck() {
		return lootDeck;
	}

	/**
	 * Sets the loot deck.
	 *
	 * @param lootDeck the new loot deck
	 */
	public void setLootDeck(boolean lootDeck) {
		this.lootDeck = lootDeck;
	}

	/**
	 * Checks if is party.
	 *
	 * @return true, if is party
	 */
	public boolean isParty() {
		return party;
	}

	/**
	 * Sets the party.
	 *
	 * @param party the new party
	 */
	public void setParty(boolean party) {
		this.party = party;
	}

}
