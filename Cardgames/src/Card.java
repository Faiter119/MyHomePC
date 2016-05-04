import java.util.Iterator;

public class Card implements Comparable<Card>{

    public enum Suit{

        SPADES,
        HEARTS,
        CLUBS,
        DIAMONDS,
        ERROR;

        public String toString() {
            return super.toString().substring(0,1)+super.toString().substring(1,super.toString().length()).toLowerCase(); // Verbosity, bitch
        }
    }

    private int value;
    private Suit suit;

    public Card(Suit suit, int value){

        this.suit = suit;
        this.value = value;
    }
    public Suit getSuit(){return suit;}
    public int getValue(){return value;}

    public int compareTo(Card otherCard){
        int value1 = this.value;
        int value2 = otherCard.getValue();

        return (value1 == value2) ? 0 : (value1 > value2) ? 1 : -1;
    }
    public  String compareToAsString( Card card2){

        int result = this.compareTo(card2);

        if(result == 0) return this+" and "+card2+" are equal in value.";

        return result == 1 ? this+" is larger than "+card2 : card2+" is larger than "+this;
    }
    public String toString(){

        String out = Integer.toString(value);

        if(value > 10 || value == 1){
            switch (value){
                case 11: out = "Jack";
                    break;
                case 12: out = "Queen";
                    break;
                case 13: out = "King";
                    break;
                case 1: out ="Ace";
                    break;
            }
        }

        return "["+out+" of "+suit+"]";
    }

    public static void main(String[]args){

        Card aceOfSpades = new Card(Suit.SPADES, 13);
        Card tenOfHearts = new Card(Suit.HEARTS, 10);


        System.out.println(aceOfSpades+" - "+tenOfHearts);
        System.out.println(aceOfSpades.compareToAsString(tenOfHearts));

    }
}
