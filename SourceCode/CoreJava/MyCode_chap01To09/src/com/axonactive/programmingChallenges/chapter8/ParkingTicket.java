package com.axonactive.programmingChallenges.chapter8;

public class ParkingTicket {
    ParkedCar carParkedInfo;
    String officerName,
            officerBadgeNumber;

    public ParkingTicket(ParkedCar carInfo, String officerName, String officerBadgeNumber) {
        this.carParkedInfo = carInfo;
        this.officerName = officerName;
        this.officerBadgeNumber = officerBadgeNumber;
    }

    public void reportCarInfo() {
        System.out.println("====== CAR INFORMATION ======");
        System.out.println("Brand: " + carParkedInfo.carsMake);
        System.out.println("Model: " + carParkedInfo.model);
        System.out.println("Color: " + carParkedInfo.color);
        System.out.println("License number: " + carParkedInfo.licenseNumber);
    }

    /*
    $25 for first hour or part of an hour that the car is illegally parked
    +$10 for every additional hour or part of an hour that the car if illegally parked
    TODO calculate fine for this method
    */
    public void reportFine(int overdueTime) {
        double fine = 0.0d;

        if (overdueTime >= 60) {
            fine += 25;
            overdueTime -= 60;
        }
        while (overdueTime > 30) {
            fine += 10;
            overdueTime -= 30;
        }

        System.out.println("Fine: $" + fine);
    }

    public void reportOfficer() {
        System.out.println("====== OFFICER INFORMATION ======");
        System.out.println("Officer's name: " + this.officerName);
        System.out.println("Badge number: " + this.officerBadgeNumber);
    }
}
