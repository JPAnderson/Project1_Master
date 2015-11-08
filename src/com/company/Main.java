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
        boolean goodToGo;

        ArrayList<PlayingCard> humanHand = mainDeck.dealToOne();
        ArrayList<PlayingCard> computerHand = mainDeck.dealToTwo();
        HumanPlayer human = new HumanPlayer(humanHand); //These set up empty
        CPU computer = new CPU(computerHand);              //human and CPU players
        human.setScore(0);                     //with 0 score.
        computer.setScore(0);
        int humanScoreCounter = 0;
        int CPUScoreCounter = 0;

        System.out.println("Welcome to crazy 8s");  //Intro sequence.
        System.out.println("What is your name?");   //Create scanner, get
        Scanner s = new Scanner(System.in);         //player name.

        human.setName(s.nextLine());    //Set the player's name
        computer.setName("CPU");        //Set the CPU's name as CPU


        PlayingCard firstOff = mainDeck.popTop(); //Pops the first card off the draw stack
        discardDeck.getCard(firstOff);            //and hands it to the discard deck. This is the
        //first card up of the game.
        boolean winner = (false);
        boolean playAgain = false;
        while (!winner && !playAgain) { //Keep playing as long as there's no winner

            System.out.println("Your hand: ");           //Lines 37 - 41 show the player their hand and
            System.out.println(human.getHand() + "\n"); //show the top card of the discard pile, which
            System.out.println("Card up: " + discardDeck.peek());            //is the card calculations are made from. As with
                                                        //everything below the while loop, this code is
                                 //executed every turn.

            PlayingCard spyCard = discardDeck.peek();   //get the top card of the discard deck.

            int validationCounter = 0;  //This variable is used in seeing if the player hay and legal cards in their hand.
            boolean noCards = false; //This becomes true if the the player has no legal cards.
            PlayingCard humanTurn;

            for (PlayingCard card : humanHand) { //For each card in the human's hand..
                int value = card.getValue(); //..get the suit
                char suit = card.getSuit(); //..and get the value

                /* For every card in the player's hand that isn't 8, doesn't match the top discard's
                 * value, or doesn't match the top discard's suit, add 1 to the counter. If the
                 * counter equals the number of cards in the player's hand, they have no legal cards.
                 * set noCards to true; If we find a card that's legal, break the loop as we don't
                 * need to check the rest. (lines 59 - 68)
                 */
                if ((value != spyCard.getValue()) && (suit != spyCard.getSuit()) && (card.getValue() != 8)) {
                    validationCounter += 1;
                    if (validationCounter == humanHand.size()) {
                        noCards = true;
                    }
                } else {
                    noCards = false;
                    break;
                }
            }
            /* If the player has no legal cards, let them know, then
             * pop one off the the draw pile and add it to their hand.
             * (lines  74 - 79)
             */
            if (noCards) {
                PlayingCard cardToAdd = mainDeck.collectCard();
                System.out.println("No legal cards to play. Here's one: " + cardToAdd.toString());
                humanHand.add(cardToAdd);
            }

            else if (!noCards) {
                goodToGo = false;
                while(!goodToGo) {
                    humanTurn = human.playCard();
                    int index = human.getIndex();

                    if (humanTurn.getValue() == 8) {
                        System.out.println("Please pick a new suit for play");
                        String suitChoice = s.nextLine();
                        char suitChose = discardDeck.switchSuit(suitChoice);

                        PlayingCard crazyEight = new PlayingCard(8, suitChose);
                        PlayingCard onceMore = human.scopeEvade(crazyEight);
                        human.remove();
                        discardDeck.getCard(onceMore);
                        discardDeck.stripHumanCard(onceMore, firstOff);
                        firstOff = onceMore;
                        human.clearCard(index);
                        System.out.println("You played " + firstOff.toString());
                        goodToGo = true;
                    } else {

                        boolean good = discardDeck.stripHumanCard(humanTurn, firstOff);
                        if(good){
                            human.clearCard(index);
                            firstOff = humanTurn;
                            System.out.println("You played " + firstOff.toString());
                            goodToGo = true;
                        }
                        else{
                            goodToGo = false;
                        }
                    }
                }
            }

            else {
                System.out.println("CPU's turn");
            }

            if(human.checkHumanWinner()){
                System.out.println(human.getName() + " won!");
                CPUScoreCounter += 1;
                computer.setScore(CPUScoreCounter);
                System.out.println("CPU wins: " + computer.getScore());

                System.out.println("Would you like to play again?");
                Scanner scanner = new Scanner(System.in);
                String playAgaim = scanner.nextLine().toLowerCase();
                if(playAgaim.equals("yes")){
                    winner = false;
                    mainDeck = new DrawDeck();
                    mainDeck.createDeck();
                    mainDeck.shuffle();
                    humanHand = mainDeck.dealToOne();
                    computerHand = mainDeck.dealToTwo();
                    discardDeck = new DiscardDeck();
                    human = new HumanPlayer(humanHand);
                    computer = new CPU((computerHand));
                    firstOff = mainDeck.popTop();
                    discardDeck.getCard(firstOff);
                }else{
                    winner = true;
                }


            }
            computer.setCardOnDiscard(firstOff);

            //computer's turn
            //back to top


            int cpuValidationCounter = 0;  //This variable is used in seeing if the player hay and legal cards in their hand.
            boolean noCPUCards = false; //This becomes true if the the player has no legal cards.
            PlayingCard CPUTurn;

            for (PlayingCard card : computerHand) { //For each card in the human's hand..
                int value = card.getValue(); //..get the suit
                char suit = card.getSuit(); //..and get the value

                if ((value != firstOff.getValue()) && (suit != firstOff.getSuit()) && (card.getValue() != 8)) {
                    cpuValidationCounter += 1;
                    if (cpuValidationCounter == computerHand.size()) {
                        noCPUCards = true;
                        break;
                    }
                } else {
                    noCPUCards = false;
                    break;
                }
            }

            if (noCPUCards) {
                computerHand.add(mainDeck.collectCard());
                System.out.println("CPU had no cards. Drew one\n Player's turn");

            } else if (!noCPUCards) {
                for (PlayingCard card : computerHand) {
                    if (card.getValue() == firstOff.getValue()) {
                        discardDeck.getCard(card);
                        computerHand.remove(card);
                        firstOff = card;
                        System.out.println("CPU played " + card.toString() + "\n");
                        break;

                    } else if (card.getSuit() == firstOff.getSuit()) {
                        discardDeck.getCard(card);
                        computerHand.remove(card);
                        firstOff = card;
                        System.out.println("CPU played " + card.toString() + "\n");
                        break;

                    } else if (card.getValue() == 8) {
                        char newSuit = computer.suitPicker();
                        PlayingCard passCard = new PlayingCard(8, newSuit);
                        discardDeck.getCard(passCard);
                        computerHand.remove(card);
                        firstOff = passCard;
                        System.out.println("CPU Played " + card.toString() + "\n");
                        break;
                    }
                }
            }

            if(computer.checkCPUWinner()){
                System.out.println("CPU Won!");
                CPUScoreCounter += 1;
                computer.setScore(CPUScoreCounter);
                System.out.println("CPU wins: " + computer.getScore());

                System.out.println("Would you like to play again?");
                Scanner scanner = new Scanner(System.in);
                String playAgaim = scanner.nextLine().toLowerCase();
                if(playAgaim.equals("yes")){
                    winner = false;
                    mainDeck = new DrawDeck();
                    mainDeck.createDeck();
                    mainDeck.shuffle();
                    humanHand = mainDeck.dealToOne();
                    computerHand = mainDeck.dealToTwo();
                    discardDeck = new DiscardDeck();
                    human = new HumanPlayer(humanHand);
                    computer = new CPU((computerHand));
                    firstOff = mainDeck.popTop();
                    discardDeck.getCard(firstOff);

                }else{
                    winner = true;
            }

            }
        }

    }
} //E.O.F.
//E.O.C

