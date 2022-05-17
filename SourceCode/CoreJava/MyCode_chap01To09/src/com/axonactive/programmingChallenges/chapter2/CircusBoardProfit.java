package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

public class CircusBoardProfit {
    public static void main(String[] args) {
        double PROFIT_PERCENT = 0.4,
                retailPrice, profit;
        Scanner input = new Scanner(System.in);

        System.out.print("Retail price of a circus board? ");
        retailPrice = input.nextDouble();

        profit = retailPrice + retailPrice * PROFIT_PERCENT;
        System.out.println("Your profit is: " + profit);
    }
}
