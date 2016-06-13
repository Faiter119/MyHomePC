import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Person implements Serializable, Comparable<Person>{

    public enum Sex{

        MALE,FEMALE;

        public String toString() {
            String str = super.toString();
            return str.charAt(0) + str.substring(1,str.length()).toLowerCase();
        }
    }

    private String name;
    private LocalDate birth;
    private Sex sex;

    public Person(String name, Sex sex, LocalDate birth) {

        this.name = name;
        this.birth = birth;
        this.sex = sex;

    }

    public String name(){       return name;}
    public LocalDate birth(){   return birth;}
    public Sex sex(){           return sex;}
    public int age(){           return Period.between(birth, LocalDate.now()).getYears();}

    public String toString(){   return name+" : "+sex+" : "+birth; }

    public boolean equals(Person p) {

        if (!name.equals(p.name())) return false;
        if (sex != p.sex()) return false;
        if (age() != p.age()) return false;

        return true;
    }

    public int compareTo(Person o) {
        return name.compareTo(o.name());
    }

    public int hashCode() { // "Indexen" i en hash-table, sykt fordi du søker raskt osv

        int value = 0;

        for(int i=0; i<name.length() ; i++) {
            value += name.charAt(i);
        }
        value += age();
        value += sex.ordinal();

        return value;
    }


    public static void main(String[] args){

        /*long start = System.currentTimeMillis();*/

        List<Person> persons = Arrays.asList(
                new Person("Olav Reppe Husby", Person.Sex.MALE, LocalDate.of(1996,6,8)),
                new Person("Per Bjarte", Person.Sex.MALE, LocalDate.of(1990,1,1)),
                new Person("Lise Saus", Person.Sex.FEMALE, LocalDate.of(1986,2,3)),
                new Person("Gunnar Gnaus", Person.Sex.MALE, LocalDate.of(1995,2,9)),
                new Person("Valentina Kerman", Person.Sex.FEMALE, LocalDate.of(1996,5,25)),
                new Person("Larse Mat",Sex.MALE, LocalDate.of(1996,1,1)),
                new Person("Trude Reppe",Sex.FEMALE, LocalDate.of(1962,5,26)),
                new Person("Eldbjørn Husby", Sex.MALE, LocalDate.of(1960,2,13))
        );

        /*for (Person p : persons) {
            System.out.println(p + " \t\t- "+p.hashCode()+" "+p.age());
        }*/

        /*long end = System.currentTimeMillis();
        System.out.println("\n"+(end-start));*/

        Person[] array = persons.stream()
                .filter((Person p)->(p.age() >= 20))
                .filter(p->p.sex()==Sex.MALE)
                .sorted((p0,p1)->(-Integer.compare(p0.age(),p1.age())))
                .toArray(Person[]::new);

        for(Person o : array){
            System.out.println(o);
        }
    }
}
