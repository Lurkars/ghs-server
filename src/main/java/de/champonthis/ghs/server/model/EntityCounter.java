package de.champonthis.ghs.server.model;

public class EntityCounter {

	private AdditionalIdentifier identifier;
	private int total;
	private int killed;

	public AdditionalIdentifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(AdditionalIdentifier identifier) {
		this.identifier = identifier;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getKilled() {
		return killed;
	}

	public void setKilled(int killed) {
		this.killed = killed;
	}

}
