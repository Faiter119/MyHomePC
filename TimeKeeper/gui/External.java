import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

public class External {

    public static <T extends Serializable> T noStorageFileFoundAlert(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("No storage-file found!");
        alert.setContentText("Choose your option.");

        ButtonType newButton = new ButtonType("New file");
        ButtonType loadButton = new ButtonType("Load file");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(newButton, loadButton, cancelButton);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == newButton){

            System.out.println("New file..");

            File newFile = Manager.newStorageFile();
            return Manager.readFile(newFile);

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

        File selectedDir = chooser.showDialog(stage);

        if(selectedDir == null){
            Manager.writeBackup(Manager.getJarFolder(), events);
        }
        else {
            Manager.writeBackup(selectedDir, events);
        }
    }
    public static ArrayList<Event> loadNewEvents(Stage stage){

        FileChooser chooser = new FileChooser();

        File loadedFile = chooser.showOpenDialog(stage);

        if(loadedFile == null) return null;

        return Manager.readFile(loadedFile);
    }
}
