package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CPU extends Player {
    ArrayList<PlayingCard> hand = new ArrayList<>(7);

    public CPU(ArrayList<PlayingCard> nand){
        this.hand = nand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PlayingCard> getHand() {
        return this.hand;
    }

    public void setHand(ArrayList<PlayingCard> hand) {
        this.hand = hand;
    }

    public void playHand(){
        //Look at top card
        //Play the same number
        //if not, then play the same suit
        //if not, then play an 8
        //if not then draw a card
        //end turn
    }
}
