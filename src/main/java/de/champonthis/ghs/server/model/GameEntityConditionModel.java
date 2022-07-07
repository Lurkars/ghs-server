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
	 * @return the name
	 */
	public ConditionName getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(ConditionName name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the state
	 */
	public EntityConditionState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(EntityConditionState state) {
		this.state = state;
	}

	/**
	 * @return the expired
	 */
	public boolean isExpired() {
		return expired;
	}

	/**
	 * @param expired the expired to set
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	/**
	 * @return the highlight
	 */
	public boolean isHighlight() {
		return highlight;
	}

	/**
	 * @param highlight the highlight to set
	 */
	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

}
