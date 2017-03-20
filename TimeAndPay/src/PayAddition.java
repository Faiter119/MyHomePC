import backend.TimeInterval;

import java.time.DayOfWeek;
import java.util.*;

/**
 * Created by OlavH on 04-Jan-17.
 */
public class PayAddition {

    private List<DayOfWeek> daysList;
    private int extraPay;

    private TimeInterval timeInterval;

    public PayAddition(int extraPay) {
        this.extraPay = extraPay;

    }
    public int getExtraPay() {
        return extraPay;
    }
    public void addDays(DayOfWeek ... days){
        Objects.requireNonNull(days);

        if (daysList == null) daysList = new ArrayList<>();

        Collections.addAll(daysList, days);
    }
    public Optional<List<DayOfWeek>> getDaysList() {
        return Optional.ofNullable(daysList);
    }

    public void addTimeInterval(TimeInterval interval){
        Objects.requireNonNull(interval);
        timeInterval = interval;
    }

    public Optional<TimeInterval> getTimeInterval() {
        return Optional.ofNullable(timeInterval);
    }
}
