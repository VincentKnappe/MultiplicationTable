package com.example.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int MAX = 20;
    private static final int STARTPOS = 10;
    private SeekBar multiplicationSeekBar;

public void generateListOfNumbers(int multiplicationNumber){

    ListView lv_numbers = findViewById(R.id.lv_numbers);
    ArrayList<String> multiplicationContent = new ArrayList<String>();

    for (int i = 1; i <= 100; i++){
        multiplicationContent.add(Integer.toString(i * multiplicationNumber));
    }

    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, multiplicationContent);

    lv_numbers.setAdapter(arrayAdapter);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiplicationSeekBar = findViewById(R.id.sb_multiplication);

        multiplicationSeekBar.setMax(MAX);
        multiplicationSeekBar.setProgress(STARTPOS);

        generateListOfNumbers(STARTPOS);

        multiplicationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               int multiplicationNumber = 1;

               if (i < 1){
                   multiplicationSeekBar.setProgress(multiplicationNumber);
               }else{
                   multiplicationNumber = i;
               }
                Log.i("seekBar wert: ", Integer.toString(i));
                generateListOfNumbers(multiplicationNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}