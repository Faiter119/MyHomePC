package gui;

import backend.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.FileManager;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

public class External {

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T noStorageFileFoundAlert(Stage stage){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("No storage-file found!");
        alert.setContentText("Choose your option.");

        ButtonType newButton = new ButtonType("New file");
        ButtonType loadButton = new ButtonType("Load file");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(newButton, loadButton, cancelButton);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == newButton){

            System.out.println("New file..");


            File newFile = FileManager.newStorageFile().get();


            FileManager.newStorageFile().ifPresent( (file) -> FileManager.readFile(file));

            return (T) FileManager.readFile(newFile).get();

        } else if (result.get() == loadButton) {

            System.out.println("Load file..");

            return (T) loadNewEvents(stage);

        }
        else {
            return null;
        }
    }
    public static void makeBackup(Stage stage, ArrayList<Event> events){

        DirectoryChooser chooser = new DirectoryChooser();
        FileManager.getJarFolder().ifPresent((file)-> chooser.setInitialDirectory(file));

        File selectedDir = chooser.showDialog(stage);

        if(selectedDir == null){
            FileManager.getJarFolder().ifPresent((file) -> FileManager.writeBackup(file, events));
        }
        else {
            FileManager.writeBackup(selectedDir, events);
        }
    }
    public static ArrayList<Event> loadNewEvents(Stage stage){

        FileChooser chooser = new FileChooser();

        FileManager.getJarFolder().ifPresent((file)-> chooser.setInitialDirectory(file));

        File loadedFile = chooser.showOpenDialog(stage);

        if(loadedFile == null) return null;

        return (ArrayList<Event>) FileManager.readFile(loadedFile).get();
    }
}
