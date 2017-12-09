package com.company;
import java.util.Scanner;

public class Game {
    private Player player;
    private Player computer;
    private Deck deck;

    Game() {
        this.player = inputPlayerName();
        this.computer = new Player("Computer", true);
        this.deck = new Deck();
    }

    public void play() {
        print("It's gamblin time!");
        dealHands();

        print(player.printableHand());
        print(player.printableHandValue());

        Turn playerTurn = new Turn(player);
        playerTurn.take();

        Turn computerTurn = new Turn(computer);
        computerTurn.take();

        printOutcome();
    }

    private void printOutcome() {
        int playerScore = player.getHandValue();
        int computerScore = computer.getHandValue();
        String outcome;
        if (playerScore == computerScore) {
            outcome = "It's a tie! |-o-|";
        } else if (playerScore > computerScore) {
            outcome = "Player wins!";
        } else {
            outcome = "Computer wins!";
        }
        print(outcome);
    }

    private void print(String value) {
        System.out.println(value);
    }

    private void dealHands() {
        deck.dealTo(player);
        deck.dealTo(player);
        deck.dealTo(computer);
        deck.dealTo(computer);
    }

    private Player inputPlayerName() {
        Scanner scanner = new Scanner(System.in);
        print("Please enter your name: ");
        String playerName = scanner.next();
        String welcomeMessage = String.format("Thank you for playing Blackjack, %s", playerName);
        print(welcomeMessage);
        return new Player(playerName, false);
    }

    private class Turn {
        private Player player;
        private boolean stand;
        private Turn(Player player) {
            this.player = player;
            this.stand = false;
        }

        void take() {
            while (!getStand() && !player.busts()) {
                if (player.isComputer()) {
                    computerTakesTurn();
                } else {
                    chooseHitOrStand();
                }
            }
            announceHand();
            if (player.busts()) {
                print(player.bustMessage());
                System.exit(0);
            }
        }

        private void announceHand() {
            print(player.printableHand());
            print(player.printableHandValue());
        }

        private boolean getStand() {
            return this.stand;
        }

        private void playerChoosesStand() {
            this.stand = true;
        }

        private void chooseHitOrStand() {
            Scanner scanner = new Scanner(System.in);
            print("Hit or stand? (h/s)");
            String input = scanner.next().toLowerCase();
            if (input.equals("s")) {
                playerChoosesStand();
            } else if (input.equals("h")) {
                deck.dealTo(player);
                announceHand();
            }
        }

        private void computerTakesTurn() {
            while (player.getHandValue() < 17) {
                deck.dealTo(player);
            }
            playerChoosesStand();
        }
    }
}
