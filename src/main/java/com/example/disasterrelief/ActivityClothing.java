package com.example.disasterrelief;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ActivityClothing extends AppCompatActivity {

    TextView clothingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
        try {
           doStuff();
        } catch (Exception e) {
           Log.d("test failed", "test failed");
        }
    }

//    private void helperMethod() throws IOException {
//        InputStream is = getAssets().open("data.txt");
//        int size = is.available();
//        byte[] buffer = new byte[size];
//        is.read(buffer);
//        is.close();
//        finalstring = new String(buffer);
//        clothingText = findViewById(R.id.clothingTextInput);
//        clothingText.setText(finalstring);
//    }



    public static int[] count(){
        Scanner testScanner = null;
        try {
            testScanner = new Scanner(new File("app/src/main/assets/data.txt"));
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

    public static String[] clothing(){
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("app/src/main/assets/data.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] count = count();
        int clothingCount = count[0];
        int clothingIndex = 0;
        String[] clothingArray = new String[clothingCount];
        while (fileScanner.hasNextLine()) {
            String category = fileScanner.nextLine();
            Log.d("category", category);
            String name = fileScanner.nextLine();
            String description = fileScanner.nextLine();
            String date = fileScanner.nextLine();
            String time = fileScanner.nextLine();
            String location = fileScanner.nextLine();
            String data = name + "\n" + description + "\n" + date + "\n" + time + "\n" + location + "\n";

            if (category.equals("CLOTHING")) {
                clothingArray[clothingIndex] = data;
                clothingIndex++;
            }
        }
        return clothingArray;
    }

    public void doStuff(){
        String[] clothingArray = clothing();
        int size = clothingArray.length;
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < size; i++){
            String current = clothingArray[i];
            Log.d("current string", current);
            finalString.append(current);
        }
        clothingText = findViewById(R.id.clothingTextInput);
        clothingText.setText(finalString.toString());
    }



//        System.out.println("CLOTHING CATEGORY\n");
//
//        for (int clothingN = 0; clothingN < clothingCount; clothingN++){
//            System.out.println(clothingArray[clothingN]);
//        }
//
//        System.out.println("FOOD CATEGORY\n");
//
//        for (int foodN = 0; foodN < foodCount; foodN++){
//            System.out.println(foodArray[foodN]);
//        }
//
//        System.out.println("TOILETRIES CATEGORY\n");
//
//
//        for (int toiletriesN = 0; toiletriesN < toiletriesCount; toiletriesN++){
//            System.out.println(toiletriesArray[toiletriesN]);
//        }
//
//        System.out.println("MISC CATEGORY\n");
//
//        for (int miscN = 0; miscN < miscCount; miscN++){
//            System.out.println(miscArray[miscN]);
//        }
//    }

}
