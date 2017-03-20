package BusCalculator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by OlavH on 24-Dec-16.
 */
public class CMD {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] days = new int[]{7,30, 90, 180};
        int[] prices = new int[]{230, 740, 1960, 3630};

        Map<Integer, Integer> dayPriceMap = new LinkedHashMap<>();

        for (int i = 0; i < days.length; i++)
            dayPriceMap.put(days[i], prices[i]);


        System.out.println("How many times per week do you take the buss?");

        int answer = 0;

        while (answer == 0){
            try{
                answer = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e ){System.out.println("Input a valid number");}

        }

        int finalAnswer = answer; // slik at variablen blir "final" eckss deee java
        dayPriceMap.forEach((integer, integer2) -> {
            int totalTrip = (int) (((double) finalAnswer /7d)*integer);
            System.out.println("Days: "+integer+"\tPrice: "+integer2+"\tTotal trips: "+totalTrip);
            System.out.println("\tPrice per trip: "+(double)integer2/(double)totalTrip+"kr");
        });
    }


}
