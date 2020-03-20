package com.example.bikram_paint_app;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{

    private PaintView paintView;
    private SeekBar seekbar;



    //changes the size/ width of the brush as desired
    // min and max values - 3dp and 23dp are assigned in activity_main.xml
    public void seekbar() {

        //find the widget on the view
        seekbar = findViewById(R.id.seekBar);

        //Listener function for the seekbar
        seekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int progress_value;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    progress_value = progress;

                    // changes the strokeWidth based on the value of seekbar
                    paintView.strokeWidth = seekbar.getProgress();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }


    //gets called when any of the 4 color buttons are pressed
    public void changeColor(View v){

        switch (v.getId()){

            //changes currentColor in PaintView.java to Black
            case R.id.color_black:
                paintView.currentColor = Color.BLACK;
                break;

            //changes currentColor in PaintView.java to Blue
            case R.id.color_blue:
                paintView.currentColor = Color.BLUE;
                break;

            //changes currentColor in PaintView.java to Green
            case R.id.color_green:
                paintView.currentColor = Color.GREEN;
                break;

            //changes currentColor in PaintView.java to Red
            case R.id.color_red:
                paintView.currentColor = Color.RED;
                break;
        }
    }


    //calls the undo function in PaintView.java
    public void undo(View view){
        paintView.undo();
    }



    //OnCreate function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = findViewById(R.id.paintView);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);
        seekbar();
    }




}