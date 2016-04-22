import javafx.scene.control.TextInputDialog;

import java.util.Random;

/**
 * Created by Olav Husby on 02.04.2016.
 */
public final class Coin { // Final == can't be subclassed

    public static final int HEADS = 1; // The side with the picture of a person
    public static final int TAILS = 2; // The side with the value

    private static Random r = new Random();

    private Coin(){throw new AssertionError("Can not make instances of Coin");}

    public static int flip(){

        return r.nextInt(2)+1;
    }
    public static double percentage(double total, double sub){

        return ((0.01*total) * sub);

    }

    public static void main(String[]args){

        int heads = 0;
        int tails = 0;

        //Coin coin = new Coin(); // Can't create object of this type

        for(int i=0 ; i<3456456; i++) {

            int flip = Coin.flip();

            if(flip == Coin.HEADS){
                heads++;
            }
            else{
                tails++;
            }
        }

        System.out.println("Heads: "+heads+" - Tails: "+tails);

        System.out.printf("Percentage Heads: %.2f",Coin.percentage(heads+tails,heads));
        System.out.println();
        System.out.printf("Percentage Tails: %.2f",Coin.percentage(heads+tails,tails));
        System.out.println();

        double total = Coin.percentage(heads+tails,heads)+Coin.percentage(heads+tails,tails);
        System.out.println("Total Percentage: "+total);





    }

}
