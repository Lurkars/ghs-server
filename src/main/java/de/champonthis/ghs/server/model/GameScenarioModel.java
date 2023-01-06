/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameScenarioModel.
 */
public class GameScenarioModel {

	@Required
	private String index;
	private String group;
	@Required
	private String edition;
	private boolean isCustom = false;
	private String custom;
	@Required
	private LinkedList<Integer> revealedRooms = new LinkedList<Integer>();

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
	 * Checks if is custom.
	 *
	 * @return true, if is custom
	 */
	public boolean isCustom() {
		return isCustom;
	}

	/**
	 * Sets the custom.
	 *
	 * @param isCustom the new custom
	 */
	public void setCustom(boolean isCustom) {
		this.isCustom = isCustom;
	}

	/**
	 * Gets the custom.
	 *
	 * @return the custom
	 */
	public String getCustom() {
		return custom;
	}

	/**
	 * Sets the custom.
	 *
	 * @param custom the new custom
	 */
	public void setCustom(String custom) {
		this.custom = custom;
	}

	/**
	 * Gets the revealed rooms.
	 *
	 * @return the revealed rooms
	 */
	public LinkedList<Integer> getRevealedRooms() {
		return revealedRooms;
	}

	/**
	 * Sets the revealed rooms.
	 *
	 * @param revealedRooms the new revealed rooms
	 */
	public void setRevealedRooms(LinkedList<Integer> revealedRooms) {
		this.revealedRooms = revealedRooms;
	}

}
