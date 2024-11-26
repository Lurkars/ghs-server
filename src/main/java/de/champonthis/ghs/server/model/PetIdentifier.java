package de.champonthis.ghs.server.model;

public class PetIdentifier extends Identifier {

    private String petname;
    private boolean active;
    private boolean lost;

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

}
