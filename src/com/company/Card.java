package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import com.sun.deploy.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

public class Card {
    public String suit;
    public int rank;
    public static Map<Integer, String> stringRanker = new HashMap<Integer, String>() {{
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

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        if (isFacecard()) {
            return 10;
        } else {
            return getRank();
        }
    }

    public boolean isFacecard() {
        return Arrays.asList(11, 12, 13).contains(getRank());
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

    private String stringifiedRank() {
        return stringRanker.get(getRank());
    }
}
