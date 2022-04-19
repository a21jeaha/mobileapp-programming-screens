package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras(); // Här initieras en "Bundle", denna kommer användas för att ta emot data from en intent.

        textView = (TextView) findViewById(R.id.secondactivity);
        textView.setText(extras.getString("NAME"));
    }
}