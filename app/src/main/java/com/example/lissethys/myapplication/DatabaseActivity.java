package com.example.lissethys.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseActivity extends AppCompatActivity{

    private Button mBtnFirebase;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        mBtnFirebase = findViewById(R.id.button_firebase);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mBtnFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create a child in root object
                //assign value to child

                mDatabase.child("Name").setValue("Lisse");

            }
        });
    }
}
