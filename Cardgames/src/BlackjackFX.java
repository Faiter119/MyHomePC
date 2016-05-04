import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BlackjackFX extends Application{ // Now with 100% more JavaFX

    public void start(Stage stage) throws Exception {

        Deck deck = new Deck();
        stage.setScene(mainScene());


        stage.setTitle("Blackjack");
        stage.setResizable(false);
        stage.show();
    }
    private Blackjack blackjack;

    public Scene mainScene(){

        GridPane pane = new GridPane();
        pane.setHgap(20);pane.setVgap(20);pane.setPadding(new Insets(20));

        // pane.setGridLinesVisible(true);
        blackjack = new Blackjack();
        //

        TextArea playerHand = new TextArea(); playerHand.setEditable(false);
        TextArea dealerHand = new TextArea(); dealerHand.setEditable(false);

        Button startButton = new Button("Start"); startButton.setPrefSize(100,30);
        Button hitButton = new Button("Hit"); hitButton.setPrefSize(100,30); hitButton.setDisable(true);
        Button standButton = new Button("Stand"); standButton.setPrefSize(100,30); standButton.setDisable(true);
        Button doubleButton = new Button("Double"); doubleButton.setPrefSize(100,30); doubleButton.setDisable(true);
        Button splitButton = new Button("Split"); splitButton.setPrefSize(100,30); splitButton.setDisable(true);

        //
        startButton.setOnAction(e->{

            if(startButton.getText().equals("Restart")) {
                blackjack = new Blackjack();
                startButton.setText("Start");dealerHand.setText(""); playerHand.setText("");
                hitButton.setDisable(true); standButton.setDisable(true); doubleButton.setDisable(true); splitButton.setDisable(true);

            }
            else {
                blackjack.startingHand();
                playerHand.setText(blackjack.getCardsAsString(Blackjack.Player.PLAYER));
                dealerHand.setText(blackjack.getCardsAsString(Blackjack.Player.DEALER));

                startButton.setText("Restart");
                hitButton.setDisable(false);
                standButton.setDisable(false);
                doubleButton.setDisable(false);
            }

        });
        hitButton.setOnAction(event -> {
            blackjack.draw(Blackjack.Player.PLAYER);
            playerHand.setText(blackjack.getCardsAsString(Blackjack.Player.PLAYER));
        });

        //
        HBox hBox = new HBox(); hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(startButton,hitButton,standButton,doubleButton,splitButton);

        pane.add(playerHand,0,0,4,1);
        pane.add(hBox,0,1,4,1);
        pane.add(dealerHand,0,2,4,1);

        Scene scene = new Scene(pane);
        return scene;
    }

    public static void main(String[]args){

        BlackjackFX fx = new BlackjackFX();
        fx.launch();




    }


}
