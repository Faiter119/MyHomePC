import java.util.Scanner;

public class Calculation {

    public enum NumberalSystem {

        BINARY(2),
        QUINARY(5),
        OCTAL(8),
        DECIMAL(10),
        DUODECIMAL(12),
        HEXADECIMAL(16),
        MAYA(20),
        BABYLONIAN(60);

        private int base;

        NumberalSystem(int base){
            this.base = base;
        }

        public int base(){return base;}

        public static NumberalSystem parse(String number){
            if(number.contains("(")){
                return valueOf(number.toUpperCase().substring(0,number.indexOf("("))); // cuts off the "(base)" part
            }
            return valueOf(number.toUpperCase());
        }

        public static String[] valuesString(){
            String[] out = new String[values().length];

            for(int i=0; i<values().length; i++){
                out[i] = values()[i].toString();
            }
            return out;
        }

        public String toString(){

            String thisNumber = super.toString();

            return thisNumber.charAt(0)+thisNumber.toLowerCase().substring(1)+"("+base+")";
        }
    }

    // There was a better way! :D
    public static String convertNumber(int fromBase, int toBase, String value){

        try {

            int decimal = Integer.parseInt(value, fromBase); // parseInt VS valueOf : parse gives int, valueOf gives Integer

            return Integer.toString(decimal, toBase);

        }
        catch (NumberFormatException e){return "Not a number";}

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

        // System.out.println(fromTo("Binary","Hexadecimal","11111"));

        System.out.println(convertNumber(10,16,"15"));

        System.out.println(NumberalSystem.BABYLONIAN.toString());
        System.out.println(NumberalSystem.parse("decimal"));
    }
}
