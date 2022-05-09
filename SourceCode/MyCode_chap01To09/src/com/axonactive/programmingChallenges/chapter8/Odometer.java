package com.axonactive.programmingChallenges.chapter8;

public class Odometer {
    private int currentMileage;

    public Odometer(int currentMileage){
        this.currentMileage =currentMileage;
    }
    public int getCurrentMileage(){
        return currentMileage;
    }

    public void increaseCurrentMileage(){
        if(currentMileage > 999_999)
            this.currentMileage = 0;
        else
            this.currentMileage = getCurrentMileage() + 1;
    }
}
