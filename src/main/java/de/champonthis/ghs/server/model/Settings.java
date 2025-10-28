package de.champonthis.ghs.server.model;

import java.util.Arrays;
import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class Settings {

	@Required
	private boolean abilities = true;
	@Required
	private boolean abilityNumbers = true;
	@Required
	private boolean abilityReveal = true;
	@Required
	private boolean activeApplyConditions = true;
	@Required
	private LinkedList<ConditionName> activeApplyConditionsAuto = new LinkedList<>();
	@Required
	private LinkedList<ConditionName> activeApplyConditionsExcludes = new LinkedList<>(
			Arrays.asList(ConditionName.SHIELD));
	@Required
	private boolean activeStandees = true;
	@Required
	private boolean activeSummons = true;
	@Required
	private boolean addAllMonsters = false;
	@Required
	private boolean allyAttackModifierDeck = true;
	@Required
	private boolean alwaysAllyAttackModifierDeck = false;
	@Required
	private boolean alwaysFhAdvantage = false;
	@Required
	private boolean alwaysFhEnhancements = false;
	@Required
	private boolean alwaysFhSolo = false;
	@Required
	private boolean alwaysHazardousTerrain = false;
	@Required
	private boolean alwaysLootApplyDialog = false;
	@Required
	private boolean alwaysLootDeck = false;
	@Required
	private boolean amAdvantage = false;
	@Required
	private boolean amAdvantageHouseRule = false;
	@Required
	private boolean applyBuildingRewards = true;
	@Required
	private boolean applyConditions = true;
	@Required
	private LinkedList<ConditionName> applyConditionsExcludes = new LinkedList<>(Arrays.asList(ConditionName.SHIELD));
	@Required
	private boolean applyLongRest = true;
	@Required
	private boolean applyLoot = true;
	@Required
	private boolean applyLootRandomItem = true;
	@Required
	private boolean applyRetirement = true;
	@Required
	private boolean automaticFirstFigure = false;
	@Required
	private boolean automaticPassTime = true;
	@Required
	private boolean automaticStandees = true;
	@Required
	private boolean automaticStandeesDialog = false;
	@Required
	private boolean automaticUnlocking = true;
	@Required
	private boolean battleGoals = false;
	@Required
	private boolean battleGoalsCharacter = false;
	@Required
	private boolean battleGoalsFh = false;
	@Required
	private boolean battleGoalsReminder = true;
	@Required
	private boolean bbAm = true;
	@Required
	private boolean bbChars = true;
	@Required
	private boolean bbStandeeLimit = true;
	@Required
	private boolean calculate = true;
	@Required
	private boolean calculateStats = true;
	@Required
	private boolean calculateShieldStats = true;
	@Required
	private boolean characterAttackModifierDeck = true;
	@Required
	private boolean characterHandSize = false;
	@Required
	private boolean characterIdentities = true;
	@Required
	private boolean characterIdentityHint = true;
	@Required
	private boolean characterItems = false;
	@Required
	private boolean characterItemsApply = true;
	@Required
	private boolean characterSheet = true;
	@Required
	private boolean characterShieldRetaliate = false;
	@Required
	private boolean characterSortIndex = false;
	@Required
	private boolean characterTraits = false;
	@Required
	private boolean combineInteractiveAbilities = true;
	@Required
	private boolean combineSummonAction = true;
	@Required
	private boolean damageHP = false;
	@Required
	private boolean disabledTurnConfirmation = false;
	@Required
	private boolean disableSortFigures = false;
	@Required
	private boolean disableStandees = false;
	@Required
	private boolean drawRandomItem = true;
	@Required
	private boolean drawRandomScenario = true;
	@Required
	private LinkedList<String> editionDataUrls = new LinkedList<>();
	@Required
	private LinkedList<String> editions = new LinkedList<>();
	@Required
	private boolean eliteFirst = true;
	@Required
	private LinkedList<String> excludeEditionDataUrls = new LinkedList<>();
	@Required
	private boolean expireConditions = true;
	@Required
	private boolean events = true;
	@Required
	private boolean eventsApply = true;
	@Required
	private boolean eventsDraw = true;
	@Required
	private boolean fhChallenges = false;
	@Required
	private boolean fhChallengesApply = true;
	@Required
	private boolean fhGhItems = false;
	@Required
	private boolean fhSecondEdition = false;
	@Required
	private boolean fhTrials = false;
	@Required
	private boolean fhTrialsApply = true;
	@Required
	private boolean gh2eImbuement = false;
	@Required
	private boolean hideAbsent = false;
	@Required
	private boolean hideStats = false;
	@Required
	private boolean initiativeRequired = true;
	@Required
	private boolean interactiveAbilities = true;
	@Required
	private String locale = "en";
	@Required
	private boolean lootDeck = true;
	private int maxUndo = 50;
	@Required
	private boolean monsters = true;
	@Required
	private boolean monsterAttackModifierDeck = true;
	@Required
	private boolean moveElements = true;
	@Required
	private boolean partySheet = true;
	@Required
	private boolean randomStandees = false;
	@Required
	private boolean removeUnusedMonster = false;
	@Required
	private boolean scenarioNumberInput = false;
	@Required
	private boolean scenarioRewards = true;
	@Required
	private boolean scenarioRewardsItems = true;
	@Required
	private boolean scenarioRooms = true;
	@Required
	private boolean scenarioRules = true;
	@Required
	private boolean scenarioRulesAutoapply = false;
	@Required
	private boolean scenarioStats = false;
	@Required
	private boolean showExpandedAbilityCard = false;
	@Required
	private boolean showExpandedStatCard = false;
	@Required
	private boolean showFullAbilityCard = false;
	@Required
	private boolean sortFigures = true;
	@Required
	private LinkedList<String> spoilers = new LinkedList<>();
	@Required
	private boolean standees = true;
	@Required
	private boolean standeeShieldRetaliate = false;
	@Required
	private boolean standeeStats = false;
	@Required
	private boolean stats = true;
	@Required
	private boolean summons = true;
	@Required
	private boolean temporaryEnhancements = true;
	@Required
	private boolean treasures = true;
	@Required
	private boolean treasuresLoot = true;
	@Required
	private boolean treasuresLootItem = true;
	@Required
	private boolean treasuresLootScenario = true;
	@Required
	private boolean turnConfirmation = true;
	@Required
	private boolean unlockEnvelopeBuildings = true;

}
