package com.company;

public class Card {
    private int rank, suit;

    // build array that card object will pull rank and suit from
    // plurals of suit/rank denotes use of the array not the individual card
    private static String[] suits = {"Clubs","Spades","Diamonds", "Hearts"};
    private String[] ranks = {"Ace", "King","Queen","Jack", "10", "9", "8", "7", "6","5","4","3","2"};

    //method to return card rank
    public Card(int suit, int rank){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {return ranks[rank] + " of " + suits[suit];}
}