package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DrawDeck mainDeck = new DrawDeck(); //These lines create a new deck
        mainDeck.createDeck();              //and shuffle it.
        mainDeck.shuffle();

        HumanPlayer human = new HumanPlayer(); //These set up empty
        CPU computer = new CPU();              //human and CPU players
        human.setScore(0);                     //with 0 score.
        computer.setScore(0);

        System.out.println("Welcome to crazy 8s");
        System.out.println("What is your name?");
        Scanner s = new Scanner(System.in);

        human.setName(s.nextLine());
        computer.setName("CPU");

        ArrayList<PlayingCard> humanHand = mainDeck.firstDeal();     //These lines give both
        ArrayList<PlayingCard> computerHand = mainDeck.firstDeal();  //the player and the computer
        human.setHand(humanHand);                                    //an arrayList of 7 cards.
        computer.setHand(computerHand);                              //This is their hand.

        System.out.println("Here is your hand:");
        System.out.println(human.getHand());






    } //E.O.F.
} //E.O.C
