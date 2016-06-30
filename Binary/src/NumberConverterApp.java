import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NumberConverterApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        TabPane tabPane = new TabPane();

        tabPane.getTabs().addAll(converterTab(), arithmeticTab());

        stage.setScene(new Scene(tabPane));
        stage.show();
    }

    public static Tab converterTab(){
        BorderPane borderPane = new BorderPane();

        // Dropdown Menus
        HBox numeralDropdowns = new HBox();
        numeralDropdowns.setSpacing(10); numeralDropdowns.setAlignment(Pos.CENTER); numeralDropdowns.setPadding(new Insets(10,10,0,10));

        ObservableList<NumeralSystem> numeralSystems = FXCollections.observableArrayList(NumeralSystem.values());

        ComboBox<NumeralSystem> inputSystem = new ComboBox<>(numeralSystems);
        ComboBox<NumeralSystem> outputSystem = new ComboBox<>(numeralSystems);

        inputSystem.setValue(NumeralSystem.DECIMAL); outputSystem.setValue(NumeralSystem.BINARY);

        numeralDropdowns.getChildren().addAll(inputSystem, new Label("->"), outputSystem);
        // Dropdown Menus

        // Gridpane - Main input, output
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20); gridPane.setHgap(20); gridPane.setPadding(new Insets(20,20,20,20));

        TextField numberInput = new TextField();

        TextField outputText = new TextField();
        outputText.setEditable(false);

        gridPane.addRow(0, new Label("Input: "),    numberInput);
        gridPane.addRow(1, new Label("Output: "),   outputText);

        numberInput.setOnAction((event)->{

            NumeralSystem from = inputSystem.getSelectionModel().getSelectedItem();
            NumeralSystem to = outputSystem.getSelectionModel().getSelectedItem();
            String value = numberInput.getText();

            String number = Calculation.convertNumber(from, to, value);
            outputText.setText(number);
        });
        // Gridpane - Main input, output

        borderPane.setTop(numeralDropdowns);
        borderPane.setCenter(gridPane);

        Tab converterTab = new Tab("Converter");
        converterTab.setContent(borderPane);
        converterTab.setClosable(false);

        return converterTab;
    }

    public static Tab arithmeticTab(){

        BorderPane borderPane = new BorderPane();

        // Format Input
        HBox systemInput = new HBox();
        systemInput.setSpacing(10); systemInput.setAlignment(Pos.CENTER); systemInput.setPadding(new Insets(10,10,0,10));

        ComboBox<NumeralSystem> numeralComboBox = new ComboBox<>();
        numeralComboBox.getItems().addAll(NumeralSystem.values());
        numeralComboBox.setValue(NumeralSystem.DECIMAL);

        systemInput.getChildren().add(numeralComboBox);
        // Format Input

        // Center, input, output
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20); gridPane.setHgap(20); gridPane.setPadding(new Insets(20));

        TextField firstNumber = new TextField();

        ComboBox<ArithmeticOperation> operation = new ComboBox<>();
        operation.getItems().addAll(ArithmeticOperation.values());
        operation.setValue(ArithmeticOperation.ADDITION);

        TextField secondNumber = new TextField();

        TextField outputText = new TextField();
        outputText.setEditable(false);

        firstNumber.setOnAction(
                secondNumber::fireEvent // Uses the event below
        );

        secondNumber.setOnAction((event)->{

            ArithmeticOperation selectedOperation = operation.getValue();
            NumeralSystem selectedSystem = numeralComboBox.getValue();

            String value0 = firstNumber.getText();
            String value1 = secondNumber.getText();

            String answer = Calculation.calculate(selectedOperation, selectedSystem, value0, value1);

            outputText.setText(answer);
        });

        gridPane.addRow(0, new Label("Input: "),        firstNumber);
        gridPane.addRow(1, new Label("Operation: "),    operation);
        gridPane.addRow(2, new Label("Input: "),        secondNumber);
        gridPane.addRow(3, new Label("Output: "),       outputText);
        // Center, input, output

        borderPane.setTop(systemInput);
        borderPane.setCenter(gridPane);

        Tab arithmeticTab = new Tab("Arithmetic");
        arithmeticTab.setContent(borderPane);
        arithmeticTab.setClosable(false);

        return arithmeticTab;
    }
}