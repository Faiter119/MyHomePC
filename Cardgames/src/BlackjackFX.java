import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BlackjackFX extends Application{ // Now with 100% more JavaFX

    public void start(Stage stage) throws Exception {

        Deck deck = new Deck();


        stage.setTitle("Blackjack");
        stage.setScene(mainScene());
        stage.setResizable(false);
        stage.show();
    }

    public Scene mainScene(){

        GridPane pane = new GridPane();
        pane.setHgap(20);pane.setVgap(20);pane.setPadding(new Insets(20));

        // pane.setGridLinesVisible(true);

        //

        TextArea playerHand = new TextArea(); playerHand.setEditable(false);
        TextArea dealerHand = new TextArea(); dealerHand.setEditable(false);

        Button hitButton = new Button("Hit"); hitButton.setPrefSize(100,30);
        Button standButton = new Button("Stand"); standButton.setPrefSize(100,30);
        Button doubleButton = new Button("Double"); doubleButton.setPrefSize(100,30);
        Button splitButton = new Button("Split"); splitButton.setPrefSize(100,30);

        HBox hBox = new HBox(); hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(hitButton,standButton,doubleButton,splitButton);

        pane.add(playerHand,0,0,4,1);
        pane.add(hBox,0,1,4,1);
        pane.add(dealerHand,0,2,4,1);

        //

        Scene scene = new Scene(pane);
        return scene;
    }

    public static void main(String[]args){

        BlackjackFX fx = new BlackjackFX();
        fx.launch();




    }


}
