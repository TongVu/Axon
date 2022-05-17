package com.axonactive.programmingChallenges.chapter5;

import java.util.Scanner;

/*
input: distance in meters

output: pre-sent the menu of selections:
1.Convert to kilometers|| kilometers = meters * 0.001
2.Convert to inches || inches = meters * 39.37
3.Convert to feet || feet = meters * 3.281
4.Quit the program

requirements:
-showKilometers, showInches, showFeet, menu : all in void type
-continue to display until the user exit
-check error if user choose invalid number (check error number in the Menu method)

 */
public class ConversionProgram {
    public static void menu(double distance) {
        int choice;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n======================================");
            System.out.println("1.Convert to kilometes");
            System.out.println("2.Convert to inches");
            System.out.println("3.Convert to feet");
            System.out.println("4.Quit the program");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            if (choice == 1) {
                showKilometers(distance);
            } else if (choice == 2) {
                showInches(distance);
            } else if (choice == 3) {
                showFeet(distance);
            } else {
                System.out.println("Sorry please try again");
            }
        } while (choice != 4);

        if (choice == 4) {
            System.out.println("Bye!");
        }
    }

    public static void showKilometers(double distance){
        double kilometers = distance * 0.001;
        System.out.println(distance + " meters is " + kilometers + " kilometers");
    }
    public static void showInches(double distance){
        double inches = distance * 39.37;
        System.out.println(distance + " meters is " + inches + " inches");
    }
    public static void showFeet(double distance){
        double feet = distance * 0.001;
        System.out.println(distance + " meters is " + feet + " feet");
    }

    public static void main(String[] args) {
        double distance;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the distance in meters: ");
        distance = input.nextDouble();

        menu(distance);

    }
}
