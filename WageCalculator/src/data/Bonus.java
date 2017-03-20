package data;

/**
 * Created by OlavH on 10-Feb-17.
 */
public class Bonus {

    private int bonusPay;
    private TimeInterval timeInterval;

    public Bonus(int bonusPay, TimeInterval timeInterval) {
        this.bonusPay = bonusPay;
        this.timeInterval = timeInterval;
    }

    public int getBonusPay() {
        return bonusPay;
    }

    public void setBonusPay(int bonusPay) {
        this.bonusPay = bonusPay;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getBonusForInterval(){





    }
}
