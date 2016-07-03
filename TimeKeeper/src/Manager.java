import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Manager {

    private static Properties prop = new Properties();

    public static void setPath(String newPath){
        if(!newPath.contains(".txt")){
            newPath += "/storage.txt";
        }
        prop.setProperty("storagePath", newPath);
    }
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T read(){
        try {
            prop.load(Manager.class.getResourceAsStream("config.properties"));
        }catch (IOException ex){return null;}

        try{
            FileInputStream fis = new FileInputStream(prop.getProperty("storagePath"));
            //InputStream stream = Manager.class.getResourceAsStream("C:/Users/Olav Husby/IdeaProjects/MyProjects/out/artifacts/TimeKeeper_jar/storage.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            T obj = (T) ois.readObject();

            fis.close();
            //stream.close();
            ois.close();

            return obj;
        }
        catch (IOException | ClassNotFoundException | NullPointerException e){e.printStackTrace();}

        return null;
    }

    /**
     * Writes the thing to the path, deletes everything else in the file.
     */
    public static <T extends Serializable> void write(T thing){
        try {
            prop.load(Manager.class.getResourceAsStream("config.properties"));
        }catch (IOException ex){return;}

        try{

            FileOutputStream fos = new FileOutputStream(prop.getProperty("storagePath"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(thing);

            oos.close();
            fos.close();

            System.out.println("Wrote "+thing);
        }
        catch (IOException | NullPointerException e){e.printStackTrace();}

    }

    public static void main(String[] args) {

        Event oBorn = new Event(LocalDate.of(1996,6,8));
        /*oBorn.setStart(LocalTime.of(12,0));
        oBorn.setEnd(LocalTime.of(15,0));*/
        oBorn.setDescription("Olav was born.");

        Event ikeaStart = new Event(LocalDate.of(2016,5,27));
        ikeaStart.setDescription("Olav started at IKEA");

        Event workToday = new Event(LocalDate.of(2016,7,1));
        workToday.setDescription("Worked selvbetjening");
        workToday.setStart(LocalTime.of(6,0));
        workToday.setEnd(LocalTime.of(10,0));
        workToday.setDate(LocalDate.now());

        ArrayList<Event> events = new ArrayList<>();

        events.addAll(Arrays.asList(oBorn, ikeaStart, workToday));

        //write(events);

        ArrayList<Event> events2 = read();

        for(Event e : events2){
            System.out.println(e);
        }



    }

}
