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
        if (numPlayers == 2) {

            /* HumanPlayer 1 */
            System.out.println("Please enter your name HumanPlayer 1");
            String name1 = in.next();
            ArrayList<Card> p1Hand;
            p1Hand = Hand.dealHand();

            /* HumanPlayer 2 */
            System.out.println("Please enter your name HumanPlayer 2");
            String name2 = in.next();
            ArrayList<Card> p2Hand;
            p2Hand = Hand.dealHand();

            /* Create HumanPlayer Objects */
            HumanPlayer humanPlayer1 = new HumanPlayer(name1, p1Hand);
            HumanPlayer humanPlayer2 = new HumanPlayer(name2, p2Hand);

            /* Create ArrayList of Players */
            players = new ArrayList<>();
            players.add(humanPlayer1);
            players.add(humanPlayer2);
        }
        return players;
    }
    /* Method for each players turn */
    public static void playerTurn(ArrayList<HumanPlayer> players) {
        players.forEach(System.out::println);
    }
}
