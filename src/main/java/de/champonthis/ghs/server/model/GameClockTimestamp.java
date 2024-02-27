package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;

public class GameClockTimestamp {

    @Required
    private Long clockIn;
    private Long clockOut;

    /**
     * Gets the clock in.
     *
     * @return the clock in
     */
    public Long getClockIn() {
        return clockIn;
    }

    /**
     * Sets the clock in.
     *
     * @param clockIn the new clock in
     */
    public void setClockIn(Long clockIn) {
        this.clockIn = clockIn;
    }

    /**
     * Gets the clock out.
     *
     * @return the clock out
     */
    public Long getClockOut() {
        return clockOut;
    }

    /**
     * Sets the clock out.
     *
     * @param clockOut the new clock out
     */
    public void setClockOut(Long clockOut) {
        this.clockOut = clockOut;
    }
}
