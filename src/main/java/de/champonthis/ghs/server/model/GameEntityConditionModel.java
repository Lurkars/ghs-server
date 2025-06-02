package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
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

}
