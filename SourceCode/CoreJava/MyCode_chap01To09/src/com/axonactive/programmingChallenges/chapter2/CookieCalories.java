package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

public class CookieCalories {
    public static void main(String[] args) {
        int COOKIE_PER_BAG = 40,
                SERVINGS_PER_BAG = 10,
                CALORIES_PER_SERVING = 300;

        double caloriesConsumed, cookiesConsumed, CALORIES_PER_COOKIE = CALORIES_PER_SERVING * SERVINGS_PER_BAG / COOKIE_PER_BAG;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("How much cookies did you eat? ");
        cookiesConsumed = keyboard.nextInt();

        caloriesConsumed = cookiesConsumed * CALORIES_PER_COOKIE;
        System.out.println("You've consumed " + caloriesConsumed + " calories");
    }
}
