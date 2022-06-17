/**
 * 
 */
package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum AttackModifierType.
 */
public enum AttackModifierType {

	@SerializedName("plus0")
	PLUS0,

	@SerializedName("plus1")
	PLUS1,

	@SerializedName("plus2")
	PLUS2,

	@SerializedName("minus1")
	MINUS1,

	@SerializedName("minus2")
	MINUS2,

	@SerializedName("null")
	NULL,

	@SerializedName("double")
	DOUBLE,

	@SerializedName("bless")
	BLESS,

	@SerializedName("curse")
	CURSE
}
