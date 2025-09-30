package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class BuildingModel {

	@Required
	private String name;
	@Required
	private int level;
	@Required
	private String state;
	private Boolean attacked;

}
