package com.company;

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

    public PlayingCard(int value, char suit){
        this.value = value;
        this.suit = suit;
        this.name = (value + " of " + suit);
    }

    public String toString(){
        return name;
    }
}
