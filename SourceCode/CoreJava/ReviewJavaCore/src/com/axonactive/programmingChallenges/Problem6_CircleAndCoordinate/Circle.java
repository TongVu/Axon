package com.axonactive.programmingChallenges.Problem6_CircleAndCoordinate;

public class Circle {
    private Coordinate o;
    private double radius;

    public Circle(){}

    public Circle(Coordinate o) {
        this.o = o;
        this.radius = Math.sqrt(o.getX()*o.getX() + o.getY()*o.getY());
    }

    public Coordinate getO() {
        return o;
    }

    public void setO(Coordinate o) {
        this.o = o;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double circumference(){
        return 2 * Math.PI * getRadius();
    }

    public double area(){
        return Math.PI * Math.pow(getRadius(), 2); // area = PI * radius^2;
    }
}
