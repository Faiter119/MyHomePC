package gui;/**
 * Created by OlavH on 18-Nov-16.
 */

import data.ZipPacker;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.MathUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PackerApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private File file;
    private void saveFile(File file){
        this.file = file;
    }
    private File getFile(){return file;}

    private BarChart<String, Number> barChart;

    private BorderPane borderPane;


    public void start(Stage stage) {

        stage.setTitle("Compresser");

        borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20));

        borderPane.setBottom(bottomPane(stage));
        /*barChart = BarCharts.getBarchartFor(new String[]{"Original File","Output File"}, new Double[]{2d,1d});
        //barChart.setMaxWidth(stage.getWidth()/2);
        borderPane.setCenter(barChart);*/

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);

        stage.show();
    }


    /**
     * Load file button, file name osv
     * @param stage
     */
    private Pane bottomPane(Stage stage){

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER); vBox.setSpacing(10); vBox.setPadding(new Insets(20));

        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(Paths.get("./").toFile());

        Button openFileButton = new Button("Select File");
        Label label = new Label();
        Button compressButton = new Button("Compress");
        compressButton.setDisable(true);

        openFileButton.setOnAction(event -> {

            File file = chooser.showOpenDialog(stage);

            if (file == null) System.exit(1); // just fuck it

            saveFile(file);

            Path path = file.toPath();
            double space = MathUtil.toMegabytes(file.length());

            barChart = BarCharts.getBarchartFor(new String[]{"Original File","Output File"}, new Double[]{space,space});
            //barChart.setMaxWidth(stage.getWidth()/2);
            borderPane.setCenter(barChart);

            /*barChart.getData().get(0).getData().get(0).setYValue(space); // sets the data on the chart
            barChart.getData().get(0).getData().get(1).setYValue(space); // sets the data on the chart*/

            //Bindings.bindContent(Arrays.asList(space),barChart.getData().get(0).getData());

            compressButton.setDisable(false);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            stage.setMinHeight(screenSize.getHeight()-400); stage.setMinWidth(screenSize.getWidth()-800);
            stage.centerOnScreen();

            borderPane.setLeft(FileInfoPane.getFileInfoPane(stage, file));

        });

        compressButton.setOnAction(event -> {

            try {

                byte[] bytes = Files.readAllBytes(file.toPath());

                //oldPacker packer = new oldPacker(bytes);

                byte[] result = ZipPacker.pack(bytes);

                //byte[] result = packer.pack();

                int oldsize = bytes.length;
                int newSize = result.length;

                barChart.getData().get(0).getData().get(1).setYValue(MathUtil.toMegabytes(newSize));

                double reductionPercentage = 100-MathUtil.percentage(oldsize, newSize);
                System.out.println("Reduced by: "+reductionPercentage+"%");

                File newFile = new File(file.getAbsolutePath().replaceAll("\\.\\w*$",".comp")); // replaces extention with .comp

                if (!newFile.exists()) newFile.createNewFile();

                Files.write(newFile.toPath(), result, StandardOpenOption.TRUNCATE_EXISTING);
                borderPane.setRight(FileInfoPane.getFileInfoPane(stage, newFile));
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        });

        vBox.getChildren().addAll(openFileButton, compressButton);

        return vBox;
    }
}
