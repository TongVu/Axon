package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;
/*
time = distance/ 1,100 - air
time = distance/ 4,900 - water
time = distance/ 16,400 - steel
 */

public class TheSpeedOfSound {
    public static void main(String[] args) {
        String state;
        double distance, time = 0.0d;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the state (air, water or steel): ");
        state = input.nextLine();

        System.out.print("Enter the distance (in feet): ");
        distance = input.nextDouble();

        if (state.equals("air")){
            time = distance / 1100;
        } else if (state.equals("water")){
            time = distance / 4900;
        } else if (state.equals("steel")){
            time = distance / 16400;
        }

        System.out.println("The time that takes " + state + " to reach " + distance + " feets in the medium is: " + time +" seconds");
    }
}
