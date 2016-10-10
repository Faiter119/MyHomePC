import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by OlavH on 10-Oct-16.
 */
public class ArrayQueue<T> implements Iterable<T>{

    private static final int INITIAL_SIZE = 127;

    private T[] queueArray;


    private int size = 0;


    public ArrayQueue(int size) {
        queueArray = (T[]) new Object[size];
    }

    public ArrayQueue() {
        this(INITIAL_SIZE);
    }

    public int size() {
        return size;
    }
    protected int length(){return queueArray.length;}
    /**
     * Puts element at the back of the queue
     *
     * @param thing
     */
    public void offer(T thing) {

        ensureSize();

        queueArray[size] = thing;
        size++;
    }

    /**
     * Retrieves element from the front of the queue
     *
     * @return
     */
    public T poll() {
        ensureSize();
        T thing = queueArray[0];

        System.arraycopy(queueArray, 1, queueArray, 0, queueArray.length-1); // Shifter arrayen 1 til venstre

        size--;

        return thing;
    }

    /**
     * Looks at the front of the queue
     *
     * @return
     */
    public T peek() {
        ensureSize();
        return queueArray[0];
    }

    private void ensureSize() {

        //System.out.println("Ensure: " + Arrays.toString(queueArray));

        if (size > queueArray.length-1) {
            System.out.println("\tIncreasing size");

            queueArray = Arrays.copyOf(queueArray, queueArray.length << 1);

        }
        else if (size < queueArray.length >> 1){
            System.out.println("\tDecreasing size");
            queueArray = Arrays.copyOf(queueArray, queueArray.length >> 1);


        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;
            int thisSize = size;
            @Override
            public boolean hasNext() {
                return thisSize > 0;
            }

            @Override
            public T next() {
                thisSize--;
                return queueArray[i++];
            }
        };
    }
    public Stream<T> stream(){

        return Arrays.stream(queueArray,0, size);
    }


    public static void main(String[] args) {

        ArrayQueue<String> stringArrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 100; i++) {
            stringArrayQueue.offer(String.valueOf(i));
        }

        /**
         * Now you can use fore and streams with the queue because iterable
         */
        /*stringArrayQueue.forEach(System.out::println);

        for (String str : stringArrayQueue) {
            System.out.println(str);
        }*/

        stringArrayQueue.stream().forEach(System.out::println);

        /*int c = 0;
        while (stringArrayQueue.peek() != null) {
            System.out.println(stringArrayQueue.pop());
            System.out.println(Arrays.toString(stringArrayQueue.queueArray));
            System.out.println("Size: "+stringArrayQueue.size());
            System.out.println("Length: "+stringArrayQueue.length());

            //if (Math.random() < 0.5) stringArrayQueue.push("random: "+c++);
        }
        System.out.println(Arrays.toString(stringArrayQueue.queueArray));*/
        // assert 1==0; // Må bruke -ea, samme som å kaste exception ish

        // System.out.println(Arrays.toString(stringArrayQueue.queueArray));

    }
}
