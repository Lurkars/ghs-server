package de.champonthis.ghs.server.model;

import java.util.LinkedList;

public class AdditionalIdentifier extends Identifier {

	private String type;
	private String marker;
	private LinkedList<String> tags = new LinkedList<>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public LinkedList<String> getTags() {
		return tags;
	}

	public void setTags(LinkedList<String> tags) {
		this.tags = tags;
	}

}
