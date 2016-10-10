import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Olav Husby on 10.10.2016.
 */
public class ArrayStack<T> implements Iterable<T> {

    private T[] stackArray;
    private int size = 0;

    private static final int INITIAL_SIZE = 16;

    public ArrayStack(int size) {

        stackArray = (T[]) new Object[size];

    }

    public ArrayStack() {
        this(INITIAL_SIZE);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T o) {
        ensureCapasity();
        stackArray[size++] = o;

    }

    public T pop() {
        if (isEmpty()) return null;
        T thing = stackArray[size - 1];
        stackArray[size - 1] = null;
        size--;

        return thing;
    }

    public T peek() {
        if (isEmpty()) return null;
        ensureCapasity();
        return stackArray[size - 1];
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = size-1;

            @Override
            public boolean hasNext() {
                return index != 0;
            }

            @Override
            public T next() {
                return stackArray[index--];
            }
        };
    }

    public Stream<T> stream() { // Only a bit ghetto
        T[] reverseTable = (T[]) new Object[size];
        int otherIndex = size-1;
        for (int i = 0; i < size; i++) {

            reverseTable[i] = stackArray[otherIndex--];

        }
        return Arrays.stream(reverseTable);
    }

    private void ensureCapasity() {

        int length = stackArray.length;

        if (size >= length) {
            stackArray = Arrays.copyOf(stackArray, length << 1);
        }
        else if (size < length >> 1) {
            stackArray = Arrays.copyOf(stackArray, length >> 1);

        }

    }

    public static void main(String[] args) {

        ArrayStack<String> stack = new ArrayStack<>();
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            stack.push(String.valueOf(i));

            if (Math.random() < 0.5) stack.push("Random " + counter++);
        }

       /* while (stack.peek() != null) {
            System.out.println(stack.pop());
        }*/
        /*stack.forEach(System.out::println);

        for (String str : stack) {
            System.out.println(str);
        }*/

        stack.stream().forEach(System.out::println);
        System.out.println(stack.stream().filter(s -> s.length() > 2).collect(Collectors.toList()));

    }


}
