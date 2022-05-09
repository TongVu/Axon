package com.axonactive.programmingChallenges.chapter8;

public class FuelGauge {
    private int amountOfGas;

    public FuelGauge(int gasInTank){
        this.amountOfGas = gasInTank;
    }

    public int getAmountOfGas() {
        return amountOfGas;
    }

    public boolean isFull(){
        return amountOfGas == 15;
    }

    public int fillingGas(){
        if(getAmountOfGas() == 15) {
            System.out.println("The gas tank is full");
            return getAmountOfGas();
        }
        amountOfGas++;

        return amountOfGas;
    }

    public int usingGas(){
        if(getAmountOfGas() >= 1){
            System.out.println("Vroom vroom vroom!!!");
            amountOfGas -= 1;
        } else if (getAmountOfGas() < 1){
            System.out.println("Vroom vroom vroom, we're running out of gas");
        }

        return amountOfGas;
    }
}
