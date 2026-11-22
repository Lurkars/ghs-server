package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import com.google.gson.JsonElement;

import lombok.Data;

@Data
public class OutpostAttackModel {

	private JsonElement attack;
	private LinkedList<JsonElement> effects = new LinkedList<>();
	private int manualAttackValue = 50;
	private int manualTargetNumber = 4;
	private JsonElement target;
	private LinkedList<String> buildings = new LinkedList<>();
	private LinkedList<String> others = new LinkedList<>();
	private int attacks = 0;
	private int soldiers = 0;
	private int drawnBefore = -1;
	private int attackResult = -1;
	private LinkedList<OutpostAttackResource> resources = new LinkedList<>();

}
