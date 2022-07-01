/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.ArrayList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Summon.
 */
public class GameSummonModel {

	@Required
	private int number;
	@Required
	private SummonColor color;
	private Integer attack;
	private Integer movement;
	private Integer range;
	private Boolean dead;
	@Required
	private SummonState state;
	private Integer level;
	@Required
	private int health;
	@Required
	private int maxHealth;
	@Required
	private ArrayList<Condition> conditions = new ArrayList<Condition>();
	@Required
	private ArrayList<Condition> turnConditions = new ArrayList<Condition>();
	@Required
	private ArrayList<Condition> expiredConditions = new ArrayList<Condition>();
	@Required
	private ArrayList<String> markers = new ArrayList<String>();

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the color
	 */
	public SummonColor getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(SummonColor color) {
		this.color = color;
	}

	/**
	 * @return the attack
	 */
	public Integer getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	/**
	 * @return the movement
	 */
	public Integer getMovement() {
		return movement;
	}

	/**
	 * @param movement the movement to set
	 */
	public void setMovement(Integer movement) {
		this.movement = movement;
	}

	/**
	 * @return the range
	 */
	public Integer getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(Integer range) {
		this.range = range;
	}

	/**
	 * @return the dead
	 */
	public Boolean getDead() {
		return dead;
	}

	/**
	 * @param dead the dead to set
	 */
	public void setDead(Boolean dead) {
		this.dead = dead;
	}

	/**
	 * @return the state
	 */
	public SummonState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(SummonState state) {
		this.state = state;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the maxHealth
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @param maxHealth the maxHealth to set
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * @return the conditions
	 */
	public ArrayList<Condition> getConditions() {
		return conditions;
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(ArrayList<Condition> conditions) {
		this.conditions = conditions;
	}

	/**
	 * @return the turnConditions
	 */
	public ArrayList<Condition> getTurnConditions() {
		return turnConditions;
	}

	/**
	 * @param turnConditions the turnConditions to set
	 */
	public void setTurnConditions(ArrayList<Condition> turnConditions) {
		this.turnConditions = turnConditions;
	}

	/**
	 * @return the expiredConditions
	 */
	public ArrayList<Condition> getExpiredConditions() {
		return expiredConditions;
	}

	/**
	 * @param expiredConditions the expiredConditions to set
	 */
	public void setExpiredConditions(ArrayList<Condition> expiredConditions) {
		this.expiredConditions = expiredConditions;
	}

	/**
	 * @return the markers
	 */
	public ArrayList<String> getMarkers() {
		return markers;
	}

	/**
	 * @param markers the markers to set
	 */
	public void setMarkers(ArrayList<String> markers) {
		this.markers = markers;
	}

}
