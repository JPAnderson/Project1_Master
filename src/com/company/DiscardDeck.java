package com.company;


import java.util.Stack;

public class DiscardDeck {
    protected Stack<PlayingCard> discardDeck = new Stack<>();

    public void getCard(PlayingCard y){
        discardDeck.push(y);
    }

    public void peekAtCard(){
        System.out.println(discardDeck.peek());
    }

    public void stripCard(PlayingCard cardPlayed, PlayingCard cardUp){
        char suit = cardPlayed.getSuit();
        int value = cardPlayed.getValue();

        char otherSuit = cardUp.getSuit();
        int otherValue = cardUp.getValue();

        if(value == 8){
            this.discardDeck.push(cardPlayed);
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
}
