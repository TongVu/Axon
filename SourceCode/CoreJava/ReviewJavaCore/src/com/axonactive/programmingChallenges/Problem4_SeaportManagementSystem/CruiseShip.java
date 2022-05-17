package com.axonactive.programmingChallenges.Problem4_SeaportManagementSystem;

public class CruiseShip extends Ship{
    private int maxCapacity; // holds the maximum number of passengers

    public CruiseShip(String ship, int cap) {
        super(ship);
        this.maxCapacity = cap;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString(){
        String nameAndCapacity = "Name: " + getShip()
                + " _ Capacity: " + String.valueOf(getMaxCapacity());

        return nameAndCapacity;
    }
}
