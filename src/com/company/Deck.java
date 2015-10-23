package com.company;

import java.lang.reflect.Array;
import java.util.Stack;


public abstract class Deck implements Card{
    protected Stack<Integer> deckStack = new Stack<>();
    private char[] suits = {'\u2660', '\u2665', '\u2663', '\u2666' };
    private int[] cards = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    public int passCard(int card) {
        return deckStack.pop();
    }

    public void createDeck(){
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 12; j++){
                deckStack.add(suits[i] + cards[j]);
            }
        }
    }
}
