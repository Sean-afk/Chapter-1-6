package com.example.sean.WorkOut;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sean.R;

public class WorkOutDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_detail);

        WorkOutDetailFragment fragment = (WorkOutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_frag);
        //get WorkoutDetailFragment to display details of a workout here to check that it’s working.
        fragment.setWorkOut(1);


    }
}