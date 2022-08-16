/**
 * 
 */
package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum Element.
 */
public enum Element {

	@SerializedName("all")
	ALL,

	@SerializedName("fire")
	FIRE,

	@SerializedName("ice")
	ICE,

	@SerializedName("air")
	AIR,

	@SerializedName("earth")
	EARTH,

	@SerializedName("light")
	LIGHT,

	@SerializedName("dark")
	DARK
}
