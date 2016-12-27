package com.example.lenovo.androiddemo;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;

import com.google.android.gms.common.api.GoogleApiClient;

public class ProgressBarExample extends AppCompatActivity {

    ProgressBar progressBar2, progressBar3;
    private SeekBar seekBar;
    private SeekBar seekBar2;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_example);

        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);

        progressBar2.setVisibility(View.INVISIBLE);

        //progressBar3.setIndeterminate(true);

        progressBar3.setMax(200);
        progressBar3.setProgress(70);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                progressBar3.setProgress(150);

            }
        }, 3000);


        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);


        seekBar.setMax(120);
        seekBar.setProgress(40);

        seekBar2.setProgress(1);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("MSG-PROGRESS",progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("MSG-START",seekBar.getProgress()+"");


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("MSG-STOP",seekBar.getProgress()+"");

            }
        });


        Switch aSwitch=(Switch)findViewById(R.id.switch1);
        aSwitch.setTextOff("OFF");
        aSwitch.setTextOn("ON");
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("MSG-PROGRESS"," "+isChecked);

            }
        });

    }





}
