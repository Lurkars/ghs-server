package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

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

	public boolean isCharacters() {
		return characters;
	}

	public void setCharacters(boolean characters) {
		this.characters = characters;
	}

	public LinkedList<Identifier> getCharacter() {
		return character;
	}

	public void setCharacter(LinkedList<Identifier> character) {
		this.character = character;
	}

	public boolean isMonsters() {
		return monsters;
	}

	public void setMonsters(boolean monsters) {
		this.monsters = monsters;
	}

	public LinkedList<Identifier> getMonster() {
		return monster;
	}

	public void setMonster(LinkedList<Identifier> monster) {
		this.monster = monster;
	}

	public boolean isScenario() {
		return scenario;
	}

	public void setScenario(boolean scenario) {
		this.scenario = scenario;
	}

	public boolean isElements() {
		return elements;
	}

	public void setElements(boolean elements) {
		this.elements = elements;
	}

	public boolean isRound() {
		return round;
	}

	public void setRound(boolean round) {
		this.round = round;
	}

	public boolean isLevel() {
		return level;
	}

	public void setLevel(boolean level) {
		this.level = level;
	}

	public boolean isAttackModifiers() {
		return attackModifiers;
	}

	public void setAttackModifiers(boolean attackModifiers) {
		this.attackModifiers = attackModifiers;
	}

	public boolean isLootDeck() {
		return lootDeck;
	}

	public void setLootDeck(boolean lootDeck) {
		this.lootDeck = lootDeck;
	}

	public boolean isParty() {
		return party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

}
