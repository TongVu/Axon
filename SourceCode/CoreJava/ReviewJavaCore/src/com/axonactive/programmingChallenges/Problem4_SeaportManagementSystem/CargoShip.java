package com.axonactive.programmingChallenges.Problem4_SeaportManagementSystem;

public class CargoShip extends Ship{
    private int goodsCapacity; // a capacity of goods that a ship can carry in tons

    public CargoShip(String name, int cap){
        super(name);
        this.goodsCapacity = cap;
    }

    public CargoShip(int goodsCapacity) {
        this.goodsCapacity = goodsCapacity;
    }

    public int getGoodsCapacity() {
        return goodsCapacity;
    }

    public void setGoodsCapacity(int goodsCapacity) {
        this.goodsCapacity = goodsCapacity;
    }

    @Override
    public String toString(){
        String nameCargoCapacity = "Name: " + getShip() +
                " _ Cargo capacity: " + String.valueOf(getGoodsCapacity());
        return nameCargoCapacity;
    }
}
