import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Calculation {

    /**
     * @return array with the percentage distribution of the original values, at the same indexes.
     * Rounded to 2 decimals with 0.02 accuracy
     */
    public static double[] getPercentageDistribution(int[] values){

        int total = Arrays.stream(values).sum();

        double[] out = new double[values.length];

        for(int i=0; i<values.length; i++){

            double exact = percentageOfTotal(total,values[i]);

            double rounded = round(exact);

            out[i] = rounded;

        }
        //System.out.println(Arrays.stream(out).sum());

        return out;

    }


    private static double percentageOfTotal(int total, int amount){

        return (double) 100/total * amount;

    }

    /**
     * Rounds to 2 decimals
     */
    public static double round(double number){

        int nr = (int) ((number*1000));

        return nr / 1000d;
    }
    public static void printWithTitles(String[] titles, double[] values, double[] ... moreRows ){

        if(titles.length == values.length){

            System.out.print(" ");
            for(int i=0; i<titles.length; i++) {
                if (i == titles.length - 1) {
                    System.out.print("__________");
                }
                else {
                    System.out.print("___________");
                }
            }
            System.out.print("\n|");

            for(int i=0; i<titles.length; i++){

                String title = titles[i];
                double value = values[i];

                System.out.print(String.format("%-10s",title)+"|");

            }

            System.out.print("\n|");

            for(int i=0; i<titles.length; i++){

                double value = values[i];
                DecimalFormat df = new DecimalFormat("0.00");

                System.out.print(String.format("%-10s",df.format(value))+"|");

            }
            System.out.println();

            for(double[] row : moreRows){
                System.out.print("|");

                for(int i=0; i<titles.length; i++){

                    double value = row[i];
                    DecimalFormat df = new DecimalFormat("0.00");

                    System.out.print(String.format("%-10s",df.format(value))+"|");

                }
                System.out.println();
            }


            System.out.print(" ");
            for(int i=0; i<titles.length; i++) {
                if (i == titles.length - 1) {
                    System.out.print("¯¯¯¯¯¯¯¯¯¯");
                }
                else {
                    System.out.print("¯¯¯¯¯¯¯¯¯¯¯");
                }
            }
            System.out.println();
        }
        else{ System.out.println("Lengths are not the same");}
    }


    public static void main(String[] args) {

        int[] values = {5,6,11,17,17,22}; // Matte 1 resultater
        double[] extraValues = {5,5,5,5,5,5};

        String[] titles = {"A","B","C","D","E","F"};
        double[] percentages = Calculation.getPercentageDistribution(values);

        printWithTitles(titles, percentages/*,extravalues*/);

    }
}
