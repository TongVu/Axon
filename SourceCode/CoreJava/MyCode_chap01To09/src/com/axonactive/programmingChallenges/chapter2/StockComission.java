package com.axonactive.programmingChallenges.chapter2;

public class StockComission {
    public static void main(String[] args) {
        double SHARES = 600,
                VALUE_PER_SHARE = 21.77,
                PERCENT_PER_TRANSACTION = 0.02,
                AMOUNT_PAID_FOR_STOCK = SHARES * VALUE_PER_SHARE,
                COMMISSION = AMOUNT_PAID_FOR_STOCK * 0.02;

        System.out.println("Amount paid for stocks " + AMOUNT_PAID_FOR_STOCK);

        System.out.println("Commission " + COMMISSION);

        System.out.println("Total amount paid " + AMOUNT_PAID_FOR_STOCK + COMMISSION);
    }
}
