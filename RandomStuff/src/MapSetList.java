import java.util.*;

/**
 * Created by Faiter119 on 30.04.2016.
 */
public class MapSetList {


    public static void main(String[]args){

        /*Map<Integer, String> map = new HashMap<>();

        map.put(1,"First");
        map.put(5,"Fifth");
        map.get(1);
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("First"));
        System.out.println(map.toString());*/

        Queue<Integer> queue = new PriorityQueue<>();

        queue.offer(5); // offer > add
        System.out.println(queue.peek()); // peek > element
        System.out.println(queue.poll());
        System.out.println(queue.peek());


        //

        /*Stack<Integer> stack = new Stack<>(); // Deprecated
        stack.push(5);
        stack.peek();
        stack.pop();
        stack.empty();
        stack.size();*/

        Deque<Integer> deque = new ArrayDeque<>(); // Better stack than Stack, better Queue than LinkedLisT
        deque.add(5);
        deque.peek();
        deque.poll(); // Queue
        deque.pop(); // Stack


    }

}
