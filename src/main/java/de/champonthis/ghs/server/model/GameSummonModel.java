/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameSummonModel.
 */
public class GameSummonModel {

	@Required
	private String name;
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
	private LinkedList<GameEntityConditionModel> entityConditions = new LinkedList<>();
	@Required
	private LinkedList<String> markers = new LinkedList<>();
	private String action;
	private String additionalAction;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

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
	 * Gets the color.
	 *
	 * @return the color
	 */
	public SummonColor getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(SummonColor color) {
		this.color = color;
	}

	/**
	 * Gets the attack.
	 *
	 * @return the attack
	 */
	public Integer getAttack() {
		return attack;
	}

	/**
	 * Sets the attack.
	 *
	 * @param attack the new attack
	 */
	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	/**
	 * Gets the movement.
	 *
	 * @return the movement
	 */
	public Integer getMovement() {
		return movement;
	}

	/**
	 * Sets the movement.
	 *
	 * @param movement the new movement
	 */
	public void setMovement(Integer movement) {
		this.movement = movement;
	}

	/**
	 * Gets the range.
	 *
	 * @return the range
	 */
	public Integer getRange() {
		return range;
	}

	/**
	 * Sets the range.
	 *
	 * @param range the new range
	 */
	public void setRange(Integer range) {
		this.range = range;
	}

	/**
	 * Gets the dead.
	 *
	 * @return the dead
	 */
	public Boolean getDead() {
		return dead;
	}

	/**
	 * Sets the dead.
	 *
	 * @param dead the new dead
	 */
	public void setDead(Boolean dead) {
		this.dead = dead;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public SummonState getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(SummonState state) {
		this.state = state;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(Integer level) {
		this.level = level;
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
	 * Gets the entity conditions.
	 *
	 * @return the entity conditions
	 */
	public LinkedList<GameEntityConditionModel> getEntityConditions() {
		return entityConditions;
	}

	/**
	 * Sets the entity conditions.
	 *
	 * @param entityConditions the new entity conditions
	 */
	public void setEntityConditions(LinkedList<GameEntityConditionModel> entityConditions) {
		this.entityConditions = entityConditions;
	}

	/**
	 * Gets the markers.
	 *
	 * @return the markers
	 */
	public LinkedList<String> getMarkers() {
		return markers;
	}

	/**
	 * Sets the markers.
	 *
	 * @param markers the new markers
	 */
	public void setMarkers(LinkedList<String> markers) {
		this.markers = markers;
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * Gets the additional action.
	 *
	 * @return the additional action
	 */
	public String getAdditionalAction() {
		return additionalAction;
	}

	/**
	 * Sets the additional action.
	 *
	 * @param additionalAction the new additional action
	 */
	public void setAdditionalAction(String additionalAction) {
		this.additionalAction = additionalAction;
	}

}
