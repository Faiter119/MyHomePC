import javafx.util.converter.LocalTimeStringConverter;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Properties;

public class Manager {

    private static Properties prop = new Properties();

    public static void setPath(String newPath){
        if(!newPath.contains(".txt")){
            newPath += "/storage.txt";
        }
        prop.setProperty("storagePath", newPath);
    }
    public static ArrayList<Event> getDefaultEvents(){

        ArrayList<Event> events = new ArrayList<>();

        Event event = new Event(LocalDate.now());
        event.setStart(LocalTime.parse(new LocalTimeStringConverter().toString(LocalTime.now())));
        event.setDescription("You started using this application, good for you.");

        events.add(event);

        return events;
    }
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T read(){

        /*try {
            prop.load(Manager.class.getResourceAsStream("config.properties"));
        }catch (IOException ex){return null;}*/

        File jarFolder = getJarFolder();

        File storage = new File(jarFolder,"storage.txt");

        return readFile(storage);
    }
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T readFile(File file){

        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)){

            return (T) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e){return null;}

    }

    /**
     * Writes the thing to the path, deletes everything else in the file.
     */
    public static <T extends Serializable> void write(T thing){
        try {
            prop.load(Manager.class.getResourceAsStream("config.properties"));
        }catch (IOException ex){return;}

        try(FileOutputStream fos = new FileOutputStream(prop.getProperty("storagePath"));
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(thing);

            System.out.println("Wrote "+thing);
        }
        catch (IOException | NullPointerException e){e.printStackTrace();}
    }

    public static <T extends Serializable> void write(File file, T thing){

        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(thing);

            System.out.println("Wrote "+thing);
        }
        catch (IOException | NullPointerException e){e.printStackTrace();}
    }

    public static <T extends Serializable> void writeBackup(File dir, T toBeWriten){

        if(toBeWriten == null) return;

        System.out.println(dir.getAbsolutePath());

        File backupFile = new File(dir.getAbsolutePath()+"/BACKUP_"+LocalDate.now().toString()+".txt");

        try {
            System.out.println(backupFile.createNewFile());
        }catch (IOException e){e.printStackTrace(); return;}


        write(backupFile, toBeWriten);

    }

    /**
     * Gets folder from where Jar / class files are ran.
     */
    public static File getJarFolder() {

        /*String jarFilePath = Manager.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        File jarFile = new File(jarFilePath);

        String jarFolderPath = jarFile.getParent();
        File jarFolder = new File(jarFolderPath);

        if(jarFolder.isDirectory()) return jarFolder;*/

        //

        File jarFolder = new File("."); // u make yoke, 2ez4rtz

        if(jarFolder.isDirectory()) return jarFolder;

        return null;

        //
    }

    public static File newStorageFile(){

        File jarFolder = getJarFolder();
        if(jarFolder == null) return null;

        File storageFile = new File(jarFolder, "storage.txt");
        System.out.println(storageFile.getAbsolutePath());

        try {
            if(!storageFile.createNewFile()) return null;

            write(storageFile, getDefaultEvents());

        }catch (IOException e){e.printStackTrace();}

        return storageFile;
    }

    public static void main(String[] args) {

        Event oBorn = new Event(LocalDate.of(1996,6,8));
        /*oBorn.setStart(LocalTime.of(12,0));
        oBorn.setEnd(LocalTime.of(15,0));*/
        oBorn.setDescription("Olav was born.");

       /* Event ikeaStart = new Event(LocalDate.of(2016,5,27));
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
        }*/



        System.out.println(Manager.getJarFolder());
        System.out.println(newStorageFile());

        //Manager.newStorageFile();



    }
}
