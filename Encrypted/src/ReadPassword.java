import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ReadPassword extends Application {

    public ReadPassword(){

    }

    public void start(Stage stage) {

        stage.setTitle("Read Password");

        GridPane pane = new GridPane();

        Button checkPassword = new Button("Confirm");
        checkPassword.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        Scene scene = new Scene(pane,300,300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}