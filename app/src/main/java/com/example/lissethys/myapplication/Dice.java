package com.example.lissethys.myapplication;

import java.util.Random;

public class Dice {
    private int number;
    Random ran = new Random();

    public void rollDice(){
        number=ran.nextInt(6)+1;
    }

    public int getDice(){
        return number;
    }

}
