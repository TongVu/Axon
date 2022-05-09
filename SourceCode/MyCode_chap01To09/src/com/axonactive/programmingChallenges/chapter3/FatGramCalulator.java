package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

// Calories from fat = Fatgrams * 9
// Percentage of Calories from fat = Calories from fat / Totalcalories
// if Percentage < 30% then display the foos is low in fat
public class FatGramCalulator {
    public static void main(String[] args) {
        double calories,
                caloriesFromFat,
                fatGrams,
                fatPercentage;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter calories from food item: ");
        calories = input.nextDouble();

        System.out.print("Enter fat grams from food item: ");
        fatGrams = input.nextDouble();
        caloriesFromFat = fatGrams * 9;

        fatPercentage = ( caloriesFromFat / calories ) * 100;
        if ( fatPercentage < 30){
            System.out.println("The food is low in fat");
        } else {
            System.out.println("The food is high in fat");
        }
    }
}
