import java.util.Scanner;

public class Binary {

    public static String toBinaryString(String input){

        try{
            return Integer.toBinaryString(Integer.parseInt(input));
        }
        catch (NumberFormatException e){
            return "Not a number.";
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type \"end\" to end.");

        String input;

        do {

            System.out.println("Input a number: ");
            input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                System.out.println(input + " in binary is " + Integer.toBinaryString(number));
            }
            catch (NumberFormatException e) {
                System.out.println("\""+input+"\"" + " is not a valid number. Number must be 32 bit integer");
            }

        }while (!input.equalsIgnoreCase("end"));
    }
}
