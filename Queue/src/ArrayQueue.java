import java.util.Arrays;

/**
 * Created by OlavH on 10-Oct-16.
 */
public class ArrayQueue<T> {

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
        else if (size < queueArray.length-1 >> 1){
            System.out.println("\tDecreasing size");
            queueArray = Arrays.copyOf(queueArray, queueArray.length >> 1);


        }

    }

    public static void main(String[] args) {

        ArrayQueue<String> stringArrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 100; i++) {
            stringArrayQueue.offer(String.valueOf(i));
        }

        int c = 0;
        while (stringArrayQueue.peek() != null) {
            System.out.println(stringArrayQueue.poll());
            System.out.println(Arrays.toString(stringArrayQueue.queueArray));

            //if (Math.random() < 0.5) stringArrayQueue.offer("random: "+c++);
        }
        System.out.println(Arrays.toString(stringArrayQueue.queueArray));
        // assert 1==0; // Må bruke -ea, samme som å kaste exception ish

        // System.out.println(Arrays.toString(stringArrayQueue.queueArray));



    }


}
