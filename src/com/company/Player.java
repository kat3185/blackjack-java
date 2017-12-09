package com.company;

public class Player {
    private String name;
    private boolean isComputer;
    private Hand hand;

    Player(String name, boolean isComputer) {
        this.name = name;
        this.isComputer = isComputer;
        this.hand = new Hand();
    }

    public boolean isComputer() {
        return isComputer;
    }

    public boolean busts() {
        return getHandValue() > 21;
    }

    public String bustMessage() {
        return String.format("%s busts!  They looooose!", getName());
    }

    public String printableHandValue() {
        return String.format("%s's total hand value is: %s", getName(), handValue());
    }

    public String printableHand() {
        String message = hand.showCards();
        return String.format("%s%s", getName(), message);
    }

    public int getHandValue() {
        return hand.getValue();
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public String getName() {
        return name;
    }

    private String handValue() {
        return String.valueOf(getHandValue());
    }
}
