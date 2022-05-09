package com.axonactive.programmingChallenges.chapter8;

public class CarInstrumentSimulator {
    public static void main(String[] args) {
        FuelGauge carGas = new FuelGauge(5);
        Odometer carOdo = new Odometer(529_300);

        System.out.println("Current gas in the tank (gallons). Filling it up...");
        while (!carGas.isFull()) {
            carGas.fillingGas();
            System.out.println("Gas in the tank (gallons): " + carGas.getAmountOfGas());
        }
        System.out.println("The gas tank is full");

        for (int miles = 0; carGas.getAmountOfGas() != 0; miles++) {
            if(miles == 0){
                //do nothing
            }
            if(miles % 24 == 0){
                carGas.usingGas();
                System.out.println("Gas in the tank: " + carGas.getAmountOfGas());
            }
            carOdo.increaseCurrentMileage();
            System.out.println("Current mileages: " + carOdo.getCurrentMileage());
        }
    }
}
