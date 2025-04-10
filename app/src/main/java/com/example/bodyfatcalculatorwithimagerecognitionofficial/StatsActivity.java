package com.example.bodyfatcalculatorwithimagerecognitionofficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class StatsActivity extends AppCompatActivity {
    TextView tv_history;
    Button button;
    MyDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        tv_history=findViewById(R.id.tv_history);
        button = findViewById(R.id.returntomain);

        db = new MyDatabaseHelper(this);
        setHistoryToTextView();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StatsActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
    private void setHistoryToTextView(){
        Cursor res = db.getData();
        if(res.getCount() == 0) {
            tv_history.setText("No history");
            return;
        }


        StringBuilder stringBuilder = new StringBuilder();
        while (res.moveToNext()) {
            stringBuilder.append("Gender: "+res.getString(1));
            stringBuilder.append(" BMI: "+res.getString(2));
            stringBuilder.append(" - "+ getDateByTimeStamp(Long.parseLong(res.getString(3))));
            stringBuilder.append("\n");
        }
        tv_history.setText(stringBuilder.toString());
    }

    private String getDateByTimeStamp(long t){
        Timestamp timestamp = new Timestamp(t);
        Date date = new Date(timestamp.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss:");

        //return simpleDateFormat.format(timestamp)+" "+simpleDateFormat.format(date);
        return simpleDateFormat.format(date);
    }
}
