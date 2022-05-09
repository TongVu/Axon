package com.axonactive.programmingChallenges.chapter8;

public class ParkingMeter {
    ParkedCar carParkedInfo;

    public ParkingMeter(ParkedCar carParkedInfo){
           this.carParkedInfo = carParkedInfo;
    }

    public int getPurchasedTime(){
        return carParkedInfo.getMinutesCarHasPurchased();
    }
}
