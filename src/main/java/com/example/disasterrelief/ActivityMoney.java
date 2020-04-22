package com.example.disasterrelief;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ActivityMoney extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
    }

    public static int[] count(){
        Scanner testScanner = null;
        try {
            testScanner = new Scanner(new File("data.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] count = new int[4];
        while (testScanner.hasNextLine()) {
            String category = testScanner.nextLine();
            for (int i = 0; i < 5; i++){
                testScanner.nextLine();
            }
            if (category.equals("CLOTHING")){
                count[0]++;
            }
            else if (category.equals("FOOD")){
                count[1]++;
            }
            else if (category.equals("TOILETRIES")){
                count[2]++;
            }
            else{
                count[3]++;
            }
        }
        return count;
    }
}
