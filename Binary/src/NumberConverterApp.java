import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NumberConverterApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        TabPane tabPane = new TabPane();

        Tab converter = converterTab();

        tabPane.getTabs().addAll(converterTab(), arithmeticTab());

        stage.setScene(new Scene(tabPane));
        stage.show();
    }

    public static Tab converterTab(){
        BorderPane borderPane = new BorderPane();

        // Dropdown Menus
        HBox dropdowns = new HBox();
        dropdowns.setSpacing(10); dropdowns.setAlignment(Pos.CENTER); dropdowns.setPadding(new Insets(10,10,0,10));

        ObservableList<NumeralSystem> options = FXCollections.observableArrayList(NumeralSystem.values());

        ComboBox<NumeralSystem> inputType = new ComboBox<>(options);
        ComboBox<NumeralSystem> outputType = new ComboBox<>(options);

        inputType.setValue(NumeralSystem.DECIMAL); outputType.setValue(NumeralSystem.BINARY);

        dropdowns.getChildren().addAll(inputType, new Label("->"), outputType);
        // Dropdown Menus

        // Gridpane - Main input, output
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20); gridPane.setHgap(20); gridPane.setPadding(new Insets(20,20,20,20));


        Label inputLabel = new Label("Input: ");
        TextField numberInput = new TextField();
        Label outputLabel = new Label("Output: ");
        Text outputText = new Text();

        gridPane.add(inputLabel,0,0);
        gridPane.add(numberInput,1,0);
        gridPane.add(outputLabel,0,1);
        gridPane.add(outputText,1,1);

        numberInput.setOnAction((event)->{

            NumeralSystem from = inputType.getSelectionModel().getSelectedItem();
            NumeralSystem to = outputType.getSelectionModel().getSelectedItem();
            String value = numberInput.getText();

            String number = Calculation.convertNumber(from,to,value);
            outputText.setText(number);
        });
        // Gridpane - Main input, output

        borderPane.setTop(dropdowns);
        borderPane.setCenter(gridPane);

        Tab converterTab = new Tab("Converter");
        converterTab.setContent(borderPane);
        converterTab.setClosable(false);

        return converterTab;
    }

    public static Tab arithmeticTab(){

        GridPane gridPane = new GridPane();
        gridPane.setVgap(20); gridPane.setHgap(20); gridPane.setPadding(new Insets(10,0,10,0));

        TextField firstNumber = new TextField();

        ComboBox<ArithmeticOperation> operations = new ComboBox<>();
        operations.getItems().addAll(ArithmeticOperation.values());
        operations.setValue(ArithmeticOperation.ADDITION);

        TextField secondNumber = new TextField();

        Label labelOutput = new Label("="); labelOutput.setAlignment(Pos.BASELINE_RIGHT);
        Text outPutText = new Text();

        secondNumber.setOnAction((event)->{

            ArithmeticOperation operation = operations.getValue();
            String value0 = firstNumber.getText();
            String value1 = secondNumber.getText();

            outPutText.setText(Calculation.calculate(operation,NumeralSystem.DECIMAL,value0,value1));
        });


        gridPane.add(firstNumber, 1, 0);
        gridPane.add(operations,1,1);
        gridPane.add(secondNumber, 1, 2);
        gridPane.addRow(3, labelOutput, outPutText);

        Tab arithmeticTab = new Tab("Arithmetic");
        arithmeticTab.setContent(gridPane);
        arithmeticTab.setClosable(false);

        return arithmeticTab;

    }
}