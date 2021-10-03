package com.example.sean.WorkOut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sean.R;

public class WorkOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out);
    }

    public void onShowDetails(View view){
        Intent intent = new Intent(WorkOutActivity.this,WorkOutDetail.class);
        startActivity(intent);

    }
}