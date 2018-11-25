package com.example.lissethys.myapplication;

import java.util.Random;

public class Dice {
    private int number = 0;
    private boolean stuck;

    public Dice(){}

    public Dice(int number){
        this.number= number;
    }

    Random ran = new Random();

    public void rollDice(){
        number=ran.nextInt(6)+1;
    }

    public int getDice(){
        return number;
    }

    public void changeStuck(){
        if(stuck){
            stuck = false;
        }else{
            stuck = true;
        }
    }

    public boolean isStuck(){
        return stuck;
    }

    public int getDiceScore(){
        if(number == 1){
            return 100;
        }else if(number == 6){
            return 60;
        }else{
            return number;
        }
    }
}
