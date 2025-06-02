package de.champonthis.ghs.server.model;

import lombok.Data;

@Data
public class ScenarioRuleIdentifier {

	private String edition;
	private String scenario;
	private String group;
	private int index;
	private boolean section;

}
