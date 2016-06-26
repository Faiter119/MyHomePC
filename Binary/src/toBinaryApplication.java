/**
 * Created by Olav Husby on 26.06.2016.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class toBinaryApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        GridPane pane = new GridPane();
        pane.setVgap(20); pane.setHgap(20); pane.setPadding(new Insets(20,20,20,20));

        Label inputLabel = new Label("Input Number Here: ");
        TextField numberInput = new TextField();
        Label outputLabel = new Label("Output Here: ");
        Text text = new Text();

        pane.add(inputLabel,0,0);
        pane.add(numberInput,1,0);
        pane.add(outputLabel,0,1);
        pane.add(text,1,1);

        numberInput.setOnAction((event)->{

            String input = numberInput.getText();
            String textAsBinary = Binary.toBinaryString(input);
            text.setText(textAsBinary);

        });

        stage.setTitle("Integer -> Twos-compliment-binary");
        stage.setScene(new Scene(pane));
        stage.show();
    }
}