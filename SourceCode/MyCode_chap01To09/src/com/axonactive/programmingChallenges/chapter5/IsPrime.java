package com.axonactive.programmingChallenges.chapter5;

import java.util.Scanner;

/*
method name: isPrime(int numbCheck)
output : boolean;
 */
public class IsPrime {
    public static boolean isPrime(int numbCheck) {
        if (numbCheck <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(numbCheck); i++) {
            if (numbCheck % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberToCheck;
        boolean checkPrime;

        System.out.print("Enter a number: ");
        numberToCheck = input.nextInt();
        checkPrime = isPrime(numberToCheck);
        if (checkPrime) {
            System.out.println("The number is a prime number");
        } else {
            System.out.println("The number is not a prime number");
        }
    }
}
