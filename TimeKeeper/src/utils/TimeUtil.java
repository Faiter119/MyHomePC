package utils;

import java.time.DateTimeException;
import java.time.LocalTime;

/**
 * Created by OlavH on 13-Oct-16.
 */
public class TimeUtil {

    /**
     * Takes badly formated time and makes it into localtime by magic
     */
    public static LocalTime parseBadlyFormattedTime(String time){
        time = time.trim();
        if(time.length() == 4) time = time.substring(0,2)+":"+time.substring(2); // changes 1430 -> 14:30
        else if(time.length() == 3) time = time.substring(0,1)+":"+time.substring(1); // changes 630 -> 6:30

        time = time.replaceAll("[ .]",":");
        time = time.replaceAll("-",":");
        time = time.replaceAll(" ",":");

        try {
            if (time.contains(":")) {

                if(time.indexOf(":") == 1) time = "0"+time;

                return LocalTime.parse(time);
            }
            else {

                return LocalTime.of(Integer.parseInt(time),0);
            }
        }
        catch (DateTimeException | NumberFormatException ex){
            return LocalTime.MIN;
        }
    }
}
