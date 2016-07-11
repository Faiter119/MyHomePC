package gui;


import backend.Ticker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class TickerPane {

    public static Pane tickerPane(Ticker ticker){

        HBox box = new HBox();
        box.setPadding(new Insets(2,20,2,20)); box.setSpacing(20); box.setAlignment(Pos.CENTER);

        TextField nameField = new TextField(ticker.getTitle());
        nameField.setAlignment(Pos.CENTER); nameField.setEditable(false);

        TextField scoreField = new TextField(ticker.getCount()+"");
        scoreField.setAlignment(Pos.CENTER); scoreField.setEditable(false); scoreField.setPrefWidth(100);


        TextField inputAmount = new TextField(Integer.toString(ticker.getDefaultAmount()));
        inputAmount.setPrefWidth(50); inputAmount.setAlignment(Pos.CENTER);
        inputAmount.setOnKeyReleased(event -> {
            if (inputAmount.getText().contains("-")){
                inputAmount.setText(inputAmount.getText().replace("-",""));
            }
        });

        Button addButton = new Button("+");
        addButton.setOnAction(event -> {
            ticker.add(parse(inputAmount.getText()));
            scoreField.setText(ticker.getCount()+"");
        });

        Button removeButton = new Button("-");
        removeButton.setOnAction(event -> {
            ticker.remove(parse(inputAmount.getText()));
            scoreField.setText(ticker.getCount()+"");
        });

        HBox scoreManipulation = new HBox(removeButton, inputAmount, addButton);
        scoreManipulation.setAlignment(Pos.CENTER);

        box.getChildren().addAll(nameField, new Label(":"), scoreField, new Label("<-"), scoreManipulation);

        return box;
    }
    private static int parse(String input){
        try{
            return Integer.parseInt(input);

        }catch (NumberFormatException e){return 1;}
    }

}
