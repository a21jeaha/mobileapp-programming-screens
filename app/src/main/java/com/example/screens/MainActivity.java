package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button toSecondActivity;                                    // en knapp skapas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toSecondActivity = findViewById(R.id.get2activity2);    // knappen associeras till knapp widgeten via dess ID

        toSecondActivity.setOnClickListener(new View.OnClickListener() {   // en lyssnare för knappen initieras
            @Override
            public void onClick(View view) {
                onButtonTap();              // skickar ett metod anropp till metoden som skickar intent
            }
        });
    }

    private void onButtonTap(){
        Intent intent = new Intent (this, SecondActivity.class);    // här skappas en intent som agerar från DENNA klass, och öppnar klassen SecondActivity.class
        intent.putExtra("NAME", "Jean-Paul Hanna");                  // här skickas en sträng med NYCKEL "NAME", vid mottagar sidan måste samma nyckel anges
        startActivity(intent); // intenten activeras!!
    }
}
