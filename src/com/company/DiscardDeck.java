package com.company;


import java.util.Scanner;
import java.util.Stack;

public class DiscardDeck {
    protected Stack<PlayingCard> discardDeck = new Stack<>();
    private boolean playEight = false;
    private char suit;
    private PlayingCard card;
    private char out;

    public void getCard(PlayingCard y){
        discardDeck.push(y);
    }

    public void peekAtCard(){
        System.out.println(discardDeck.peek());
    }

    public void stripHumanCard(PlayingCard cardPlayed, PlayingCard cardUp){
        char suit = cardPlayed.getSuit();
        int value = cardPlayed.getValue();

        char otherSuit = cardUp.getSuit();
        int otherValue = cardUp.getValue();

        if(cardPlayed.getValue() == 8){
            this.discardDeck.push(cardPlayed);
        }
        else if(value == otherValue){
            this.discardDeck.push(cardPlayed);
        }
        else if (suit == otherSuit){
            this.discardDeck.push(cardPlayed);
        }
        else{
            System.out.println("That's an invalid card! FAGGOT!!!!!");
        }
    }

    public void stripCPUCard(PlayingCard cardPlayed, PlayingCard cardUp){
        char suit = cardPlayed.getSuit();
        int value = cardPlayed.getValue();

        char otherSuit = cardUp.getSuit();
        int otherValue = cardUp.getValue();

        if(value == 8){

        }
        else if(value == otherValue){
            this.discardDeck.push(cardPlayed);
        }
        else if(suit == otherSuit){
            this.discardDeck.push(cardPlayed);
        }
        else {
            System.out.println("That is not a legal card!");
        }
    }

    public char switchSuit(String suit){
        String suitToLower = suit.toLowerCase();
        switch(suitToLower){
            case "spades": out = '\u2660';
                break;
            case "clubs": out = '\u2663';
                break;
            case "hearts": out = '\u2665';
                break;
            case "diamonds": out = '\u2666';
                break;
            default:
                System.out.println("Please pick a valid suit");
                break;
        }
        return out;
    }


}

