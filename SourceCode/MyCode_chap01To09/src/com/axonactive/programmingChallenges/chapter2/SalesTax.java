package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args) {
        double STATE_SALES_TAX= 0.04, COUNTRY_SALES_TAX=0.02,
                amountOfPurchase, totalSales;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("State sales tax: "+STATE_SALES_TAX);
        System.out.println("Country sales tax: " + COUNTRY_SALES_TAX);

        System.out.print("Amount of purchase: "  );
        amountOfPurchase = keyboard.nextDouble();

        totalSales = amountOfPurchase + amountOfPurchase*(STATE_SALES_TAX + COUNTRY_SALES_TAX);
        System.out.println("Total sales: " + totalSales);
    }
}
