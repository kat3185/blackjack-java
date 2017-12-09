package com.company;
import java.util.Scanner;

public class Game {
    public Player player;
    public Player computer;
    public Deck deck;

    public Game() {
        this.player = inputPlayerName();
        this.computer = new Player("Computer", true);
        this.deck = new Deck();
    }

    public void play() {
        System.out.println("It's gamblin time!");
        dealHands();

        System.out.println(player.showHand());
        printHandValue(player);

        Turn playerTurn = new Turn(player);
        playerTurn.take();
        if (player.busts()) {
            System.out.println("You loooose!  Sucka.");
        } else {
            printHandValue(player);
        }



//        System.out.println(this.deck.showCards());
//        System.out.println(this.deck.countCards());
    }

    private void printHandValue(Player person) {
        System.out.println(String.format("Your total hand value is: %s", person.handValue()));
    }

    private void dealHands() {
        deck.dealTo(player);
        deck.dealTo(player);
        deck.dealTo(computer);
        deck.dealTo(computer);
    }

    private Player inputPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String playerName = scanner.next();
        String welcomeMessage = String.format("Thank you for playing Blackjack, %s", playerName);
        System.out.println(welcomeMessage);
        return new Player(playerName, false);
    }

    private class Turn {
        public Player player;
        public boolean stand;
        public Turn(Player player) {
            this.player = player;
            this.stand = false;
        }

        public void take() {
            while (!getStand() && !player.busts()) {
                hitOrStand();
            }
        }

        public void setStand(boolean value) {
            this.stand = value;
        }

        public boolean getStand() {
            return this.stand;
        }

        public void playerChoosesStand() {
            setStand(true);
        }

        public void hitOrStand() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hit or stand? (h/s)");
            String input = scanner.next().toLowerCase();
            if (input.equals("s")) {
                playerChoosesStand();
            } else if (input.equals("h")) {
                deck.dealTo(player);
                System.out.println(player.showHand());
                System.out.println(String.format("Your total hand value is: %s", player.handValue()));
            }
        }
    }
}
