package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

public class IngredientAdjuster {
    public static void main(String[] args) {
        double amountOfSugar = 1.5 / 48,
                amountOfButter = 1.0 / 48,
                amountOfFlour = 2.75 / 48;
        int cookies;
        Scanner input = new Scanner(System.in);

        System.out.print("How much cookies do you want to make? ");
        cookies = input.nextInt();

        System.out.println("Sugar: " + amountOfSugar * cookies + " cups");
        System.out.println("Butter: " + amountOfButter * cookies + " cups");
        System.out.println("Flour: " + amountOfFlour * cookies + " cups");
    }
}
