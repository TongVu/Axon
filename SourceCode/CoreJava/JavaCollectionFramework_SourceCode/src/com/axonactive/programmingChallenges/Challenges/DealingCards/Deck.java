package com.axonactive.programmingChallenges.Challenges.DealingCards;

import java.util.*;

/**
 * have a list of 52 Card object
 * each representing a valid card in a deck of cards.
 * + shuffle() randomly shuffles the Card objects in the list
 * + deal() deals a card from the deck: removing the Card obj at the beginning of the list
 * and returning a reference to that obj
 */
public class Deck {
    private List<Card> cards = new LinkedList<>();
    private final String[] suits = {
            "Spade", "Club", "Diamond", "Heart"
    };
    private String[] cardValues = {
            "Ace", "2", "3",
            "4", "5", "6", "7",
            "8", "9", "10",
            "Jack", "Queen", "King",
    };

    public Deck() {
//        String[] suits = {
//                "Spade", "Club", "Diamond", "Heart"
//        };
//        String[] cardValues = {
//                "Ace", "2", "3",
//                "4", "5", "6", "7",
//                "8", "9", "10",
//                "Jack", "Queen", "King",
//        };

        for (String suit : suits) {
            for (String val : cardValues) {
                cards.add(new Card(suit, val));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
//        if(cards.size() == 0) throw new RuntimeException("No card to deal");

        Card tmp = cards.get(0);
        cards.remove(0);
        return tmp;
    }

}
