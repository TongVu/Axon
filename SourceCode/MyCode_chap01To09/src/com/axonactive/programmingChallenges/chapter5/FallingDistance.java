package com.axonactive.programmingChallenges.chapter5;

import java.lang.Math;
import java.util.Scanner;

/*
d = 1/2g*( t^2 )
d: distance (m)
g: 9.8
t: time (s)

input : falling time
output: distance
require: method calling in a loop passes the values 1 through 10 as arguments, display output
 */

public class FallingDistance {
    public static double fallingDistance(double fallingTime) {
        final double GRAVITY = 9.8;
        double distance = 0.5 * GRAVITY * (Math.pow(fallingTime, 2));

        return distance;
    }

    public static void main(String[] args) {

        for(double time = 0; time < 10; time++){
            System.out.format("\nDistance in " + time + " seconds: %.2f", fallingDistance(time) );
        }
    }
}
