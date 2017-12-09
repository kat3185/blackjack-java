package com.company;

public class Player {
    private String name;
    private boolean isComputer;
    public Hand hand;

    Player(String name, boolean isComputer) {
        this.name = name;
        this.isComputer = isComputer;
        this.hand = new Hand();
    }

    public boolean isComputer() {
        return isComputer;
    }

    public String getName() {
        return name;
    }

    public String showHand() {
        String message = hand.showCards();
        return String.format("%s %s", getName(), message);
    }

    public String handValue() {
        return String.valueOf(hand.getValue());
    }

    public boolean busts() {
        return hand.getValue() > 21;
    }
}
