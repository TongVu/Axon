package com.axonactive.programmingChallenges.chapter8;

import java.util.Random;

public class Coin {
    private final String[] face = {"DOWN", "UP"};
    private int randomNumber;


    public String flip() {
        Random rand = new Random();
        randomNumber = rand.nextInt(2);
        if (randomNumber == 1) {
            return face[1];
        }
        return face[0];
    }
}
