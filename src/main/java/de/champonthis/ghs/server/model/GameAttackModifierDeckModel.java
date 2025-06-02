package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class GameAttackModifierDeckModel {

	@Required
	private int current;
	@Required
	private LinkedList<String> cards = new LinkedList<>();
	@Required
	private LinkedList<Integer> discarded = new LinkedList<>();
	@Required
	private boolean active = true;
	private Integer lastVisible;
	private String state;
	private Boolean bb;
	// migration
	private LinkedList<Integer> disgarded = new LinkedList<>();

}
