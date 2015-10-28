package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public abstract class Deck{
    protected Stack<PlayingCard> deckStack = new Stack<>();
    private char[] suits = {'\u2660', '\u2665', '\u2663', '\u2666' };
    private Integer[] cards = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private PlayingCard card1;

//    public PlayingCard passCard(int card) {
//        return deckStack.add();
//    }

    public void createDeck(){                                //Creates a deck of 52 cards by
        for(int i = 0; i <= 3; i++){                         //using a nested loop to assign
            for(int j = 0; j <= 12; j++){                    //a number (1-13) to a suit
                card1 = new PlayingCard(cards[j], suits[i]); //(S,C,D,H). Repeats for each suit.
                deckStack.add(card1);
            }
        }
    }

    public void print(){
        PlayingCard card2 = (deckStack.peek());
        System.out.println(card2.toString());
    }

    public void pop(){
        PlayingCard card2 = (deckStack.pop());
        System.out.println(card2.toString());
    }

    /*
    * Deck is shuffling! (probably)
    * the print method is NOT PRINTING
    * from the stack; it is unrelated.
    * That's why it's 13-D every time.
    *
    * UPDATE
    * Dumb hashcode problem again. No
    * idea how to reference objects
    * in the stack by their card name
    *
    * UPDATE
    * Use the .toString method (somewhere)
     */


   
}
