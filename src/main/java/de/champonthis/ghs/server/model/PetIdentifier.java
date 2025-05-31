package de.champonthis.ghs.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PetIdentifier extends Identifier {

    private String petname;
    private boolean active;
    private boolean lost;

}
