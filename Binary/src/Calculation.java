import java.util.Scanner;

public class Calculation {

    // There was a better way! :D
    public static String convertNumber(NumeralSystem from, NumeralSystem to, String value){

        try {

            int decimal = Integer.parseInt(value, from.base()); // parseInt VS valueOf : parse gives int, valueOf gives Integer

            return Integer.toString(decimal, to.base()).toUpperCase();

        }
        catch (NumberFormatException e){return "Not a number";}

    }

    public static String calculate(ArithmeticOperation operation, NumeralSystem system, String value0, String value1){

        return operation.apply(system, value0, value1);

    }

    public static void main(String[] args) {

     /*   Scanner scanner = new Scanner(System.in);
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

        // System.out.println(fromTo("Binary","Hexadecimal","11111"));

        System.out.println(convertNumber(NumeralSystem.DECIMAL,NumeralSystem.BINARY,"15"));

        System.out.println(NumeralSystem.BABYLONIAN.toString());
        System.out.println(NumeralSystem.parse("decimal"));*/


        System.out.println(calculate(ArithmeticOperation.DIVISION,NumeralSystem.DECIMAL, "10","3"));

        // 10 = 1*10^1 + 0*10^0
        // 9 = 9*10^0 = 9
        // 29 = 2*10^1 = 20 + 9 = 29
        // 16^1

    }
}
