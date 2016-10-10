import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Random;


public class JavaFXMatrix extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                Random rand = new Random();
                int random = rand.nextInt(2);

                TextField text = new TextField();
                text.setPrefHeight(50);
                text.setPrefWidth(50);
                text.setText("" + random);

                root.addRow(i,text);



                /*GridPane.setRowIndex(text, i);
                GridPane.setColumnIndex(text, j);*/
            }
        }

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("JavaFX Matrix");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        greetUser();
        launch(args);
    }

    public static void greetUser(){
        System.out.println("Hello and thank you for using Random Number Matrix by JavaFX");
    }
}