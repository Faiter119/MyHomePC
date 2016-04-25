import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Main extends Application { // https://www.reddit.com/r/javahelp/comments/4gda3t/trying_to_create_a_looping_presentation_in_javafx/


    BorderPane borderPane;
    int counter;

    public Main(){}

    public void setNextImage(ArrayList<ImageView> images){
        borderPane.setCenter(images.get(counter));
        counter++;
        if(counter==4)counter=0;
    }

    public void start(Stage primaryStage) throws Exception {

        final ArrayList<ImageView> images = createPresentation();
        int counter=0;

        borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 650);

        borderPane.setCenter(images.get(0));

        scene.setOnMouseClicked(e -> {
            setNextImage(images);

        });


        primaryStage.setScene(scene);
        primaryStage.show();

        /*for(int i=0; i<5; i++){

            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){}



            if(counter==3)counter=0;
            counter++;
        }*/

    }


    public ArrayList<ImageView> createPresentation(){

        ArrayList<ImageView> slides = new ArrayList<>();

        Image image1 = new Image("1.png");
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        slides.add(imageView1);

        Image image2 = new Image("2.png");
        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        slides.add(imageView2);

        Image image3 = new Image("3.png");
        ImageView imageView3 = new ImageView();
        imageView3.setImage(image3);
        slides.add(imageView3);

        Image image4 = new Image("4.png");
        ImageView imageView4 = new ImageView();
        imageView4.setImage(image4);
        slides.add(imageView4);

        return slides;

    }
    public static void main(String[] args) {
        launch();
    }
}