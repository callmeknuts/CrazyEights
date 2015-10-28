package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {

    public static Scanner in = new Scanner(System.in);
    public static ArrayList<HumanPlayer> playersList; /* Initiate an ArrayList to store players */
    public static ArrayList<Deck> stock;              /* ArrayList for cards that can be picked up */
    public static ArrayList<Card> discard;            /* ArrayList for discarded cards */

    /*
     * Method to start the game
     */

    public static ArrayList<HumanPlayer> startGame() {
        playersList = new ArrayList<>(); // Create ArrayList of Players
        stock = new ArrayList<>();
        System.out.println("Please enter the number of players.");
        int numPlayers = in.nextInt();

        /*
         * Create players to start the game
         */

        for (int i = 0; i < numPlayers ; i++) {
            System.out.println("Please enter your name: ");
            String name = in.next();
            ArrayList<Card> hand = Hand.dealHand();           /* Call dealHand method and assign it to a hand for each player */
            HumanPlayer player = new HumanPlayer(name, hand); /* Create new players */
            playersList.add(player);
        }
//        stock =
        return playersList;
    }

    /*
     * Method for each players turn
     */

    public static void playerTurn(ArrayList<HumanPlayer> playersList) {
        playersList.forEach(System.out::println);
    }
}