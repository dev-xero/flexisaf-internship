package github.dev.xero.model;

public enum TimeControl {
    RAPID(10),
    BLITZ(5),
    BULLET(3);

    public final Integer minutes;

    TimeControl(Integer minutes) {
        this.minutes = minutes;
    }
}
