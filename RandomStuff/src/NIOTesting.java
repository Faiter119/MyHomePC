import javafx.scene.control.Button;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class NIOTesting {

    public static void main(String[] args) throws Exception{

        Path path = Paths.get("test.txt");

        System.out.println(path.toAbsolutePath());

        Files.write(path, ("Swag\n" +
                "yo\n" +
                "ost\n" +
                "dubstep\n").getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

        Files.newBufferedReader(path);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        List<String> list = Arrays.asList("ost","kræft","mat");

        objectOutputStream.writeObject(list);

        Button button = new Button();

    }

}
