package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class RpgFaction {

	private String name = "";
	private int tier = -1;
	@Required
	private LinkedList<String> benefits = new LinkedList<>();

}
