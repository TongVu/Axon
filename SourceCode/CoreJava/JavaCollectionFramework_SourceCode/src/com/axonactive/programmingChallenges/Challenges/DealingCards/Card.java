package com.axonactive.programmingChallenges.Challenges.DealingCards;

/**
 * This class represent a card from a deck of cards.
 * The class is able to store a card's suit and face value
 * Card's suit can be one of the following: Hearts, Diamonds, Spades, or Clubs
 * Card's face value can be Ace, Jack, Queen, King, or value in the range of two through ten
 */

public class Card {
    private String suit;
    private String face;

    Card(String suit, String face) {
        this.suit = suit;
        this.face = face;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

}
