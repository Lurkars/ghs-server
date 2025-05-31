package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class GameClockTimestamp {

    @Required
    private Long clockIn;
    private Long clockOut;
}
