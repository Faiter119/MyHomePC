/**
 * Created by Olav Husby on 12.04.2016.
 */
public class Bits {

    public static void main(String[]args){

        byte bits = 0x11;

        byte fifteen = 15; // 0000 1111
        byte eight = 8;    // 0000 1000
        //                    0000 1000 // And
        //                    0000 1111 // Or

        System.out.println(fifteen | eight);

        System.out.println(fifteen);


        String test = "HelloHello";

    }
}
