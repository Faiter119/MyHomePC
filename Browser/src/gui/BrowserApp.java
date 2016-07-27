package gui;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Queue;
import java.util.Stack;

public class BrowserApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stack<String> webHistoryStack = new Stack<>();

    public void start(Stage stage) {
        stage.show();

        BorderPane mainPane = new BorderPane();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://google.com");
        webHistoryStack.push("http://google.com");

        try {
            URL test = new URL("http://google.com");

            System.out.println(test.getAuthority());
            System.out.println(test.getFile());
            System.out.println(test.getPath());
            System.out.println(test.getContent().toString());
            System.out.println(test.getDefaultPort());
            System.out.println(test.getQuery());
            System.out.println(test.getUserInfo());
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Top Bar
        HBox topBar = new HBox();
        topBar.setSpacing(20); topBar.setPadding(new Insets(10));

        TextField adressBar = new TextField(parseWebAddress("google.com"));
        adressBar.setPrefWidth(1000);
        adressBar.setOnAction(event -> {
            String adress = parseWebAddress(adressBar.getText());
            webEngine.load(adress);
            webHistoryStack.push(adress);
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            String adress = webHistoryStack.pop();
            adressBar.setText(adress);
            webEngine.load(adress);
        });
        //Button forwardButton = new Button("Forward");
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> {
            webEngine.load(webEngine.getLocation());
            //System.out.println("Hello!");
        });


        topBar.getChildren().addAll(backButton,/* forwardButton,*/ refreshButton, adressBar);
        // Top Bar

        mainPane.setCenter(webView);
        mainPane.setTop(topBar);

        stage.setScene(new Scene(mainPane));
        stage.setTitle("Olavs Browser");

    }
    public static String parseWebAddress(String address){

        if(address.contains("https://www.")) return address;

        if(!address.contains("www.")) address = "www."+address;
        if(!address.contains("https://")) address = "https"+address;

        return address;

    }
}
