package com.example.lissethys.myapplication;

public class Player {
    private String name;
    private boolean turn;
    private int points;

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
}
