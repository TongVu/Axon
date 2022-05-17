package com.axonactive.programmingChallenges.chapter6;

import java.util.Scanner;

public class Circle {
    private double radius;
    private final double PI = 3.14159;

    public Circle(double radiusInput) {
        radius = radiusInput;
    }

    public Circle() {
        radius = 0.0d;
    }

    public void setRadius(double radiusInput) {
        radius = radiusInput;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return PI * radius * radius;
    }

    public double diameter() {
        return radius * 2;
    }

    public double circumference() {
        return 2 * PI * radius;
    }

    public static void main(String[] args) {
        Circle circleK;
        double radius;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the circle's radius: ");
        radius = input.nextDouble();
        circleK = new Circle(radius);

        System.out.printf("The circle's area: %.4f", circleK.area());
        System.out.printf("\nThe circle's diameter: %.4f", circleK.diameter());
        System.out.printf("\nThe circle's circumference: %.4f", circleK.circumference());
    }
}
