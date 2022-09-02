/**
 * 
 */
package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum ElementState.
 */
public enum ElementState {

	@SerializedName("strong")
	STRONG,

	@SerializedName("waning")
	WANING,

	@SerializedName("inert")
	INERT,

	@SerializedName("new")
	NEW
}
