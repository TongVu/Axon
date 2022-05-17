package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

public class RestaurantBill {
    public static void main(String[] args) {
       Scanner usrInput = new Scanner(System.in);
       double TAX = 0.0675,
               TIP,
               charge, chargeAfterTax,
               total;

        System.out.print("Charge? ");
        charge = usrInput.nextDouble();

        chargeAfterTax = charge + TAX * charge;
        TIP = 0.02 * charge;
        total = chargeAfterTax + TIP;

        System.out.println("Charge :" + charge);
        System.out.println("TAX : " + TAX);
        System.out.println("TIP : " + TIP);
        System.out.println("TOTAL : " + total);
    }
}
