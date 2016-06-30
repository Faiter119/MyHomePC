public enum NumeralSystem {

    BINARY(2),
    QUINARY(5),
    OCTAL(8),
    DECIMAL(10),
    DUODECIMAL(12),
    HEXADECIMAL(16);

    private int base;

    NumeralSystem(int base){
        this.base = base;
    }

    public int base(){return base;}

    // Not used, but handy?
    public static NumeralSystem parse(String number){
        if(number.contains("(")){
            return valueOf(number.toUpperCase().substring(0,number.indexOf("(")).trim()); // cuts off the "(base)" part
        }
        return valueOf(number.toUpperCase());
    }


    // BINARY becomes Binary (2).
    public String toString(){

        String thisNumber = super.toString();

        return thisNumber.charAt(0)+thisNumber.toLowerCase().substring(1)+" ("+base+")";
    }
}