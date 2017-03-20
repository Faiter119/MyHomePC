package data;

import java.util.*;

/**
 * Created by OlavH on 18-Nov-16.
 */
public class Packer {

    private final int backwardsBytes = 1;

    public static final String fileExtention = ".comp";

    public void lempelZiv(byte[] byteArray){

        List<Byte> completeCompressed = new ArrayList<>();

        Deque<Byte> uncompressedBytesBuffer = new LinkedList<>();

        for (byte eachByte : byteArray) {

            int backwardsSize = (int) Math.pow(Byte.MIN_VALUE, backwardsBytes);

            if (completeCompressed.contains(eachByte) || uncompressedBytesBuffer.contains(eachByte)) { // TODO: 18-Nov-16

                List<Byte> longestSequence = new ArrayList<>(eachByte);


                int index = Collections.lastIndexOfSubList(Arrays.asList(byteArray), longestSequence);
                while (Collections.lastIndexOfSubList(Arrays.asList(byteArray), longestSequence) != -1){
                    longestSequence.add(byteArray[index++]);
                }
                longestSequence.remove(longestSequence.size()); // removed the index that ruined the loop

                // write to complete array

                int size = longestSequence.size();
                int indexOf = (index-1) - size;







            }
            else {

                uncompressedBytesBuffer.push(eachByte);


            }


        }



    }

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(0, 1,2,3,4,5,6,7);

        System.out.println(Collections.lastIndexOfSubList(integerList,Arrays.asList(4,5,7)));


    }

}
