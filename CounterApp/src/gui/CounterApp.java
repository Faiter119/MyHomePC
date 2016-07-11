package gui;

import backend.Ticker;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CounterApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        // tabs; you can add new tabs
        // tickers; you can add / remove tickers
        // ["name"] -[score]+

        TabPane tabPane = new TabPane();

        Ticker[] tickers = new Ticker[]{
                new Ticker("UEF Wins"),
                new Ticker("Sera Wins"),
                new Ticker("Aeon Wins"),
                new Ticker("Cybran Wins")
        };
        Ticker[] tickers1 = new Ticker[]{
                new Ticker("UEF Losses"),
                new Ticker("Sera Losses"),
                new Ticker("Aeon Losses"),
                new Ticker("Cybran Losses")
        };
        Ticker[] trening = new Ticker[]{
                new Ticker("Granåsen",30),
                new Ticker("Sykling",10),
                new Ticker("Løping",15),
        };


        tabPane.getTabs().addAll(TabWithTickers.tabWithTickers("Trening", trening),TabWithTickers.tabWithTickers("FAF Wins",tickers), TabWithTickers.tabWithTickers("FAF Losses",tickers1));

        Scene scene = new Scene(tabPane);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();
    }
}
