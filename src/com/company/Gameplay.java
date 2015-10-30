package com.company;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {

    public static Scanner in = new Scanner(System.in);
    public static ArrayList<Players> playersList;     /* Initiate an ArrayList to store players */
    public static ArrayList<Card> discard;            /* ArrayList for discarded cards */
    public static Card stockCard;
    public static int cardChoice;
    public static String winner;
    public static String playersTurn;

    /*
     * Method to start the game
     */

    public static ArrayList<Players> startGame() {
        playersList = new ArrayList<>(); // Create ArrayList of Players
        discard = new ArrayList<>();     // Create ArrayList for discard pile

        System.out.println("Please enter your name: ");
        String name = in.next();
        ArrayList<Card> hand = Hand.dealHand();           /* Call dealHand method and assign it to the 1st player */
        HumanPlayer player = new HumanPlayer(name, hand); /* Create new player */
        playersList.add(player);                          /* Add player to list of players */

        ArrayList<Card> comHand = Hand.dealHand();
        ComputerPlayer com = new ComputerPlayer("Computer", comHand);
        playersList.add(com);

//        int size = Hand.deck.getTotalCards();
//        System.out.println("Cards left in deck: " + size);

        return playersList;
    }

    /*
     * Method for each players turn
     */

//    public static void showHand(ArrayList<Players> playersList) {
//        //playersList.forEach(System.out::println);
//        for ( Object i : playersList){
//            System.out.println(i);
//        }
//    }

    public static void playerTurn() {

        Scanner in = new Scanner(System.in);
        Card startCard = Hand.deck.drawCard();
        discard.add(startCard);
        boolean currentGame = true;
        while (currentGame)
        for (Players p : playersList) {
            System.out.println(p.getName() + "'s turn");
            System.out.println(p.getHand());
           // while (! p.getHand().isEmpty()){
                stockCard = discard.get(discard.size() - 1);
                System.out.println("Card in play: " + stockCard + "\n");
                int choice = playerMenu();
                if (choice == 1) {
                    Card playerDraw = Hand.deck.drawCard();
                    p.getHand().add(playerDraw);
                    System.out.println(p.getHand());
                } else if (choice == 2) {
                    System.out.println("Card in play: " + stockCard + "\n");
                    System.out.println("Choose the card you'd like to play");//needs to break out of loop
                    ArrayList<Card> cards = p.getHand();
                    for (int i = 0; i < cards.size();i++) {
                        System.out.println((i + 1) + ": " + cards.get(i));
                    }
                    String str = in.nextLine();
                    cardChoice = Integer.parseInt(str);
                    playersTurn = p.getName();
                    playerCard();

                    if( p.getHand().isEmpty()){
                        winner = p.getName();
                        currentGame = false;
                        endGame();
//                        System.out.println("I think you may have won.OH SHIT!!");
                        break;
                    }
                } else if (choice == 3) {
                    System.out.println("Pass function in development.");
                    System.out.println("Fart.");
                }
            }
        }


    public static int playerMenu(){
        System.out.println("(1) Draw Card: ");
        System.out.println("(2) Play Card: ");
        System.out.println("(3) Pass: ");

        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        while (! choice.matches("[1-4]")) {
            System.out.println("Not a valid selection.");
            choice = in.next();
        }
        return Integer.parseInt(choice);
    }
    public static void playerCard(){
        for ( Players p : playersList) {
            if ( p.getName().matches(playersTurn)){
                Players q = p;
                for (int i = 0; i < q.getHand().size(); i++) {
                    if (cardChoice == (i + 1)) {
                        Card j = q.getHand().get(i);
                        int r = j.getRank();
                        int s = j.getSuit();
                        int r1 = stockCard.getRank();
                        int s1 = stockCard.getSuit();
                        if (r == 7) {
                            int wild = wildCard();
                            Card eight = new Card(wild, r);
                            discard.add(eight);
                            q.getHand().remove(i);
                        } else if (r == r1 || s == s1) {
                            System.out.println("Now playing: " + q.getHand().get(i));
                            discard.add(q.getHand().get(i));
                            q.getHand().remove(i);
                        } else {
                            System.out.println("Not a valid action.");
                        }

                    }
                }
            }
        }
    }

    public static int wildCard (){
        System.out.println("What suit would you like to select?");
        System.out.println("(1) Clubs");
        System.out.println("(2) Diamonds");
        System.out.println("(3) Hearts");
        System.out.println("(4) Spades");
        String str = in.next();
        while (! str.matches("[1-4]")) {
            System.out.println("Not a valid selection.");
            str = in.next();
        }
        int suitMorph = Integer.parseInt(str);
        if (suitMorph == 1){
            System.out.println("Suit changed to Clubs.");
        } else if (suitMorph == 2){
            System.out.println("Suit changed to Diamonds");
        } else if (suitMorph == 3){
            System.out.println("Suit changed to Heart");
        } else if (suitMorph == 4){
            System.out.println("Suit changed to Spades");
        }
        suitMorph -= 1;
        return suitMorph;
    }

    public static void endGame(){
        System.out.println( winner + " won the game. You's a bad mamma gamm!\n");
        System.out.println("Do you want to play another game?");
        System.out.println("(1) Yes\n(2) No");
        String str = in.next();
        while (! str.matches("[1-2]")){
            System.out.println("Not a valid selection, please try again.");
            str = in.next();
        }
        int playAgain = Integer.parseInt(str);
        if (playAgain == 1){
            startGame();
        } else if ( playAgain == 2){
            System.exit(0);
        }



        System.exit(0);
    }
}