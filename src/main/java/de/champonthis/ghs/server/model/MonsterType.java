/**
 * 
 */
package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum MonsterType.
 */
public enum MonsterType {

	@SerializedName("normal")
	NORMAL,

	@SerializedName("elite")
	ELITE,

	@SerializedName("boss")
	BOSS
}
