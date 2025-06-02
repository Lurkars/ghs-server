package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class GameScenarioModel {

	@Required
	private String index;
	@Required
	private String edition;
	private String group;
	private boolean isCustom = false;
	private String custom;
	@Required
	private LinkedList<Integer> revealedRooms = new LinkedList<>();

}
