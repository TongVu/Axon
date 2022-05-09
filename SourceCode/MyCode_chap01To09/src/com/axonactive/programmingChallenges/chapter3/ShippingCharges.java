package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

public class ShippingCharges {
    public static void main(String[] args) {
        double chargeRate = 0.0d, // chargeRate is 0 as default
                packageWeight;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the package weight in pounds: ");
        packageWeight = input.nextDouble();

        if ( packageWeight <= 2 ){
            chargeRate = 1.1;
        } else if( packageWeight > 2 && packageWeight <= 6){
            chargeRate = 2.2;
        } else if( packageWeight > 6 && packageWeight <= 10){
            chargeRate = 3.7;
        } else if ( packageWeight > 10 ){
            chargeRate = 3.8;
        }

        System.out.println("This is the shipping charges: $" + chargeRate);
    }
}
