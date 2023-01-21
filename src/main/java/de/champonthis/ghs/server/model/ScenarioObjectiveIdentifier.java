/**
 * 
 */
package de.champonthis.ghs.server.model;

/**
 * The Class ScenarioObjectiveIdentifier.
 */
public class ScenarioObjectiveIdentifier {

	private String edition;
	private String scenario;
	private String group;
	private boolean section;
	private int index;

	/**
	 * Gets the edition.
	 *
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * Sets the edition.
	 *
	 * @param edition the new edition
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * Gets the scenario.
	 *
	 * @return the scenario
	 */
	public String getScenario() {
		return scenario;
	}

	/**
	 * Sets the scenario.
	 *
	 * @param scenario the new scenario
	 */
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	/**
	 * Gets the group.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Sets the group.
	 *
	 * @param group the new group
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Checks if is section.
	 *
	 * @return true, if is section
	 */
	public boolean isSection() {
		return section;
	}

	/**
	 * Sets the section.
	 *
	 * @param section the new section
	 */
	public void setSection(boolean section) {
		this.section = section;
	}

	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the index.
	 *
	 * @param index the new index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

}
