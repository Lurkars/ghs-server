/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.ArrayList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameCharacterModel.
 */
public class GameCharacterModel {

	@Required
	private String name;
	@Required
	private String edition;
	private String title;
	@Required
	private int initiative;
	@Required
	private int experience;
	@Required
	private int loot;
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
	private ArrayList<GameEntityConditionModel> entityConditions = new ArrayList<GameEntityConditionModel>();
	@Required
	@Deprecated
	private ArrayList<ConditionName> conditions = new ArrayList<ConditionName>();
	@Required
	@Deprecated
	private ArrayList<ConditionName> turnConditions = new ArrayList<ConditionName>();
	@Required
	@Deprecated
	private ArrayList<ConditionName> expiredConditions = new ArrayList<ConditionName>();
	@Required
	private ArrayList<String> markers = new ArrayList<String>();
	@Required
	private ArrayList<GameSummonModel> summons = new ArrayList<GameSummonModel>();

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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the initiative.
	 *
	 * @return the initiative
	 */
	public int getInitiative() {
		return initiative;
	}

	/**
	 * Sets the initiative.
	 *
	 * @param initiative the new initiative
	 */
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	/**
	 * Gets the experience.
	 *
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Sets the experience.
	 *
	 * @param experience the new experience
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * Gets the loot.
	 *
	 * @return the loot
	 */
	public int getLoot() {
		return loot;
	}

	/**
	 * Sets the loot.
	 *
	 * @param loot the new loot
	 */
	public void setLoot(int loot) {
		this.loot = loot;
	}

	/**
	 * Checks if is exhausted.
	 *
	 * @return true, if is exhausted
	 */
	public boolean isExhausted() {
		return exhausted;
	}

	/**
	 * Sets the exhausted.
	 *
	 * @param exhausted the new exhausted
	 */
	public void setExhausted(boolean exhausted) {
		this.exhausted = exhausted;
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
	 * Checks if is off.
	 *
	 * @return true, if is off
	 */
	public boolean isOff() {
		return off;
	}

	/**
	 * Sets the off.
	 *
	 * @param off the new off
	 */
	public void setOff(boolean off) {
		this.off = off;
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(boolean active) {
		this.active = active;
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
	public ArrayList<GameEntityConditionModel> getEntityConditions() {
		return entityConditions;
	}

	/**
	 * Sets the entity conditions.
	 *
	 * @param entityConditions the new entity conditions
	 */
	public void setEntityConditions(ArrayList<GameEntityConditionModel> entityConditions) {
		this.entityConditions = entityConditions;
	}

	/**
	 * Gets the conditions.
	 *
	 * @return the conditions
	 */
	public ArrayList<ConditionName> getConditions() {
		return conditions;
	}

	/**
	 * Sets the conditions.
	 *
	 * @param conditions the new conditions
	 */
	public void setConditions(ArrayList<ConditionName> conditions) {
		this.conditions = conditions;
	}

	/**
	 * Gets the turn conditions.
	 *
	 * @return the turn conditions
	 */
	public ArrayList<ConditionName> getTurnConditions() {
		return turnConditions;
	}

	/**
	 * Sets the turn conditions.
	 *
	 * @param turnConditions the new turn conditions
	 */
	public void setTurnConditions(ArrayList<ConditionName> turnConditions) {
		this.turnConditions = turnConditions;
	}

	/**
	 * Gets the expired conditions.
	 *
	 * @return the expired conditions
	 */
	public ArrayList<ConditionName> getExpiredConditions() {
		return expiredConditions;
	}

	/**
	 * Sets the expired conditions.
	 *
	 * @param expiredConditions the new expired conditions
	 */
	public void setExpiredConditions(ArrayList<ConditionName> expiredConditions) {
		this.expiredConditions = expiredConditions;
	}

	/**
	 * Gets the markers.
	 *
	 * @return the markers
	 */
	public ArrayList<String> getMarkers() {
		return markers;
	}

	/**
	 * Sets the markers.
	 *
	 * @param markers the new markers
	 */
	public void setMarkers(ArrayList<String> markers) {
		this.markers = markers;
	}

	/**
	 * Gets the summons.
	 *
	 * @return the summons
	 */
	public ArrayList<GameSummonModel> getSummons() {
		return summons;
	}

	/**
	 * Sets the summons.
	 *
	 * @param summons the new summons
	 */
	public void setSummons(ArrayList<GameSummonModel> summons) {
		this.summons = summons;
	}

}
