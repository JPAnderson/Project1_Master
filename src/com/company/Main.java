package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PlayingCard newCard;
        DiscardDeck discardDeck = new DiscardDeck();
        DrawDeck mainDeck = new DrawDeck(); //These lines create a new deck
        mainDeck.createDeck();              //and shuffle it.
        mainDeck.shuffle();

        ArrayList<PlayingCard> humanHand = mainDeck.dealToOne();
        ArrayList<PlayingCard> computerHand = mainDeck.dealToTwo();
        HumanPlayer human = new HumanPlayer(humanHand); //These set up empty
        CPU computer = new CPU(computerHand);              //human and CPU players
        human.setScore(0);                     //with 0 score.
        computer.setScore(0);

        System.out.println("Welcome to crazy 8s");  //Intro sequence.
        System.out.println("What is your name?");   //Create scanner, get
        Scanner s = new Scanner(System.in);         //player name.

        human.setName(s.nextLine());    //Set the player's name
        computer.setName("CPU");        //Set the CPU's name as CPU


        PlayingCard firstOff = mainDeck.popTop();
        discardDeck.getCard(firstOff);

        boolean winner = (false);
        while(!winner) {

            System.out.println("Your hand:");
            System.out.println(human.getHand() + "\n");

            System.out.println("Card up: ");
            discardDeck.peekAtCard();
            System.out.println("");

            PlayingCard humanTurn = human.playCard();
            PlayingCard cunt;
            if(humanTurn.getValue() == 8){
                System.out.println("pick a fucking suit");
                String fuck = s.nextLine();
                char fuckEveryone = discardDeck.switchSuit(fuck);
                PlayingCard shit = new PlayingCard(8, fuckEveryone);
                human.fuckYou(shit);
                human.remove();
                discardDeck.getCard(shit);
                discardDeck.stripHumanCard(shit, firstOff);
            }

            discardDeck.stripHumanCard(humanTurn, firstOff);
//            winner = human.checkHumanWinner();
            firstOff = humanTurn;

            //computer's turn
            //back to top
        }
        System.out.println("We have a winner!");



    } //E.O.F.
} //E.O.C
