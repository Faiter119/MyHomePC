import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    /**
     * Exact percentage of total
     */
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

    /**
     * Takes the average of the numbers
     */
    public static <N extends Number> double avg(N ... array){

        double sum = 0;

        for(N t : array){
            sum += t.doubleValue();
        }
        return sum/array.length;

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

    public static <K,V> Map<K, V> directMap(K[] keys, V[] values){

        if(keys.length != values.length) return null;

        Map<K,V> map = new HashMap<>();

        for(int i=0; i<keys.length; i++){
            map.put(keys[i], values[i]);
        }
        return map;
    }

    /**
     * Finds the 50% index using median
     */
    public static int median(int[] values){

        int total = Arrays.stream(values).sum();

        int goal = total/2; // The middle / median

        int soFar = 0;

        int index = 0;

        while(soFar <= goal){

            int thisIndex = values[index];
            int thisGoal = soFar+thisIndex;

            for(int i=soFar; i < thisGoal; i++){
                soFar++;
                if(i == goal) return index;
            }
            index++;
        }
        return index;
    }


    public static void main(String[] args) {

        int[] values = {5,6,11,17,17,22}; // Matte 1 resultater

        String[] titles = {"A","B","C","D","E","F"};
        double[] percentages = Calculation.getPercentageDistribution(values);

        printWithTitles(titles, percentages);

        /*Integer[] integerValues = {5,6,11,17,17,22}; // Matte 1 resultater

        Map<String, Integer> map = directMap(titles, integerValues);

        System.out.println(map);

        Set<String> set = map.keySet();
        String[] array = new String[set.size()];
        set.toArray(array);
        System.out.println(Arrays.toString(array));*/

        System.out.println(median(values));
    }
}
