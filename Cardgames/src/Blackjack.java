import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blackjack {

    public enum Player {DEALER, PLAYER, TIE}

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
    public Card draw(Player player){
        Card card = deck.draw();
        players.get(player).add(card);
        return card;
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
    public int getScore(Player player){

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
    public Player getWinner(){

        if(getScore(Player.PLAYER) > 21){
            return Player.DEALER;
        }
        if(getScore(Player.DEALER) > 21){
            return Player.PLAYER;
        }

        int playerScore = getScore(Player.PLAYER);
        int dealerScore = getScore(Player.DEALER);


        return (playerScore == dealerScore) ? Player.TIE : (playerScore > dealerScore) ? Player.PLAYER : Player.DEALER;

    }

    public static void main(String[]args){

        Blackjack blackjack = new Blackjack();

        blackjack.startingHand();


        System.out.println(blackjack.getCards(Player.DEALER)+"\n"+blackjack.getScore(Player.DEALER));
        System.out.println(blackjack.getCards(Player.PLAYER)+"\n"+blackjack.getScore(Player.PLAYER));


    }
}
