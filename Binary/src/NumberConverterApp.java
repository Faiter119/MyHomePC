import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NumberConverterApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        BorderPane borderPane = new BorderPane();

        // Dropdown Menus
            HBox dropdowns = new HBox();
            dropdowns.setSpacing(10); dropdowns.setAlignment(Pos.CENTER); dropdowns.setPadding(new Insets(10,10,0,10));

            ObservableList<String> options = FXCollections.observableArrayList(Calculation.NumberalSystem.valuesString());

            ComboBox<String> inputType = new ComboBox<>(options);
            ComboBox<String> outputType = new ComboBox<>(options);

            inputType.setValue("Decimal(10)"); outputType.setValue("Binary(2)");

            dropdowns.getChildren().addAll(inputType, new Label("->"), outputType);
        // Dropdown Menus

        // Gridpane - Main input, output
            GridPane gridPane = new GridPane();
            gridPane.setVgap(20); gridPane.setHgap(20); gridPane.setPadding(new Insets(20,20,20,20));


            Label inputLabel = new Label("Input: ");
            TextField numberInput = new TextField();
            Label outputLabel = new Label("Output: ");
            Text text = new Text();

            gridPane.add(inputLabel,0,0);
            gridPane.add(numberInput,1,0);
            gridPane.add(outputLabel,0,1);
            gridPane.add(text,1,1);

            numberInput.setOnAction((event)->{

                int fromBase = Calculation.NumberalSystem.parse(inputType.getSelectionModel().getSelectedItem()).base();
                int toBase = Calculation.NumberalSystem.parse(outputType.getSelectionModel().getSelectedItem()).base();
                String value = numberInput.getText();

                String number = Calculation.convertNumber(fromBase,toBase,value);
                text.setText(number);
            });
        // Gridpane - Main input, output

        borderPane.setTop(dropdowns);
        borderPane.setCenter(gridPane);

        stage.setScene(new Scene(borderPane));
        stage.show();
    }
}