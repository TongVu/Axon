package com.axonactive.programmingChallenges.chapter8;

import java.util.Scanner;

public class GeometryCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        double height, radius, base;
        float width, length;

        System.out.println("Geometry calculator");
        do{
            System.out.println("1. Calculate the Area of a Circle");
            System.out.println("2. Calculate the Area of a Triangle");
            System.out.println("3. Calculate the Area of a Rectangle");
            System.out.println("4. Quit");
            System.out.print("\nEnter your choice (1-4): ");
            choice = input.nextInt();
            if(choice < 1 || choice > 4) break;

            switch (choice){
                case 1:
                    System.out.print("Enter radius: ");
                    radius = input.nextDouble();
                    System.out.println("Circle Area: " + Geometry.circleArea(radius));
                    System.out.println("");
                    break;

                case 2:
                    System.out.print("Enter triangle's height: ");
                    height = input.nextDouble();

                    System.out.print("Enter triangle's base: ");
                    base = input.nextDouble();
                    System.out.println("Triangle's Area: " + Geometry.triangleArea(base, height));
                    System.out.println("");
                    break;

                case 3:
                    System.out.print("Enter rectangle's width: ");
                    width = input.nextFloat();

                    System.out.print("Enter rectangle's height: ");
                    length = input.nextFloat();
                    System.out.println("Rectangle's Area: " + Geometry.rectangleArea(width, length));
                    System.out.println("");
                    break;
            }
        }while(choice!=4);

        if(choice < 1 || choice > 4){
            System.out.println("Error! Your choice is out of range.");
        }
    }
}
