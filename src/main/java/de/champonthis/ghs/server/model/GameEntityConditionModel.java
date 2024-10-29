package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;

public class GameEntityConditionModel {

	@Required
	private ConditionName name;
	@Required
	private int value = 1;
	@Required
	private EntityConditionState state;
	@Required
	private EntityConditionState lastState;
	@Required
	private boolean permanent;
	@Required
	private boolean expired;
	@Required
	private boolean highlight;

	public ConditionName getName() {
		return name;
	}

	public void setName(ConditionName name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public EntityConditionState getState() {
		return state;
	}

	public void setState(EntityConditionState state) {
		this.state = state;
	}

	public EntityConditionState getLastState() {
		return lastState;
	}

	public void setLastState(EntityConditionState lastState) {
		this.lastState = lastState;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

}
