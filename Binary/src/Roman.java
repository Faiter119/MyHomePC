
public class Roman {

    public enum RomanNumeral{
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private int nr;
        RomanNumeral(int nr){
            this.nr = nr;
        }
        int getValue(){return nr;}

        static RomanNumeral valueOf(int nr){

            for(RomanNumeral numeral : values()){
                System.out.println(numeral);

                if(numeral.getValue() == nr) return numeral;
            }
            return null;
        }
    }

    public static String toRoman(int digit){

        if(getDigits(digit) > 1) return null;

        try {
            RomanNumeral num = RomanNumeral.valueOf(digit);
            if (num != null) return num.toString();


        } catch (IllegalArgumentException e){System.out.println(":p");}

        return "fail";
    }

    public static String decimalToRoman(int nr){
        String out = "";

        /*while (nr != 0){

        }*/

        while (nr --> 0) System.out.println(nr);

        return out;
    }
    public static int getDigits(int nr){
        return Integer.toString(nr).length();
    }
    public static int getNumberAt(int nr, int index){

        //815 -> 8 1 5

        int out = nr;

        int digits = getDigits(nr);
        if(index > digits-1 || index < 0) return -1;

        for(int i=index; i<digits-1; i++){ // -1 bacause you want to save the digit
            out/=10; // /10 = discard right // %10 = get right

        }
        return (out%10);
    }
    public static int getNumberValueAt(int nr, int index){

        //815 -> 800 10 5

        int digits = getDigits(nr);
        int number = getNumberAt(nr, index);

        if(number == -1) return -1;

        return number * (int) Math.pow(10,(digits-index)-1);
    }

    public static void main(String[] args) {

        int nr = 8345;
        //decimalToRoman(5);
        System.out.println(getNumberAt(nr, 0));

        System.out.println(getNumberValueAt(nr, 0));

        System.out.println(RomanNumeral.valueOf(100));

        System.out.println(toRoman(100));
    }

}
