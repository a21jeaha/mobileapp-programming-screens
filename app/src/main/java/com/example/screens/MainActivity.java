package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button toSecondActivity;                                    // en knapp skapas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toSecondActivity = findViewById(R.id.get2activity2);    // knappen associeras till knapp widgeten via dess ID
    }
}
