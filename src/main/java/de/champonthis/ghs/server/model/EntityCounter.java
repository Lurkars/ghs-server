/**
 * 
 */
package de.champonthis.ghs.server.model;

/**
 * The Class EntityCounter.
 */
public class EntityCounter {

	private AdditionalIdentifier identifier;
	private int total;
	private int killed;

	/**
	 * Gets the identifier.
	 *
	 * @return the identifier
	 */
	public AdditionalIdentifier getIdentifier() {
		return identifier;
	}

	/**
	 * Sets the identifier.
	 *
	 * @param identifier the new identifier
	 */
	public void setIdentifier(AdditionalIdentifier identifier) {
		this.identifier = identifier;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Gets the killed.
	 *
	 * @return the killed
	 */
	public int getKilled() {
		return killed;
	}

	/**
	 * Sets the killed.
	 *
	 * @param killed the new killed
	 */
	public void setKilled(int killed) {
		this.killed = killed;
	}

}
