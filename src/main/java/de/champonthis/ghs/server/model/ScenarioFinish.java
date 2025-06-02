package de.champonthis.ghs.server.model;

import java.util.LinkedList;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class ScenarioFinish {

	private GameScenarioModel conclusion;
	private boolean success = false;
	@Required
	private LinkedList<Integer> battleGoals = new LinkedList<>();
	@Required
	private LinkedList<Integer> collectiveGold = new LinkedList<>();
	@Required
	private LinkedList<Map<LootType, Integer>> collectiveResources = new LinkedList<>();
	@Required
	private LinkedList<LinkedList<Integer>> items = new LinkedList<>();
	private String chooseLocation;
	private String chooseUnlockCharacter;
	private int challenges;
	@Required
	private LinkedList<Integer> calenderSectionManual = new LinkedList<>();
	@Required
	private LinkedList<Integer> calendarSectionManual = new LinkedList<>();
	private Identifier randomItem;
	private Integer randomItemIndex = -1;
	private LinkedList<Identifier> randomItems = new LinkedList<>();
	@Required
	private LinkedList<Integer> randomItemBlueprints = new LinkedList<>();
	@Required
	private LinkedList<Boolean> trials = new LinkedList<>();

}
