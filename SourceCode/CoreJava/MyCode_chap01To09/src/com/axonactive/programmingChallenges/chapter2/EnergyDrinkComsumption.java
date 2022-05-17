package com.axonactive.programmingChallenges.chapter2;

public class EnergyDrinkComsumption {

    public static void main(String[] args) {
        double totalSurveys = 12_467,
            customersDrinkEnergyDrinks = totalSurveys * 0.14,
            customerPreferCitrus = customersDrinkEnergyDrinks * 0.64;

        System.out.println("Customers purchase one or more energy drinks per week: " + (int) customersDrinkEnergyDrinks);
        System.out.println("Customers like citrus: " + (int) customerPreferCitrus);
    }
}
