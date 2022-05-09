package com.axonactive.programmingChallenges.chapter2;

/*
 number of shares 1000
 paid 32.87 per shares
 2% paid for stockbroker

 sold 1000 shares
 33.92 per shares
 paid another commission 2% of the amount received
*/

public class StockTransactionProgram {
    public static void main(String[] args) {
        double sharesPurchased = 1000,
                paidPerShare = 32.87,
                commission = 0.02,
                soldPerShare = 33.92;

        System.out.println("The amount of money Joe paid for the stock: " + sharesPurchased * paidPerShare);
        double firstCommission = commission * (sharesPurchased * paidPerShare);
        System.out.println("The amount of commission Joe paid his broker when he bought the stock: " + firstCommission);

        System.out.println("The amount that Joe sold the stock for: " + 1000 * soldPerShare);
        double secondCommission =  commission * ( 1000 * soldPerShare);
        System.out.println("The amount of commission Joe paid his broker when he sold the stock: " + secondCommission);

        double totalEarned = 1000 * soldPerShare - firstCommission - secondCommission;
        System.out.println("Amount of profit Joe made after selling his stock and paying the two comissions to his broker: " + totalEarned);
    }
}
