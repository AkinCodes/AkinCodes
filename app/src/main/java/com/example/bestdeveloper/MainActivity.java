package com.example.bestdeveloper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public void addings(int timesTablenumber) {
        ListView listings = findViewById(R.id.listViewTimesTable);
        ArrayList<String> str = new ArrayList<String>();

        for (int j = 1; j <= 10; j++) {
            str.add(Integer.toString(j * timesTablenumber));
        }

        ArrayAdapter<String> plug = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        listings.setAdapter(plug);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int startingPosition = 10;
        int maxposition = 20;
        addings(startingPosition);

        SeekBar seeking = findViewById(R.id.seekBarTimesTable);
        seeking.setMax(maxposition);
        seeking.setProgress(startingPosition);

        seeking.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int timesTablenumber;
                int min = 1;

                if (i < min) {
                    timesTablenumber = min;
                    seeking.setProgress(min);
                } else {
                    timesTablenumber = i;
                }

                addings(timesTablenumber);
                Log.i("message", Integer.toString(timesTablenumber));

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