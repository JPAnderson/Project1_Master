package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public abstract class Deck{
    /*
     * The deck abstract class is what designs the other decks. Any deck
     * object has a createDeck method that makes a stack of 52 cards.
     * Any deck made has a stack that stores playing cards
     */
    protected Stack<PlayingCard> deckStack = new Stack<>();
    private char[] suits = {'\u2660', '\u2665', '\u2663', '\u2666' };
    private Integer[] cards = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private PlayingCard card1;


    public void createDeck(){                                //Creates a deck of 52 cards by
        for(int i = 0; i <= 3; i++){                         //using a nested loop to assign
            for(int j = 0; j <= 12; j++){                    //a number (1-13) to a suit
                card1 = new PlayingCard(cards[j], suits[i]); //(S,C,D,H). Repeats for each suit.
                deckStack.add(card1);
            }
        }
    }
    /*
     * Added this at the last minute to display the formatting rules
     */
    public void printRules(){
        System.out.println("When prompted to play a card, instead of typing the card name,\nplease select the position of the card you'd like to play");
        System.out.println("your hand will look like this: [3 of spades, 5 of hearts, etc]\nTo play the card you want, start from the beginning of your");
        System.out.println("hand with 0, and count until you reach the card you want.\n For example, to play the 5 of hearts, it would be card 1.");
        System.out.println("When playing an 8, you will be prompted to select a new suit.\n The suits are: spades, clubs, diamonds, and hearts. Please enter them in as such.\n");
        System.out.println("Lastly, due to formatting, Jacks are referenced by 11s, queens by 12s, and kings by 13s. ");
    }
}
/*
 * Honestly, this wasn't the best use of an abstract class, but my
 * ideas at the beginning of the project didn't match my needs at the
 * end, and this abstract class has remained since.
 */
