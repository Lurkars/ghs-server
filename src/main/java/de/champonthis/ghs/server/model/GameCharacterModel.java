/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameCharacterModel.
 */
public class GameCharacterModel {

	@Required
	private String name;
	@Required
	private String edition;
	@Required
	private boolean marker;
	private String title;
	@Required
	private int initiative;
	@Required
	private int experience;
	@Required
	private int loot;
	@Required
	private LinkedList<Integer> lootCards = new LinkedList<>();
	@Required
	private LinkedList<String> treasures = new LinkedList<>();
	@Required
	private boolean exhausted;
	@Required
	private int level;
	@Required
	private boolean off;
	@Required
	private boolean active;
	@Required
	private int health;
	@Required
	private int maxHealth;
	@Required
	private LinkedList<GameEntityConditionModel> entityConditions = new LinkedList<>();
	@Required
	private LinkedList<String> markers = new LinkedList<>();
	@Required
	private LinkedList<String> tags = new LinkedList<>();
	@Required
	private int identity;
	@Required
	private LinkedList<GameSummonModel> summons = new LinkedList<>();
	private CharacterProgress progress;
	@JsonIgnore
	private boolean fullview;
	@Required
	private int number;
	@Required
	private GameAttackModifierDeckModel attackModifierDeck = new GameAttackModifierDeckModel();
	@Required
	private int donations;
	@Required
	private boolean absent;
	@Required
	private boolean longRest;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the edition.
	 *
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * Sets the edition.
	 *
	 * @param edition the new edition
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * Checks if is marker.
	 *
	 * @return true, if is marker
	 */
	public boolean isMarker() {
		return marker;
	}

	/**
	 * Sets the marker.
	 *
	 * @param marker the new marker
	 */
	public void setMarker(boolean marker) {
		this.marker = marker;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the initiative.
	 *
	 * @return the initiative
	 */
	public int getInitiative() {
		return initiative;
	}

	/**
	 * Sets the initiative.
	 *
	 * @param initiative the new initiative
	 */
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	/**
	 * Gets the experience.
	 *
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Sets the experience.
	 *
	 * @param experience the new experience
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * Gets the loot.
	 *
	 * @return the loot
	 */
	public int getLoot() {
		return loot;
	}

	/**
	 * Sets the loot.
	 *
	 * @param loot the new loot
	 */
	public void setLoot(int loot) {
		this.loot = loot;
	}

	/**
	 * Gets the loot cards.
	 *
	 * @return the loot cards
	 */
	public LinkedList<Integer> getLootCards() {
		return lootCards;
	}

	/**
	 * Sets the loot cards.
	 *
	 * @param lootCards the new loot cards
	 */
	public void setLootCards(LinkedList<Integer> lootCards) {
		this.lootCards = lootCards;
	}

	/**
	 * Gets the treasures.
	 *
	 * @return the treasures
	 */
	public LinkedList<String> getTreasures() {
		return treasures;
	}

	/**
	 * Sets the treasures.
	 *
	 * @param treasures the new treasures
	 */
	public void setTreasures(LinkedList<String> treasures) {
		this.treasures = treasures;
	}

	/**
	 * Checks if is exhausted.
	 *
	 * @return true, if is exhausted
	 */
	public boolean isExhausted() {
		return exhausted;
	}

	/**
	 * Sets the exhausted.
	 *
	 * @param exhausted the new exhausted
	 */
	public void setExhausted(boolean exhausted) {
		this.exhausted = exhausted;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Checks if is off.
	 *
	 * @return true, if is off
	 */
	public boolean isOff() {
		return off;
	}

	/**
	 * Sets the off.
	 *
	 * @param off the new off
	 */
	public void setOff(boolean off) {
		this.off = off;
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Gets the health.
	 *
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Sets the health.
	 *
	 * @param health the new health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Gets the max health.
	 *
	 * @return the max health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * Sets the max health.
	 *
	 * @param maxHealth the new max health
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * Gets the entity conditions.
	 *
	 * @return the entity conditions
	 */
	public LinkedList<GameEntityConditionModel> getEntityConditions() {
		return entityConditions;
	}

	/**
	 * Sets the entity conditions.
	 *
	 * @param entityConditions the new entity conditions
	 */
	public void setEntityConditions(LinkedList<GameEntityConditionModel> entityConditions) {
		this.entityConditions = entityConditions;
	}

	/**
	 * Gets the markers.
	 *
	 * @return the markers
	 */
	public LinkedList<String> getMarkers() {
		return markers;
	}

	/**
	 * Sets the markers.
	 *
	 * @param markers the new markers
	 */
	public void setMarkers(LinkedList<String> markers) {
		this.markers = markers;
	}

	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	public LinkedList<String> getTags() {
		return tags;
	}

	/**
	 * Sets the tags.
	 *
	 * @param tags the new tags
	 */
	public void setTags(LinkedList<String> tags) {
		this.tags = tags;
	}

	/**
	 * Gets the identity.
	 *
	 * @return the identity
	 */
	public int getIdentity() {
		return identity;
	}

	/**
	 * Sets the identity.
	 *
	 * @param identity the new identity
	 */
	public void setIdentity(int identity) {
		this.identity = identity;
	}

	/**
	 * Gets the summons.
	 *
	 * @return the summons
	 */
	public LinkedList<GameSummonModel> getSummons() {
		return summons;
	}

	/**
	 * Sets the summons.
	 *
	 * @param summons the new summons
	 */
	public void setSummons(LinkedList<GameSummonModel> summons) {
		this.summons = summons;
	}

	/**
	 * Gets the progress.
	 *
	 * @return the progress
	 */
	public CharacterProgress getProgress() {
		return progress;
	}

	/**
	 * Sets the progress.
	 *
	 * @param progress the new progress
	 */
	public void setProgress(CharacterProgress progress) {
		this.progress = progress;
	}

	/**
	 * Checks if is fullview.
	 *
	 * @return true, if is fullview
	 */
	public boolean isFullview() {
		return fullview;
	}

	/**
	 * Sets the fullview.
	 *
	 * @param fullview the new fullview
	 */
	public void setFullview(boolean fullview) {
		this.fullview = fullview;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Gets the attack modifier deck.
	 *
	 * @return the attack modifier deck
	 */
	public GameAttackModifierDeckModel getAttackModifierDeck() {
		return attackModifierDeck;
	}

	/**
	 * Sets the attack modifier deck.
	 *
	 * @param attackModifierDeck the new attack modifier deck
	 */
	public void setAttackModifierDeck(GameAttackModifierDeckModel attackModifierDeck) {
		this.attackModifierDeck = attackModifierDeck;
	}

	/**
	 * Gets the donations.
	 *
	 * @return the donations
	 */
	public int getDonations() {
		return donations;
	}

	/**
	 * Sets the donations.
	 *
	 * @param donations the new donations
	 */
	public void setDonations(int donations) {
		this.donations = donations;
	}

	/**
	 * Checks if is absent.
	 *
	 * @return true, if is absent
	 */
	public boolean isAbsent() {
		return absent;
	}

	/**
	 * Sets the absent.
	 *
	 * @param absent the new absent
	 */
	public void setAbsent(boolean absent) {
		this.absent = absent;
	}

	/**
	 * Checks if is long rest.
	 *
	 * @return true, if is long rest
	 */
	public boolean isLongRest() {
		return longRest;
	}

	/**
	 * Sets the long rest.
	 *
	 * @param longRest the new long rest
	 */
	public void setLongRest(boolean longRest) {
		this.longRest = longRest;
	}

}
