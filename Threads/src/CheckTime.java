import java.time.LocalDate;
import java.time.LocalDateTime;

public class CheckTime implements Runnable{

    public void run(){

        LocalDateTime now;

        for(int i=0; i<10; i++){

            now = LocalDateTime.now();

            System.out.println(now.toLocalDate().toString() + " - "+now.toLocalTime().getHour()+":"+now.toLocalTime().getMinute()+":"+now.toLocalTime().getSecond()); // Performance not confirmed

            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
