import com.sun.deploy.util.ArrayUtil;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public static void main(String[] args) throws IOException {

        /*for (int i=0; i<10; i++) {
            System.out.println(getRandomInRange(0, 10));
        }*/

        //System.out.println(Arrays.toString(getRandomArray(10,-10,10)));

        int[] array = getRandomArray(39, Integer.MIN_VALUE, Integer.MAX_VALUE-1);
        System.out.println(Arrays.toString(array));

    /*    Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        reverse(array);
        System.out.println(Arrays.toString(array));*/

        Path path = Paths.get("RandomStuff/numbers.txt");

        if (!Files.exists(path)) Files.createFile(path);

        else{
            Files.delete(path);
            Files.createFile(path);
        }

        List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toList());

        for (Integer integer : list){
            Files.write(path, (integer.toString()+"\n").getBytes(), StandardOpenOption.APPEND);
        }
    }
}
