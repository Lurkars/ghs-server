/**
 * 
 */
package de.champonthis.ghs.server.model;

/**
 * 
 */
public class ObjectiveData {

	private String name;
	private String maxHealth;
	private boolean escort;

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

}
