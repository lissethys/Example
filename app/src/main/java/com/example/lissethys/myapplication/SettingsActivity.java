package com.example.lissethys.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    Game game = new Game();

    private EditText mNamePlayer1;
    private EditText mNamePlayer2;

    private Button mButtonPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        mNamePlayer1 = findViewById(R.id.name_player_1);
        mNamePlayer2 = findViewById(R.id.name_player_2);


        mButtonPlayers = findViewById(R.id.buttonAddPlayer);


        //tweede scherm waar men de namen van de spelers kan ingeven en deze dan worden doorgestuurd naar de MainActivity

        mButtonPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namePlayer1 = mNamePlayer1.getText().toString();
                String namePlayer2 = mNamePlayer2.getText().toString();
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("player1", namePlayer1);
                intent.putExtra("player2", namePlayer2);
                startActivity(intent);
            }
        });

    }



    }

