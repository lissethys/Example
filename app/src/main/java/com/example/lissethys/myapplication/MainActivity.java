package com.example.lissethys.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Dice dice1 = new Dice();
    private Dice dice2 = new Dice();
    private Dice dice3 = new Dice();

    private TextView mDiceTextView1;
    private TextView mDiceTextView2;
    private TextView mDiceTextView3;

    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDiceTextView1 = (TextView) findViewById(R.id.textView);
        mDiceTextView2 = (TextView) findViewById(R.id.textView2);
        mDiceTextView3 = (TextView) findViewById(R.id.textView3);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mDiceTextView1.setOnClickListener(this);
        mDiceTextView2.setOnClickListener(this);
        mDiceTextView3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                dice1.rollDice();
                dice2.rollDice();
                dice3.rollDice();
                mDiceTextView1.setText("" + dice1.getDice());
                mDiceTextView2.setText("" + dice2.getDice());
                mDiceTextView3.setText("" + dice3.getDice());
                break;
            case R.id.textView:
                mDiceTextView1.setBackgroundColor(0xfff00000);
                mDiceTextView1.setTextColor(0xffffffff);
                break;
            case R.id.textView2:
                mDiceTextView2.setBackgroundColor(0xfff00000);
                mDiceTextView2.setTextColor(0xffffffff);
                break;
            case R.id.textView3:
                mDiceTextView3.setBackgroundColor(0xfff00000);
                mDiceTextView3.setTextColor(0xffffffff);
                break;
            default:
                break;
        }
    }
}