package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

public class BookClubPoints {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int points = 0,
                booksPurchased = 0;

        System.out.print("How many books have you purchased this month? ");
        booksPurchased = input.nextInt();

        if ( booksPurchased == 1 ){
           points = 5;
        } else if ( booksPurchased == 2 ){
            points = 15;
        }
        if ( booksPurchased == 3 ){
            points = 30;
        }
        if ( booksPurchased >= 4 ){
            points = 60;
        }
        System.out.println("You've purchased " + booksPurchased + " books this month. Your total points is: " + points);
    }
}
