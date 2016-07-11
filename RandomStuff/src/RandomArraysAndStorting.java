import com.sun.deploy.util.ArrayUtil;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Arrays;
import java.util.Random;

public class RandomArraysAndStorting {

    private static Random r = new Random();

    /**
      * inclusive min, inclusive max [min, max]
      */
    public static int getRandomInRange(int min, int max){

        if(min >= max) throw new IllegalArgumentException("max <= min");

        int diff = max-min;

        int res = r.nextInt(diff+1) + min;

        // System.out.println("["+min +" -> "+max+"] - Diff: "+diff+" - Res: "+res);

        return res;
    }

    public static int[] getRandomArray(int size, int min, int max){

        if(min > max || size <= 0) throw new IllegalArgumentException("max <= min");

        int[] array = new int[size];

        for(int i=0; i<size; i++){
            array[i] = getRandomInRange(min, max);
        }
        return array;
    }

    /**
     * 110% random, probably goes out of memory :p
     */
    public static int[] getRandomArray(){
        int size = r.nextInt();
        int min = r.nextInt();
        int max = r.nextInt();

        while (max <= min) max = r.nextInt();

        System.out.println("size "+size+" min "+min+" max "+max);

        return getRandomArray(size, min, max);
    }

    public static void reverse(int[] array){

        int size = array.length;

        for(int i=0; i<size/2; i++){

            int opposite = size-i-1;

            int temp = array[i];

            array[i] = array[opposite];
            array[opposite] = temp;
        }
    }
    public static void main(String[] args) {

        /*for (int i=0; i<10; i++) {
            System.out.println(getRandomInRange(0, 10));
        }*/

        //System.out.println(Arrays.toString(getRandomArray(10,-10,10)));

        int[] array = getRandomArray(70,-9,9);
        System.out.println(Arrays.toString(array));

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        reverse(array);
        System.out.println(Arrays.toString(array));

        // System.out.println(Arrays.toString(getRandomArray())); // out of mem ':p

    }
}
