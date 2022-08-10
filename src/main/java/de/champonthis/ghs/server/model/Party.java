/**
 * 
 */
package de.champonthis.ghs.server.model;

/**
 * 
 */
public class Party {

	private String name;
	private String location;
	private String notes;
	private String achievements;
	private int reputation = 0;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the achievements
	 */
	public String getAchievements() {
		return achievements;
	}

	/**
	 * @param achievements the achievements to set
	 */
	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	/**
	 * @return the reputation
	 */
	public int getReputation() {
		return reputation;
	}

	/**
	 * @param reputation the reputation to set
	 */
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

}
