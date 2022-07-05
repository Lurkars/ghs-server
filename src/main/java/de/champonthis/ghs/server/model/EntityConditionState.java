/**
 * 
 */
package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum EntityConditionState.
 */
public enum EntityConditionState {

	@SerializedName("normal")
	NORMAL,

	@SerializedName("expire")
	EXPIRE,

	@SerializedName("turn")
	TURN

}
