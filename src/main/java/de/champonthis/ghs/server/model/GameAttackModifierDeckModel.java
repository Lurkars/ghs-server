package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
	// TODO: rework these fields so they play nice with Lombok
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private String state;
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean bb;
	// migration
	private LinkedList<Integer> disgarded = new LinkedList<>();

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getBb() {
		return bb;
	}

	public void setState(Boolean bb) {
		this.bb = bb;
	}

}
