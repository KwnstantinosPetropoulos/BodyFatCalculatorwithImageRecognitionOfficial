package com.example.bodyfatcalculatorwithimagerecognitionofficial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class BmiResult extends AppCompatActivity {

    Button button;

    android.widget.Button mcalculatebmi;


    TextView mcurrentheight;
    TextView mcurrentage,mcurrentweight;
    ImageView mincrementage,mincrementweight,mdecrementage,mdecrementweight;
    SeekBar mseekbarforheight;
    RelativeLayout mmale,mfemale;


    int intweight = 55;
    int intage = 55;
    int currentprogress;
    String mintprogress="170";
    String typeofuser="0";
    String weight2="55";
    String age2="55";






    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_acticity);
        //getSupportActionBar().hide();
        button=findViewById(R.id.returntomain);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BmiResult.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });


        mcalculatebmi=findViewById(R.id.calculatebmi);
        mcurrentage=findViewById(R.id.currentage);
        mcurrentweight=findViewById(R.id.currentweight);
        mcurrentheight=findViewById(R.id.currentheight);
        mincrementage=findViewById(R.id.incrementage);
        mdecrementage=findViewById(R.id.decrementage);
        mincrementweight=findViewById(R.id.incrementweight);
        mdecrementweight=findViewById(R.id.decrementweight);
        mseekbarforheight=findViewById(R.id.seekbarforheight);
        mmale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);





        mmale.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.agorikoritsi));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.focus));
                typeofuser="Male";
            }
        });
        mfemale.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.agorikoritsi));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.focus));
                typeofuser="Female";
            }
        });
        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

               currentprogress=progress;
               mintprogress=String.valueOf(currentprogress);
               mcurrentheight.setText(mintprogress);



            }





            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage +1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);

            }
        });
        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage -1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);

            }
        });
        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight +1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);

            }
        });
        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight -1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);

            }
        });




        mcalculatebmi.setOnClickListener(v -> {

            if(typeofuser.equals("0"))
            {
                Toast.makeText(getApplicationContext(), "Select Your Gender First",Toast.LENGTH_SHORT).show();
            } else if (mintprogress.equals("0")) {
                Toast.makeText(getApplicationContext(), "Select Your Height First",Toast.LENGTH_SHORT).show();
            } else if (intage ==0 || intage <0) {
                Toast.makeText(getApplicationContext(), "Age Is Incorrect",Toast.LENGTH_SHORT).show();
            } else if (intweight ==0 || intweight <0) {
                Toast.makeText(getApplicationContext(), "Weight Is Incorrect",Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(BmiResult.this, BmiActicity.class);
                intent.putExtra("gender", typeofuser);
                intent.putExtra("height", mintprogress);
                intent.putExtra("weight", weight2);
                intent.putExtra("age", age2);
                startActivity(intent);
            }
        });

    }

}