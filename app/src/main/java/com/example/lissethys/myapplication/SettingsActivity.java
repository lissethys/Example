package com.example.lissethys.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

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
    private Button mButton2;
    private Button mButtonPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        /* android shit linken me uw variabelen hier in uw klasse**/
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
        mButton2 = findViewById(R.id.button2);
        mButtonPlayers = findViewById(R.id.buttonAddPlayer);



    }



    public void onClick(View view){
        switch(view.getId()){
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
        }

    }
}
