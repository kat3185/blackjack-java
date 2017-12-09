package com.company;

public class Player {
    public String name;
    public boolean isComputer;
    public Hand hand;

    public Player(String name, boolean isComputer) {
        this.name = name;
        this.isComputer = isComputer;
        this.hand = new Hand();
    }

    public String showHand() {
        return hand.showCards();
    }

    public String handValue() {
        return String.valueOf(hand.getValue());
    }

    public boolean busts() {
        return hand.getValue() > 21;
    }
}
