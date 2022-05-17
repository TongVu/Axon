package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;
import java.lang.Math;

/*
    A = P * ( (1 + r / n) ^ (nt))
    A : amountOfMoney
    P : principal amount that was originally deposited into the account
    r : annualInterestRate
    n : timesInterestCompounded
    t : numberOfYears
 */
public class CompoundInterest {
    public static void main(String[] args) {

        double amountOfMoney,
                originallyDeposited,
                annualInterestRate,
                timesInterestCompounded,
                numberOfYears;

        Scanner input = new Scanner(System.in);

        System.out.print("The amount of principal originally depostied into the account: ");
        originallyDeposited = input.nextDouble();

        System.out.print("Annual interest rate (in percent) paid by the account: ");
        annualInterestRate = input.nextDouble();
        System.out.println("Interest rate: " + annualInterestRate + "%");

        System.out.print("Number of times that the interest is compounded every year: ");
        timesInterestCompounded = input.nextDouble();

        System.out.print("Number of years the account will be left to earn interst: ");
        numberOfYears = input.nextDouble();

        double innerParentheses = (1 + annualInterestRate / (numberOfYears * 100)),
                powerPart = numberOfYears * timesInterestCompounded;
        amountOfMoney = originallyDeposited * Math.pow(innerParentheses, powerPart);
        System.out.println("Your money that will be in the account after " + numberOfYears + " years: " + amountOfMoney);

    }
}
