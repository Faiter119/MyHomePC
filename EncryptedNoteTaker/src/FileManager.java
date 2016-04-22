import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class FileManager {

    private String filename;
    private File file;

    public FileManager(String filename){
        this.filename = filename;

    }

    public int writeToFile(String toWrite){
        return 1;
    }

    public static void main(String[]args){

        try {
            File file = new File(FileManager.class.getResource("notepad.txt").toURI().getPath());

            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("Im the first line!");

            System.out.println(reader.readLine());
        }
        catch (Exception e){e.printStackTrace();}

    }

}
