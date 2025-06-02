package de.champonthis.ghs.server.model;

import lombok.Data;

@Data
public class ScenarioObjectiveIdentifier {

	private String edition;
	private String scenario;
	private String group;
	private boolean section;
	private int index;

}
