package com.example.lissethys.myapplication;

// Klasse om de score te tellen die een player gegooid heeft om daarna met de andere speler te kunnen vergelijken

public class Counter {
    private int score;

    public Counter(Dice dice1, Dice dice2, Dice dice3) {
        if(dice1.getDice() == dice2.getDice() && dice2.getDice() == dice3.getDice()){
            //wanneer alle 3 de dices gelijk zijn wordt er zand gegooid en is meer waard dan eenders welke worp
            switch(dice1.getDice()){
                case 1:
                    score = 300;
                    break;
                case 5:
                    score = 298;
                    break;
                case 4:
                    score = 297;
                    break;
                case 3:
                    score = 296;
                    break;
                case 2:
                    score = 295;
                    break;
                case 6:
                    score = 180; //wrm 180? Is zand van 6 niet hoger dan zand van 5?
                    break;
                default:
                    break;
            }
        }else if((dice1.getDice() == 6 && dice2.getDice() == 5 && dice3.getDice() == 4) || (dice1.getDice() == 4 && dice2.getDice() == 6 && dice3.getDice() == 5) || (dice1.getDice() == 5 && dice2.getDice() == 4 && dice3.getDice() == 6)){
            score = 299; //wanneer de getallen 4,5,6 zijn is dit soixante-neuf en is dit meer waard dan zand maar minder dan zand van 1
        }else{
            score = dice1.getDiceScore() + dice2.getDiceScore() + dice3.getDiceScore(); //als er geen speciale worp is worden de scores van de dices gewoon opgeteld
        }
    }

    public int getScore(){
        return score;
    }
}
