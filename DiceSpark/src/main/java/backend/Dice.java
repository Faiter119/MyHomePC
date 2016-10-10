package backend;

import java.util.Random;

public class Dice {

    private int sides;
    private int side;

    private Dice(int sides){
        this.sides = sides;
        this.side = randomSide();
    }
    public int getSides(){ return sides; }
    public int getSide(){ return side; }

    /**
     * Random nr between 1 and the nr of sides.
     * 6 sides: 1-6
     */
    private int randomSide(){
        Random random = new Random();
        return 1 + (random.nextInt(sides));
    }

    public static Dice roll(){
        return new Dice(6);
    }
    public static Dice roll(int sides){
        return new Dice(sides);
    }

    public void reroll(){ side = randomSide(); } // Does NOT seem to be faster than creating a new obj every time via roll... Compiler optimization maybe

    public String toString() {
        return "Sides: "+sides+" - Side: "+side;
    }

    public static void main(String[] args){

        long s = System.currentTimeMillis();

        //Dice dice = Dice.roll(); // Did not make it faster...

        for (int i=0; i<10000; i++) {
            System.out.println(Dice.roll(8).getSide());
            //dice.reRoll();
        }

        System.out.println("Time: "+(System.currentTimeMillis() - s));

    }


}
