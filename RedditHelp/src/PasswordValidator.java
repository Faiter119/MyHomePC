import java.util.Scanner;

public class PasswordValidator {

    public static void oneChoice() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String choose = input.nextLine();

    }

    public static boolean checkPassword(String password) {
        boolean checkPassword = true;

        if (password.length() >= 8) {

            int numberOfDigit;
            numberOfDigit = 0;

            int numberOfSymbol;
            numberOfSymbol = 0;

            int numberOfLetter;
            numberOfLetter = 0;

            for (int index = 0; index < password.length(); index++) {
                if ((checkForDigit(password.charAt(index)) && checkForLetter(password.charAt(index))) && checkForSpecial(password.charAt(index))) {
                    if (checkForDigit(password.charAt(index))) {
                        numberOfDigit++;
                    }

                }
                else {
                    checkPassword = false;
                }
            }

            if (numberOfDigit < 1 || numberOfLetter < 1 || numberOfSymbol < 1) {
                checkPassword = false;
            }

        }
        else {
            checkPassword = false;
        }

        return checkPassword;

    }

    public static boolean checkForLetter(char letter) {

        return ((letter <= 'z' && letter >= 'a') || (letter <= 'Z' && letter >= 'A'));

    }

    public static boolean checkForDigit(char digit) {
        return (digit <= '9' && digit >= '0');
    }

    public static boolean checkForSpecial(char symbol) {

        return (symbol == '@' && symbol == '#' && symbol == '&' && symbol == '!' && symbol == '$' && symbol == '%' && symbol == '^' && symbol == '*' && symbol == '+');
    }
    public static void main(String[] args) {
        boolean quit = false;
        Scanner getInput = new Scanner(System.in);

        do {
            System.out.print("\n\n Choose (1-3): \n \t (1) Enter \n \t " + "(2) Process \n \t " + "(3) Quit \n\n \t Your option: ");
            String choose = getInput.next();
            char choice = choose.charAt(0);
            switch (choice) {
                case '1':
                    oneChoice();
                    break;
                case '2':
                    if (checkPassword(choose)) System.out.println("Valid Password");
                    else System.out.println("Invalid Password");
                    break;
                case '3':
                    quit = true;
                    break;

                default:
                    System.out.println("\n\n Not a valid option - Choose again!!!! \n\n");
            }
        } while (quit == false);

    }
}