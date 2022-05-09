package com.axonactive.programmingChallenges.chapter5;

import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

// markupPercentage = (sellingPrice - cost)/cost*100

public class RetailPriceCalculator {
    public static double calculateRetail(double cost, double markupPercentage) {

        return cost + cost * markupPercentage / 100;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double itemCost, percentage;

        System.out.print("Enter the item's wholesale cost: ");
        itemCost = input.nextInt();

        System.out.print("Enter the markup percentage: ");
        percentage = input.nextInt();

        double retailPrice;
        retailPrice = calculateRetail(itemCost, percentage);
        System.out.println("The item's retail price is: " + retailPrice);
    }
}
