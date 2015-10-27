package com.company;
import java.util.ArrayList;

public class Computer extends Players {
    public Computer(String name, ArrayList<Card> hand){
        this.name = name;
        this.hand = hand;
    }
}