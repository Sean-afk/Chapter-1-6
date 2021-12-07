package com.example.sean.WorkOut;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sean.R;

import java.util.Locale;


public class StopWatchFragment extends Fragment implements View.OnClickListener {
    private int seconds = 0;   //No of seconds displayed on stopwatch
    private boolean running, wasRunning;  //Is the stopwatch running?



    public StopWatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stop_watch, container, false);
        runTimer(view);
        Button startButton = view.findViewById(R.id.start_btn); //Attach the listener to the buttons.
        startButton.setOnClickListener(this);
        Button stopButton = view.findViewById(R.id.stop_btn);
        stopButton.setOnClickListener(this);
        Button resetButton = view.findViewById(R.id.reset_btn);
        resetButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onPause() {  //If the fragment’s paused record whether the stopwatch was running and stop it.
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume() {  //If the stopwatch was running before it was paused, set it running again.
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);  //Put the values of the variables in the Bundle before the activity is destroyed.
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning);
    }


    //Start the stopwatch running when the Start button is clicked.
    private void onClickStart() {
        running = true;


    }

    //Stop the stopwatch running when the Stop button is clicked.
    private void onClickStop() {
        running = false;

    }

    //Reset the stopwatch when the Reset button is clicked.
    private void onClickReset() {
        running = false;
        seconds = 0;

    }
    private void runTimer(View view) {
        final TextView timeView = view.findViewById(R.id.time_view);
        final Handler handler = new Handler(); //The runTimer() method uses a Handler to increment the seconds and update the text view.
        handler.post(new Runnable() {
            @Override
            public void run() {    //Use a handler to post code
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs); //format the seconds into hours minutes and secs
                timeView.setText(time);
                if (running) {
                    seconds++; //if running is true then increment seconds variable
                }
                handler.postDelayed(this, 1000); //Post the code again with delay of 1 sec

            }
        });
    }

    @Override
    public void onClick(View v) { //As we’re implementing the OnClickListener interface, we need to override the onClick() method.
        switch (v.getId()){
            case R.id.start_btn:  //Call the appropriate method  in the fragment for the  button that was clicked.
                onClickStart();
                break;
            case R.id.stop_btn:
                onClickStop();
                break;
            case R.id.reset_btn:
                onClickReset();
                break;
        }
    }
}