/**
 * Created by OlavH on 03-Mar-17.
 */
public class NumberChecker {

    public static boolean allDigitsAreDifferent(int nr){

        String string = String.valueOf(nr);


        for (int i = 0; i < string.length(); i++) {

            char c = string.charAt(i);

            if(string.substring(i+1).contains((String.valueOf(c)))) return false;
        }

        return true;
    }

    public static boolean sumIsEqualTo(int nr, int sum){

        String string = String.valueOf(nr);

        int total = 0;

        for (int i = 0; i < string.length(); i++) {

            char c = string.charAt(i);

            total += Integer.parseInt(String.valueOf(c));

        }
        return total == sum;
    }

    public static boolean isOdd(int nr){

        return (nr & 1) == 1;

    }
    public static boolean digitAtPositionIsXTimesDigitAtOtherPosition(int nr, int indexToCheck, int startIndex, int factor){

        int length = String.valueOf(nr).length();

        System.out.println((int)(nr/Math.pow(10, indexToCheck)) );

        return true;

    }

    public static void main(String[] args) {


        int nr = 1234;

        System.out.println(allDigitsAreDifferent(nr));
        System.out.println(sumIsEqualTo(nr, 27));
        System.out.println(isOdd(nr));
        System.out.println(digitAtPositionIsXTimesDigitAtOtherPosition(nr, 3, 1, 3));

    }

}
