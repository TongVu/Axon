package com.axonactive.programmingChallenges.chapter8;

import java.util.Scanner;

public class ParkingTicketSimulator {
    public static void main(String[] args) {
        ParkedCar FerrariCar = new ParkedCar();
        ParkingMeter timeMeter = new ParkingMeter(FerrariCar);
        PoliceOfficer officerIncharge = new PoliceOfficer("Tong Vu", "NON39BIT");

        int currentTime;
        Scanner input = new Scanner(System.in);

        System.out.print("Hello, officer " + officerIncharge.getPoliceName() + " please enter the minute on the Parking Meter to check: ");
        currentTime = input.nextInt();

        officerIncharge.setCarInfo(FerrariCar);
        officerIncharge.setCarPurchasedTime(timeMeter.getPurchasedTime());
        officerIncharge.setCurrentTime(currentTime);

        System.out.println("=========================================");
        if(officerIncharge.checkExpiredTime()){
            System.out.println("The time is overdue");
            officerIncharge.issueTicket();
        }else{
            System.out.println("The time isn't overdue");
        }


    }
}
