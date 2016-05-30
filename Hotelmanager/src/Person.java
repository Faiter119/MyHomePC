import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable{

    private final String name;
    private final String id; // String cause you cant use 0-padding in long

    public Person(String name, String id){

        this.name = name;
        this.id = id;

    }

    public String getName(){ return name;}
    public String getID(){ return id;}

    public String toString(){ return "Name: "+name+" - ID: "+id; }


    public boolean equals(Person p) {

        if(p == null) return false;
        if(this == p) return true;

        return id.equals(p.getID());
    }

    public int hashCode() { // "Indexen" i en hash-table, sykt fordi du søker raskt osv
        int hash = 3; // Prime non-zero
        hash = Objects.hashCode(this);
        return 0;
    }

    public static void main(String[] args){

        Person person = new Person("Olav Reppe Husby", "08069642579");
        Person person1 = new Person("Per Bjarte","934567803");

        System.out.println(person.hashCode());

    }
}
