package com.company;

import java.util.ArrayList;
import java.util.Collections;

/* This class inherits from "Deck". It is the
Draw pile and may be called the "main deck" */

public class DrawDeck extends Deck {
    public ArrayList<Integer> hand = new ArrayList<>(7);

    public void shuffle(){
        Collections.shuffle(deckStack);
    }

    public ArrayList firstDeal(){      // Pops 7 cards from the deck into
        for(int i = 0; i <= 6; i++){   // an array list, which is passed
            hand.add(deckStack.pop()); // to a player.
        }
        return hand;
    }

    public void print(){

    }


}

