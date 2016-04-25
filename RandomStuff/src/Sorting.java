import java.util.*;

public class Sorting {

    public static void main(String[]args){

        String in = "Java is love Java is life. Get swagged on.\nHello";

        String scanned = new Scanner(in).useDelimiter("tgvyigyhuftvfgvghbhfc").next();
        System.out.println(scanned);


        Map map = getCountPerLetter(in);

        System.out.println(map.toString());

        System.out.println(map.containsKey('å'));

        map.keySet();

        Collection collection = map.values();

    }

    /**
     * Maps the chars in the string to the amount of times they are used in the String
     */
    public static Map<Character,Integer> getCountPerLetter(String input){

        Map<Character, Integer> map = new HashMap<>();

        char[] chars = input.toCharArray();

        for(char element: chars){

            if(map.containsKey(element)){
                int value = map.get(element);
                map.replace(element,++value);
            }
            else {
                map.put(element,1);
            }
        }
        return map;
    }
}
