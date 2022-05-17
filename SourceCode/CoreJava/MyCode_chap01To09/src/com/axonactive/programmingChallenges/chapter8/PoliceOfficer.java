package com.axonactive.programmingChallenges.chapter8;

public class PoliceOfficer {
    String policeName;
    String badgeNumber;
    ParkedCar carInfo;


    int carPurchasedTime = 0,
            currentTime = 0;

    public PoliceOfficer(String name, String badgeNumber) {
        this.policeName = name;
        this.badgeNumber = badgeNumber;
    }

    public void setCarInfo(ParkedCar carInfo) {
        this.carInfo = carInfo;
    }

    public void setCarPurchasedTime(int carPurchasedTime) {
        this.carPurchasedTime = carPurchasedTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public int getCarPurchasedTime() {
        return carPurchasedTime;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public boolean checkExpiredTime() {
        return carPurchasedTime < currentTime;
    }

    public String getPoliceName() {
        return policeName;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void issueTicket() {
        ParkingTicket ticket = new ParkingTicket(this.carInfo, this.policeName, this.badgeNumber);
        if (checkExpiredTime()) {
            int overdueTime = currentTime - carPurchasedTime;
            ticket.reportFine(overdueTime);
            ticket.reportCarInfo();
            ticket.reportOfficer();
        }
    }

}
