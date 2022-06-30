/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.ArrayList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Objective.
 */
public class GameObjectiveModel {

	@Required
	private int id;
	private String title;
	@Required
	private String name;
	private Boolean escort;
	private Integer level;
	private Boolean exhausted;
	private Boolean off;
	private Boolean active;
	@Required
	private int health;
	@Required
	private String maxHealth;
	@Required
	private ArrayList<Condition> conditions = new ArrayList<Condition>();
	@Required
	private ArrayList<Condition> turnConditions = new ArrayList<Condition>();
	@Required
	private ArrayList<String> markers = new ArrayList<String>();
	private Integer initiative;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the escort
	 */
	public Boolean getEscort() {
		return escort;
	}

	/**
	 * @param escort the escort to set
	 */
	public void setEscort(Boolean escort) {
		this.escort = escort;
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
	 * @return the exhausted
	 */
	public Boolean getExhausted() {
		return exhausted;
	}

	/**
	 * @param exhausted the exhausted to set
	 */
	public void setExhausted(Boolean exhausted) {
		this.exhausted = exhausted;
	}

	/**
	 * @return the off
	 */
	public Boolean getOff() {
		return off;
	}

	/**
	 * @param off the off to set
	 */
	public void setOff(Boolean off) {
		this.off = off;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
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
	public String getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @param maxHealth the maxHealth to set
	 */
	public void setMaxHealth(String maxHealth) {
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
	 * @return the initiative
	 */
	public Integer getInitiative() {
		return initiative;
	}

	/**
	 * @param initiative the initiative to set
	 */
	public void setInitiative(Integer initiative) {
		this.initiative = initiative;
	}

}
