package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

public enum EntityConditionState {

	@SerializedName("new")
	NEW,

	@SerializedName("normal")
	NORMAL,

	@SerializedName("expire")
	EXPIRE,

	@SerializedName("removed")
	REMOVED,

	@SerializedName("turn")
	TURN

}
