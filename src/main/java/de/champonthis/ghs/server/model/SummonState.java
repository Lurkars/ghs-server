/**
 * 
 */
package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum SummonState.
 */
public enum SummonState {

	@SerializedName("new")
	NEW,

	@SerializedName("true")
	TRUE,

	@SerializedName("false")
	FALSE
}
