public class CheckSystem implements Runnable{

    public void run(){


        for(int i=0; i<5; i++) {
            System.out.println("Checking System");

            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {}

        }
    }
}
