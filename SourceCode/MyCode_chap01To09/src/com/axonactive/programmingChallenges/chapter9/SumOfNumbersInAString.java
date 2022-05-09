package com.axonactive.programmingChallenges.chapter9;

import java.util.Scanner;

public class SumOfNumbersInAString {
    public static int sum(String numbers){
        String[] splittedNumber = numbers.split(",");
        int sum = 0;

        for (String number: splittedNumber) {
            number = number.trim();
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    public static void main(String[] args) {
        String usrNumb;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a sequence of numbers separated by commas: ");
        usrNumb = input.nextLine();

        System.out.println("Sum: " + sum(usrNumb));

    }
}
