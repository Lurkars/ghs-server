/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.ArrayList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Character.
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
	private ArrayList<Condition> conditions = new ArrayList<Condition>();
	@Required
	private ArrayList<Condition> turnConditions = new ArrayList<Condition>();
	@Required
	private ArrayList<Condition> expiredConditions = new ArrayList<Condition>();
	@Required
	private ArrayList<String> markers = new ArrayList<String>();
	@Required
	private ArrayList<GameSummonModel> summons = new ArrayList<GameSummonModel>();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * @param edition the edition to set
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the initiative
	 */
	public int getInitiative() {
		return initiative;
	}

	/**
	 * @param initiative the initiative to set
	 */
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @return the loot
	 */
	public int getLoot() {
		return loot;
	}

	/**
	 * @param loot the loot to set
	 */
	public void setLoot(int loot) {
		this.loot = loot;
	}

	/**
	 * @return the exhausted
	 */
	public boolean isExhausted() {
		return exhausted;
	}

	/**
	 * @param exhausted the exhausted to set
	 */
	public void setExhausted(boolean exhausted) {
		this.exhausted = exhausted;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the off
	 */
	public boolean isOff() {
		return off;
	}

	/**
	 * @param off the off to set
	 */
	public void setOff(boolean off) {
		this.off = off;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
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

	/**
	 * @return the summons
	 */
	public ArrayList<GameSummonModel> getSummons() {
		return summons;
	}

	/**
	 * @param summons the summons to set
	 */
	public void setSummons(ArrayList<GameSummonModel> summons) {
		this.summons = summons;
	}

}
