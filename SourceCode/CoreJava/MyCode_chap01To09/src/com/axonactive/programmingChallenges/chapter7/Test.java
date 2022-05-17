package com.axonactive.programmingChallenges.chapter7;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // just test for 6 months
        double[] rainfallEachMonth = new double[6];
        String monthsHaveLeastRainfall = "";

        // Set rainfall for each months
        for (int i = 0; i < rainfallEachMonth.length; i++) {
            System.out.print("Input rainfall in the month " + (i + 1) + ": ");
            rainfallEachMonth[i] = input.nextDouble();
        }

        // Get months have least rainfall;
        // OK, now convert the index of least rainfall to monthsHaveLeastRainfall
        double leastRainfall = rainfallEachMonth[0];
        for (int i = 1; i < rainfallEachMonth.length; i++) {
            if(leastRainfall > rainfallEachMonth[i]){
                leastRainfall = rainfallEachMonth[i];
            }
        }

        for (int i = 0; i < rainfallEachMonth.length; i++) {
            if(leastRainfall == rainfallEachMonth[i]){
                monthsHaveLeastRainfall = monthsHaveLeastRainfall.concat(Integer.toString(i + 1)).concat(" ");
            }
        }
        // test result
        System.out.println("=============================");
        System.out.println("Months have least rain fall are: " + monthsHaveLeastRainfall);
    }
}
