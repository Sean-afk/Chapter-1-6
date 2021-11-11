package com.example.sean.WorkOut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.ListFragment;

//A fragment representing a list of Items.

public class WorkoutListFragment extends ListFragment { //The activity needs to extend  ListFragment, not Fragment.


    public WorkoutListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[WorkOut.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = WorkOut.workouts[i].getName(); // create a string array of workout names
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(  // create an array adapter
                inflater.getContext(), android.R.layout.simple_list_item_1, names); //get context from layout inflater
        setListAdapter(adapter); // bind array adapter to list view


        //Calling the superclass onCreateView() method gives you the default layout for the ListFragment.
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}