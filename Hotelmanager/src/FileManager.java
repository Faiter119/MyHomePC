import java.io.*;
import java.time.LocalDate;


public class FileManager {

    public static <T extends Serializable> void write(T object) {
        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./Hotelmanager/Test.txt"));
            out.writeObject(object);
        }
        catch (IOException e) {e.printStackTrace();}
    }
    public static <T extends Serializable> T read(){

        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("./Hotelmanager/Test.txt"));
            Object o = in.readObject();

            return (T) o;

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {

        Person p = new Person("Olav Reppe Husby", Person.Sex.MALE, LocalDate.of(1996,6,8));

        FileManager.write(p);

        System.out.println(""+FileManager.read());


    }

}
