package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
         * Descriptions of methods are in their respective classes
         */
        DiscardDeck discardDeck = new DiscardDeck(); //Create a new Discard deck object
        DrawDeck mainDeck = new DrawDeck(); //Create a new Draw deck object
        mainDeck.createDeck(); //Add the cards to the deck
        mainDeck.shuffle(); //Shuffle the cards
        boolean goodToGo; //This is used later as a validation checker.

        ArrayList<PlayingCard> humanHand = mainDeck.dealToOne(); //Create a new Hand of 7 card objects. These will go to the human
        ArrayList<PlayingCard> computerHand = mainDeck.dealToTwo(); //Ditto above, but for the computer
        HumanPlayer human = new HumanPlayer(humanHand); //Create a new human player object. Takes a hand as a parameter
        CPU computer = new CPU(computerHand); //Ditto above.
        human.setScore(0); //Set both the human and computer scores to 0
        computer.setScore(0);
        int humanScoreCounter = 0; //This is an accumulator. When someone wins a games, +1 is added.
        int CPUScoreCounter = 0;

        System.out.println("Welcome to crazy 8s");
        mainDeck.printRules();                      //Intro sequence.
        System.out.println("What is your name?");   //Create scanner, get
        Scanner s = new Scanner(System.in);         //player name.

        human.setName(s.nextLine());    //Set the player's name

        PlayingCard firstOff = mainDeck.popTop(); //Pops the first card off the draw stack
        discardDeck.getCard(firstOff);            //and hands it to the discard deck. This is equivalent
                                                  //to flipping the top card over after the deck is shuffled.

        boolean winner = (false); //Becomes true when there is a winner
        boolean playAgain = false; //Becomes true when the player says they want to play again
        while (!winner && !playAgain) { //Keep playing as long as there's no winner and the user says to do so

            /*
             * Lines 43-45 show the player their hand
             * and the card face up on the discard pile
             */
            System.out.println("Your hand: ");
            System.out.println(human.getHand() + "\n");
            System.out.println("Card up: " + discardDeck.peek());

            PlayingCard spyCard = discardDeck.peek();   //get the top card of the discard deck. Assign it to spyCard

            int validationCounter = 0;  //This variable is used in seeing if the player has and legal cards in their hand.
            boolean noCards = false; //This becomes true if the the player has no legal cards.
            PlayingCard humanTurn; //This becomes the card the human played

            for (PlayingCard card : humanHand) { //For each card in the human's hand..
                int value = card.getValue(); //..get the suit
                char suit = card.getSuit(); //..and get the value

                /* For every card in the player's hand that isn't 8, doesn't match the top discard's
                 * value, or doesn't match the top discard's suit, add 1 to the counter. If the
                 * counter equals the number of cards in the player's hand, they have no legal cards.
                 * set noCards to true. If we find a card that's legal, break the loop as we don't
                 * need to check the rest. (lines 66 - 75)
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
             * (lines  81 - 85)
             */
            if (noCards) {
                PlayingCard cardToAdd = mainDeck.collectCard();
                System.out.println("No legal cards to play. Here's one: " + cardToAdd.toString());
                humanHand.add(cardToAdd);
            }

            /*
             * The gist of lines 93 - 133 is: if the player DOES HAVE legal cards,
             * let them play. If the card the human plays is an 8, matches
             * the suit, or matches the value of the face up card, push that card into
             * the discard stack, and it becomes the new face up card.
             */
            else if (!noCards) {
                goodToGo = false; //For validation
                while(!goodToGo) { //If we're not good to go (!goodToGo) then loop until we are
                    humanTurn = human.playCard(); //Method for playing a card. In HumanPlayer class
                    int index = human.getIndex(); //Used for pulling the card from the player's hand

                    if (humanTurn.getValue() == 8) { //If the card is an 8, get the suit that the player wants with scanner
                        System.out.println("Please pick a new suit for play");
                        String suitChoice = s.nextLine();
                        char suitChose = discardDeck.switchSuit(suitChoice); //Send the player's string to switchSuit, a method in the DiscardDeck class

                        PlayingCard crazyEight = new PlayingCard(8, suitChose); //Instantiates a new card object with the suit of the player's choice
                        /*
                         * Lines 109 - 114 put the new card into the player's hand
                         * and calculate with it. Then it's removed.
                         */
                        PlayingCard twoTimes = human.scopeEvade(crazyEight); //Method in HumanPlayer class
                        human.remove(); //Removes the 0 element from the player's hand
                        discardDeck.getCard(twoTimes); //pushes the player's wild card into the discard stack
                        discardDeck.stripHumanCard(twoTimes, firstOff); //Method for comparing the player's card to the top card. Found in DiscardDeck class
                        firstOff = twoTimes; //Makes the top card the player's card
                        human.clearCard(index); //clears the position of the other 8

                        System.out.println("You played " + firstOff.toString());
                        goodToGo = true; //Everything's valid at this point. Continue the game
                    }
                    else { //If it's not an 8, send it to stripHumanCard to check if it's legal
                        boolean good = discardDeck.stripHumanCard(humanTurn, firstOff);
                        if(good){ //If the card is legal to play...
                            human.clearCard(index); //..remove it from the hand
                            firstOff = humanTurn; //..make it the new topCard

                            System.out.println("You played " + firstOff.toString());
                            goodToGo = true; //Validation finished
                        }
                        else{ //If the card played isn't valid, go back to the start of the while loop
                            goodToGo = false;
                        }
                    }
                }
            }

            /*
             * lines 132 - 168 check if the human won. If yes, display that they did and show
             * the scores of the CPU and the human. After, ask to play again. If yes, then
             * almost everything is cleared and new discard decks, draw decks, players,
             * and player hands are created. Essentially all the set up near the top of
             * main is done again.
             */
            if(human.checkHumanWinner()){ //Check winner method found in human player class
                System.out.println(human.getName() + " won!");
                humanScoreCounter += 1; //add one to the score counter accumulator
                human.setScore(humanScoreCounter);
                System.out.println("CPU wins: " + computer.getScore()); //show total CPU wins
                System.out.println(human.getName() + " wins: " + human.getScore()); //show total human wins

                System.out.println("Would you like to play again?\n('yes' to play again. Anything else for no");
                Scanner scanner = new Scanner(System.in);
                String playAgaim = scanner.nextLine().toLowerCase();
                if(playAgaim.equals("yes")){ //if they want to play again, reset everything except scores.
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
                }
                else{ //If the player doesn't want to keep playing, exit
                    winner = true;
                }
            }

            /************ BEGIN COMPUTER TURN ***********/

            /*
             * The CPU does basically the same thing the human does, there's just no validation
             * because computers do everything perfectly.
             */
            computer.setCardOnDiscard(firstOff); //Show the CPU the face up card

            int cpuValidationCounter = 0; //This works exactly the same way as on line 52, except for the CPU
            boolean noCPUCards = false; //Ditto ^
            PlayingCard CPUTurn; // ^

            for (PlayingCard card : computerHand) { //For each card in the CPUs hand..
                int value = card.getValue(); //..get the suit
                char suit = card.getSuit(); //..and get the value

                /*
                 * Lines 189 -199 do exactly what lines 66 - 75 do.
                 */
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
                computerHand.add(mainDeck.collectCard()); //If the Computer has no legal cards, add a card to it's hand and switch turns
                System.out.println("\nCPU had no cards. Drew one\nPlayer's turn");

            } else if (!noCPUCards) {
                for (PlayingCard card : computerHand) {
                    if (card.getValue() == firstOff.getValue()) { //If the card in the hand's value equals the card that's face up
                        discardDeck.getCard(card); //push card into discard deck
                        computerHand.remove(card); //remove card from CPUs hand
                        firstOff = card; //Top card = card
                        System.out.println("CPU played " + card.toString() + "\n"); //Tell the player the card the CPU played
                        break;

                    } else if (card.getSuit() == firstOff.getSuit()) {// else, if the suit in the hand's value equals the card that's face up
                        discardDeck.getCard(card);
                        computerHand.remove(card);
                        firstOff = card;
                        System.out.println("CPU played " + card.toString() + "\n");
                        break;

                    } else if (card.getValue() == 8) {
                        char newSuit = computer.suitPicker(); //lastly, if a card is an 8
                        PlayingCard passCard = new PlayingCard(8, newSuit);
                        discardDeck.getCard(passCard);
                        computerHand.remove(card);
                        firstOff = passCard;
                        System.out.println("CPU Played " + card.toString() + "\n");
                        break;
                    }
                }
            }
            /*
             * lines 237 - 264 do what lines 132 - 168 do, but check to see if the computer
             * is the winner. This way, a winner is check after every turn.
             */

            if(computer.checkCPUWinner()){
                System.out.println("CPU Won!");
                CPUScoreCounter += 1;
                computer.setScore(CPUScoreCounter);
                System.out.println("CPU wins: " + computer.getScore());
                System.out.println(human.getName() + " wins: " + human.getScore());

                System.out.println("Would you like to play again?\n('yes' to play again. Anything else for no");
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

                }
                else{
                    winner = true;
                }
            }
        }
    } //E.O.F.
} //E.O.C

/*******Final Comments*******/
/*
 * I realize that there's a bit too much code in main. My problem
 * was that I wanted to call methods without instantiating objects.
 * By the time I learned that static methods were what I was looking for,
 * I was too far along to let myself go back and attempt to change everything.
 * I cut my losses and worked in main. If I were to rebuild this program from
 * the ground up, I would use a substantial amount of static methods. I also
 * really wanted to use interfaces, but I couldn't quite come up with a useful
 * way to implement them. I'm sure if I did more research I could come up
 * with a great use here. Also, to come clean, there's no exception handling for what happens
 * when the deck runs out of cards, or when a user enter a bad suit. I started hammering
 * a little too late. Time did not allow.
 */

