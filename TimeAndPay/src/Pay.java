import backend.Event;
import backend.TimeInterval;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by OlavH on 04-Jan-17.
 */
public class Pay {

    private int basePay;
    private List<PayAddition> payAdditionList = new ArrayList<>();

    public Pay(int basePay) {
        this.basePay = basePay;
    }

    public double minutePay(){
        return (double) basePay / 60d;
    }

    public void addPayAdditon(int extra, TimeInterval interval, DayOfWeek ... days){

        PayAddition payAddition = new PayAddition(extra);
        payAddition.addTimeInterval(interval);
        payAddition.addDays(days);

        payAdditionList.add(payAddition);

    }

    public int payForEvent(Event event){

        int total = 0;

        LocalTime start = event.getStart();
        LocalTime end = event.getEnd();

        TimeInterval eventInterval = TimeInterval.of(event);

        int totalMinutes = (int) eventInterval.getMinutes();

        List<PayAddition> payAdditions = payAdditionList;

        for (PayAddition addition : payAdditions) {

            Optional<TimeInterval> timeInterval = addition.getTimeInterval();

            if (timeInterval.isPresent()){

                Optional<TimeInterval> overlap = timeInterval.get().overlapWith(eventInterval);

                if (overlap.isPresent()){

                    TimeInterval interval = overlap.get();

                    total += overlap.get().getMinutes() * minutePay() + addition.getExtraPay();
                    totalMinutes -= overlap.get().getMinutes();

                }

            }


        }
        total += totalMinutes * minutePay();

        return total;
    }

    public static void main(String[] args) {

        Event earlyDay = new Event(LocalDate.now());
        earlyDay.setStart(LocalTime.of(6,0)); earlyDay.setEnd(LocalTime.of(14,0));

        Pay pay = new Pay(16245); // øre

        pay.addPayAdditon(4500, new TimeInterval(LocalTime.of(6,0),LocalTime.of(7,0)), DayOfWeek.values());


        int i = pay.payForEvent(earlyDay);

        System.out.println(i / 100 + "kr");


    }
}
