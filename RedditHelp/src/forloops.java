import java.io.Console;
import java.util.Scanner;

public class forloops {

    public static void main(String[] args) {


        // System.out.println(test = new Scanner(System.in).nextLine()); // Weird but works

        Console c = System.console();

        char[] chars = c.readPassword("Pass");


        System.out.println(new String(chars));

        int[][] int2DArray = new int[10][10];

        for(int i = 0; i < int2DArray.length; i++){

            int[] thisArray = int2DArray[i];

            for(int j = 0; j < thisArray.length; j++){

                thisArray[j] = (int) (Math.random() * 100);

            }
        }

        for(int[] array : int2DArray) {

            for (int element : array) {

                System.out.printf("%3d ", element);
            }
            System.out.println();
        }



    }
}
