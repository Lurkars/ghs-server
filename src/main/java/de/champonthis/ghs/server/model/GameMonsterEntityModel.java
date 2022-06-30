/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.ArrayList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class MonsterEntity.
 */
public class GameMonsterEntityModel {

	@Required
	private int number;
	@Required
	private MonsterType type;
	@Required
	private boolean dead;
	@Required
	private SummonState summon;
	@Required
	private int health;
	@Required
	private int maxHealth;
	@Required
	private ArrayList<Condition> conditions = new ArrayList<Condition>();
	@Required
	private ArrayList<Condition> turnConditions = new ArrayList<Condition>();
	@Required
	private ArrayList<String> markers = new ArrayList<String>();

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public MonsterType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(MonsterType type) {
		this.type = type;
	}

	/**
	 * Checks if is dead.
	 *
	 * @return true, if is dead
	 */
	public boolean isDead() {
		return dead;
	}

	/**
	 * Sets the dead.
	 *
	 * @param dead the new dead
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}

	/**
	 * Gets the summon.
	 *
	 * @return the summon
	 */
	public SummonState getSummon() {
		return summon;
	}

	/**
	 * Sets the summon.
	 *
	 * @param summon the new summon
	 */
	public void setSummon(SummonState summon) {
		this.summon = summon;
	}

	/**
	 * Gets the health.
	 *
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Sets the health.
	 *
	 * @param health the new health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Gets the max health.
	 *
	 * @return the max health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * Sets the max health.
	 *
	 * @param maxHealth the new max health
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * Gets the conditions.
	 *
	 * @return the conditions
	 */
	public ArrayList<Condition> getConditions() {
		return conditions;
	}

	/**
	 * Sets the conditions.
	 *
	 * @param conditions the new conditions
	 */
	public void setConditions(ArrayList<Condition> conditions) {
		this.conditions = conditions;
	}

	/**
	 * Gets the turn conditions.
	 *
	 * @return the turn conditions
	 */
	public ArrayList<Condition> getTurnConditions() {
		return turnConditions;
	}

	/**
	 * Sets the turn conditions.
	 *
	 * @param turnConditions the new turn conditions
	 */
	public void setTurnConditions(ArrayList<Condition> turnConditions) {
		this.turnConditions = turnConditions;
	}

}
