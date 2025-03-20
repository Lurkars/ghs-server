package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

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

	@SerializedName("dodge")
	DODGE,

	@SerializedName("empower")
	EMPOWER,

	@SerializedName("enfeeble")
	ENFEEBLE,

	@SerializedName("poison_x")
	POISON_X,

	@SerializedName("wound_x")
	WOUND_X,

	@SerializedName("heal")
	HEAL,

	@SerializedName("shield")
	SHIELD,

	@SerializedName("retaliate")
	RETALIATE,

	@SerializedName("invalid")
	INVALID
}
