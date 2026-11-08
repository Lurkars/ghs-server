package de.champonthis.ghs.server.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class RpgProgress {

	@Required
	private Map<String, Integer> attributes = new HashMap<>();
	private String pronouns = "";
	private String playerName = "";
	private String ancestry = "";
	private String backgrounds = "";
	private String personalGoal = "";
	@Required
	private LinkedList<RpgItem> items = new LinkedList<>();
	@Required
	private LinkedList<RpgFaction> factions = new LinkedList<>();
	@Required
	private LinkedList<RpgPower> talents = new LinkedList<>();
	@Required
	private LinkedList<RpgPower> ancestrySkills = new LinkedList<>();
	@Required
	private LinkedList<RpgPower> classSkills = new LinkedList<>();

}
