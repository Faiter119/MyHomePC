package gui;

import backend.Coin;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CoinFlipper extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));

        Button flipButton = new Button("Flip!");
        flipButton.setOnAction(event -> {

            Coin coin = Coin.flip();

            if (coin.getSide() == Coin.Side.HEADS){
                borderPane.setCenter(new Label("Heads!"));
            }
            else {
                borderPane.setCenter(new Label("Tails!"));
            }

        });

        VBox centerVBox = new VBox(flipButton);
        centerVBox.setAlignment(Pos.CENTER); centerVBox.setSpacing(10); centerVBox.setPadding(new Insets(10));

        borderPane.setTop(centerVBox);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
