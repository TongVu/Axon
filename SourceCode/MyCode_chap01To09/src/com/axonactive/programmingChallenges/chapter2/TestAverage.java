package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

public class TestAverage {
    public static void main(String[] args) {
        double AVERAGE,
                test1,
                test2,
                test3;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter test1 score: ");
        test1= keyboard.nextDouble();
        System.out.print("Enter test1 score: ");
        test2= keyboard.nextDouble();
        System.out.print("Enter test1 score: ");
        test3= keyboard.nextDouble();

        AVERAGE = (test1 + test2 + test3) / 3;
        System.out.println("Your average score is: " + AVERAGE);
    }
}
