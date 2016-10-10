package gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class AlarmApp extends Application{

    public static void main(String[] args) {launch();}

    public void start(Stage stage) throws Exception {

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20));

        HBox centerPane = new HBox();
        centerPane.setSpacing(20); centerPane.setPadding(new Insets(20));

        // Select time, count down to time, alarm

        Media media = new Media(new File("C:/sound/smoke.mp3").toURI().toString());

        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.0);

        //player.play();

        Slider slider = new Slider();
        slider.setMin(0.0); slider.setMax(1); slider.setShowTickMarks(true);
        slider.valueProperty().addListener(observable -> {

            double value = slider.getValue();

            if(value == 0.0) player.setMute(true);
            else {
                player.setMute(false);
                player.setVolume(slider.getValue());
            }


        });
        HBox bottomPane = new HBox();

        Slider timeSlider = new Slider();


        bottomPane.getChildren().addAll(timeSlider);

       /* Timeline timeline = new Timeline();
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000),
                new KeyValue(timeSlider.setValue(2), 25)));
        timeline.play();*/



        centerPane.getChildren().addAll(playButton(player, centerPane), new VBox(slider, new Label("Volume (careful ; loud)")));

        border.setCenter(centerPane);
        border.setBottom(bottomPane);

        stage.setScene(new Scene(border));
        stage.sizeToScene();
        stage.show();
    }
    private Button pauseButton(MediaPlayer player, Pane pane){

        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(event -> {
            player.pause();
            int index = pane.getChildren().indexOf(pauseButton);
            pane.getChildren().remove(pauseButton);
            pane.getChildren().add(index, playButton(player, pane));
        });
        return pauseButton;
    }
    private Button playButton(MediaPlayer player, Pane pane){

        Button playButton = new Button("Play");
        playButton.setOnAction(event -> {
            int index = pane.getChildren().indexOf(playButton);
            player.play();
            pane.getChildren().remove(playButton);
            pane.getChildren().add(index, pauseButton(player, pane));
        });
        return playButton;

    }
}
