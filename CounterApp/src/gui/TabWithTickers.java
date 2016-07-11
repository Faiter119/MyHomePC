package gui;


import backend.Ticker;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TabWithTickers {


    public static Tab tabWithTickers(String title, Ticker[] tickers){

        Tab tab = new Tab();
        tab.setText(title);

        VBox vBox = new VBox();

        Label titleLabel = new Label(title);
        titleLabel.setFont(new Font("Consolas", 20)); titleLabel.setAlignment(Pos.CENTER);

        vBox.getChildren().add(titleLabel);

        for (Ticker ticker : tickers) vBox.getChildren().add(TickerPane.tickerPane(ticker));


        tab.setContent(vBox);

        return tab;
    }

}
