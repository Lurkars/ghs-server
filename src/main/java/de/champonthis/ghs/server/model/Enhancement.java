package de.champonthis.ghs.server.model;

public class Enhancement {

    private int cardId;
    private String actionIndex;
    private int index;
    private String action;
    private boolean inherited;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getActionIndex() {
        return actionIndex;
    }

    public void setActionIndex(String actionIndex) {
        this.actionIndex = actionIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isInherited() {
        return inherited;
    }

    public void setInherited(boolean inherited) {
        this.inherited = inherited;
    }

}
