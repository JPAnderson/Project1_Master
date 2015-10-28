package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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

        System.out.println("Here is your hand:"); //Show the player the cards in their hand
        System.out.println(human.getHand());


        /* Any variables that are 'x' or similar
         * are PURELY PLACEHOLDERS. They're there
         * to see if I can run something. If it works
         * I change them to something more useful.
         */

        PlayingCard x = mainDeck.popTop();
        discardDeck.getCard(x);
        System.out.println("Card up: ");
        discardDeck.peekAtCard();

        System.out.println("What would you like to play?");



    } //E.O.F.
} //E.O.C
