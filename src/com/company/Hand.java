package com.company;

import java.util.ArrayList;

public class Hand {
    public static ArrayList<Card> hand; // ArrayList for each player's hand
    private static Card C; // Create card Object
    private static Deck deck = new Deck(); // create deck object

    /* Deal Hand to each player */
    public static ArrayList<Card> dealHand() {
        hand = new ArrayList<>();
//        int numOfCards = 5;

        System.out.println("Cards drawn: ");
        for (int i = 0; i < 5; i++) {
            C = deck.drawCard();
            System.out.println(C.toString());
            hand.add(C);
        }
        return hand;
    }
}