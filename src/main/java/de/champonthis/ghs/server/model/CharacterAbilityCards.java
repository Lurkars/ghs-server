package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import lombok.Data;

@Data
public class CharacterAbilityCards {

	private LinkedList<Integer> hand = new LinkedList<>();
	private LinkedList<Integer> selected = new LinkedList<>();
	private LinkedList<Integer> discard = new LinkedList<>();
	private LinkedList<Integer> lost = new LinkedList<>();
	private LinkedList<ActiveAbilityCard> active = new LinkedList<>();
	private String played;
	private LinkedList<Integer> shortRest = new LinkedList<>();

}
