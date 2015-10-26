package com.company;

/*
* This class also inherits from Deck.
* it is the deck that players discard to
* and also has a few methods of its own
*/

//TODO: Collect all(?)
/* ^ don't do until you have more information */


public class DiscardDeck extends Deck {

//    public void acceptCard(int Card){
//        this.deckStack.add(Card);
//    }

    public void peekAtDeck(){
        System.out.println(deckStack.peek());
    }
}
