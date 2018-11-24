package com.example.lissethys.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice1.rollDice();
                dice2.rollDice();
                dice3.rollDice();
                mDiceTextView1.setText("" + dice1.getDice());
                mDiceTextView2.setText("" + dice2.getDice());
                mDiceTextView3.setText("" + dice3.getDice());
            }
        });


    }
}
