package com.company;

/*
 * This class is what all the playing card objects are built from.
 * A playing card has a value and a suit, which are an int and a
 * char respectively.
 */
public class PlayingCard {
    private int value;
    private char suit;
    private String name;

    public char getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
 /*
  * This method takes the value and the char of a card
  * and makes them their own values. Used in comparing
  * equivelancy to other playing cards.
  */
    public PlayingCard(int value, char suit){
        this.value = value;
        this.suit = suit;
        this.name = (value + " of " + suit);
    }

    /*
     * This returns the formal name of the card.
     */
    public String toString(){
        return name;
    }
}
