/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.ArrayList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Scenario.
 */
public class Scenario {

	@Required
	private String name;
	@Required
	private Integer index;
	@Required
	private ArrayList<String> monsters = new ArrayList<String>();
	@Required
	private String edition;
	private Boolean spoiler;
	private Boolean custom;

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
	public Integer getIndex() {
		return index;
	}

	/**
	 * Sets the index.
	 *
	 * @param index the new index
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * Gets the monsters.
	 *
	 * @return the monsters
	 */
	public ArrayList<String> getMonsters() {
		return monsters;
	}

	/**
	 * Sets the monsters.
	 *
	 * @param monsters the new monsters
	 */
	public void setMonsters(ArrayList<String> monsters) {
		this.monsters = monsters;
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

	/**
	 * Gets the custom.
	 *
	 * @return the custom
	 */
	public Boolean getCustom() {
		return custom;
	}

	/**
	 * Sets the custom.
	 *
	 * @param custom the new custom
	 */
	public void setCustom(Boolean custom) {
		this.custom = custom;
	}

}
