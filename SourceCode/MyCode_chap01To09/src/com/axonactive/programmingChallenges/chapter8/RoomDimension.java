package com.axonactive.programmingChallenges.chapter8;

public class RoomDimension {
    private double width;
    private double length;

    public RoomDimension(double width, double length){
        this.width = width;
        this.length = length;
    }
    public double calArea(){
        return this.length * this.width;
    }
    public String toString(){
        return "With a room has " + width * length + " sq.ft";
    }
}
