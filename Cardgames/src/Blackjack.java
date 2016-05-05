import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blackjack {

    public enum Player {DEALER, PLAYER}

    /**
     * Represents the states of the game
     */
    public enum Result {

        WIN("The player won"), LOSS("The dealer won"), TIE("It's a tie");

        private String message;
        Result(String message){
            this.message = message;
        }
        public String toString(){return message;}
    }

    /**
     * Maps the player with their respective cards, via List<Card> and Player
     */
    private Map<Player, List<Card>> players;

    /**
     * The deck used by this instance
     */
    private Deck deck;

    /**
     * Object that plays the game Blackjack
     */
    public Blackjack(){

        this.deck = new Deck();
        this.players = new HashMap<>();

        for(int i=0; i < 2; i++){

            List<Card> player = new ArrayList<>();

            this.players.put(Player.values()[i],player);

        }

    }

    /**
     * Draws a card for a player
     * @param player The player in question
     * @return The card drawn
     */
    public Card draw(Player player){
        Card card = deck.draw();
        players.get(player).add(card);
        return card;
    }

    /**
     * Draws 2 cards for each player.
     */
    public void startingHand(){

        for(List<Card> player : players.values()){

            for (int i=0; i<2; i++){ // 2 cards in starting hand
                player.add(deck.draw());
            }
        }
    }

    /**
     * Gets a players cards
     * @param player
     * @return
     */
    public List<Card> getCards(Player player){

        if(players.containsKey(player)) {
            return players.get(player);
        }

        return new ArrayList<>(); // Empty List
    }

    /**
     * Gets the score of a player
     * @param player Player in question
     * @return score as int
     */
    public int getScore(Player player){

        int score = 0;

        if(players.containsKey(player)){
            List<Card> cards = players.get(player);

            for (Card card : cards){

                int value = card.getValue();

                if(card.getType() != Card.Type.NORMAL) card.setValue(10);
                if(card.getType() == Card.Type.ACE) card.setValue(11);

                score += card.getValue();
            }

            if(score > 21 && hasAce(player)){
                return aceConvert(player);
            }
        }


        return score;
    }
    private boolean hasAce(Player player){
        List<Card> cards = players.get(player);

        for(Card card : cards){
            if(card.getType() == Card.Type.ACE) return true;
        }
        return false;
    }
    private int aceConvert(Player player){

        int score = 0;

        List<Card> cards = players.get(player);

        for (Card card : cards){

            if(card.getType() == Card.Type.ACE) card.setValue(1);

            score += card.getValue();
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
    public Result getWinner(){

        if(getScore(Player.PLAYER) > 21){
            return Result.LOSS;
        }
        if(getScore(Player.DEALER) > 21){
            return Result.WIN;
        }

        int playerScore = getScore(Player.PLAYER);
        int dealerScore = getScore(Player.DEALER);


        return (playerScore == dealerScore) ? Result.TIE : (playerScore > dealerScore) ? Result.WIN : Result.LOSS;

    }

    public static void main(String[]args){

        Blackjack blackjack = new Blackjack();

        blackjack.startingHand();


        System.out.println(blackjack.getCards(Player.DEALER)+"\n"+blackjack.getScore(Player.DEALER));
        System.out.println(blackjack.getCards(Player.PLAYER)+"\n"+blackjack.getScore(Player.PLAYER));


    }
}
