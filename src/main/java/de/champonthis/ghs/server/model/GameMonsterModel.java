/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.ArrayList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Monster.
 */
public class GameMonsterModel {

	@Required
	private String name;
	@Required
	private String edition;
	@Required
	private int level = 1;
	@Required
	private boolean off = false;
	@Required
	private boolean active = false;
	@Required
	private int ability = -1;
	@Required
	private ArrayList<Integer> abilities = new ArrayList<Integer>();
	@Required
	private ArrayList<GameMonsterEntityModel> entities = new ArrayList<GameMonsterEntityModel>();

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
	 * Gets the off.
	 *
	 * @return the off
	 */
	public boolean getOff() {
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
	 * Gets the active.
	 *
	 * @return the active
	 */
	public boolean getActive() {
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
	 * Gets the ability.
	 *
	 * @return the ability
	 */
	public int getAbility() {
		return ability;
	}

	/**
	 * Sets the ability.
	 *
	 * @param ability the new ability
	 */
	public void setAbility(int ability) {
		this.ability = ability;
	}

	/**
	 * Gets the abilities.
	 *
	 * @return the abilities
	 */
	public ArrayList<Integer> getAbilities() {
		return abilities;
	}

	/**
	 * Sets the abilities.
	 *
	 * @param abilities the new abilities
	 */
	public void setAbilities(ArrayList<Integer> abilities) {
		this.abilities = abilities;
	}

	/**
	 * Gets the entities.
	 *
	 * @return the entities
	 */
	public ArrayList<GameMonsterEntityModel> getEntities() {
		return entities;
	}

	/**
	 * Sets the entities.
	 *
	 * @param entities the new entities
	 */
	public void setEntities(ArrayList<GameMonsterEntityModel> entities) {
		this.entities = entities;
	}

}
