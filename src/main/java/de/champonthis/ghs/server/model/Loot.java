package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;

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

	public LootType getType() {
		return type;
	}

	public void setType(LootType type) {
		this.type = type;
	}

	public Integer getValue4P() {
		return value4P;
	}

	public void setValue4P(Integer value4p) {
		value4P = value4p;
	}

	public Integer getValue3P() {
		return value3P;
	}

	public void setValue3P(Integer value3p) {
		value3P = value3p;
	}

	public Integer getValue2P() {
		return value2P;
	}

	public void setValue2P(Integer value2p) {
		value2P = value2p;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getEnhancements() {
		return enhancements;
	}

	public void setEnhancements(int enhancements) {
		this.enhancements = enhancements;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

}
