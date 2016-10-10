import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Olav Husby on 01.09.2016.
 */
public class Time {


    public static void main(String[] args) {

        LocalDate now = LocalDate.now();

        System.out.println(now);

        LocalDate firstDec = LocalDate.of(2016, 12, 1);

        System.out.println(ChronoUnit.DAYS.between(now, firstDec));

    }
}
