import java.util.Scanner;

public class Digits {

    public static void correctOrder(int nr) {

        while (nr > 0){

            int length = lengthOf(nr);
            int divider = (int) Math.pow(10, length);

            System.out.println(nr / divider);
            nr %= divider;
        }
    }

    public static void correctOrderRecursion(int nr){
        if (nr <= 0) return;

        int length = lengthOf(nr);
        int divider = (int) Math.pow(10, length);

        System.out.println(nr / divider);
        nr %= divider;
        correctOrderRecursion(nr);

    }

    public static int lengthOf(int i) {

        int length = 0;

        while ((i /= 10) > 0) length++; // 0 indexed

        return length;
    }

    public static void main(String[] args) {
        int input = 7623;

        correctOrder(input);
        //correctOrderRecursion(input);
    }
}