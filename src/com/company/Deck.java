package com.company;
import java.util.*;

public class Deck {
    private static String[] suits = new String[] {"♠", "♥", "♦", "♣"};
    private static int[] ranks = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private List<Card> cards = new ArrayList<Card>();

    Deck() {
        this.cards = populateCards();
    }

    public void dealTo(Player player) {
        Card card = cards.remove(cards.size() - 1);
        player.receiveCard(card);
    }

    private List<Card> populateCards() {
        for(String suit : suits)
        {
            for(int rank : ranks)
            {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
        return cards;
    }
}
