package com.example.lissethys.myapplication;

public class Player {
    private String name;
    private boolean turn = false;
    private String displayScore;
    private int compareScore;
    private int turf = 5;

    public Player(String name){
        this.setName(name);
    }
    public String getName() {
        return name;
    }

    /* ja niemand wilt/mag toch          noemen ? of nie ?**/
    public void setName(String name) {
        if(name != null || name.trim().isEmpty()){
            this.name = name;
        }
    }

    public boolean isTurn() {
        return turn;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public String getDisplayScore() {
        return displayScore;
    }

    /* methode setDisplayScore wordt opgeroepen wanneer setCompareScore wordt gedaan om automatisch een displayScore te hebben**/
    public void setDisplayScore(int compareScore) {
        switch(compareScore){
            case 300:
                this.displayScore = "drie azen";
                break;
            case 299:
                this.displayScore = "soixante-neuf";
                break;
            case 298:
                this.displayScore = "zand van 5";
                break;
            case 297:
                this.displayScore = "zand van 4";
                break;
            case 296:
                this.displayScore = "zand van 3";
                break;
            case 295:
                this.displayScore = "zand van 2";
                break;
            default:
                this.displayScore = "" + compareScore;
                break;
        }
    }

    public int getCompareScore() {
        return compareScore;
    }

    /* methode setCompareScore om een oud vlaams spel te kunnen doen werken op een pc moest het zo. pareltje van inventiviteit**/
    public void setCompareScore(int compareScore) {
        this.compareScore = compareScore;
        setDisplayScore(compareScore);
    }

    /* Moet ik hier uitleg bij geven.... lisse thys...**/
    public void decreaseTurf(){
        turf--;
    }

    public int getTurf() {
        return turf;
    }
}
