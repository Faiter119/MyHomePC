import java.time.Duration;
import java.time.LocalTime;

public class Primes {

    public static boolean isPrime(int nr){

        if(nr == 1 || nr == 0 || nr == 2) return false;

        for(int i=2; i<nr/2; i++){

            if(nr % i == 0) return false;

        }
        return true;
    }

    public static void main(String[]args){

        long start = System.currentTimeMillis();

        for(int i=0 ; i<100 ; i++){

            if(isPrime(i)){
                System.out.println(i);
            }

        }

        long end = System.currentTimeMillis();

        System.out.println("The calculation took "+(end-start));
    }
}
