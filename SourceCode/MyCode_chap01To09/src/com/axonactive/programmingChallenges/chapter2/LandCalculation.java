package com.axonactive.programmingChallenges.chapter2;

public class LandCalculation {
    public static void main(String[] args) {
       int ACRE_OF_LAND = 43_560,
            LAND_AREA = 389_767,
            numberOfAcres = LAND_AREA/ ACRE_OF_LAND;

        System.out.println("Total acres: " + numberOfAcres);
    }
}
