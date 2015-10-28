package com.company;

import java.util.ArrayList;

public class Hand {
    public static ArrayList<Card> hand;     /* ArrayList for each player's hand */
    public static ArrayList<Deck> stock;    /* ArrayList for cards that can be picked up */
    public static ArrayList<Deck> discard;  /* ArrayList for discarded cards */
    private static Deck deck = new Deck();  /* Create deck object */
    static Card C;                          /* Create card Object */

    /*
     * Deal Hand to each player
     */

    public static ArrayList<Card> dealHand() {
        hand = new ArrayList<>();
        System.out.println("Cards drawn: ");
        for (int i = 0; i < 5; i++) {
            C = deck.drawCard();
            System.out.println(C.toString());
            hand.add(C);
        }
        return hand;
    }
    /* Flip card after dealing */
//    public static ArrayList<Deck> stockPile(){
//        stock = new ArrayList<>();
//    }
}