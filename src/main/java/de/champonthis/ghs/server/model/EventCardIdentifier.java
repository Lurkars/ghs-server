package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import lombok.Data;

@Data
public class EventCardIdentifier {

    private String cardId;
    private String edition;
    private String type;
    private int selected;
    private LinkedList<Integer> subSelections;
    private boolean scenarioApply;
}
