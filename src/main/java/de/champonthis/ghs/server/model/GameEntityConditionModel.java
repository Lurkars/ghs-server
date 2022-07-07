/**
 * 
 */
package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameEntityConditionModel.
 */
public class GameEntityConditionModel {

	@Required
	private ConditionName name;
	@Required
	private int value = 1;
	@Required
	private EntityConditionState state;
	@Required
	private boolean expired;
	@Required
	private boolean highlight;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public ConditionName getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(ConditionName name) {
		this.name = name;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public EntityConditionState getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(EntityConditionState state) {
		this.state = state;
	}

	/**
	 * Checks if is expired.
	 *
	 * @return true, if is expired
	 */
	public boolean isExpired() {
		return expired;
	}

	/**
	 * Sets the expired.
	 *
	 * @param expired the new expired
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	/**
	 * Checks if is highlight.
	 *
	 * @return true, if is highlight
	 */
	public boolean isHighlight() {
		return highlight;
	}

	/**
	 * Sets the highlight.
	 *
	 * @param highlight the new highlight
	 */
	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

}
