/**
 * 
 */
package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Loot.
 */
public class Loot {

	@Required
	private LootType type;
	private Integer value4P;
	private Integer value3P;
	private Integer value2P;
	private String value;
	@Required
	private int enhancements = 0;
	private Integer cardId;

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public LootType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(LootType type) {
		this.type = type;
	}

	/**
	 * Gets the value 4 P.
	 *
	 * @return the value 4 P
	 */
	public Integer getValue4P() {
		return value4P;
	}

	/**
	 * Sets the value 4 P.
	 *
	 * @param value4p the new value 4 P
	 */
	public void setValue4P(Integer value4p) {
		value4P = value4p;
	}

	/**
	 * Gets the value 3 P.
	 *
	 * @return the value 3 P
	 */
	public Integer getValue3P() {
		return value3P;
	}

	/**
	 * Sets the value 3 P.
	 *
	 * @param value3p the new value 3 P
	 */
	public void setValue3P(Integer value3p) {
		value3P = value3p;
	}

	/**
	 * Gets the value 2 P.
	 *
	 * @return the value 2 P
	 */
	public Integer getValue2P() {
		return value2P;
	}

	/**
	 * Sets the value 2 P.
	 *
	 * @param value2p the new value 2 P
	 */
	public void setValue2P(Integer value2p) {
		value2P = value2p;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the enhancements.
	 *
	 * @return the enhancements
	 */
	public int getEnhancements() {
		return enhancements;
	}

	/**
	 * Sets the enhancements.
	 *
	 * @param enhancements the new enhancements
	 */
	public void setEnhancements(int enhancements) {
		this.enhancements = enhancements;
	}

	/**
	 * Gets the card id.
	 *
	 * @return the card id
	 */
	public Integer getCardId() {
		return cardId;
	}

	/**
	 * Sets the card id.
	 *
	 * @param cardId the new card id
	 */
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

}
