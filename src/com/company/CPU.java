package com.company;

import java.util.ArrayList;
import java.util.Random;

public class CPU extends Player {
    private ArrayList<PlayingCard> hand = new ArrayList<>(7);
    private char out;
    private boolean winner;
    private PlayingCard cardOnDiscard;

    //constructor
    public CPU(ArrayList<PlayingCard> nand){ //Initialize the CPU with the hand dealt to it
        this.hand = nand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCardOnDiscard(PlayingCard cardOnDiscard) {
        this.cardOnDiscard = cardOnDiscard;
    }

    /*
     * This method picks a suit when the CPU plays an 8.
     * It is completely random. A random int between 0 and 3 is picked,
     * and depending on what it is, the suit is picked and returned
     */
    public char suitPicker(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(3);
        switch (randomNumber){
            case 0: out = '\u2660';
                break;
            case 1: out = '\u2663';
                break;
            case 2: out = '\u2665';
                break;
            case 3: out = '\u2666';
                break;
            default:
                break;
        }
        return out;
    }

    public boolean checkCPUWinner(){ //If the CPUs hand is empty, the CPU is the winner
        if(this.hand.isEmpty()){
            this.winner = true ;
        }
        else{
            this.winner = false ;
        }
        return winner;
    }
}

/*
 * There's a discrepancy when the CPU picks an 8. It says the CPU
 * played an 8 of x, which it DID, but the card up will be the 8 of y.
 * This is not a bug. It happens because the computer assigns the new
 * suit AFTER it plays the card.
 */
