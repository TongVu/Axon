package com.axonactive.programmingChallenges.chapter5;

import java.util.Scanner;
/*
KE =  0.5*m*(v^2)
KE: kinetic energy
m: object's mass in kg
v: object's velocity in m/s

input: kineticEnergy(objMass, velocity)
output: KE
 */

public class KineticEnergy {
    public static double kineticEnergy(double objMass, double velocity) {
        return 0.5 * objMass * (Math.pow(velocity, 2));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double mass, speed;

        System.out.print("Please enter the objet's mass (kg): ");
        mass = input.nextDouble();

        System.out.print("Please enter the velocity (m/s): ");
        speed = input.nextDouble();

        System.out.println("The kinetic energy is: " + kineticEnergy(mass, speed));
    }
}
