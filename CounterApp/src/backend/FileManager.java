package backend;

import java.io.*;
import java.util.Optional;

public class FileManager {

    public static  Optional<File> getWorkingDirectory(){

        File jarFolder = new File(".");

        System.out.println(jarFolder.isDirectory());

        return Optional.of(jarFolder);
    }

    public static <T extends Serializable> void write(T item){
        getWorkingDirectory().ifPresent( (file) -> writeTo(file, item));
    }

    public static <T extends Serializable> void writeTo(File file, T item){

        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(item);

        } catch (IOException e){e.printStackTrace();}
    }

    public static <T extends Serializable> Optional<T> readFrom(File file){

        try(FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            return Optional.of( (T) objectInputStream.readObject());

        }catch (IOException | ClassNotFoundException e){return Optional.empty();}

    }


    public static void main(String[] args) {

        getWorkingDirectory().ifPresent((file -> System.out.println(file.toPath())));

    }

}
