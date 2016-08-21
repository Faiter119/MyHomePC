import java.math.BigDecimal;
import java.sql.Time;
import java.text.NumberFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.util.Currency.getAvailableCurrencies;

public class Pay {

    private BigDecimal base;
    private Currency currency;

    private Map<TimeInterval, BigDecimal> additionalPayMap;

    public Pay(BigDecimal base, Currency currency){
        this.base = base;
        this.currency = currency;
    }
    public Pay(BigDecimal base){ this(base, Currency.getInstance("NOK")); }
    public Pay(){ this(new BigDecimal(111.9)); }

    public BigDecimal getBase(){ return base;}
    public void setBase(BigDecimal base) { this.base = base;}
    public void setCurrency(Currency currency) { this.currency = currency;}
    public Currency getCurrency(){return currency;}

    private BigDecimal payPerMinute(){
        return base.divide(new BigDecimal(60), BigDecimal.ROUND_DOWN);
    }

    public BigDecimal payFor(Event event){

        TimeInterval[] intervals = additionalPayMap.keySet().toArray(new TimeInterval[0]);

        BigDecimal wage = new BigDecimal(0d);
        TimeInterval eventInterval = TimeInterval.of(event);
        long intervalMinutes = 0;

        for (TimeInterval interval : intervals){

            if (interval.overlaps(eventInterval)){

                TimeInterval overlap = interval.overlapWith(eventInterval).get(); // Checked above

                wage = wage.add(base.multiply(additionalPayMap.get(interval)));
                intervalMinutes += overlap.getMinutes();
            }

        }
        long remaining = eventInterval.getMinutes() - intervalMinutes;

        wage = wage.add(base.multiply(new BigDecimal(remaining)));

        return wage;

    }
    public BigDecimal payFor(Event[] events){

        BigDecimal wage = new BigDecimal(0);

        for (Event event : events){
            wage = wage.add(payFor(event));
        }
        return wage;
    }
    public void addPeriodPay(LocalTime start, LocalTime end, BigDecimal percentagePlus, DayOfWeek ... days){

        BigDecimal addition = base.add(base.multiply(percentagePlus));
        TimeInterval interval = new TimeInterval(start, end);

        List<LocalTime> dates = Arrays.asList(start,end);
    }



    public static void main(String[] args) {

        Pay pay = new Pay(new BigDecimal(162.45));

        System.out.println(pay.payFor(new Event(LocalDate.now())).doubleValue());

        LocalTime start = LocalTime.of(6,0);
        LocalTime end = LocalTime.of(14,30);

        System.out.println(ChronoUnit.MINUTES.between(start, end));

        pay.addPeriodPay(LocalTime.of(18,0), LocalTime.of(0,0), new BigDecimal(150));


    }

}
