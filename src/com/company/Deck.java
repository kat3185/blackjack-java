package com.company;
import java.util.*;
//import com.google.common.collect.ImmutableMap;


public class Deck {
    public static String[] suits = new String[] {"♠", "♥", "♦", "♣"};
    public static int[] ranks = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    public List<Card> cards = new ArrayList<Card>();

    public Deck() {
        for(String suit : suits)
        {
            for(int rank : ranks)
            {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void dealTo(Player player) {
        Card card = cards.remove(cards.size() - 1);
        player.hand.addCard(card);
    }

    public int countCards() {
        return this.cards.size();
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
