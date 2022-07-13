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
	 * @return the health
	 */
	public String getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(String health) {
		this.health = health;
	}

	/**
	 * @return the escort
	 */
	public boolean isEscort() {
		return escort;
	}

	/**
	 * @param escort the escort to set
	 */
	public void setEscort(boolean escort) {
		this.escort = escort;
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

}
