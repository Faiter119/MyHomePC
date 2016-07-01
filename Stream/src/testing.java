/**
 * Trying out java.util.stream
 */

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Testing {


    public static void main(String[] args) {


        long start = System.currentTimeMillis();

        List<Person> persons = Arrays.asList(
                new Person("Olav Reppe Husby", Person.Sex.MALE, LocalDate.of(1996,8,6)),
                new Person("Per Bjarte", Person.Sex.MALE, LocalDate.of(1990,1,1)),
                new Person("Lise Saus", Person.Sex.FEMALE, LocalDate.of(1986,2,3)),
                new Person("Gunnar Gnaus", Person.Sex.MALE, LocalDate.of(1995,2,9)),
                new Person("Valentina Kerman", Person.Sex.FEMALE, LocalDate.of(1996,5,25))
        );

        //*
        persons.stream()
                .filter((Person p) -> p.getSex() == Person.Sex.MALE)
                .filter((Person p) -> p.getAge() > 0)
                .map(Person::getName)
                .forEach(System.out::println);
        /*/
        for (Person p : persons) {
            System.out.println(p);
        }
        //*/

        long end = System.currentTimeMillis();
        System.out.println("\nTime : "+ (end-start));

        int[] ints = {1,5,3,5,7,2,5,3,5,6,4,8,6,6,5,8,3,8,37,5,7,8,9,2,123,35,6,7,3,2,1,6,57,5,8,3,3,47,46,23,2,3,2,4,5,4,3,5,6,7,234,6,34,34,6,345,34,};
        IntStream stream = Arrays.stream(ints);

        stream
        .filter(Testing::isEven)
        .forEach((int i) -> System.out.print(i+" "));

    }
    public static boolean isEven(int nr){
        return nr % 2 == 0;
    }
    public static boolean isOdd(int nr){
        return nr % 2 != 0;
    }
}
