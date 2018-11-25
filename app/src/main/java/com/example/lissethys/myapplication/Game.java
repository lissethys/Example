package com.example.lissethys.myapplication;

public class Game {
    private Dice dice1 = new Dice();
    private Dice dice2 = new Dice();
    private Dice dice3 = new Dice();

    private Player player1;
    private Player player2;

    private int turn = 3;


    public Dice getDice1() {
        return dice1;
    }
    public Dice getDice2() {
        return dice2;
    }
    public Dice getDice3() {
        return dice3;
    }

    public Player getPlayer1() {
        return player1;
    }
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getTurn(){
        return this.turn = turn;
    }

    public void roll(){
        if(turn > 1){
            rollDices();
            turn--;
        } else if (turn == 1) {
            switchTurn();
            rollDices();
            turn = 3;
        }
    }

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

    public void switchTurn(){
        if(player1.isTurn()){
            player1.setTurn(false);
            player2.setTurn(true);
        }else{
            player2.setTurn(false);
            player1.setTurn(true);
        }
    }
}
