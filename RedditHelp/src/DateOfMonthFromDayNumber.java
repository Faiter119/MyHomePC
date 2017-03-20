import java.time.LocalDate;

/**
 * Created by OlavH on 01-Mar-17.
 */
public class DateOfMonthFromDayNumber {

    public static void main(String[] args) {

        LocalDate janfirst = LocalDate.of(2017, 1, 1);

        LocalDate date = janfirst.plusDays(100);

        System.out.println(date);


    }
}
