package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

public class GardenModel {

    private boolean flipped;
    private boolean automated;
    @Required
    private LinkedList<LootType> plots;

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    public boolean isAutomated() {
        return automated;
    }

    public void setAutomated(boolean automated) {
        this.automated = automated;
    }

    public LinkedList<LootType> getPlots() {
        return plots;
    }

    public void setPlots(LinkedList<LootType> plots) {
        this.plots = plots;
    }

}
