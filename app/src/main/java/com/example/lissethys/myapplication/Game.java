package com.example.lissethys.myapplication;

public class Game {
    private Dice dice1 = new Dice();
    private Dice dice2 = new Dice();
    private Dice dice3 = new Dice();

    private Player player1;
    private Player player2;

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

    public Dice getDice1() {
        return dice1;
    }
    public Dice getDice2() {
        return dice2;
    }
    public Dice getDice3() {
        return dice3;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
}
