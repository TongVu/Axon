package com.axonactive.programmingChallenges.Challenges.DealingCards;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class keep a list of Car obj that have been dealt to it.
 * This represents a hand of cards.
 * + getCard(Card obj): added to the list
 * + showCards displays the Card obj in the list
 */
public class CardPlayer {
    private List<Card> playerCards = new LinkedList<>();

    public CardPlayer() {
    }

    public void getCard(Card cardFromDeck) {
        playerCards.add(cardFromDeck);
    }

    public void showCards() {
        Iterator<Card> it = playerCards.iterator();

        while (it.hasNext()) {
            Card tmp = it.next();
            System.out.println(tmp.getFace() + "-" + tmp.getSuit());
        }
    }
}
