package com.company;


import java.util.Scanner;
import java.util.Stack;

public class DiscardDeck {

    protected Stack<PlayingCard> discardDeck = new Stack<>();
    private char out;
    boolean validCard;

    public void getCard(PlayingCard y){
        discardDeck.push(y);
    }

    public PlayingCard peek(){
        return discardDeck.peek();
    }


    /*
     * This method takes the card the human played, and the face up card, and
     * strips the cards to their values and their suits. It then compares if any
     * are equivalent, and if yes, passed true back to main. If not, it displays as such,
     * and the data validation is handled in main
     */
    public boolean stripHumanCard(PlayingCard cardPlayed, PlayingCard cardUp){
            char suit = cardPlayed.getSuit();
            int value = cardPlayed.getValue();

            char otherSuit = cardUp.getSuit();
            int otherValue = cardUp.getValue();

            if (cardPlayed.getValue() == 8) {
                this.discardDeck.push(cardPlayed);
                validCard = true;
            } else if (value == otherValue) {
                this.discardDeck.push(cardPlayed);
                validCard = true;
            } else if (suit == otherSuit) {
                this.discardDeck.push(cardPlayed);
                validCard = true;
            } else {
                System.out.println("Not a legal card!");
                validCard = false;
            }
        return validCard;
        }

    /*
  * This method accepts a string that was passed in by the player
  * with the name of the suit they want. That's then put in a switch statement
  * that determines the correct suit.
  */
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

