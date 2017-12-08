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
}
