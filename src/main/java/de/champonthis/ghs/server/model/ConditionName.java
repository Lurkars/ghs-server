/**
 * 
 */
package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum ConditionName.
 */
public enum ConditionName {
	@SerializedName("stun")
	STUN,

	@SerializedName("immobilize")
	IMMOBILIZE,

	@SerializedName("disarm")
	DISARM,

	@SerializedName("wound")
	WOUND,

	@SerializedName("muddle")
	MUDDLE,

	@SerializedName("poison")
	POISON,

	@SerializedName("invisible")
	INVISIBLE,

	@SerializedName("strengthen")
	STRENGTHEN,

	@SerializedName("curse")
	CURSE,

	@SerializedName("bless")
	BLESS,

	@SerializedName("regenerate")
	REGENERATE,

	@SerializedName("chill")
	CHILL,

	@SerializedName("infect")
	INFECT,

	@SerializedName("ward")
	WARD,

	@SerializedName("bane")
	BANE,

	@SerializedName("brittle")
	BRITTLE,

	@SerializedName("impair")
	IMPAIR,

	@SerializedName("rupture")
	RUPTURE,

	@SerializedName("poison_x")
	POISON_X,

	@SerializedName("wound_x")
	WOUND_X,

	@SerializedName("heal")
	HEAL
}
