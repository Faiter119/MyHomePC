/**
 * Created by Olav Husby on 01.07.2016.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TableTestApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static ObservableList<Person> persons = FXCollections.observableArrayList(

            new Person("Olav Reppe Husby", Person.Sex.MALE, LocalDate.of(1996,6,8)),
            new Person("Per Bjarte", Person.Sex.MALE, LocalDate.of(1990,1,1)),
            new Person("Lise Saus", Person.Sex.FEMALE, LocalDate.of(1986,2,3)),
            new Person("Gunnar Gnaus", Person.Sex.MALE, LocalDate.of(1995,2,9)),
            new Person("Valentina Kerman", Person.Sex.FEMALE, LocalDate.of(1996,5,25)),
            new Person("Larse Mat", Person.Sex.MALE, LocalDate.of(1996,1,1)),
            new Person("Trude Reppe", Person.Sex.FEMALE, LocalDate.of(1962,5,26)),
            new Person("Eldbjørn Husby", Person.Sex.MALE, LocalDate.of(1960,2,13))
    );

    public void start(Stage stage) {

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20));


        VBox vBox = new VBox();
        // Table
        TableView<Person> table = new TableView<>(); // Could input persons here, same as setItems(persons)

        TableColumn<Person,String> firstName = new TableColumn<>("First name");
        firstName.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));

        TableColumn<Person,String> lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));

        TableColumn<Person,LocalDate> birth = new TableColumn<>("Birth");
        birth.setCellValueFactory(new PropertyValueFactory<>("birth"));


        table.getColumns().addAll(firstName, lastName, birth);

        table.setItems(persons);
        table.getSelectionModel().select(0);

        table.getSelectionModel().selectedItemProperty().addListener((e)->{
            border.setLeft(displaySelectedPersonPane(table.getSelectionModel().getSelectedItem()));
        });

        // Table

        Label label = new Label("People"); label.setFont(new Font("Consolas",16));
        vBox.getChildren().addAll(label, table);

        border.setCenter(vBox);
        border.setRight(addNewPersonPane());
        border.setLeft(displaySelectedPersonPane(table.getSelectionModel().getSelectedItem()));

        stage.setScene(new Scene(border));
        stage.show();

    }
    public static Pane addNewPersonPane(){
        GridPane grid = new GridPane();
        grid.setVgap(20); grid.setHgap(20); grid.setPadding(new Insets(20));

        TextField nameField = new TextField();
        TextField birthField = new TextField("YYYY-MM-DD");

        ComboBox<Person.Sex> sexComboBox = new ComboBox<>();
        sexComboBox.getItems().addAll(Person.Sex.MALE, Person.Sex.FEMALE);
        sexComboBox.getSelectionModel().select(0);

        Button addButton = new Button("Add");

        addButton.setOnAction((e)->{

            String name = nameField.getText();
            Person.Sex sex = sexComboBox.getValue();

            LocalDate birth = LocalDate.now();

            try{
                birth = LocalDate.parse(birthField.getText());
            }
            catch (DateTimeParseException ex){}


            persons.add(new Person(name, sex, birth));

            nameField.clear();
            birthField.clear();
        });

        grid.addRow(0, new Label("Name: "), nameField);
        grid.addRow(1, new Label("Birth: "), birthField);
        grid.add(sexComboBox, 1,2);
        grid.add(addButton,1,3);

        return grid;
    }
    public static Pane displaySelectedPersonPane(Person p){

        GridPane grid = new GridPane();
        grid.setVgap(20); grid.setHgap(20); grid.setPadding(new Insets(20));
        grid.setMaxWidth(200);
        grid.setMinWidth(200);

        grid.addRow(0, new Label("Name: "), new Text(p.getName()));
        grid.addRow(1, new Label("Sex: "),new Text(p.getSex().toString()));
        grid.addRow(2, new Label("Birth: "), new Text(p.getBirth().toString()));
        grid.addRow(3, new Label("Age: "), new Text(""+p.getAge()));

        return grid;
    }
}
