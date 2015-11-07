package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CPU extends Player {
    ArrayList<PlayingCard> hand = new ArrayList<>(7);
    private PlayingCard cardOnDiscard;
    char out;
    private boolean winner;

    public CPU(ArrayList<PlayingCard> nand){
        this.hand = nand;
    }

    public void setCardOnDiscard(PlayingCard cardOnDiscard) {
        this.cardOnDiscard = cardOnDiscard;
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

    public PlayingCard playCPUCard(PlayingCard cardII) {
        System.out.println("What card to play? ");
        int cardToPull = scanner.nextInt();
        cardII = this.hand.remove(cardToPull);
        return cardII;
    }

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

    public boolean checkCPUWinner(){
        if(this.hand.isEmpty()){
            this.winner = true ;
        }
        else{
            this.winner = false ;
        }
        return winner;
    }





}
