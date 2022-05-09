package com.axonactive.programmingChallenges.chapter7;

import java.util.Scanner;
/*
Program is completed, now I want to set show most rain and lest rain in months if they have the same amount of rain in those months
 */

public class Rainfall {
    private double[] rainData = new double[12];

    public void setRainFall() {
        Scanner input = new Scanner(System.in);

        // check if rain fall < 0 then ask usr input again
        for (int i = 0; i < rainData.length; i++) {
            do {
                System.out.printf("Month %d, enter the rain (in millimeters): ", i + 1);
                rainData[i] = input.nextDouble();
            } while (rainData[i] < 0);
        }
    }

    public double totalRainFall() {
        double total = 0.0d;
        for (int i = 0; i < rainData.length; i++) {
            total += rainData[i];
        }
        return total;
    }

    public double avgRain() {
        return totalRainFall() / 12;
    }

    public void getMonthGotMostRain() {
        double mostRain = rainData[0];
        String mostRainyMonths = " ";

        for (int i = 1; i < rainData.length; i++) {
            if (mostRain < rainData[i]) {
                mostRain = rainData[i];
            }
        }
        for (int month = 0; month < rainData.length; month++) {
            if (mostRain == rainData[month]) {
                mostRainyMonths = mostRainyMonths.concat(Integer.toString(month+1)).concat(" ");
            }
        }

        System.out.println("Most rainy month(s) of the year are: " + mostRainyMonths);
    }

    public void getMonthGotLeastRain() {
        double leastRain = rainData[0];
        String leastRainyMonths = "";

        for (int i = 2; i < rainData.length; i++) {
            if (leastRain > rainData[i]) {
                leastRain = rainData[i];
            }
        }

        for (int month = 0; month < rainData.length; month++) {
            if (leastRain == rainData[month]) {
                leastRainyMonths = leastRainyMonths.concat(Integer.toString(month+1)).concat(" ");
            }
        }

        System.out.println("Most rainy month(s) of the year are: " + leastRainyMonths);
    }

    public static void main(String[] args) {
        Rainfall thisYear = new Rainfall();

        thisYear.setRainFall();
        System.out.println("=================================================");
        System.out.printf("Total rain fall: %.2f \n", thisYear.totalRainFall());
        System.out.printf("Average rain fall this year: %.2f \n", thisYear.avgRain());
        thisYear.getMonthGotMostRain();
        thisYear.getMonthGotLeastRain();

    }
}
