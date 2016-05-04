import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> cards; // Using interface because 'Effective Java'
    private int initialNumberOfCards;

    public Deck(){

        this.cards = new ArrayList<>();

        for(int i=0; i<4; i++){

            for(int j=1; j<=13; j++){

                cards.add(new Card(Card.Suit.values()[i],j));
                this.initialNumberOfCards++;
            }
        }
    }
    public int getInitialNumberOfCards(){return initialNumberOfCards;}
    public int size(){return cards.size();}
    public List<Card> getCards(){return cards;}

    public Card draw(){

        if(cards.size() != 0) {

            Random random = new Random();
            int cardNumber = random.nextInt(cards.size());

            // System.out.println(suit + " - "+value);

            Card drawn = cards.get(cardNumber);

            cards.remove(drawn);

            return drawn;
        }

        return new Card(Card.Suit.ERROR,-1);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder("---Deck---\n"); // Efficiency confirmed

        for(int i=0; i<cards.size(); i++){

            builder.append(cards.get(i));
            builder.append("\n");

        }
        builder.append("---Deck---");
        return builder.toString();
    }

    public static void main(String[]args){

        Deck deck = new Deck();

      /*  System.out.println(deck+"\n"+deck.size());

        for(int i = 0; i < deck.getInitialNumberOfCards(); i++){
            System.out.println("Drew : "+deck.draw());
        }

        System.out.println(deck.size());
        System.out.println(deck);*/
        Card card = deck.draw();
        System.out.println(card+" - "+card.getValue());

    }
}
