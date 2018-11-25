package com.example.lissethys.myapplication;

public class Player {
    private String name;
    private boolean turn = false;
    private int score = 0;

    public Player(String name){
        this.setName(name);
    }
    public String getName() {
        return name;
    }

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
