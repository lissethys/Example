package com.example.lissethys.myapplication;

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

    private EditText mEditText;

    private Button mButton;
    private Button mButtonPlayers;

    private int turn = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDiceTextView1 = (TextView) findViewById(R.id.textView);
        mDiceTextView2 = (TextView) findViewById(R.id.textView2);
        mDiceTextView3 = (TextView) findViewById(R.id.textView3);
        mTextViewPlayer1 = (TextView) findViewById(R.id.textView_player1);
        mTextViewPlayer2 = (TextView) findViewById(R.id.textView_player2);
        mTextViewTurn = (TextView) findViewById(R.id.textView_turn);

        mEditText = (EditText) findViewById(R.id.et_player);


        mButton = (Button) findViewById(R.id.button);
        mButtonPlayers = (Button) findViewById(R.id.buttonAddPlayer);

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
                if(turn > 1){
                    game.rollDices();
                    turn--;
                    mTextViewTurn.setText("Turn: " + turn);
                } else if (turn == 1) {
                    game.rollDices();
                    turn = 3;
                    mTextViewTurn.setText("Turn: " + turn);
                }

                mDiceTextView1.setText("" + game.getDice1().getDice());
                mDiceTextView2.setText("" + game.getDice2().getDice());
                mDiceTextView3.setText("" + game.getDice3().getDice());
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
                    game.setPlayer1(new Player(mEditText.getText().toString()));
                    game.getPlayer1().setTurn(true);
                    mEditText.setText("");
                    mTextViewPlayer1.setText(game.getPlayer1().getName());
                }else if(game.getPlayer2() == null){
                    game.setPlayer2(new Player(mEditText.getText().toString()));
                    mEditText.setText("");
                    mTextViewPlayer2.setText(game.getPlayer2().getName());
                }
                break;
            default:
                break;
        }
    }
}