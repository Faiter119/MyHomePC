import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<List<Card>> cards; // Using interface because 'Effective Java'

    public Deck(){

        cards = new ArrayList<>();

        for(int i=0; i<4; i++){

            cards.add(new ArrayList<>());

            for(int j=1; j<=13; j++){

                cards.get(i).add(new Card(Card.Suit.values()[i],j));

            }
        }
    }

    public Card draw(){
        Random random = new Random();
        int suit = random.nextInt(cards.size());
        int value = random.nextInt(cards.get(suit).size());

        System.out.println(suit + " - "+value);

        cards.get(suit).remove(value);

        return cards.get(suit).get(value);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder("---Deck---\n"); // Efficiency confirmed

        for(int i=0; i<cards.size(); i++){

            for(int j=1; j<=cards.get(i).size(); j++){

                builder.append(cards.get(i).get(j-1));
                builder.append("\n");

            }
        }
        builder.append("---Deck---");
        return builder.toString();
    }

    public static void main(String[]args){

        Deck deck = new Deck();

        System.out.println(deck);


        System.out.println(deck.draw());

        System.out.println(deck);

    }

}
