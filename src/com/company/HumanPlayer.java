package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {

    private ArrayList<PlayingCard> hand = new ArrayList<>(7);
    private boolean winner;
    private PlayingCard pulledCard;
    private boolean validEntry;
    private int index;

    //constructor
    public HumanPlayer(ArrayList<PlayingCard> nand){ //Initialize the human player object with the hand passed to it
        this.hand = nand;
    }
    public int getScore() { //Send the player's score when asked
        return score;
    }

    public void setScore(int score) { //Set the players score when called
        this.score = score;
    }

    public String getName() {  //Set the players named when called
        return name;            //(getters and setters are intuitive to understand, no?)
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PlayingCard> getHand() {
        return this.hand;
    }


    public PlayingCard playCard(){ //called when the player needs to play a card
        validEntry = false; //Data validation checker

        while(!validEntry) //While the entry isn't valid..
            try {
                System.out.println("What card to play? ");
                int card = scanner.nextInt();
                pulledCard = this.hand.get(card); //..get the INDEX of the card the user wants
                index = card; //This will eventually be referred to to remove the card from the player's hand
                validEntry = true; //If everything checked out, the entry was valid, and can skip the catch blocks
            }
            catch(InputMismatchException ime){ //If an input mismatch exception is thrown
                System.out.println("Please enter the INDEX of the card you'd like to play (a number)");
                scanner.next();
            }
            catch(ArrayIndexOutOfBoundsException obe){ //If an array index out of bounds exception is thrown
                System.out.println("That index doesn't exist, please pick another card");
                scanner.next();
            }
            catch(IndexOutOfBoundsException iobe){ //If an index out of bounds exception is thrown
                System.out.println("That index doesn't exist! please pick another card");
                scanner.next();
            }
        return pulledCard; //if everything worked, return the Playing Card object to ()
    }
    public int getIndex(){
        return index;
    }

    public boolean checkHumanWinner(){
        if(this.hand.isEmpty()){ //You win if you have 0 cards in your hand
            this.winner = true ;
        }
        else{
            this.winner = false ;
        }
        return winner;
    }

    /*
     * this method was made to avoid a scope problem I was having.
     * I've since forgotten what it was, but lines () take the playing
     * card, add it to element 0 in the hand, and then return the card
     * itself to (). This method is exclusively used when 8s are played
     * by the player, and the card that's passed to the method is the
     * new card that's made when the player picks a suit for the 8.
     */
    public PlayingCard scopeEvade(PlayingCard card){
        this.hand.add(0, card);
        return this.hand.get(0);
    }

    /*
     * called close to immediately after scopeEvade, this method removes
     * the artificial 8 card placed in element 0 of the hand
     */
    public void remove(){
        this.hand.remove(0);
    }

    /*
     * this removes the card that's played by the player.
     * Not exclusive to 8s.
     */
    public void clearCard(int position){
        this.hand.remove(position);
    }


}
