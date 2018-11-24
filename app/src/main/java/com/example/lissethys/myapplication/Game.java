package com.example.lissethys.myapplication;

public class Game {
    private Dice dice1 = new Dice();
    private Dice dice2 = new Dice();
    private Dice dice3 = new Dice();

    public void rollDices(){
        if(!dice1.isStuck()){
            dice1.rollDice();
        }
        if(!dice2.isStuck()){
            dice2.rollDice();
        }
        if(!dice3.isStuck()){
            dice3.rollDice();
        }
    }

}
