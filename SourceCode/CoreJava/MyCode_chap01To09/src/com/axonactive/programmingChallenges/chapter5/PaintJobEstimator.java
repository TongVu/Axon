package com.axonactive.programmingChallenges.chapter5;

import java.util.Scanner;

// 115sq.ft <=> 1 gallon of paint <=> 8 hours of labor $18.00 per hour of labor

// input: number of rooms, price of the paint per gallon, room space in each room

// output: number of gallons of paint required
//          hours of labor required, cost of the paint
//          labor charges
//          Total cost of the paint job

public class PaintJobEstimator {
    public static void estimator(double roomQuantity, double paintPricePerGallon, double roomSpace) {
            double LABOR_PRICE = 18,
                    totalSqft = roomQuantity * roomSpace,
                    paintRequired = ( totalSqft / 115 ),// 1 gallon = 115sqft
                    paintCost = paintPricePerGallon * paintRequired,
                    laborCharges = LABOR_PRICE * paintRequired,
                    totalCost = laborCharges + paintCost;

            System.out.println("The number of gallons of paint required: " + paintRequired);
            System.out.println("The hours of labor required: " + paintRequired * 8);
            System.out.println("The cost of the paint: $" + paintCost);
            System.out.println("The labor charges: $" + laborCharges);
            System.out.println("The total cost of the paint job: $" + totalCost);
    }

    public static void main(String[] args) {
        double rooms,
                pricePerGallon,
                roomSpace;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of room to be painted: ");
        rooms = input.nextInt();

        System.out.print("Enter the price of the paint (per gallon): ");
        pricePerGallon = input.nextInt();

        System.out.print("What is the room space? ");
        roomSpace = input.nextInt();

        estimator(rooms, pricePerGallon, roomSpace);
    }
}
