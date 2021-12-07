package com.example.sean.WorkOut;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

//A fragment representing a list of Items.

public class WorkoutListFragment extends ListFragment { //The activity needs to extend  ListFragment, not Fragment.

    static interface Listener{      //We’ll call the interface Listener.
        void itemClicked(long id);
    };

    private Listener listener;  //Add listener to fragment


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

    @Override
    public void onAttach(@NonNull Context context) {  //This is the context (in this case, the activity) the fragment is attached to.
        super.onAttach(context);  //This is called when the fragment gets attached to the activity. Remember, the Activity class is a subclass of Context.
        this.listener = (Listener) context;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if(listener != null){
            listener.itemClicked(id);    //Tell the listener when an item in the ListView is clicked.
        }
    }
}