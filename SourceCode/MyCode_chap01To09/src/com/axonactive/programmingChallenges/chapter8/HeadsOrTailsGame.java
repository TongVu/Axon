package com.axonactive.programmingChallenges.chapter8;

/*
The random number seems to have a common pattern
 */

public class HeadsOrTailsGame {
    public static void main(String[] args) {
        Player player1 = new Player(), // create 2 player
                player2 = new Player();
        Coin brassCoin = new Coin(); // create a coin to flip
        String guess,
                flipFace;
        boolean turn = true; // player1 goes first

        while (player1.getPoint() < 5 &&
                player2.getPoint() < 5) {
            if (turn) {
                System.out.println("\nPlayer 1's turn");

                guess = player1.guessFace(); // get usr guess value
                flipFace = brassCoin.flip(); // get actual value from the coin

                if (guess.equalsIgnoreCase(flipFace)) { // if guess value == actual value
                    player1.earnPoint(); // earn 1 point
                    System.out.println("Player 1: " + player1.getPoint()); // show point to the screen
                    turn = false; // change turn
                } else {
                    player1.lostPoint(); // lost 1 point
                    System.out.println("Player 1: " + player1.getPoint());
                    turn = false; // change turn
                }
            } else {
                System.out.println("\nPlayer 2's turn");

                guess = player2.guessFace();
                flipFace = brassCoin.flip();

                if (guess.equalsIgnoreCase(flipFace)) {
                    player2.earnPoint();
                    System.out.println("Player 2: " + player2.getPoint());
                    turn = true;
                } else {
                    player2.lostPoint();
                    System.out.println("Player 2: " + player2.getPoint());
                    turn = true;
                }
            }
        }

        // shout out the winner
        if(player1.getPoint() > player2.getPoint()){
            System.out.println("Player 1 is the winner with " + player1.getPoint() + " pts");
        } else System.out.println("Player 2 is the winner with " + player2.getPoint() + " pts");
    }
}
