package backend;

import java.util.Random;

public class Coin {

    public enum Side{
        HEADS, TAILS;

        public String toString(){
            String orig = super.toString();
            return orig.charAt(0)+orig.substring(1).toLowerCase();
        }
    }

    private Side side;

    private Coin(){
        this.side = randomSide();
    }

    public Side getSide(){return side;}

    private Side randomSide(){

        Random r = new Random();

        int sides = Side.values().length;

        return Side.values()[r.nextInt(sides)];

    }

    public static Coin flip(){
        return new Coin();
    }
    public void reflip(){ side = randomSide();} // More memory-efficient

    public String toString() {
        return side.toString();
    }

    public static void main(String[] args) {

        // System.out.println(Coin.flip());

        int heads = 0, tails = 0;

        for(int i=0; i<100; i++){

            Coin coin = Coin.flip();

            if (coin.side == Side.HEADS) heads++;
            else tails++;

        }
        System.out.println("Heads: "+heads+"\nTails: "+tails);

    }

}
