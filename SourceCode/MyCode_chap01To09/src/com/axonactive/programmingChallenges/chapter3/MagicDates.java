package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

public class MagicDates {
    public static void main(String[] args) {
        int month,
              day,
              year;
        Scanner input = new Scanner(System.in);

        System.out.print("Month: ");
        month = input.nextInt();

        System.out.print("Day : ");
        day = input.nextInt();

        System.out.print("Month (in 2 digits): ");
        year = input.nextInt();

        if(day * month == year){
            System.out.println("The date is magic");
        } else{
            System.out.println("The date is not magic");
        }
    }
}
