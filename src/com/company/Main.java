package com.company;

public class Main {

    public static void main(String[] args) {
        Gameplay.startGame();                      /* Run startGame method from Gameplay */
//        Gameplay.showHand(Gameplay.playersList); /* Run playerTurn method from Gameplay */
        Gameplay.playerTurn();
    }
}