import java.util.Arrays;
import java.util.Scanner;

public class PrintCharArray {

    public static char[] toCharArray(String s){

        char[] chars = new char[s.length()];

        for(int i = 0; i < s.length(); i++) {

            chars[i] = s.charAt(i);
        }
        return chars;
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Input Characters: ");

        String in = scan.next();

        char[] c = toCharArray(in);

        System.out.println("Printing Array: "+c);

        System.out.println("Printing Array: "+Arrays.toString(c));
    }
}
