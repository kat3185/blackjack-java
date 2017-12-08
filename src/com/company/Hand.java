package com.company;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public List<Card> cards = new ArrayList<Card>();

    public Hand(){

    }

    public List<Card> getCards() {
        return cards;
    }

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
        if (value < 12 && hasAce) {
            value += 10;
        }
        return value;
    }

    public String showCards() {
        StringBuilder cardsToPrint;
        cardsToPrint = new StringBuilder();
        for(Card card : cards) {
            cardsToPrint.append(card.printableSummary());
        }
        return cardsToPrint.toString();
    }
}
