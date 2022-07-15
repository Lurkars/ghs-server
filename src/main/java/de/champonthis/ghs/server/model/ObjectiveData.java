/**
 * 
 */
package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class ObjectiveData.
 */
public class ObjectiveData {

	@Required
	private String name;
	@Required
	private String health;
	private boolean escort;
	private int initiative;

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
	 * Gets the health.
	 *
	 * @return the health
	 */
	public String getHealth() {
		return health;
	}

	/**
	 * Sets the health.
	 *
	 * @param health the new health
	 */
	public void setHealth(String health) {
		this.health = health;
	}

	/**
	 * Checks if is escort.
	 *
	 * @return true, if is escort
	 */
	public boolean isEscort() {
		return escort;
	}

	/**
	 * Sets the escort.
	 *
	 * @param escort the new escort
	 */
	public void setEscort(boolean escort) {
		this.escort = escort;
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

}
