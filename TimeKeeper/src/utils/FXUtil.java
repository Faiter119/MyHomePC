package utils;

import javafx.scene.control.TextInputControl;

/**
 * Created by OlavH on 13-Oct-16.
 */
public class FXUtil {

    public static void clearAll(TextInputControl... items){

        for(TextInputControl item : items){
            item.clear();
        }
    }

}
