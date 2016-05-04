import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generics<T> { // Generic class

    public static <T extends Number> int sum(T...a){
        int sum = 0;

        for(Number b : a){
            sum += b.intValue();
        }

        return sum;
    }

    /**
     * @return A new String that is the original String reversed
     */
    public static String reverse(String input){

        String[] table = input.split("");
        String out = "";

        for(int i=table.length-1; i>=0; i--){
            out += table[i];
        }

        return out;
    }

    public static void arrayReverse(int[] a){

        int[] b = new int[a.length];
        for(int i = 0; i<a.length; i++){
            b[i] = a[i];
        }

        int index = 0;
        for(int i = a.length-1; i>=0; i++){

            System.out.println(index + " "+i + " - "+b[i]+"\n"+Arrays.toString(a)+" - "+ Arrays.toString(b));

            a[index] = b[i];
            index++;
        }
    }
    public static <T> List<T> asList(T first, T ... rest){

        List<T> list = new ArrayList<>(); // Ikke prøv å bruk []s, det er rassert

        list.add(first); // fucke sæ ikke hvis varargsn e tom

        for(T element : rest){
            list.add(element);
        }

        return list;
    }

    public static void main(String[]args){

        List<?> list = asList("Olav","Har",10,"Skills"); // <?>

        System.out.println(list.getClass());

        System.out.println(asList(list)); // Forskjellige ting i listen? op

        for(Object element : list){
            System.out.println(element.getClass());
        }

    }
}
