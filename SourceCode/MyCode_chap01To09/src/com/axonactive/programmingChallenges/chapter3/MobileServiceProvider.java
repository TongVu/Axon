package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

public class MobileServiceProvider {
    public static void main(String[] args) {
        String packageLetter;
        double minutes,
                totalCharge = 0,
                additionalCharge;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the package letter (A, B, C): ");
        packageLetter = input.nextLine();
        System.out.print("Enter the time you've used: ");
        minutes = input.nextDouble();

        if(packageLetter.equals("A")){
            if(minutes > 450){
                additionalCharge = ( minutes - 450 ) * 0.45; // -- 450 minutes provided with package A
                totalCharge = additionalCharge + 39.99; // -- 39.99 per month
            } else{
                totalCharge = 39.99;
            }
        }

        if(packageLetter.equals("B")){
            if(minutes > 900){
                additionalCharge = ( minutes - 900 ) * 0.40; // -- 900 minutes provided with package B
                totalCharge = additionalCharge + 59.99; // -- 59.99$ per month
            } else{
                totalCharge = 59.99;
            }
        }

        if(packageLetter.equals("C")){
                totalCharge = 69.99; // -- 69.99 per month
        }

        System.out.println("With the package " + packageLetter + " and " + minutes + " minutes used you have to pay $" + totalCharge);
    }
}
