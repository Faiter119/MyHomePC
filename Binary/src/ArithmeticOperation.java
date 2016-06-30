
public enum ArithmeticOperation {

    ADDITION("+"){

        public String apply(NumeralSystem system, String value0, String value1){

            String decimal0 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value0);
            String decimal1 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value1);
            try {

                return Calculation.convertNumber(NumeralSystem.DECIMAL, system, Integer.toString(Integer.parseInt(decimal0)+Integer.parseInt(decimal1)));

            } catch (NumberFormatException e) {
                return "Not a number";
            }
        }
    },
    SUBTRACTION("-"){

        public String apply(NumeralSystem system, String value0, String value1){

            String decimal0 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value0);
            String decimal1 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value1);

            try{
            return Calculation.convertNumber(NumeralSystem.DECIMAL, system, Integer.toString(Integer.parseInt(decimal0)-Integer.parseInt(decimal1)));
            } catch (NumberFormatException e) {
                return "Not a number";
            }

        }
    },
    MULTIPLICATION("*"){

        public String apply(NumeralSystem system, String value0, String value1){

            String decimal0 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value0);
            String decimal1 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value1);
            try{
                return Calculation.convertNumber(NumeralSystem.DECIMAL, system, Integer.toString(Integer.parseInt(decimal0)*Integer.parseInt(decimal1)));
            } catch (NumberFormatException e) {
                return "Not a number";
            }


        }
    },
    DIVISION("/"){

        public String apply(NumeralSystem system, String value0, String value1){

            String decimal0 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value0);
            String decimal1 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value1);
            try{
                return Calculation.convertNumber(NumeralSystem.DECIMAL, system, Integer.toString(Integer.parseInt(decimal0)/Integer.parseInt(decimal1)));
            } catch (NumberFormatException e) {
                return "Not a number";
            }


        }
    };

    private String operator;

    ArithmeticOperation(String operator){
        this.operator = operator;
    }

    public String toString() {
        return operator;
    }
    public abstract String apply(NumeralSystem system, String v0, String v1);

}
