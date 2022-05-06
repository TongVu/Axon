package com.axonactive.programmingChallenges.Challenges.DealingCards;

public class DealingCards {
    public static void main(String[] args) {
        Deck casino = new Deck();
        CardPlayer me = new CardPlayer();

        casino.shuffle(); // shuffle 5 times,
        for (int i = 0; i < 5 ;i++) {
            me.getCard(casino.deal()); // get 5 cards
        }

        me.showCards();
    }
}
