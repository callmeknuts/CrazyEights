package com.company;

public class Main {

    public static void main(String[] args) {
        Gameplay.startGame(); // Run startGame method from Gameplay
        Gameplay.playerTurn(Gameplay.players); // Run playerTurn method from Gameplay
    }
}
//    Card C;
//    // create deck object
//    Deck deck = new Deck();
//
//    int numOfCards = 5;
//
//    System.out.println("Cards drawn: ");
//    for (int i = 0; i < numOfCards; i++) {
//        C = deck.drawCard();
//        System.out.println(C.toString());
//    }
