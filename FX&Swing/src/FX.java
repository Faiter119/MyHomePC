import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URI;
import java.time.Duration;
import java.time.LocalTime;

public class FX extends Application{


    @Override
    public void start(Stage stage) {

        LocalTime start = LocalTime.now();

        GridPane gridPane = new GridPane(); // HBox(horizontal), VBox(vertical), StackPane(on top of eachother?), GridPane, FlowPane, Tabpane( and Tab)
        gridPane.setPadding(new Insets(50));
        gridPane.setVgap(50); gridPane.setHgap(50);
       // gridPane.setGridLinesVisible(true);

        // Text
        Text text = new Text();
        text.setFont(new Font("Consolas",14));
        text.setWrappingWidth(20); // Pixel width
        text.setTextAlignment(TextAlignment.RIGHT); // Where link the text is placed
        // Text

        // Hyperlink
        Hyperlink link = new Hyperlink("Google Maps");
        link.setOnAction(e->{
            try {
                URI uri = new URI("https://www.google.no/maps/place/Trondheim/@63.416248,10.40906,13z/data=!4m2!3m1!1s0x466d319747037e53:0xbf7c8288f3cf3d4");
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.BROWSE)) {
                        desktop.browse(uri);
                    }
                }
            }catch (Exception f){}
        });
        // Hyperlink

        // Combobox
        String[] strings = {"Ost","Mat","Pizza","Taco","Brus","Dubstep","Trap"};
        ComboBox<String> dropdown = new ComboBox<>();
        dropdown.getItems().addAll(strings);
        dropdown.getSelectionModel().select(0); // Sets the 0th item as the selected one

        Text dropDownText = new Text(dropdown.getSelectionModel().getSelectedItem());

        dropdown.setOnAction(event -> {
            dropDownText.setText(dropdown.getSelectionModel().getSelectedItem());
        });
        // Combobox

        Text mouse = new Text("X: Y:");



        gridPane.add(markTimeButton(text, start),0,0,2,1); gridPane.add(new Label("Marked Time ->"),1,0);gridPane.add(text,2,0);

        gridPane.add(dropdown,0,2,2,1); gridPane.add(new Label("Selected Item ->"),1,2); gridPane.add(dropDownText,2,2);
        System.out.println(MouseInfo.getPointerInfo().getDevice().toString());
        gridPane.add(link,0,4);
        gridPane.add(mouse,4,4,4,4);
        Scene scene = new Scene(gridPane);
        scene.setOnMouseClicked(event -> mouse.setText("X: "+Double.toString(scene.getX())+" - Y: "+Double.toString(scene.getY())));
        stage.setScene(scene);
        stage.setMinHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2); stage.setMinWidth(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2);
        stage.show();
    }

    public Button markTimeButton(Text text, LocalTime startTime){

        Button button = new Button("Mark Time!");
        button.setFont(new Font("Consolas",14));
        button.setOnAction(e->{
            text.setText(Long.toString(Duration.between(startTime,LocalTime.now()).getSeconds()));
        });

        return button;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
