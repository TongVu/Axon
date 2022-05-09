package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

public class SoftwareSales {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int packages;
        double totalPrice,
                discountRate = 0.0d, // discount Rate = 0 as default
                retailPrice = 99;

        System.out.print("How much do you buy? : ");
        packages = input.nextInt();

        if ( packages >= 10 && packages <= 29){
            discountRate = 0.2;
        } else if ( packages >= 20 && packages <= 29){
            discountRate = 0.3;
        } else if ( packages >= 50 && packages <= 99){
            discountRate = 0.4;
        } else if ( packages >= 100){
            discountRate = 0.5;
        }
        System.out.println("Discount rate : " + discountRate * 100 + "%");
        totalPrice = packages * 99 - ( packages * 99 * discountRate); // each packge costs $99
        System.out.println("Price after discount :$" + totalPrice);
    }
}
