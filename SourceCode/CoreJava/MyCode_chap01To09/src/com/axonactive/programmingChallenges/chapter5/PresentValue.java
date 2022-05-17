package com.axonactive.programmingChallenges.chapter5;

import java.util.Scanner;

/*
P = F / ( (1 + r)^n )
P: present value
F: future value
r: annual interest rate
n: number of years

method name: presentValue(double futureVal, double interestRate, int years)
output: present value <=> the amount that you need to deposit today
require: let the usr tinkers with different values
 */
public class PresentValue {
    public static double presentValue(double futureVal, double interestRate, int years){
        double preVal = futureVal / Math.pow(1 + interestRate, years);
        return preVal;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double futureValue, interestRate, depositToPutIn;
        char answer = 'n';
        int years;

        do {
            System.out.print("Enter the future value that you want to get: ");
            futureValue = input.nextDouble();

            System.out.print("Enter the interest rate: ");
            interestRate = input.nextDouble();

            System.out.print("In how many do you want to get the money back: ");
            years = input.nextInt();

            depositToPutIn = presentValue(futureValue, interestRate, years);
            System.out.printf("You need to put in $%.3f", depositToPutIn, " to get that money");
            System.out.println("\nDo you want to try other values? (y/n) ");
            answer = input.next().charAt(0);
            System.out.println("==========================================\n");
        } while (Character.compare(answer, 'y') == 0);
    }

}
