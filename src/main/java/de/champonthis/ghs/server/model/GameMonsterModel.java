/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameMonsterModel.
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
	private boolean drawExtra = false;
	@Required
	private int lastDraw = -1;
	@Required
	private int ability = -1;
	@Required
	private LinkedList<Integer> abilities = new LinkedList<>();
	@Required
	private LinkedList<GameMonsterEntityModel> entities = new LinkedList<>();
	@Required
	private boolean isAlly = false;
	@Required
	private boolean isConfederated = false;

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
	 * Checks if is draw extra.
	 *
	 * @return true, if is draw extra
	 */
	public boolean isDrawExtra() {
		return drawExtra;
	}

	/**
	 * Sets the draw extra.
	 *
	 * @param drawExtra the new draw extra
	 */
	public void setDrawExtra(boolean drawExtra) {
		this.drawExtra = drawExtra;
	}

	/**
	 * Gets the last draw.
	 *
	 * @return the last draw
	 */
	public int getLastDraw() {
		return lastDraw;
	}

	/**
	 * Sets the last draw.
	 *
	 * @param lastDraw the new last draw
	 */
	public void setLastDraw(int lastDraw) {
		this.lastDraw = lastDraw;
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
	public LinkedList<Integer> getAbilities() {
		return abilities;
	}

	/**
	 * Sets the abilities.
	 *
	 * @param abilities the new abilities
	 */
	public void setAbilities(LinkedList<Integer> abilities) {
		this.abilities = abilities;
	}

	/**
	 * Gets the entities.
	 *
	 * @return the entities
	 */
	public LinkedList<GameMonsterEntityModel> getEntities() {
		return entities;
	}

	/**
	 * Sets the entities.
	 *
	 * @param entities the new entities
	 */
	public void setEntities(LinkedList<GameMonsterEntityModel> entities) {
		this.entities = entities;
	}

	/**
	 * Checks if is ally.
	 *
	 * @return true, if is ally
	 */
	public boolean isAlly() {
		return isAlly;
	}

	/**
	 * Sets the ally.
	 *
	 * @param isAlly the new ally
	 */
	public void setAlly(boolean isAlly) {
		this.isAlly = isAlly;
	}

	/**
	 * Checks if is confederated.
	 *
	 * @return true, if is confederated
	 */
	public boolean isConfederated() {
		return isConfederated;
	}

	/**
	 * Sets the confederated.
	 *
	 * @param isConfederated the new confederated
	 */
	public void setConfederated(boolean isConfederated) {
		this.isConfederated = isConfederated;
	}

}
