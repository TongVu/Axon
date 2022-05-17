package com.axonactive.programmingChallenges.chapter5;

import java.util.Scanner;

/*
input: width, length
output: rectangle's area

method:
-getLength(double length)
-getWidth(double width)
-getArea(double length, double width)
-displayData(double length, double width, double area)
 */

public class RectangleArea {
    public static double getLength() {
        Scanner input = new Scanner(System.in);
        double length;

        System.out.print("Enter the rectangle's length: ");
        length = input.nextDouble();
        return length;
    }

    public static double getWidth() {
        Scanner input = new Scanner(System.in);
        double width;

        System.out.print("Enter the rectangle's width: ");
        width = input.nextDouble();
        return width;
    }

    public static double getArea(double length, double width) {
        return length * width;
    }

    public static void displayData(double length, double width, double area) {
        System.out.println("Length: " + length);
        System.out.println("Width : " + width);
        System.out.println("Area: " + area);
    }

    public static void main(String[] args) {
            double length, width, area;

            length = getLength();
            width = getWidth();
            area = getArea(length, width);

            displayData(length, width, area);
    }
}
