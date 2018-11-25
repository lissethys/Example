package com.example.lissethys.myapplication;

public class main {
    public static void main(String[] args) {
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        Dice dice3 = new Dice(6);

        System.out.println(dice1.getDice() + "\n" + dice2.getDice() + "\n" + dice3.getDice());

        Counter counter = new Counter(dice1,dice2,dice3);
        System.out.println(counter.getScore());
    }
}
