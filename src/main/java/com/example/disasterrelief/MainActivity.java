package com.example.disasterrelief;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button one = findViewById(R.id.foodBtn);
        one.setOnClickListener(this);
        Button two = findViewById(R.id.clothBtn);
        two.setOnClickListener(this);
        Button three = findViewById(R.id.moneyBtn);
        three.setOnClickListener(this);
        Button four = findViewById(R.id.toiletriesBtn);
        four.setOnClickListener(this);
        Button five = findViewById(R.id.miscBtn);
        five.setOnClickListener(this);
        Button six = findViewById(R.id.organizeEventBtn);
        six.setOnClickListener(this);
        Button seven = findViewById((R.id.organizeEventBtn));
        seven.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.foodBtn:
                openActivityFood();
                break;
            case R.id.clothBtn:
                openActivityClothing();
                break;
            case R.id.moneyBtn:
                openActivityMoney();
                break;
            case R.id.toiletriesBtn:
                openActivityToiletries();
                break;
            case R.id.miscBtn:
                openActivityMisc();
                break;
            case R.id.organizeEventBtn:
                openActivityNewEvent();
                break;
            default: break;
        }
    }

    public void openActivityClothing() {
        Intent intent = new Intent(this, ActivityClothing.class);
        startActivity(intent);
    }

    public void openActivityFood() {
        Intent intent = new Intent(this, foodActivity.class);
        startActivity(intent);
    }

    public void openActivityMoney() {
        Intent intent = new Intent(this, ActivityMoney.class);
        startActivity(intent);
    }

    public void openActivityToiletries() {
        Intent intent = new Intent(this, ActivityToiletries.class);
        startActivity(intent);
    }

    public void openActivityMisc() {
        Intent intent = new Intent(this, ActivityMisc.class);
        startActivity(intent);
    }

    public void openActivityNewEvent() {
        Intent intent = new Intent (this, createEvent.class);
        startActivity(intent);
    }
}
