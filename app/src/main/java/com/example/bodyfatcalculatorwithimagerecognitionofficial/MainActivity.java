package com.example.bodyfatcalculatorwithimagerecognitionofficial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView cardBMI;
    CardView cardFFMI;
    CardView cardSettings;
    CardView cardStats;
    CardView cardInfo;
    CardView cardBodyFatCalculator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardBMI = findViewById(R.id.cardBMI);
        cardBodyFatCalculator=findViewById(R.id.cardBodyFatCalculator);
        cardInfo= findViewById(R.id.cardInfo);
        cardFFMI= findViewById(R.id.cardFFMI);
        cardSettings= findViewById(R.id.cardSettings);
        cardStats= findViewById(R.id.cardStats);

        cardBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,BmiResult.class);
                startActivity(intent);
                finish();

            }

        });

        cardFFMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,FFMIActivity.class);
                startActivity(intent);
                finish();

            }

        });
        cardSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        cardInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,InfoActivity.class);
                startActivity(intent);
                finish();
            }
        });
        cardStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,StatsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        cardBodyFatCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PhotoActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}