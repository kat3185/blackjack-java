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

        


//        System.out.println(this.deck.showCards());
//        System.out.println(this.deck.countCards());
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
}
