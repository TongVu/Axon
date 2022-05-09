package com.axonactive.programmingChallenges.chapter4;
import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        int number, sum = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive number (>0): ");
        number = input.nextInt();

        for(int i = 1; i <= number; i++){
            sum += i;
        }
        System.out.println("Sum of 1 to " + number + " is: " + sum);
    }
}
