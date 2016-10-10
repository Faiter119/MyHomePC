import java.util.ArrayList;
import java.util.Arrays;

/**
 * Generic number-array with a lightweight underlaying array
 * @param <E> any Number
 */
public class Array<E> {

    private E[] numberArray;

    private final static int DEFAULT_CAPACITY = 10;
    private int elements = 0;

    @SuppressWarnings("unchecked")
    public Array(int size){
        numberArray =  (E[]) new Object[size];
        // ArrayList
    }
    public Array(){
        this(DEFAULT_CAPACITY);
    }

    public int size(){return elements;}
    public void add(E element){
        if (isFull()) extend();
        numberArray[elements++] = element;
    }
    public void add(E... elements){
        for (E e : elements) add(e);
    }
    public E get(int index){
        elements--;
        E element = numberArray[index];
        numberArray[index] = null;
        return element;
    }

    public void sort(){ // Maybe implement own for fun
        trim();
        Arrays.sort(numberArray);
    }
    public void reverse(){
        trim();
        for (int i = 0; i < size()/2; i++) {
            numberArray[size()-i-1] = numberArray[i];
        }
        for (int i = size()-1; i > 0; i--) {
            numberArray[i] = numberArray[size()-i];
        }

    }

    public String toString(){
        trim();
        return Arrays.toString(numberArray);
    }

    // Private methods
    private boolean isFull(){
        return size() == elements;
    }
    private void trim(){
        numberArray = Arrays.copyOf(numberArray, elements);
    }
    private void extend(){
        numberArray = Arrays.copyOf(numberArray, elements+DEFAULT_CAPACITY);
    }
    private void removeNulls(){

        int nullCounter = 0;

        for (int i = 0; i < size(); i++) if (numberArray[i] == null) nullCounter++;

       // E[] newArray = new Object[e];
    }
    private void removeIndex(int index){

        if (index == 0) numberArray = Arrays.copyOf(numberArray, size());

      //  for (int i = 0; i < ; i++) {

      //  }

    }


    public static void main(String[] args) {

        Array<Integer> integerArray = new Array<>();

        integerArray.add(5,6,7,1,4);
        integerArray.add(2,5,7,9,6);
        System.out.println(integerArray);

        integerArray.sort();
        System.out.println(integerArray);

        integerArray.reverse();
        System.out.println(integerArray);




    }
}
