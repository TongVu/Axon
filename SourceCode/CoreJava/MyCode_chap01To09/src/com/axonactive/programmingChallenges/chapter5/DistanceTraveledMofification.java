package com.axonactive.programmingChallenges.chapter5;
/*
Distance = Speed * Time
input:
        method: distance( vehicle's speed; time)

output: the distance the vehicle has traveled
 */

import java.util.Scanner;

public class DistanceTraveledMofification {
    public static double distance(double speed, double time) {
        return speed * time;
    }

    public static void main(String[] args) {
        double speed, time;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the speed (km/h): ");
        speed = input.nextDouble();

        System.out.print("Enter the time (hours): ");
        time = input.nextDouble();

        System.out.println("The distance you've traveled: " + distance(speed, time) + " kilometers");
    }
}
