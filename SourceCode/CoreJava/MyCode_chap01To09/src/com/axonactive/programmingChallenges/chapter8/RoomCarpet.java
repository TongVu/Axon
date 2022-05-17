package com.axonactive.programmingChallenges.chapter8;

public class RoomCarpet {
    private RoomDimension size;
    private double carpetCost;

    public RoomCarpet(RoomDimension dim, double cost){
        this.size = dim;
        this.carpetCost = cost;
    }

    public double getTotal(){
        return size.calArea() * carpetCost;
    }
    public String toString(){
        return "The total price would be: $" + getTotal();
    }
}
