package gui;/**
 * Created by OlavH on 14-Oct-16.
 */

import backend.data.Graph;
import backend.data.Node;
import backend.util.GraphReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class NodeDrawer extends Application {

    public static int WIDTH = 1920;
    public static int HEIGHT = 1080;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws IOException {

        Graph graph = new GraphReader(Paths.get("./NodePlacerApp/files/vg1.txt")).buildGraph();
        List<Node> nodeList = graph.getNodeList();

        BorderPane borderPane = new BorderPane();

        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (Node node : nodeList) {
            drawNode(gc, node);
        }

        borderPane.setCenter(canvas);


        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
    private static int STANDARD_SPACING = 50;
    public void drawNode(GraphicsContext gc, Node node){

        gc.setFill(Color.rgb(63,155,155)); // Fyllt form
        gc.setStroke(Color.BLUE); // Form med border

        gc.setLineWidth(3);
        //gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
       /* gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);*/

    }


}
