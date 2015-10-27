package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {
    public static Scanner in = new Scanner(System.in);
    public static ArrayList<HumanPlayer> players;

    /* Method to start the game */
    public static ArrayList<HumanPlayer> startGame() {
        System.out.println("Please enter the number of players.");
        int numPlayers = in.nextInt();
        /* Create players to start the game */
        for (int i = 0; i <= numPlayers ; i++) {
            System.out.println("Please enter your name: ");
            String name = in.next();
            ArrayList<Card> hand = Hand.dealHand(); //call dealHand method and assign it to a hand for each player

            HumanPlayer player = new HumanPlayer(name, hand);//create new players
            players = new ArrayList<>(); //create ArrayList of Players
            players.add(player);
        }

        return players;
    }
    /* Method for each players turn */
    public static void playerTurn(ArrayList<HumanPlayer> players) {
        players.forEach(System.out::println);
    }
}