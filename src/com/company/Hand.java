package com.company;

import java.util.ArrayList;

public class Hand {
    public static ArrayList<Card> hand;     // declare an ArrayList for hand
    public static Deck deck = new Deck();  // Refer to Deck instance
    static Card C;                          // Refer to Card Object

    /*
     * Deal Hand to each player
     */

    public static ArrayList<Card> dealHand() {
        hand = new ArrayList<>();
//        System.out.println("Cards drawn: ");
        for (int i = 0; i < 5; i++) {
            C = deck.drawCard();
//            System.out.println(C.toString());
            hand.add(C);
        }
        deck.getTotalCards();
        return hand;
    }
}
    /* Flip card after dealing */
//    public static ArrayList<Deck> stockPile(){
//        stock = new ArrayList<>();
//    }