package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {

    ArrayList<PlayingCard> hand = new ArrayList<>(7);
    boolean winner;
    PlayingCard pulledCard;
    boolean validEntry;
    int index;

    public HumanPlayer(ArrayList<PlayingCard> nand){
        this.hand = nand;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<PlayingCard> getHand() {
        return this.hand;
    }

    public void setHand(ArrayList<PlayingCard> hand) {
        this.hand = hand;
    }

    public PlayingCard playCard(){
        validEntry = false;

        while(!validEntry)
            try {
                System.out.println("What card to play? ");
                int nerd = scanner.nextInt();
                pulledCard = this.hand.get(nerd);
                index = nerd;
                validEntry = true;
            }
            catch(InputMismatchException ime){
                System.out.println("Please enter the INDEX of the card you'd like to play (a number)");
                scanner.next();
            }
            catch(ArrayIndexOutOfBoundsException obe){
                System.out.println("That index doesn't exist, please pick another card");
                scanner.next();
            }
            catch(IndexOutOfBoundsException iobe){
                System.out.println("That index doesn't exist! please pick another card");
                scanner.next();
            }
        return pulledCard;
    }
    public int getIndex(){
        return index;
    }

    public boolean checkHumanWinner(){
        if(this.hand.isEmpty()){
            this.winner = true ;
        }
        else{
            this.winner = false ;
        }
        return winner;
    }

    public PlayingCard scopeEvade(PlayingCard card){
        this.hand.add(0, card);
        return this.hand.get(0);
    }

    public void remove(){
        this.hand.remove(0);
    }

    public void clearCard(int position){
        this.hand.remove(position);
    }


}
