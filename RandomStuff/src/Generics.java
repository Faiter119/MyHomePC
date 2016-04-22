import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Generics {

    public static <T extends Number> int sum(T...a){
        int sum = 0;

        for(Number b : a){
            sum += b.intValue();
        }

        return sum;
    }

    /**
     * @return A new String that is the original String reversed
     */
    public static String reverse(String input){

        String[] table = input.split("");
        String out = "";

        for(int i=table.length-1; i>=0; i--){
            out += table[i];
        }

        return out;
    }

    public static void arrayReverse(int[] a){

        int[] b = new int[a.length];
        for(int i = 0; i<a.length; i++){
            b[i] = a[i];
        }

        int index = 0;
        for(int i = a.length-1; i>=0; i++){

            System.out.println(index + " "+i + " - "+b[i]+"\n"+Arrays.toString(a)+" - "+ Arrays.toString(b));

            a[index] = b[i];
            index++;
        }
    }

    public static void main(String[]args){


        String test = "olav";

        System.out.println(test.length()+"\n"+test.indexOf('l'));





    }
}
