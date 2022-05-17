package com.axonactive.programmingChallenges.ShipCruiseShipCargoShip;

public class Ship {
    private String ship; // name of the ship
    private String yearBuilt; // year that the ship was built

    public Ship(){}

    public Ship(String name){
        this.ship = name;
        this.yearBuilt = "Unknown";
    }

    public Ship(String ship, String yearBuilt) {
        this.ship = ship;
        this.yearBuilt = yearBuilt;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    @Override
    public String toString(){

        return "Name: " + getShip() + " _ Year built: " + getYearBuilt();
    }
}
