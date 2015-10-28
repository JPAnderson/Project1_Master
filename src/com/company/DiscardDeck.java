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

    public void stripCard(PlayingCard x){
        char suit = x.getSuit();
        int value = x.getValue();
    }
}
