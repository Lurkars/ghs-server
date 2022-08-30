/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class SectionData.
 */
public class SectionData {

	@Required
	private String name;
	@Required
	private String index;
	private String group;
	@Required
	private LinkedList<String> monsters = new LinkedList<String>();
	@Required
	private LinkedList<String> allies = new LinkedList<String>();
	@Required
	private LinkedList<ObjectiveData> objectives = new LinkedList<ObjectiveData>();
	@Required
	private String edition;
	private Boolean spoiler;

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
	 * Gets the index.
	 *
	 * @return the index
	 */
	public String getIndex() {
		return index;
	}

	/**
	 * Sets the index.
	 *
	 * @param index the new index
	 */
	public void setIndex(String index) {
		this.index = index;
	}

	/**
	 * Gets the group.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Sets the group.
	 *
	 * @param group the new group
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Gets the monsters.
	 *
	 * @return the monsters
	 */
	public LinkedList<String> getMonsters() {
		return monsters;
	}

	/**
	 * Sets the monsters.
	 *
	 * @param monsters the new monsters
	 */
	public void setMonsters(LinkedList<String> monsters) {
		this.monsters = monsters;
	}

	/**
	 * Gets the allies.
	 *
	 * @return the allies
	 */
	public LinkedList<String> getAllies() {
		return allies;
	}

	/**
	 * Sets the allies.
	 *
	 * @param allies the new allies
	 */
	public void setAllies(LinkedList<String> allies) {
		this.allies = allies;
	}

	/**
	 * Gets the objectives.
	 *
	 * @return the objectives
	 */
	public LinkedList<ObjectiveData> getObjectives() {
		return objectives;
	}

	/**
	 * Sets the objectives.
	 *
	 * @param objectives the new objectives
	 */
	public void setObjectives(LinkedList<ObjectiveData> objectives) {
		this.objectives = objectives;
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
	 * Gets the spoiler.
	 *
	 * @return the spoiler
	 */
	public Boolean getSpoiler() {
		return spoiler;
	}

	/**
	 * Sets the spoiler.
	 *
	 * @param spoiler the new spoiler
	 */
	public void setSpoiler(Boolean spoiler) {
		this.spoiler = spoiler;
	}

}
