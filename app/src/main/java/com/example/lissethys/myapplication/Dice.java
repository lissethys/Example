package com.example.lissethys.myapplication;

/* ne Fucking dobbelsteen lisse. allee komaan. met alle methodekes die nodig zijn om het te doen werken.**/
import java.util.Random;

public class Dice {
    private int number = 0;
    private boolean stuck;

    public Dice(){} //wrm deze Dice()?

    public Dice(int number){
        this.number= number;
    }

    Random ran = new Random(); //genereren van een random getal

    //ervoor zorgen dat het random getal tussen 1 en 6 ligt
    public void rollDice(){
        number=ran.nextInt(6)+1;
    } //nextInt(max-min+1)+min;

    //verworven random getal teruggeven
    public int getDice(){
        return number;
    }

    //bepalen of de dice vastligt en teruggeven
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

    //score verbinden met het gegooid getal (1=100, 6=60, 2=2, 3=3, 4=4, 5=5) en teruggeven
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
