package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class GardenModel {

    private boolean flipped;
    private boolean automated;
    @Required
    private LinkedList<LootType> plots;

}
