package com.example.disasterrelief;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class createEvent extends AppCompatActivity {
    private Button submitEventButton;
    private EditText category;
    private EditText name;
    private EditText description;
    private EditText date;
    private EditText time;
    private EditText location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        submitEventButton = findViewById(R.id.submitEventBtn);
        category = findViewById(R.id.categoryText);
        name = findViewById(R.id.nameText);
        description = findViewById(R.id.descriptionText);
        date = findViewById(R.id.dateText);
        time = findViewById(R.id.timeText);
        location = findViewById(R.id.locationText);

        submitEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("Category", category.getText().toString().toUpperCase());
                editor.putString("Name", name.getText().toString());
                editor.putString("Description", description.getText().toString());
                editor.putString("Date", date.getText().toString());
                editor.putString("Time", time.getText().toString());
                editor.putString("Location", location.getText().toString());

                startActivity(new Intent(createEvent.this, thanksScreen.class));
            }
        });
    }

        public void createFileWriter(StringBuilder sb) {
            try {
                FileOutputStream fOut = openFileOutput("example.txt", MODE_WORLD_READABLE);
                fOut.write(sb.toString().getBytes());
                fOut.close();
            } catch (Exception e) {
                Log.d("myLog","loser");
                e.printStackTrace();
            }
        }

        private StringBuilder readFile(String fileName) {
            StringBuilder sb = new StringBuilder();
            try {
                Scanner sc = new Scanner(new File(fileName));
                while(sc.hasNextLine()) {
                    sb.append(sc.nextLine() + "\n");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return sb;
        }
    }