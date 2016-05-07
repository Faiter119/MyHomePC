import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BlackjackFX extends Application{ // Now with 100% more JavaFX

    public void start(Stage stage) throws Exception {

        stage.setScene(mainScene());

        stage.setTitle("Blackjack");
        stage.setResizable(false);
        stage.show();
    }
    private Blackjack blackjack;

    public Scene mainScene(){

        blackjack = new Blackjack();

        // Elements of the UI
        TextArea playerHand = new TextArea(); playerHand.setEditable(false);
        Text resultText = new Text("Result here");
        TextArea dealerHand = new TextArea(); dealerHand.setEditable(false);

        Button startButton = new Button("Start"); startButton.setPrefSize(100,30);
        Button hitButton = new Button("Hit"); hitButton.setPrefSize(100,30); hitButton.setDisable(true);
        Button standButton = new Button("Stand"); standButton.setPrefSize(100,30); standButton.setDisable(true);
        Button doubleButton = new Button("Double"); doubleButton.setPrefSize(100,30); doubleButton.setDisable(true);
        Button splitButton = new Button("Split"); splitButton.setPrefSize(100,30); splitButton.setDisable(true);
        // End Elements of the UI

        // Button Actions
        startButton.setOnAction(e->{

            if(startButton.getText().equals("Reset")) {
                blackjack = new Blackjack();
                startButton.setText("Start");dealerHand.setText(""); playerHand.setText("");resultText.setText("Result here");
                disableButtons(hitButton, standButton, doubleButton, splitButton);

            }
            else {
                blackjack.startingHand();
                playerHand.setText(blackjack.getCardsAsString(Blackjack.Player.PLAYER));
                dealerHand.setText("[Hidden]\n" + blackjack.getCards(Blackjack.Player.DEALER).get(1));

                startButton.setText("Reset");
                enableButtons(hitButton, standButton, doubleButton);

                if(blackjack.getCards(Blackjack.Player.PLAYER).get(0)
                        .compareTo(blackjack.getCards(Blackjack.Player.PLAYER).get(1)) == 0){ // Both starting-cards are the same, aka can be split
                    splitButton.setDisable(false);
                }
            }

        });

        hitButton.setOnAction(event -> {

            blackjack.draw(Blackjack.Player.PLAYER);
            playerHand.setText(blackjack.getCardsAsString(Blackjack.Player.PLAYER));

            if(blackjack.getScore(Blackjack.Player.PLAYER) > 21){
                //playerHand.setText("You Lost");
                resultText.setText("You broke with "+blackjack.getScore(Blackjack.Player.PLAYER)+" points.");
                dealerHand.setText(blackjack.getCardsAsString(Blackjack.Player.DEALER));
                disableButtons(hitButton, standButton, doubleButton, splitButton);

            }
        });

        standButton.setOnAction(event -> {

            disableButtons(hitButton, standButton, doubleButton, splitButton);

            blackjack.drawTo(17, Blackjack.Player.DEALER);

            dealerHand.setText(blackjack.getCardsAsString(Blackjack.Player.DEALER));

            Blackjack.Result winner = blackjack.getWinner();

            resultText.setText(winner+" with the player having "+blackjack.getScore(Blackjack.Player.PLAYER)+ " points and the dealer having "+blackjack.getScore(Blackjack.Player.DEALER)+" points.");
            System.out.println(winner);

        });

        doubleButton.setOnAction(event -> {

            disableButtons(hitButton, standButton, doubleButton, splitButton);

            dealerHand.setText(blackjack.getCardsAsString(Blackjack.Player.DEALER));

            blackjack.draw(Blackjack.Player.PLAYER); // You go 100% extra bet on one more card

            blackjack.drawTo(17, Blackjack.Player.DEALER);

            dealerHand.setText(blackjack.getCardsAsString(Blackjack.Player.DEALER));
            playerHand.setText(blackjack.getCardsAsString(Blackjack.Player.PLAYER));

            Blackjack.Result winner = blackjack.getWinner();
            resultText.setText("Double! - "+winner+" with the player having "+blackjack.getScore(Blackjack.Player.PLAYER)+ " points and the dealer having "+blackjack.getScore(Blackjack.Player.DEALER)+" points.");

            System.out.println(winner);

        });
        splitButton.setOnAction(event -> {

            disableButtons(hitButton, standButton, doubleButton, splitButton);
            dealerHand.setText(blackjack.getCardsAsString(Blackjack.Player.DEALER));

        });
        // End Button Actions

        // Asembling the layout
        GridPane pane = new GridPane();
        pane.setHgap(20); pane.setVgap(20); pane.setPadding(new Insets(20));

        HBox horizontalButtons = new HBox(); horizontalButtons.setAlignment(Pos.CENTER);
        horizontalButtons.getChildren().addAll(startButton,hitButton,standButton,doubleButton,splitButton);

        pane.add(playerHand,0,0,4,1);
        pane.add(resultText,0,1,4,1);
        pane.add(horizontalButtons,0,2,4,1);
        pane.add(dealerHand,0,3,4,1);

        //pane.setGridLinesVisible(true);
        // End Asembling the layout
        return new Scene(pane);
    }

    private void disableButtons(Button ... buttons){
        for(Button button : buttons){
            button.setDisable(true);
        }
    }
    private void enableButtons(Button ... buttons){
        for(Button button : buttons){
            button.setDisable(false);
        }
    }

    public static void main(String[]args){

        BlackjackFX.launch();


    }
}
