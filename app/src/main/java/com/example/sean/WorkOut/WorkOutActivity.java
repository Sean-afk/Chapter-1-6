package com.example.sean.WorkOut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import com.example.sean.R;

public class WorkOutActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    //Implement the listener interface defined in WorkoutListFragment.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out);
    }

    /* public void onShowDetails(View view){  //We’ve removed the button, so we no longer need this method.
        Intent intent = new Intent(WorkOutActivity.this,WorkOutDetail.class);
        startActivity(intent);
    }*/

    @Override
    public void itemClicked(long id) {
         FragmentContainerView fragmentContainer = findViewById(R.id.fragment_container);  //Get a reference to the frame layout that will contain WorkoutDetailFragment.
        if (fragmentContainer != null) { // This will only exist if the app is being run on a device with a large screen.
            //Add the fragment to the FrameLayout
            WorkOutDetailFragment details = new WorkOutDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setWorkOut(id);
            //ft.replace(R.id.fragment_container,details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();


        } else {
            Intent intent = new Intent(this, WorkOutDetail.class);
            intent.putExtra(WorkOutDetail.EXTRA_WORKOUT_ID, (int) id);  //Pass the ID of the workout to DetailActivity.
            startActivity(intent);
        }
    }
}