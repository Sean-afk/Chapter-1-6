package com.example.sean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        startActivity(intent1);
    }

    public void onClickMessage(View view){
        Intent intent2 = new Intent(this,ConstraintActivity.class);
        startActivity(intent2);
    }



}