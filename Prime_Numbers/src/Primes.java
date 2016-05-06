import java.time.Duration;
import java.time.LocalTime;

public class Primes {

    public static boolean isPrime(int nr){

        if(nr == 1) return false;

        for(int i=2; i<nr/2; i++){

            if(nr % i == 0) return false;

        }
        return true;
    }

    public static void main(String[]args){
        LocalTime start = LocalTime.now();

        for(int i=0 ; i<1000000 ; i++){
            isPrime(i);
            //if(isPrime(i));
           // System.out.println(i);

        }

        LocalTime end = LocalTime.now();
        System.out.println("The calculation took "+ Duration.between(start,end).getSeconds()+" seconds.");
    }
}
