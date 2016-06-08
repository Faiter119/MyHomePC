import java.util.Scanner;
import java.util.Stack;

public class tenFive { // https://www.reddit.com/r/javahelp/comments/4n0r6z/how_do_i_move_a_variable_with_values_from_one/d403fjr?context=3

    //The main takes a number and returns the factors

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.close();

        int factors = num;
        int w = 0;

        //determines how big the array should be

        while(factors != 0){
            int rCheck = num % factors;
            if( rCheck == 0) {
                w++;
            }
            factors--;
        }

        //makes array

        int[] valuesGet = new int[w];

        //finds factors

        factors = num;
        int i = 0;
        while(factors != 0){
            int rCheck = num % factors;
            if( rCheck == 0) {
                valuesGet[i] = factors;
                i++;
                //tested to see if they print out; they did
                System.out.println(factors);
            }
            factors--;
        }
        StackOfIntegers stack = new StackOfIntegers(valuesGet);

        System.out.println(stack.getStack().toString());

        //not really sure where to go at this point seeing as I have no experiance calling methods outside of the class i'm working in
    }
}
//here is where the array is pushed into a stack; if this worked I would then empty the stack back out as to produce the array in reverse order
class StackOfIntegers {

    private Stack<Integer> stack = new Stack<>();

    //I think this is pulling the array above but can't check because it isnt running

    public StackOfIntegers(int[] valuesGet){

        for(int element : valuesGet){
            stack.push(element);
        }
    }
    public Stack<Integer> getStack(){return stack;}
}