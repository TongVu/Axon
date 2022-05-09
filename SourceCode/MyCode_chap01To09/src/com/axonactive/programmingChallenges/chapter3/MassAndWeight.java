package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

public class MassAndWeight {
    public static void main(String[] args) {
        double mass, weight;
        Scanner input = new Scanner(System.in);

        System.out.print("Mass? ");
        mass = input.nextDouble();

        weight = mass * 9.8;
        System.out.println("Weight : " + weight + " Newtons");

        if(weight > 1000){
            System.out.println("Too heavy");
        } else if (weight < 10){
            System.out.println("Too light");
        }

    }

    public static class ShippingCharges {
        public static void main(String[] args) {
            double weightOfPackage,
            shippingCharges;
            Scanner input = new Scanner(System.in);

            System.out.print("What's the weight of the package?: ");
            weightOfPackage = input.nextDouble();

        }
    }
}
