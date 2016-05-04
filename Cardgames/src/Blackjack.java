import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blackjack {

    public enum Player {DEALER, PLAYER}

    private Map<Player, List<Card>> players;

    private Deck deck;

    public Blackjack(){

        this.deck = new Deck();
        this.players = new HashMap<>();

        for(int i=0; i < 2; i++){

            List<Card> player = new ArrayList<>();

            this.players.put(Player.values()[i],player);

        }

    }
    public void draw(Player player){
        Card card = deck.draw();
        players.get(player).add(card);
    }
    public void startingHand(){

        for(List<Card> player : players.values()){

            for (int i=0; i<2; i++){ // 2 cards in starting hand
                player.add(deck.draw());
            }
        }
    }
    public List<Card> getCards(Player player){

        if(players.containsKey(player)) {
            return players.get(player);
        }

        return new ArrayList<>(); // Empty List
    }
    public int checkScore(Player player){

        int score = 0;

        if(players.containsKey(player)){
            List<Card> cards = players.get(player);

            for (Card card : cards){
                int value = card.getValue();

                if(value > 10) value = 10;
                if(value == 1) value = 11;

                score += value;
            }
        }

        return score;
    }
    public String getCardsAsString(Player player){

        StringBuilder builder = new StringBuilder();

        for(Card card : players.get(player)){
            builder.append(card);
            builder.append("\n");
        }

        return builder.toString();
    }

    public static void main(String[]args){

        Blackjack blackjack = new Blackjack();

        blackjack.startingHand();


        System.out.println(blackjack.getCards(Player.DEALER)+"\n"+blackjack.checkScore(Player.DEALER));
        System.out.println(blackjack.getCards(Player.PLAYER)+"\n"+blackjack.checkScore(Player.PLAYER));


    }
}
