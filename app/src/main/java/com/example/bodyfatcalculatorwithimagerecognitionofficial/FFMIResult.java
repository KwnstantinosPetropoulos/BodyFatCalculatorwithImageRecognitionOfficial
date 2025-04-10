package com.example.bodyfatcalculatorwithimagerecognitionofficial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FFMIResult extends AppCompatActivity {

    android.widget.Button mrecalculateffmi;
    TextView mffmidisplay,mffmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mffmi;
    float intffmi;

    String height;
    String weight;
    float intheight;
    float intweight;
    RelativeLayout mbackground;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ffmiresult);

        //getSupportActionBar().setElevation(0);
        //getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        //getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        //getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();

        mffmidisplay=findViewById(R.id.ffmidisplay);
        mffmicategory=findViewById(R.id.ffmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculateffmi=findViewById(R.id.recalculateffmi);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");



        intheight = Float.parseFloat(String.valueOf(height));
        intweight = Float.parseFloat(String.valueOf(weight));

        intheight = intheight/100;

        intffmi = intweight/(intheight*intheight);

        mffmi = Float.toString(intffmi);

        if(intffmi<16)
        {
            mffmicategory.setText("Severse Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);

        } else if (intffmi<16.9 && intffmi>16)
        {
            mffmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);

        } else if (intffmi < 18.4 && intffmi>17) {
            mffmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);


        } else if (intffmi<25 && intffmi>18.4) {
            mffmicategory.setText("Normal");
            mbackground.setBackgroundColor(Color.GREEN);
            mimageview.setImageResource(R.drawable.ok);
        } else if (intffmi<29.4 && intffmi>25) {
            mffmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);

        }
        else
        {
            mffmicategory.setText("Obese Class I");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);

        }

        mgender.setText(intent.getStringExtra("gender"));
        mffmidisplay.setText(mffmi);





        mrecalculateffmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FFMIResult.this,FFMIActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}