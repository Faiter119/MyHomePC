/**
 * Created by Olav Husby on 28.03.2016.
 */
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Testing {

    public static boolean hasOne(int n) {

        String number = Integer.toString(n);
        String[] numbers = number.split("");

        for(String a : numbers){
            if(Integer.parseInt(a) == 1) return true;
        }
        return false;
    }

    public static void main(String[]args){

/**********************************************************************************************************************/
       /* *//*DoubleSummaryStatistics stats = new DoubleSummaryStatistics();

        for(int i=0; i<100; i++) {
            stats.accept(i);
        }

        System.out.println("Avg: "+stats.getAverage());
        System.out.println("Count: "+stats.getCount());
        System.out.println("Max: "+stats.getMax());
        System.out.println("Min: "+stats.getMin());
        System.out.println("Sum: "+stats.getSum());*//*
*//**********************************************************************************************************************//*
        // Base 64
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        String out = "mådahaost";

        byte[] encoded = encoder.encode(out.getBytes());

        System.out.println(new String(decoder.decode(encoded)));
        // Base 64
*//**********************************************************************************************************************//*
        // Scanner

        Scanner keyboard = new Scanner(System.in); // Scanns any inputstream (keyboard, file, String etc)
        System.out.println("Input Something: ");
        System.out.println("Something: "+keyboard.next());

        Scanner string = new Scanner("Yo jiggas better have rad shredds yo"); // Default delimiter = " "
        while (string.hasNext()){
            System.out.println(string.next());
        }

        // Scanner*/
/**********************************************************************************************************************/
        // BigDecimal

        BigDecimal decimal = new BigDecimal(9999.1);
        decimal.add(new BigDecimal(0.9));

        System.out.println(decimal.doubleValue());
        // BigDecimal

        // BigInteger

        BigInteger integer = new BigInteger("19");
        System.out.println(integer.toString());

        // BigInteger
    }
}
