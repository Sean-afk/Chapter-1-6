package com.example.sean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sean.WorkOut.WorkOutActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  BeerExpert expert= new BeerExpert();

    TextView brands;
    Button findBeer;
    Spinner beerType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brands=findViewById(R.id.beerId);
        findBeer=findViewById(R.id.findBeer);
        beerType=findViewById(R.id.color);
    }

    public void onClickFindBeer(View view) {
        String type= String.valueOf(beerType.getSelectedItem());
        List<String> brandList = expert.getBrands(type);
        StringBuilder brandsFormatted= new StringBuilder();
        for (String brand: brandList){
            brandsFormatted.append(brand).append('\n');
        }
        brands.setText(brandsFormatted);
    }

    public void onClickStopWatch(View view){
        Intent intent = new Intent(this,StopWatch.class);
        Toast.makeText(this, "Stopwatch", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void onClickFrame(View view){
        Intent intent1 = new Intent(this,FrameActivity.class);
        Toast.makeText(this, "Frame Layout", Toast.LENGTH_SHORT).show();
        startActivity(intent1);
    }

    public void onClickMessage(View view){
        Intent intent2 = new Intent(this,ConstraintActivity.class);
        Toast.makeText(this, "Constraint Layout", Toast.LENGTH_SHORT).show();
        startActivity(intent2);
    }

    public void onClickWorkOut(View view){
        Intent intent3 = new Intent(this, WorkOutActivity.class);
        Toast.makeText(this, "Fragments", Toast.LENGTH_SHORT).show();
        startActivity(intent3);
    }

    public void onClickWeb(View view){
        Intent intent4 = new Intent(this, WebViewDemo.class);
        Toast.makeText(this, "Web view", Toast.LENGTH_SHORT).show();
        startActivity(intent4);

    }



}