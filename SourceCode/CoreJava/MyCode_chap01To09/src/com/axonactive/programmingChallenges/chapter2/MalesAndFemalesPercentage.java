package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

public class MalesAndFemalesPercentage {
    public static void main(String[] args) {
       double male, female;
       double malePercent, femalePercent;
       Scanner input = new Scanner(System.in);

       System.out.print("Male: ");
       male = input.nextInt();

       System.out.print("Female: ");
       female = input.nextInt();

       malePercent =  ( male / (male + female)) * 100;
       femalePercent = 100 - malePercent;
       System.out.println("Male: " + malePercent);
        System.out.println("Female: " + femalePercent);
    }
}
