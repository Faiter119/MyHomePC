import java.awt.*;
import java.time.*;

public class ThreadTest{

    public static void main(String[]args){

        Runnable time = new CheckTime();
        Runnable system = new CheckSystem();

        new Thread(time).start();
        new Thread(system).start();


        try {
            Thread.sleep(2500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Im not in the thread!");

        try {
            Thread.sleep(2500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Im not in the thread!");
    }
}

