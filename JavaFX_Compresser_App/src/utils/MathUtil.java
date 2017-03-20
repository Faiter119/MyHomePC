package utils;

/**
 * Created by OlavH on 18-Nov-16.
 */
public class MathUtil {

    public static double toMegabytes(long bytes){

        return (double) bytes / (double) 1000000;
    }

    public static double percentage(long total, long part){

        return (double) (100d/total) * (double) part;
    }

}
