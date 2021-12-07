package com.example.sean.WorkOut;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sean.R;

public class WorkOutDetail extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID = "id"; //We’re using a constant to pass the ID from MainActivity
    //to DetailActivity to avoid hardcoding this value.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_detail);

        WorkOutDetailFragment fragment = (WorkOutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_frag);
        //get WorkoutDetailFragment to display details of a workout here to check that it’s working.

        //fragment.setWorkOut(1);  We’re no longer hardcoding an ID of 1, so remove this line.

        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        fragment.setWorkOut(workoutId);  //Get the ID from the intent, and pass it to the fragment via its setWorkout() method.


    }
}