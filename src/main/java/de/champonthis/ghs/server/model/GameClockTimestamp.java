package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;

public class GameClockTimestamp {

    @Required
    private Long clockIn;
    private Long clockOut;

    public Long getClockIn() {
        return clockIn;
    }

    public void setClockIn(Long clockIn) {
        this.clockIn = clockIn;
    }

    public Long getClockOut() {
        return clockOut;
    }

    public void setClockOut(Long clockOut) {
        this.clockOut = clockOut;
    }
}
