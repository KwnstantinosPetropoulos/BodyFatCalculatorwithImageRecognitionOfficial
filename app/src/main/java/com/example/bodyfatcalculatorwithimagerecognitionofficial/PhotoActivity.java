package com.example.bodyfatcalculatorwithimagerecognitionofficial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class PhotoActivity extends AppCompatActivity {
    ImageView image;
    Button button;
    private static final int WRITE_EXTERNAL = 100;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_photo);
        image=findViewById(R.id.image);
        button = findViewById(R.id.returntomain);
        Button btn_gallery = findViewById(R.id.btn_gallery);

        btn_gallery.setOnClickListener(v -> checkPermission());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PhotoActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
    private void checkPermission() {
        int permission = ActivityCompat.checkSelfPermission(PhotoActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            pickImage();
        }else{
            if(permission != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(PhotoActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL);
            }else{
                pickImage();
            }
        }
    }



    private void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, WRITE_EXTERNAL);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == WRITE_EXTERNAL && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            pickImage();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode ==RESULT_OK){
            Uri uri = data.getData();
            switch (requestCode){
                case WRITE_EXTERNAL:
                    image.setImageURI(uri);
                    break;
            }
        }
    }
}