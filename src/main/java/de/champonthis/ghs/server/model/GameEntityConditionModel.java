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
	private int count = 0;
	@Required
	private EntityConditionState state;
	@Required
	private boolean applied;

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
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(int count) {
		this.count = count;
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
	 * Checks if is applied.
	 *
	 * @return true, if is applied
	 */
	public boolean isApplied() {
		return applied;
	}

	/**
	 * Sets the applied.
	 *
	 * @param applied the new applied
	 */
	public void setApplied(boolean applied) {
		this.applied = applied;
	}

}
