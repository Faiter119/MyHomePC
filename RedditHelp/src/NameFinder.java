import java.util.*;
import java.io.*;
public class NameFinder { // https://www.reddit.com/r/javahelp/comments/4dxmw7/arraylist_help/
    public static void main(String args[]) throws IOException {

        Scanner file = new Scanner(new File("RandomStuff/src/names.txt"));
        Scanner keyboard = new Scanner(System.in);

        file.useDelimiter(",");

        ArrayList<String> names = new ArrayList<String>();
        while (file.hasNext()) {
            names.add(file.next());
        }

        String namesArray[] = names.toArray(new String[0]);

        String longest = namesArray[0];
        for(String name : namesArray){
            if(name.length() > longest.length()) {
                longest = name;
            }
        }

        System.out.println(longest);

        String shortest = namesArray[0];
        for(String name : namesArray){
            if(name.length() < shortest.length()) {
                shortest = name;
            }
        }

        System.out.println(shortest);

        System.out.println("The ArrayList has " + names.size() + " names names.");
        System.out.println(names);


        String answer = "y";
        while(answer.equalsIgnoreCase("y")) {
            System.out.println("What name would you like to find? ");
            String i = keyboard.next();
            //i = i.toUpperCase();

            System.out.println("Did we find '" + i + "' in the document? " + names.contains(i));
            System.out.println("Search again? (Y/N)  ");
            answer = keyboard.next();
        }
    }
}