package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

public class MilesPerGallon {
    public static void main(String[] args) {
        double milesDriven,
                gallonsOfGasUsed,
                MPG;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Miles: ");
        milesDriven = keyboard.nextDouble();

        System.out.print("Gallons: ");
        gallonsOfGasUsed = keyboard.nextDouble();

        MPG = milesDriven/gallonsOfGasUsed;
        System.out.println(MPG + " miles per gallon");
    }
}
