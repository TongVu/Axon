package com.axonactive.programmingChallenges.Problem6_CircleAndCoordinate;

import java.util.Scanner;

/**
 * This program let the usr input coordinate x, y of a circle
 * then display the (x,y) coordinate as well as circumference and area of that circle
 */
public class CircleCoordinateDemo {
    public static void main(String[] args) {
        float x,y;
        Scanner input = new Scanner(System.in);

        System.out.print("Input x: ");
        x = input.nextFloat();

        System.out.print("Input y: ");
        y = input.nextFloat();

        Coordinate o = new Coordinate(x,y); // create a Coordinate obj
        Circle circleK = new Circle(o);

        System.out.printf("%s has the radius: %.1f has the area and circumference respectively are: %.3f and %.3f",
                o.toString(), circleK.getRadius(), circleK.area(), circleK.circumference());
/*
        System.out.println(o.toString() +
                " has the radius: " + circleK.getRadius() +
                " has area and circumference respectively are: " + circleK.area() +
                " and " + circleK.circumference());
*/
    }
}
