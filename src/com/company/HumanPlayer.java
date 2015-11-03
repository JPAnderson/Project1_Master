package com.company;

import java.util.ArrayList;

public class HumanPlayer extends Player {

    ArrayList<PlayingCard> hand = new ArrayList<>(7);
    boolean winner;

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
        System.out.println("What card to play? ");
        int cardToPull = scanner.nextInt();
        PlayingCard pulledCard = this.hand.remove(cardToPull);
        return pulledCard;
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
}
