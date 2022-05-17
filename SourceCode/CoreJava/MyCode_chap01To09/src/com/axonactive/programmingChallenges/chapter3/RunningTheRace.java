package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

public class RunningTheRace {
    public static void main(String[] args) {
        String runner1, runner2, runner3;
        double time1, time2, time3, first, second, last;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        runner1 = input.nextLine();
        System.out.print("Enter your finish time in minutes: ");
        time1 = input.nextDouble();
        first = time1;
        input.nextLine(); // this line to prevent after typed nextDouble will pass the /n to next line

        System.out.print("Enter your name: ");
        runner2 = input.nextLine();
        System.out.print("Enter your finish time in minutes: ");
        time2 = input.nextDouble();
        second = time2;
        input.nextLine(); // this line to prevent after typed nextDouble will pass the /n to next line

        System.out.print("Enter your name: ");
        runner3 = input.nextLine();
        System.out.print("Enter your finish time in minutes: ");
        time3 = input.nextDouble();
        last = time3;

        // Compare the time first
        if ( first > second ){
            double tmp = second;
            second = first;
            first = tmp;
        }
        if ( first > last ) {
            double tmp = last;
            last = first;
            first = tmp;
        }
        if ( second > last ){
            double tmp = last;
            last = second;
            second = tmp;
        }

        // Then check the time with the runner it's in accordance with
        if ( first == time1 ){
            System.out.println(runner1 + " with running time is: " + first);
        } else if ( first == time2 ){
            System.out.println(runner2 + " with running time is: " + first);
        } else if ( first == time3 ){
            System.out.println(runner3 + " with running time is: " + first);
        }

        if ( second == time1 ){
            System.out.println(runner1 + " with running time is: " + second);
        } else if ( second == time2 ){
            System.out.println(runner2 + " with running time is: " + second);
        } else if ( second == time3 ){
            System.out.println(runner3 + " with running time is: " + second);
        }

        if ( last == time1 ){
            System.out.println(runner1 + " with running time is: " + last);
        } else if ( last == time2 ){
            System.out.println(runner2 + " with running time is: " + last);
        } else if ( last == time3 ){
            System.out.println(runner3 + " with running time is: " + last);
        }
    }
}
