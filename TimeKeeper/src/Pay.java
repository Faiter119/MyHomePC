import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.util.Currency.getAvailableCurrencies;

public class Pay {

    private BigDecimal base;
    private Currency currency;
    private List<Map<List<LocalTime>, BigDecimal>> periodPayList; // idk what to do

    public Pay(BigDecimal base, Currency currency){
        this.base = base;
        this.currency = currency;
    }
    public Pay(BigDecimal base){ this(base,Currency.getInstance("NOK")); }
    public Pay(){ this(new BigDecimal(111.9)); }

    public BigDecimal getBase(){ return base;}
    public void setBase(BigDecimal base) { this.base = base;}
    public void setCurrency(Currency currency) { this.currency = currency;}
    public Currency getCurrency(){return currency;}

    private BigDecimal payPerMinute(){
        return base.divide(new BigDecimal(60), BigDecimal.ROUND_DOWN);
    }

    public BigDecimal payFor(LocalTime start, LocalTime end){

        long minutes = ChronoUnit.MINUTES.between(start, end);

        return payPerMinute().multiply(new BigDecimal(minutes));

    }
    public void addPeriodPay(LocalTime start, LocalTime end, BigDecimal percentagePlus){
        List<LocalTime> dates = Arrays.asList(start,end);
    }



    public static void main(String[] args) {

        Pay pay = new Pay(new BigDecimal(162.45));

        System.out.println(pay.payFor(LocalTime.of(6,0), LocalTime.of(14,0)).doubleValue());

        LocalTime start = LocalTime.of(6,0);
        LocalTime end = LocalTime.of(14,30);

        System.out.println(ChronoUnit.MINUTES.between(start, end));

        pay.addPeriodPay(LocalTime.of(18,0), LocalTime.of(24,0),new BigDecimal(150));


    }

}
