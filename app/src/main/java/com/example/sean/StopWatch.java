package com.example.sean;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.sean.WorkOut.StopWatchFragment;

public class StopWatch extends AppCompatActivity {
    /*//No of seconds displayed on stopwatch
    private int seconds = 0;
    //Is the stopwatch running?
    private boolean running, wasRunning;
    We added a new variable, wasRunning, to record whether the stopwatch was running before the onStop() method
    was called so that we know whether to set it running
    again when the activity becomes visible again.
    private TextView timeView;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        if(savedInstanceState ==null){
            StopWatchFragment stopWatchFragment = new StopWatchFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.stop_watch_container,stopWatchFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }


       /* if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning"); We’ll restore the state of the wasRunning variable if the activity is recreated.
        }

        timeView = findViewById(R.id.time_view);

        runTimer();*/

    }

  /*  @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning); //Save the state of the wasRunning variable.
    }

     @Override
    protected void onStop() {
        super.onStop();
        wasRunning = running; //Record whether the stopwatch was running when the onStop() method was called.
        running = false;
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        if(wasRunning) {   //Implement the onStart()method.
            running = true; //If the stopwatch was running set it running again.
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning= running;
        running = false;

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }


    //Start the stopwatch running when the Start button is clicked.
    public void onClickStart(View view) {
        running = true;


    }

    //Stop the stopwatch running when the Stop button is clicked.
    public void onClickStop(View view) {
        running = false;

    }

    //Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;

    }

    private void runTimer() {
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
        });*/
}




