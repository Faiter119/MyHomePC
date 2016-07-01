
public class Testing {

    public static void main(String[] args) {

        System.out.println(addThread(1,4));


    }
    public static int addThread(int a, int b){



        Thread thread = new Thread(()->{

                System.out.println(a);
                try {
                Thread.sleep(1000);

            } catch (Exception e){}

            System.out.println(b);
        });

        thread.start(); // What should I be using threads for???

        return a+b;
    }

}
