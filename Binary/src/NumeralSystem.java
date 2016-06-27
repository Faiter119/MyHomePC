public enum NumeralSystem {

    BINARY(2),
    QUINARY(5),
    OCTAL(8),
    DECIMAL(10),
    DUODECIMAL(12),
    HEXADECIMAL(16),
    MAYA(20),
    BABYLONIAN(60);

    private int base;

    NumeralSystem(int base){
        this.base = base;
    }

    public int base(){return base;}

    public static NumeralSystem parse(String number){
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