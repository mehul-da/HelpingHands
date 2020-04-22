package com.example.disasterrelief;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ActivityToiletries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toiletries);
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

    public static String[] toiletries(){
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("data.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] count = count();
        int toiletriesCount = count[2];
        int toiletriesIndex = 0;
        String[] toiletriesArray = new String[toiletriesCount];
        while (fileScanner.hasNextLine()) {
            String category = fileScanner.nextLine();
            String name = fileScanner.nextLine();
            String description = fileScanner.nextLine();
            String date = fileScanner.nextLine();
            String time = fileScanner.nextLine();
            String location = fileScanner.nextLine();
            String data = name + "\n" + description + "\n" + date + "\n" + time + "\n" + location + "\n";

            if (category.equals("TOILETRIES")) {
                toiletriesArray[toiletriesIndex] = data;
                toiletriesIndex++;

            }
        }
        return toiletriesArray;
    }
}
