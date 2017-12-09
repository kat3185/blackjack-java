package com.company;
import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<Card>();

    Hand() { }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int getValue() {
        int value = 0;
        boolean hasAce = false;
        for(Card card : cards)
        {
            if (card.isAce()) {
                hasAce = true;
            }
            value += card.getValue();
        }
        if (hasAce && value < 12) {
            value += 10;
        }
        return value;
    }

    public String showCards() {
        StringBuilder cardsToPrint;
        cardsToPrint = new StringBuilder();
        cardsToPrint.append("'s hand contains:\n");
        for(Card card : cards) {
            cardsToPrint.append(card.printableSummary());
        }
        return cardsToPrint.toString();
    }
}
