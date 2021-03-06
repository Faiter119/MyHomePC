package utils;

import backend.Event;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;

public class FileManager {

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
        event.setStart(TimeUtil.parseBadlyFormattedTime("1000"));
        event.setDescription("You started using this application, good for you.");

        events.add(event);

        return events;
    }
    @SuppressWarnings("unchecked")
    public static <T> Optional<Object> read(){

        /*try {
            prop.load(utils.FileManager.class.getResourceAsStream("config.properties"));
        }catch (IOException ex){return null;}*/

        Optional<File> jarFolder = getJarFolder();

        if(!jarFolder.isPresent()) return Optional.empty();

        File storage = new File(jarFolder.get(),"storage.txt");

        System.out.println("reading? "+storage.exists()+" "+storage.isFile());

        return readFile(storage);
    }
    @SuppressWarnings("unchecked")
    public static Optional<Object> readFile(File file){

        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)){

            return Optional.of(ois.readObject());
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return Optional.empty();}

    }

    /**
     * Writes the thing to the path, deletes everything else in the file.
    public static <T extends Serializable> void write(T thing){
        try {
            prop.load(utils.FileManager.class.getResourceAsStream("config.properties"));
        }catch (IOException ex){return;}

        try(FileOutputStream fos = new FileOutputStream(prop.getProperty("storagePath"));
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(thing);

            System.out.println("Wrote "+thing);
        }
        catch (IOException | NullPointerException e){e.printStackTrace();}
    }*/

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
        if(!dir.isDirectory()) return;

        System.out.println(dir.getAbsolutePath());

        File backupFile = new File(dir.getAbsolutePath()+"/BACKUP_"+LocalDate.now().toString()+".txt");

        try {
            System.out.println(backupFile.createNewFile());
            write(backupFile, toBeWriten);

        }catch (IOException e){e.printStackTrace(); return;}
    }

    /**
     * Gets folder from where Jar / class files are ran.
     */
    public static Optional<File> getJarFolder() {

        /*String jarFilePath = utils.FileManager.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        File jarFile = new File(jarFilePath);

        String jarFolderPath = jarFile.getParent();
        File jarFolder = new File(jarFolderPath);

        if(jarFolder.isDirectory()) return jarFolder;*/

        //

        File jarFolder = new File("."); // u make yoke, 2ez4rtz

        if(jarFolder.isDirectory()) return Optional.of(jarFolder);

        return Optional.empty();

        //
    }
    public static File getJarFolderTEST() {

        String classFolderPath = FileManager.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        File file = new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().getFile());
        System.out.println("exists: "+file.exists()+"\nisFile: "+file.isFile()+"\nisDir: "+file.isDirectory()+"\nPath: "+file.getAbsolutePath());

        File classFolder = new File(classFolderPath);
        System.out.println("exists: "+classFolder.exists()+"\nisFile: "+classFolder.isFile()+"\nisDir: "+classFolder.isDirectory()+"\nPath: "+classFolder.getAbsolutePath());

        String folderPath = classFolder.getParent();
        File folder = new File(folderPath);

        System.out.println("exists: "+folder.exists()+"\nisFile: "+folder.isFile()+"\nisDir: "+folder.isDirectory()+"\nPath: :"+folder.getAbsolutePath());

        if(folder.isDirectory()) return folder;

        //
        return null;

        //
    }


    /**
     * Makes a new file named "storage.txt" in the same folder as the jar
     */
    public static Optional<File> newStorageFile(){

        Optional<File> jarFolder = getJarFolder();
        if(!jarFolder.isPresent()) return Optional.empty();

        File storageFile = new File(jarFolder.get(), "storage.txt");
        System.out.println(storageFile.getAbsolutePath());

        try {
            if(!storageFile.createNewFile()) return Optional.empty();

            write(storageFile, getDefaultEvents());

        }catch (IOException e){e.printStackTrace();}

        return Optional.of(storageFile);
    }

    public static void main(String[] args) {

        Event oBorn = new Event(LocalDate.of(1996,6,8));
        /*oBorn.setStart(LocalTime.of(12,0));
        oBorn.setEnd(LocalTime.of(15,0));*/
        oBorn.setDescription("Olav was born.");

       /* backend.Event ikeaStart = new backend.Event(LocalDate.of(2016,5,27));
        ikeaStart.setDescription("Olav started at IKEA");

        backend.Event workToday = new backend.Event(LocalDate.of(2016,7,1));
        workToday.setDescription("Worked selvbetjening");
        workToday.setStart(LocalTime.of(6,0));
        workToday.setEnd(LocalTime.of(10,0));
        workToday.setDate(LocalDate.now());

        ArrayList<backend.Event> events = new ArrayList<>();

        events.addAll(Arrays.asList(oBorn, ikeaStart, workToday));

        //write(events);

        ArrayList<backend.Event> events2 = read();

        for(backend.Event e : events2){
            System.out.println(e);
        }*/



        //System.out.println(utils.FileManager.getJarFolder());
        //System.out.println(newStorageFile());

        System.out.println(FileManager.getJarFolderTEST());

        //utils.FileManager.newStorageFile();



    }
}
