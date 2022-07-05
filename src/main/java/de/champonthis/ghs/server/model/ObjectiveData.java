/**
 * 
 */
package de.champonthis.ghs.server.model;

/**
 * The Class ObjectiveData.
 */
public class ObjectiveData {

	private String name;
	private String maxHealth;
	private boolean escort;

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
	 * Gets the max health.
	 *
	 * @return the max health
	 */
	public String getMaxHealth() {
		return maxHealth;
	}

	/**
	 * Sets the max health.
	 *
	 * @param maxHealth the new max health
	 */
	public void setMaxHealth(String maxHealth) {
		this.maxHealth = maxHealth;
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

}
