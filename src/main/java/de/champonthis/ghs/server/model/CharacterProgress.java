package de.champonthis.ghs.server.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class CharacterProgress {

	private int experience = 0;
	private int gold = 0;
	@Required
	private Map<LootType, Integer> loot = new HashMap<>();
	private String itemNotes = "";
	@Required
	private LinkedList<Identifier> items = new LinkedList<>();
	@Required
	private LinkedList<AdditionalIdentifier> equippedItems = new LinkedList<>();
	private String personalQuest = "";
	@Required
	private LinkedList<Integer> personalQuestProgress = new LinkedList<>();
	private int battleGoals = 0;
	private String notes = "";
	private boolean retired = false;
	private int retirements = 0;
	private int extraPerks = 0;
	@Required
	private LinkedList<Integer> perks = new LinkedList<>();
	@Required
	private LinkedList<Integer> masteries = new LinkedList<>();
	private int donations = 0;
	@Required
	private LinkedList<ScenarioStats> scenarioStats = new LinkedList<>();
	private Identifier trial;
	@Required
	private LinkedList<Integer> deck = new LinkedList<>();
	@Required
	private LinkedList<Enhancement> enhancements = new LinkedList<>();

}
