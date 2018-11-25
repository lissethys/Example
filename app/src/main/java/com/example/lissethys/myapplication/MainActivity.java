package com.example.lissethys.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Game game = new Game();

    private TextView mDiceTextView1;
    private TextView mDiceTextView2;
    private TextView mDiceTextView3;
    private TextView mTextViewPlayer1;
    private TextView mTextViewPlayer2;
    private TextView mTextViewTurn;
    private TextView mTextViewTurnTo1;
    private TextView mTextViewTurnTo2;
    private TextView mTextViewScore1;
    private TextView mTextViewScore2;
    private TextView mTextViewPoints1;
    private TextView mTextViewPoints2;
    private TextView mTextViewWinner;

    private EditText mEditText;

    private Button mButton;
    private Button mButtonPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDiceTextView1 = findViewById(R.id.textView);
        mDiceTextView2 = findViewById(R.id.textView2);
        mDiceTextView3 = findViewById(R.id.textView3);
        mTextViewPlayer1 = findViewById(R.id.textView_player1);
        mTextViewPlayer2 = findViewById(R.id.textView_player2);
        mTextViewTurn = findViewById(R.id.textView_turn);
        mTextViewTurnTo1 = findViewById(R.id.textView_turnTo1);
        mTextViewTurnTo2 = findViewById(R.id.textView_turnTo2);
        mTextViewScore1 = findViewById(R.id.score1);
        mTextViewScore2 = findViewById(R.id.score2);
        mTextViewPoints1 = findViewById(R.id.points1);
        mTextViewPoints2 = findViewById(R.id.points2);
        mTextViewWinner = findViewById(R.id.textView_winner);


        mEditText = findViewById(R.id.et_player);


        mButton = findViewById(R.id.button);
        mButtonPlayers = findViewById(R.id.buttonAddPlayer);

        mButton.setOnClickListener(this);
        mButtonPlayers.setOnClickListener(this);
        mDiceTextView1.setOnClickListener(this);
        mDiceTextView2.setOnClickListener(this);
        mDiceTextView3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                if(game.getPlayer1() != null && game.getPlayer2() != null) {
                    game.roll();
                    mTextViewScore1.setText(game.getPlayer1().getDisplayScore());
                    mTextViewScore2.setText(game.getPlayer2().getDisplayScore());
                    mTextViewPoints1.setText("" + game.getPlayer1().getTurf());
                    mTextViewPoints2.setText("" + game.getPlayer2().getTurf());

                    if (game.getWinner() != null)
                        mTextViewWinner.setText(game.getWinner().getName());

                    mTextViewTurn.setText("Turn: " + game.getTurn());
                    if (game.getPlayer1().isTurn()) {
                        mTextViewTurnTo1.setText("T");
                        mTextViewTurnTo2.setText("");
                    } else {
                        mTextViewTurnTo1.setText("");
                        mTextViewTurnTo2.setText("T");
                    }

                    mDiceTextView1.setText("" + game.getDice1().getDice());
                    mDiceTextView2.setText("" + game.getDice2().getDice());
                    mDiceTextView3.setText("" + game.getDice3().getDice());
                }else{
                    mTextViewWinner.setText("Add 2 players first");
                }
                break;
            case R.id.textView:
                game.getDice1().changeStuck();
                if(game.getDice1().isStuck()){
                    mDiceTextView1.setBackgroundColor(0xfff00000);
                }else{
                    mDiceTextView1.setBackgroundColor(0x00000fff);
                }
                break;
            case R.id.textView2:
                game.getDice2().changeStuck();
                if(game.getDice2().isStuck()){
                    mDiceTextView2.setBackgroundColor(0xfff00000);
                }else{
                    mDiceTextView2.setBackgroundColor(0x00000fff);
                }
                break;
            case R.id.textView3:
                game.getDice3().changeStuck();
                if(game.getDice3().isStuck()){
                    mDiceTextView3.setBackgroundColor(0xfff00000);
                }else{
                    mDiceTextView3.setBackgroundColor(0x00000fff);
                }
                break;
            case R.id.buttonAddPlayer:
                if(game.getPlayer1() == null){
                    String name = mEditText.getText().toString();
                    if(!name.equals("")) {
                        game.setPlayer1(new Player(name));
                        game.getPlayer1().setTurn(true);
                        mEditText.setText("");
                        mTextViewPlayer1.setText(game.getPlayer1().getName());
                        mTextViewWinner.setText("");
                    }else{
                        mTextViewWinner.setText("No valid name");
                    }
                }else if(game.getPlayer2() == null) {
                    String name = mEditText.getText().toString();
                    if (!name.equals("")) {
                        game.setPlayer2(new Player(name));
                        mEditText.setText("");
                        mTextViewPlayer2.setText(game.getPlayer2().getName());
                        mTextViewWinner.setText("");
                    }else{
                        mTextViewWinner.setText(("No valid name"));
                    }
                }
                break;
            default:
                break;
        }
    }
}