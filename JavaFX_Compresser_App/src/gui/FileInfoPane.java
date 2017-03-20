package gui;

import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

/**
 * Created by OlavH on 25-Nov-16.
 */
public class FileInfoPane {

    public static Pane getFileInfoPane(Stage stage, File file){
        Objects.requireNonNull(file);

        VBox vBox = new VBox();
        vBox.setMaxWidth(stage.getWidth()/4);

        Text header = new Text("File Info");
        header.setFont(Font.font("Consolas"));

        Label path = new Label("*Path*\t"+file.getAbsolutePath());
        path.setTooltip(new Tooltip(file.getAbsolutePath()));

        Label size = new Label("*Size*\t"+(double)file.length()/1000000d+"MB");
        size.setTooltip(new Tooltip((double)file.length()/1000000d+"MB"));


        vBox.getChildren().addAll(
                header,
                path,
                size
        );

        return vBox;

    }

}
