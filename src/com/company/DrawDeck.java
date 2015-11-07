package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/* This class inherits from "Deck". It is the
Draw pile and may be called the "main deck" */

public class DrawDeck extends Deck {
    public ArrayList<PlayingCard> forPlayerOne = new ArrayList<>(7);
    public ArrayList<PlayingCard> forPlayerTwo = new ArrayList<>(7);

                                                            //This empty arrayList will be
                                                             //the hand that gets passed to the
                                                             //player.


    public void shuffle(){                    // Shuffles the draw deck. Not a method in
        Collections.shuffle(deckStack);       // Deck because this is the only deck
                                              // we'll ever need to shuffle.
    }

    public ArrayList dealToOne(){      // Pops 7 cards from the deck into
        for(int i = 0; i <= 6; i++){
           // System.out.println(deckStack.peek());
            forPlayerOne.add(deckStack.pop()); // to a player
        }
        return forPlayerOne;
    }

    public ArrayList dealToTwo(){
        for(int i = 0; i <= 6; i++){
            //System.out.println(deckStack.peek());
            forPlayerTwo.add(deckStack.pop()); // to a player
        }
        return forPlayerTwo;
    }

    public PlayingCard popTop(){
        PlayingCard sendCard = deckStack.pop();

        return sendCard;
    }
    public PlayingCard collectCard(){
        PlayingCard card = deckStack.pop();
        return card;
    }




}

