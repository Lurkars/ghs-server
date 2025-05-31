package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class GameChallengeDeckModel {

	@Required
	private int current;
	@Required
	private int finished;
	@Required
	private LinkedList<Integer> keep = new LinkedList<>();
	@Required
	private LinkedList<Identifier> cards = new LinkedList<>();
	@Required
	private boolean active = false;

}
