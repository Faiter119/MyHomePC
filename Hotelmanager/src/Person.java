import java.io.Serializable;

public class Person implements Serializable{

    private final String name;
    private final String id; // String cause you cant use 0-padding in long

    public Person(String name, String id){

        this.name = name;
        this.id = id;

    }

    public String getName(){ return name;}
    public String getID(){ return id;}

    public String toString(){ // TODO: 16.05.2016 StringBuilder
        return "Name: "+name+" - ID: "+id;
    }

    public static void main(String[] args){

        Person person = new Person("Olav Reppe Husby", "08069642579");

        System.out.println(person);

    }

}
