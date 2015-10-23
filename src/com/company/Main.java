package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to crazy 8s");

        DrawDeck mainDeck = new DrawDeck();

        mainDeck.createDeck();
        mainDeck.firstDeal();

        mainDeck.print();

    }
}
