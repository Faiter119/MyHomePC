
public enum ArithmeticOperation {

    ADDITION("+"){

        public String apply(NumeralSystem system, String value0, String value1){

            String decimal0 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value0);
            String decimal1 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value1);

            return Calculation.convertNumber(NumeralSystem.DECIMAL, system, Integer.toString(Integer.parseInt(decimal0)+Integer.parseInt(decimal1)));


        }
    },
    SUBTRACTION("-"){

        public String apply(NumeralSystem system, String value0, String value1){

            String decimal0 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value0);
            String decimal1 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value1);

            return Calculation.convertNumber(NumeralSystem.DECIMAL, system, Integer.toString(Integer.parseInt(decimal0)-Integer.parseInt(decimal1)));


        }
    },
    MULTIPLICATION("*"){

        public String apply(NumeralSystem system, String value0, String value1){

            String decimal0 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value0);
            String decimal1 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value1);

            return Calculation.convertNumber(NumeralSystem.DECIMAL, system, Integer.toString(Integer.parseInt(decimal0)*Integer.parseInt(decimal1)));


        }
    },
    DIVISION("/"){

        public String apply(NumeralSystem system, String value0, String value1){

            String decimal0 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value0);
            String decimal1 = Calculation.convertNumber(system, NumeralSystem.DECIMAL, value1);

            return Calculation.convertNumber(NumeralSystem.DECIMAL, system, Integer.toString(Integer.parseInt(decimal0)/Integer.parseInt(decimal1)));


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
