package de.champonthis.ghs.server.model;

import lombok.Data;

@Data
public class Enhancement {

    private int cardId;
    private String actionIndex;
    private int index;
    private String action;
    private boolean inherited;

}
