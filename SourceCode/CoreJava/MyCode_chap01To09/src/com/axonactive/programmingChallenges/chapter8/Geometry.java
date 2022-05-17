package com.axonactive.programmingChallenges.chapter8;

public class Geometry {
    private double radius;
    private double length, width;
    private double base, height;

    public static double circleArea(double radius) {
        if(radius <= 0 ){
            System.out.println("ERROR!!! You have to input positive value\n");
            return 0;
        }

        return Math.PI * radius;
    }

    public static double rectangleArea(float width, float length) {
        if(width <= 0 || length <= 0){
            System.out.println("ERROR!!! You have to input positive value\n");
            return 0;
        }

        return width * length;
    }

    public static double triangleArea(double base, double height) {
        if(base <= 0 || height <= 0){
            System.out.println("ERROR!!! You have to input positive value\n");
            return 0;
        }

        return base * height * 0.5;
    }
}
