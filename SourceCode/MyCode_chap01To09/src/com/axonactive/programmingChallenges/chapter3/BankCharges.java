package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

public class BankCharges {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fees = 10;
        int checkTimes;

        System.out.print("How many times have you checked the account? ");
        checkTimes = input.nextInt();

        if(checkTimes < 20){
            fees = fees + 0.1 * checkTimes; // $10 each
        } else if (checkTimes >=20 && checkTimes < 39){
            fees = fees + 0.8 * checkTimes;
        } else if(checkTimes >= 40 && checkTimes < 59) {
            fees = fees + 0.6 * checkTimes;
        } else if (checkTimes >= 60){
            fees = fees + 0.4 * checkTimes;
        }
        System.out.println("You fees for this month: " + fees);
    }
}
