package com.axonactive.programmingChallenges.chapter8;

import java.util.Scanner;

public class Player {
    private int point;
    private String guess;
    private final String[] face = {"DOWN", "UP"};

    public Player() {
        point = 0;
    }

    public int getPoint() {
        return point;
    }

    public String guessFace() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("up or down: ");
            guess = input.nextLine();
            if (guess.equalsIgnoreCase("up") ) return guess;
            else if(guess.equalsIgnoreCase("down") ) return guess;
        } while (!guess.equalsIgnoreCase("up") &&
                !guess.equalsIgnoreCase("down"));
        return "";
    }

    public void earnPoint() {
        point++;
    }

    public void lostPoint() {
        if (point > 0)
            point--;
    }

}
