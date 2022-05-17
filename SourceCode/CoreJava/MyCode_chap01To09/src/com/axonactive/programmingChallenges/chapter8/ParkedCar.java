package com.axonactive.programmingChallenges.chapter8;

public class ParkedCar {
    String carsMake;
    String model;
    String color;
    String licenseNumber;
    int minutesCarHasPurchased;

    public ParkedCar(){
        this.carsMake = "Ferrari";
        this.model = "488";
        this.color = "violet";
        this.licenseNumber = "FX85023";
        this.minutesCarHasPurchased = 120;
    }
    public void setCarsMake(String carsMake) {
        this.carsMake = carsMake;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setMinutesCarHasPurchased(int minutesCarHasPurchased) {
        this.minutesCarHasPurchased = minutesCarHasPurchased;
    }

    public String getCarsMake() {
        return carsMake;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getMinutesCarHasPurchased() {
        return minutesCarHasPurchased;
    }
}
