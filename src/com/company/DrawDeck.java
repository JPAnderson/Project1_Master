package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/* This class inherits from "Deck". It is the
Draw pile and may be called the "main deck" */

public class DrawDeck extends Deck {
    public ArrayList<PlayingCard> hand = new ArrayList<>(7); //This empty arrayList will be
                                                             //the hand that gets passed to the
                                                             //player.


    public void shuffle(){                    // Shuffles the draw deck. Not a method in
        Collections.shuffle(deckStack);       // Deck because this is the only deck
                                              // we'll ever need to shuffle.
    }

    public ArrayList firstDeal(){      // Pops 7 cards from the deck into
        for(int i = 0; i <= 6; i++){   // an array list, which is passed
            hand.add(deckStack.pop()); // to a player.
        }
        return hand;
    }


//    public void print(){
//        System.out.println();
//    }


}

