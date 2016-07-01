import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ApartmentApp extends Application{

    public static void main(String[]args){
        launch(args);
    }



    public void start(Stage stage){

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20));



        borderPane.setCenter(generateGrid(5,5));

        stage.setScene(new Scene(borderPane));
        stage.setTitle("App");
        stage.show();
    }

    public Pane generateGrid(int width, int heigth){

        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);


        for(int x=0; x<width; x++){

            for(int y=0; y<heigth;y++){

                /*Rectangle rect = new Rectangle(20,20);
                rect.setFill(Paint.valueOf("Grey"));
                */
                Button button = new Button(x+" "+y);
                button.getTranslateY();
                button.setDisable(false);

                button.setOnAction((e)->{
                    System.out.println(button.getText());
                });

                //grid.add(rect,x,y);
                grid.add(button,x,y);



            }

        }

        return grid;
    }

}
