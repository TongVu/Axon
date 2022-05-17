package com.axonactive.programmingChallenges.chapter8;

public class Area {
    private double area;
    private double radius;
    private float width, length;
    private double height;

    public Area(double radius, float width, float length, double height) {
        this.radius = radius;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public static double area(double radius) {
        return Math.PI * radius;
    }

    public static double area(float width, float length) {
        return width * length;
    }

    public static double area(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    public static void main(String[] args) {
        double radius = 2.5d,
                height = 12.0d;

        float width = 5.2f,
                length = 7.0f;
        Area shape = new Area(radius, width, length, height);

        System.out.printf("Area of circle: %.2f\n", shape.area(radius));
        System.out.printf("Area of rectangles: %.2f\n", shape.area(width, length));
        System.out.printf("Area of cylinder %.2f\n", shape.area(radius, height));

    }
}
