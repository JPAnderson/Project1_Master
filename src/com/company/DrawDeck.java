package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/* This class inherits from "Deck". It is the
Draw pile and may be called the "main deck" */

public class DrawDeck extends Deck {
    public ArrayList<PlayingCard> forPlayerOne = new ArrayList<>(7); //These two empty array Lists will be filled with
    public ArrayList<PlayingCard> forPlayerTwo = new ArrayList<>(7); //cards, and passed to human and CPU players

    
    public void shuffle(){                    // Shuffles the draw deck. Not a method in
        Collections.shuffle(deckStack);       // Deck because this is the only deck
                                              // we'll ever need to shuffle.
    }

    public ArrayList dealToOne(){      // Pops 7 cards from the deck into
        for(int i = 0; i <= 6; i++){   // the player's array list hand
            forPlayerOne.add(deckStack.pop());
        }
        return forPlayerOne;
    }

    public ArrayList dealToTwo(){       //pops 7 more cards from the deck int0
        for(int i = 0; i <= 6; i++){    //the computer's array list hand
            forPlayerTwo.add(deckStack.pop());
        }
        return forPlayerTwo;
    }

    /*
     * This method removes the first card on the draw pile
     * and returns it. Used for giving players cards when
     * they have none
     */
    public PlayingCard popTop(){
        PlayingCard sendCard = deckStack.pop();
        return sendCard;
    }

    /*
     * This does exactly the same thing as the method above
     * for no logical reason.
     */
    public PlayingCard collectCard(){
        PlayingCard card = deckStack.pop();
        return card;
    }




}

