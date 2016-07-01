/**
 * Created by Olav Husby on 01.07.2016.
 */

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.LocalTimeStringConverter;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class JobTimesApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static ArrayList<Event> events;
    private static BorderPane border;
    public void start(Stage stage) {

        events = Manager.read();
        if(events == null){
            System.exit(-1);
        }
        if(events.size() == 0){
            LocalTimeStringConverter converter = new LocalTimeStringConverter();
            Event event = new Event(LocalDate.now());
            event.setStart(LocalTime.parse(converter.toString(LocalTime.now())));
            event.setDescription("You started using this application, good for you.");
            events.add(event);
        }

        border = new BorderPane();
        border.setPadding(new Insets(20));

        border.setCenter(tableOfEventsPane());
        border.setRight(newEventPane());
        border.setLeft(currentSelectedItemPane());
        // border.setBottom(interactionOptionsPane());

        table.getSelectionModel().selectedItemProperty().addListener((e)->{
            border.setLeft(currentSelectedItemPane());
        });

        stage.setScene(new Scene(border));
        stage.setOnCloseRequest((event)->
            Manager.write(events)
        );
        stage.show();
    }
    private static TableView<Event> table;
    public static Pane tableOfEventsPane(){

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20)); vBox.setSpacing(20);

        /*GridPane grid = new GridPane();
        grid.setVgap(20); grid.setHgap(20); grid.setPadding(new Insets(20));*/

        // Table
        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // No dumb extra colomns

        TableColumn<Event, LocalDate> date = new TableColumn<>("Date");
        date.setCellValueFactory( (data) -> new SimpleObjectProperty<>(data.getValue().getDate()) ); // "data" is a CellData object made my JavaFx containing the data in the cells

        TableColumn<Event, LocalTime> startTime = new TableColumn<>("Start");
        startTime.setCellValueFactory( (data) -> new SimpleObjectProperty<>(data.getValue().getStart())); // Need to use SimpleObjectProperty because javafx says so (-.-*)==\\7

        TableColumn<Event, LocalTime> endTime = new TableColumn<>("End");
        endTime.setCellValueFactory( (data) -> new SimpleObjectProperty<>(data.getValue().getEnd()));

        TableColumn<Event, String> desc = new TableColumn<>("Description");
        desc.setCellValueFactory( (data) -> new SimpleObjectProperty<>(data.getValue().getDescription()));

        table.getColumns().addAll(date, startTime, endTime, desc);

        table.getItems().addAll(events);
        table.autosize();
        table.getSelectionModel().select(0);
        // Table

        Label label = new Label("Events");
        label.setFont(new Font("Consolas",20));
        label.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(label, table, interactionOptionsPane());

        return vBox;
    }
    public static Pane newEventPane(){

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER); vBox.setSpacing(20); vBox.setPadding(new Insets(20));
        GridPane grid = new GridPane();

        grid.setVgap(20); grid.setHgap(20); grid.setPadding(new Insets(20)); grid.setAlignment(Pos.CENTER);

        TextField dateTextField = new TextField(LocalDate.now().toString());
            dateTextField.setTooltip(new Tooltip("Format is YYYY-MM-DD"));
        TextField startTextField = new TextField();
            startTextField.setTooltip(new Tooltip("Format is H, HH:MM, or H:MM | H = Hour(24-clock), M = Minute"));
        TextField endTextField = new TextField();
            endTextField.setTooltip(new Tooltip("Format is H, HH:MM, or H:MM | H = Hour(24-clock), M = Minute"));
        TextField descriptionTextField = new TextField();

        // Button
        Button addNewEventButton = new Button("Add");
        addNewEventButton.setAlignment(Pos.CENTER);

        addNewEventButton.setOnAction((e)->{

            try{
                String dateString = dateTextField.getText();
                String startString = startTextField.getText();
                String endString = endTextField.getText();
                String description = descriptionTextField.getText();

                LocalDate date = LocalDate.parse(dateString);
                LocalTime start;
                LocalTime end;

                Event event = new Event(date);
                event.setDescription(description);

                if(!startString.trim().equals("")) {
                    event.setStart(parse(startString));
                }

                if(!endString.trim().equals("")) {
                    event.setEnd(parse(endString));
                }

                System.out.println(event+" got added!");
                events.add(event);
                table.getItems().add(event);
                clearAll(startTextField, endTextField, descriptionTextField);
                dateTextField.setText(LocalDate.now().toString());
            }
            catch (DateTimeParseException ex){
                dateTextField.clear();
            }
        });
        // Button

        grid.addRow(0, new Label("Date: "), dateTextField);
        grid.addRow(1, new Label("Start (Optional): "), startTextField);
        grid.addRow(2, new Label("End (Optional): "), endTextField);
        grid.addRow(3, new Label("Description (Optional): "), descriptionTextField);

        Label label = new Label("New Event");
        label.setFont(new Font("Consolas",20));

        vBox.getChildren().addAll(label, grid, addNewEventButton);

        return vBox;
    }
    public static Pane currentSelectedItemPane(){

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER); vBox.setSpacing(20); vBox.setPadding(new Insets(20));

        GridPane grid = new GridPane();
        grid.setVgap(20); grid.setHgap(20); grid.setPadding(new Insets(20)); grid.setAlignment(Pos.CENTER);

        Event currentEvent = table.getSelectionModel().getSelectedItem(); // Current item
        if(currentEvent == null){
            currentEvent = new Event(LocalDate.now().plusDays(1));
            currentEvent.setDescription("ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn");
        }
        // date, start, end, desc, date created, duration?

        TextField date = new TextField(currentEvent.getDate().toString());
        date.setEditable(false);

        TextField start = new TextField(currentEvent.getStart().toString());
        start.setEditable(false);

        TextField end = new TextField(currentEvent.getEnd().toString());
        end.setEditable(false);

        Duration d = currentEvent.getDuration();
        TextField duration = new TextField(d.toHours()+" hours and "+((d.toMinutes())-(60*d.toHours()))+" minutes.");
        duration.setEditable(false);

        TextArea desc = new TextArea(currentEvent.getDescription());
        desc.setEditable(false);

        TextField dateCreated = new TextField(currentEvent.getDateAdded().toString());
        dateCreated.setEditable(false);

        TextField createdBy = new TextField(currentEvent.getAddedBy());
        createdBy.setEditable(false);

        TextField history = new TextField(currentEvent.getHistory());
        history.setEditable(false);

        grid.addRow(0, new Label("Date: "), date);
        grid.addRow(1, new Label("Start: "), start);
        grid.addRow(2, new Label("End: "), end);
        grid.addRow(3, new Label("Duration: "), duration);
        grid.addRow(4, new Label("Description"), desc);
        grid.addRow(5, new Label("Created: "), dateCreated);
        grid.addRow(6, new Label("By: "), createdBy);
        grid.addRow(7, new Label("History"), history); // For safety

        Label label = new Label("Details");
        label.setFont(new Font("Consolas",20));

        vBox.getChildren().addAll(label, grid);

        return vBox;

    }

    public static Pane interactionOptionsPane(){

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER); vBox.setPadding(new Insets(20));

        Label deleteLabel = new Label("Type \"delete\" to delete Event. This is final!");
        deleteLabel.setFont(new Font("Consolas",20));
        deleteLabel.setVisible(false);

        TextField deleteTextField = new TextField(); // Write "delete" to delete, security
        deleteTextField.setVisible(false);
        deleteTextField.setOnAction(event -> {

            if(deleteTextField.getText().equalsIgnoreCase("delete")){

                events.remove(table.getSelectionModel().getSelectedItem());
                table.getItems().remove(table.getSelectionModel().getSelectedItem());

            }
            deleteTextField.clear();
            deleteTextField.setVisible(false);
            deleteLabel.setVisible(false);
            table.requestFocus();
        });



        // Buttons
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER); hBox.setSpacing(20); hBox.setPadding(new Insets(20));

        // Delete (confirm dialog), edit,

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((event -> {

            deleteTextField.setVisible(true);
            deleteLabel.setVisible(true);
            deleteTextField.requestFocus();

        }));


        Button editButton = new Button("Edit");
        editButton.setOnAction(event -> {

            Event currentEvent = table.getSelectionModel().getSelectedItem();

            if(currentEvent != null) border.setLeft(eventEditPane());

        });

        Button verifyButton = new Button("Verify");
        verifyButton.setOnAction(event -> {

            int index = table.getSelectionModel().getSelectedIndex();
            System.out.println("Must use CSS for colors? ;(");

        });


        hBox.getChildren().addAll(deleteButton, editButton, verifyButton);
        // Buttons

        vBox.getChildren().addAll(hBox,deleteTextField, deleteLabel);
        return vBox;

    }
    public static Pane eventEditPane(){

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER); vBox.setSpacing(20); vBox.setPadding(new Insets(20));

        GridPane grid = new GridPane();
        grid.setVgap(20); grid.setHgap(20); grid.setPadding(new Insets(20)); grid.setAlignment(Pos.CENTER);

        Event currentEvent = table.getSelectionModel().getSelectedItem(); // Current item

        // date, start, end, desc, date created,

        String dateOrig = currentEvent.getDate().toString();
        TextField date = new TextField(dateOrig);

        String startOrig = currentEvent.getStart().toString();
        TextField start = new TextField(startOrig);

        String endOrig = currentEvent.getEnd().toString();
        TextField end = new TextField(endOrig);

        String descOrig = currentEvent.getDescription();
        TextArea desc = new TextArea(descOrig);

        grid.addRow(0, new Label("Date: "), date);
        grid.addRow(1, new Label("Start: "), start);
        grid.addRow(2, new Label("End: "), end);
        grid.addRow(3, new Label("Description"), desc);

        Label label = new Label("Edit Event");
        label.setFont(new Font("Consolas",20));

        Button acceptButton = new Button("Accept");
        acceptButton.setOnAction(event -> {

            String dateNew = date.getText();
            String startNew = start.getText();
            String endNew = end.getText();
            String descNew = desc.getText();

            if(!dateOrig.equals(dateNew)){
                try {
                    currentEvent.setDate(LocalDate.parse(dateNew));
                } catch (DateTimeParseException e){date.setText(dateOrig);}
            }
            if(!startOrig.equals(startNew)){
                currentEvent.setStart(parse(startNew));
            }
            if(!endOrig.equals(endNew)){
                currentEvent.setEnd(parse(endNew));
            }
            if(!descOrig.equals(descNew)){
                currentEvent.setDescription(descNew);
            }
            table.getItems().set(table.getSelectionModel().getSelectedIndex(), currentEvent);
            table.requestFocus();
            table.getSelectionModel().select(0);
            border.setLeft(currentSelectedItemPane());
        });

        vBox.getChildren().addAll(label, grid, acceptButton);

        return vBox;

    }

    private static void clearAll(TextInputControl ... items){

        for(TextInputControl item : items){
            item.clear();
        }
    }
    private static LocalTime parse(String time){

        try {
            if (time.contains(":")) {

                if(time.indexOf(":") == 1) time = "0"+time;

                return LocalTime.parse(time);
            }
            else {

                return LocalTime.of(Integer.parseInt(time),0);
            }
        }
        catch (DateTimeException | NumberFormatException ex){
            return LocalTime.MIN;
        }
    }
}