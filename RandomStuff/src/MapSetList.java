import java.util.HashMap;
import java.util.Map;

/**
 * Created by Faiter119 on 30.04.2016.
 */
public class MapSetList {


    public static void main(String[]args){

        Map<Integer, String> map = new HashMap<>();

        map.put(1,"First");
        map.put(5,"Fifth");
        map.get(1);
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("First"));
        System.out.println(map.toString());

    }

}
