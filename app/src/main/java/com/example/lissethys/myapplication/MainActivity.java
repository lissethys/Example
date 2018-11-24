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


    }

    @Override
    public void onClick(View view) {

    }
}
