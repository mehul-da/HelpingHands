package com.example.disasterrelief;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thanksScreen extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks_screen);

        Button  homeButton = findViewById(R.id.homeBtn);
        homeButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }

}

