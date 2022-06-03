package com.axonactive.programmingChallenges.Problem6_CircleAndCoordinate;

public class Coordinate {
    private String name = "O";
    private float x;
    private float y;

    public Coordinate(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Coordinate(){}

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return String.format("Circle with center %s (%.2f, %.2f)", name,x ,y);

    }

}
