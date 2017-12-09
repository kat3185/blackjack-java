package com.company;
import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String suit;
    private int rank;
    private static Map<Integer, String> stringRanker = new HashMap<Integer, String>() {{
        put(1, "A");
        put(2, "2");
        put(3, "3");
        put(4, "4");
        put(5, "5");
        put(6, "6");
        put(7, "7");
        put(8, "8");
        put(9, "9");
        put(10, "10");
        put(11, "J");
        put(12, "Q");
        put(13, "K");
    }};

    Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        if (isFacecard()) {
            return 10;
        } else {
            return getRank();
        }
    }

    public boolean isAce() {
        return getRank() == 1;
    }

    public String printableSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append(stringifiedRank());
        summary.append(getSuit());
        summary.append(", ");
        return String.valueOf(summary);
    }

    private int getRank() {
        return rank;
    }

    private String getSuit() {
        return suit;
    }

    private boolean isFacecard() {
        return Arrays.asList(11, 12, 13).contains(getRank());
    }

    private String stringifiedRank() {
        return stringRanker.get(getRank());
    }
}
