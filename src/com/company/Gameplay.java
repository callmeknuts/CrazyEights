package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {

    public static Scanner in = new Scanner(System.in);
    public static ArrayList<Players> playersList; /* Initiate an ArrayList to store players */
    public static ArrayList<Deck> stock;              /* ArrayList for cards that can be picked up */
    public static ArrayList<Card> discard;            /* ArrayList for discarded cards */

    /*
     * Method to start the game
     */

    public static ArrayList<Players> startGame() {
        playersList = new ArrayList<>(); // Create ArrayList of Players
        stock = new ArrayList<>();

        System.out.println("Please enter your name: ");
        String name = in.next();
        ArrayList<Card> hand = Hand.dealHand();           /* Call dealHand method and assign it to the 1st player */
        HumanPlayer player = new HumanPlayer(name, hand); /* Create new player */
        playersList.add(player);                          /* Add player to list of players */

        ArrayList<Card> comHand = Hand.dealHand();
        ComputerPlayer com = new ComputerPlayer("Com", comHand);
        playersList.add(com);

        int size = Hand.deck.getTotalCards();
        System.out.println(size);
        return playersList;
    }

    /*
     * Method for each players turn
     */

    public static void playerTurn(ArrayList<Players> playersList) {
        playersList.forEach(System.out::println);
    }
}