package com.axonactive.programmingChallenges.chapter4;
import java.util.Scanner;

public class LargestAndSmallest {
    public static void main(String[] args) {
        int number = 0,
            largest = 1,
            smallest = 0;
        Scanner input = new Scanner(System.in);

        while (number != -99){
            System.out.print("Enter an interger number (!= -99): ");
            number = input.nextInt();

            if(number > largest){
                largest = number;
            }
            if (number < smallest){
                if(number == -99) {
                    System.out.println("You've pressed -99, out of program!");
                }
                else{
                    smallest = number;
                }
            }
        }
        System.out.println("Largest number: " + largest);
        System.out.println("Smallest number: " + smallest);
    }
}
