package com.example.sean.WorkOut;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sean.R;


public class WorkOutDetailFragment extends Fragment {   //WorkoutDetailFragment extends the Fragment class.
    private long workOutId; //This is the ID of the workout the user chooses.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,   //This is the onCreateView() method. It’s called when Android needs the fragment’s layout.
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work_out_detail, container, false); //This tells Android which layout the fragment uses

    }

    public void setWorkOut(long id){  //This is a setter method for the workout ID. The activity will use this method to set the value of the workout ID.
        this.workOutId=id;
    }
}