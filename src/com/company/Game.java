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
        System.out.println("It's gamblin time!");
        dealHands();

        System.out.println(player.showHand());
        printHandValue(player);

        Turn playerTurn = new Turn(player);
        playerTurn.take();
        printHandValue(player);
        if (player.busts()) {
            System.out.println("You loooose!  Sucka.");
            System.exit(0);
        }

        Turn computerTurn = new Turn(computer);
        computerTurn.take();
        printHandValue(computer);
        if (computer.busts()) {
            System.out.println("Computer busts!  You win!");
            System.exit(0);
        }

        printOutcome();
    }

    private void printOutcome() {
        int playerScore = player.hand.getValue();
        int computerScore = computer.hand.getValue();
        String outcome;
        if (playerScore == computerScore) {
            outcome = "It's a tie! |-o-|";
        } else if (playerScore > computerScore) {
            outcome = "Player wins!";
        } else {
            outcome = "Computer wins!";
        }
        System.out.println(outcome);
    }

    private void printHandValue(Player person) {
        System.out.println(String.format("%s's total hand value is: %s", person.getName(), person.handValue()));
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
        }

        private boolean getStand() {
            return this.stand;
        }

        private void playerChoosesStand() {
            this.stand = true;
        }

        private void chooseHitOrStand() {
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

        private void computerTakesTurn() {
            while (player.hand.getValue() < 17) {
                deck.dealTo(player);
            }
            System.out.println(player.showHand());
            playerChoosesStand();
        }
    }
}
