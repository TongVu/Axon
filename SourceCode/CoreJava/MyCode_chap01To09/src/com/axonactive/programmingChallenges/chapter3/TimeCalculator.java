package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

public class TimeCalculator {
    public static void main(String[] args) {
        int seconds,
            minutes = 0,
            hours = 0,
            days = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter seconds: ");
        seconds = input.nextInt();

        if (seconds >= 60){
           minutes = seconds / 60;
           seconds = seconds % 60;
        }
        if (minutes >= 60){
            hours = minutes / 60;
            minutes = minutes % 60;
        }
        if (hours >= 24){
            days = hours / 24;
            hours = hours % 24;
        }
        System.out.println(days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds ");

    }
}
