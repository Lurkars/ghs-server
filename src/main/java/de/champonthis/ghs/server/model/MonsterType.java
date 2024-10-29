package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

public enum MonsterType {

	@SerializedName("normal")
	NORMAL,

	@SerializedName("elite")
	ELITE,

	@SerializedName("boss")
	BOSS
}
