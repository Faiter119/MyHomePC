import java.util.Scanner;

public class Calculation {

    public static String fromTo(String from, String to, String value){
    // Swear to god there must be a better way..
        switch (from){
            case "Binary":
                switch (to){
                    case "Binary":
                        return isBin(value) ? value : "Not a number";
                    case "Decimal":
                        return binToDec(value);
                    case "Hexadecimal":
                        return binToHex(value);
                    default:
                        return "Not valid";
                }
            case "Decimal":
                switch (to){
                    case "Binary":
                        return decToBin(value);
                    case "Decimal":
                        return isDec(value) ? value : "Not a number";
                    case "Hexadecimal":
                        return decToHex(value);
                    default:
                        return "Not valid";
                }
            case "Hexadecimal":
                switch (to){
                    case "Binary":
                        return hexToBin(value);
                    case "Decimal":
                        return hexToDec(value);
                    case "Hexadecimal":
                        return isHex(value) ? value : "Not a number";
                    default:
                        return "Not valid";
                }
            default:
                return "Not valid";
        }
    }

    public static boolean isBin(String bin){
        try{
            Integer.parseInt(bin,2);
            return true;
        }catch (NumberFormatException e){return false;}
    }
    public static boolean isDec(String dec){
        try{
            Integer.parseInt(dec);
            return true;
        }catch (NumberFormatException e){return false;}
    }
    public static boolean isHex(String hex){
        try{
            Integer.parseInt(hex,16);
            return true;
        }catch (NumberFormatException e){return false;}
    }

    public static String binToDec(String bin){
        try {
            return Integer.toString(Integer.parseInt(bin,2));
        } catch (NumberFormatException e){return "Not a number";}
    }
    public static String binToHex(String bin){
        try {
            return Integer.toHexString(Integer.parseInt(bin,2));
        } catch (NumberFormatException e){return "Not a number";}
    }
    public static String hexToDec(String hex){
        try {
            return Integer.toString(Integer.parseInt(hex,16));
        } catch (NumberFormatException e){return "Not a number";}
    }
    public static String hexToBin(String hex){
        try {
            return Integer.toBinaryString(Integer.parseInt(hex,16));
        } catch (NumberFormatException e){return "Not a number";}
    }
    public static String decToBin(String dec){
        try {
            return Integer.toBinaryString(Integer.parseInt(dec));
        } catch (NumberFormatException e){return "Not a number";}
    }
    public static String decToHex(String dec){
        try {
            return Integer.toHexString(Integer.parseInt(dec));
        } catch (NumberFormatException e){return "Not a number";}
    }


    public static String toBinaryString(String input){

        try{
            return Integer.toBinaryString(Integer.parseInt(input));
        }
        catch (NumberFormatException e){
            return "Not a number.";
        }

    }

    public static void main(String[] args) {

      /*  Scanner scanner = new Scanner(System.in);
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

        }while (!input.equalsIgnoreCase("end"));*/

        System.out.println(fromTo("Binary","Hexadecimal","11111"));
    }
}
