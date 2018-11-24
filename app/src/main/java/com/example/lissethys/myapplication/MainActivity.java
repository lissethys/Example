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

    private Dice dice1 = game.getDice1();
    private Dice dice2 = game.getDice2();
    private Dice dice3 = game.getDice3();

    private Player player1;
    private Player player2;

    private TextView mDiceTextView1;
    private TextView mDiceTextView2;
    private TextView mDiceTextView3;
    private TextView mTextViewPlayer1;
    private TextView mTextViewPlayer2;

    private EditText mEditText;

    private Button mButton;
    private Button mButtonPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDiceTextView1 = (TextView) findViewById(R.id.textView);
        mDiceTextView2 = (TextView) findViewById(R.id.textView2);
        mDiceTextView3 = (TextView) findViewById(R.id.textView3);
        mTextViewPlayer1 = (TextView) findViewById(R.id.textView_player1);
        mTextViewPlayer2 = (TextView) findViewById(R.id.textView_player2);

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
                game.rollDices();
                mDiceTextView1.setText("" + dice1.getDice());
                mDiceTextView2.setText("" + dice2.getDice());
                mDiceTextView3.setText("" + dice3.getDice());
                break;
            case R.id.textView:
                dice1.changeStuck();
                if(dice1.isStuck()){
                    mDiceTextView1.setBackgroundColor(0xfff00000);
                }else{
                    mDiceTextView1.setBackgroundColor(0x00000fff);
                }
                break;
            case R.id.textView2:
                dice2.changeStuck();
                if(dice2.isStuck()){
                    mDiceTextView2.setBackgroundColor(0xfff00000);
                }else{
                    mDiceTextView2.setBackgroundColor(0x00000fff);
                }
                break;
            case R.id.textView3:
                dice3.changeStuck();
                if(dice3.isStuck()){
                    mDiceTextView3.setBackgroundColor(0xfff00000);
                }else{
                    mDiceTextView3.setBackgroundColor(0x00000fff);
                }
                break;
            case R.id.buttonAddPlayer:
                if(player1 == null){
                    player1 = new Player(mEditText.getText().toString());
                    mEditText.setText("");
                    mTextViewPlayer1.setText(player1.getName());
                }else if(player2 == null){
                    player2 = new Player(mEditText.getText().toString());
                    mEditText.setText("");
                    mTextViewPlayer2.setText(player2.getName());
                }
                break;
            default:
                break;
        }
    }
}