/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.ArrayList;

import de.champonthis.ghs.server.util.Required;

/**
 * 
 */
public class SectionData {

	@Required
	private String name;
	@Required
	private Integer index;
	@Required
	private ArrayList<String> monsters = new ArrayList<String>();
	@Required
	private ArrayList<ObjectiveData> objectives = new ArrayList<ObjectiveData>();
	@Required
	private String edition;
	private Boolean spoiler;

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
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * @return the monsters
	 */
	public ArrayList<String> getMonsters() {
		return monsters;
	}

	/**
	 * @param monsters the monsters to set
	 */
	public void setMonsters(ArrayList<String> monsters) {
		this.monsters = monsters;
	}

	/**
	 * @return the objectives
	 */
	public ArrayList<ObjectiveData> getObjectives() {
		return objectives;
	}

	/**
	 * @param objectives the objectives to set
	 */
	public void setObjectives(ArrayList<ObjectiveData> objectives) {
		this.objectives = objectives;
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
	 * @return the spoiler
	 */
	public Boolean getSpoiler() {
		return spoiler;
	}

	/**
	 * @param spoiler the spoiler to set
	 */
	public void setSpoiler(Boolean spoiler) {
		this.spoiler = spoiler;
	}

}
