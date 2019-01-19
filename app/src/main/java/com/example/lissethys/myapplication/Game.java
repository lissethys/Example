package com.example.lissethys.myapplication;

public class Game {
    private Dice dice1 = new Dice();
    private Dice dice2 = new Dice();
    private Dice dice3 = new Dice();

    private Player player1;
    private Player player2;

    private Player winner;

    private int turn = 3;

    private boolean rondeStart;

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

    /*public void setTurn(int turn) { //setTurn wordt zogezegd niet gebruikt
        this.turn = turn;
    }**/
    public int getTurn(){
        return this.turn;
    }

    /* methode roll zorgt voor de hele werking van het spel.
     * speler 1 laten rollen --> na 3 keer rollen wordt score van player 1 ge-set
     * Beurt afwisseling
     * speler 2 laten rollen --> na 3 keer rollen wordt score van player 2 ge-set **/
    public void roll(){
        this.winner = null;
        //speler 1 aan de beurt
        if(player1.isTurn()){
            if(turn > 1){
                rondeStart = true;
                rollDices();
                turn--;
            } else if (turn == 1) {
                switchTurn();
                setScorePlayer1();
                //als de dices vastliggen worden deze hier terug vrij gemaakt
                if(dice1.isStuck()) dice1.changeStuck();
                if(dice2.isStuck()) dice2.changeStuck();
                if(dice3.isStuck()) dice3.changeStuck();
                rollDices();
                this.turn = 3;
            }
        //speler 2 aan de beurt
        }else{
            if(turn > 1){
                rollDices();
                turn--;
            } else if (turn == 1) {
                switchTurn();
                setScorePlayer2();
                if(dice1.isStuck()) dice1.changeStuck();
                if(dice2.isStuck()) dice2.changeStuck();
                if(dice3.isStuck()) dice3.changeStuck();
                rondeStart = false;
                rollDices();
                this.turn = 3;
            }
        }
        //Wanneer speler 2 gespeeld heeft start nieuwe ronde
        //vergelijkt de score en doet 1 turf weg bij de winnaar van die ronde
        if(!rondeStart){
            if(player1.getCompareScore() > player2.getCompareScore()){
                player1.decreaseTurf();
            }else{
                player2.decreaseTurf();
            }
        }
        //checkt elke keer of iemand al op 0 is
        //wanneer iemand op 0 dan is er winnaar
        if(player1.getTurf() == 0){
            this.winner = player1;
        }else if(player2.getTurf() == 0){
            this.winner = player2;
        }
    }

    public Player getWinner() {
        return winner;
    }

    /* methode rollDices zorgt ervoor dat dices niet rollen wanneer ze vast gezet worden en vice versa**/
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

    /* methode switchTurn zorgt voor afwisseling van beurt**/
    public void switchTurn(){
        if(player1.isTurn()){
            player1.setTurn(false);
            player2.setTurn(true);
        }else{
            player2.setTurn(false);
            player1.setTurn(true);
        }
    }

    /* methode setScorePlayer1 neemt de score van player1 uit player klasse en zet deze in het scorebord**/
    public void setScorePlayer1(){
        Counter counter = new Counter(dice1,dice2,dice3);
        this.player1.setCompareScore(counter.getScore());
    }

    /* methode setScorePlayer2 neemt de score van player2 uit player klasse en zet deze in het scorebord**/
    public void setScorePlayer2(){
        Counter counter = new Counter(dice1,dice2,dice3);
        this.player2.setCompareScore(counter.getScore());
    }
}
