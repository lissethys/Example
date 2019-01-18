package com.example.lissethys.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button mButton2;
    private Button mButtonPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        /*die boys hier onder mij worden gewoon allemaal verwezen naar de onClick methode en daar wordt het juiste uitgevoerd naar gelang welke knop. (door de switch met dan R.id.(iets)**/
        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButtonPlayers.setOnClickListener(this);
        mDiceTextView1.setOnClickListener(this);
        mDiceTextView2.setOnClickListener(this);
        mDiceTextView3.setOnClickListener(this);





    }

    /* Ja android bucht he lisse. basic want ik kon het op 1 dag ;)**/
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
                    if (!game.getDice1().isStuck()) mDiceTextView1.setBackgroundColor(0x00000fff);
                    if (!game.getDice2().isStuck()) mDiceTextView2.setBackgroundColor(0x00000fff);
                    if (!game.getDice3().isStuck()) mDiceTextView3.setBackgroundColor(0x00000fff);


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
            case R.id.button2:

                mTextViewWinner.setText("pass");
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

    //settings in action bar om naar second activity te gaan
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemThatWasSelected = item.getItemId();
        if (menuItemThatWasSelected == R.id.action_settings){
            Intent startIntent = new Intent(getApplicationContext(),SettingsActivity.class);
            startActivity(startIntent);
        }
        if (menuItemThatWasSelected == R.id.action_search){
            Context context = MainActivity.this;
            String message = "search clicked";
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}