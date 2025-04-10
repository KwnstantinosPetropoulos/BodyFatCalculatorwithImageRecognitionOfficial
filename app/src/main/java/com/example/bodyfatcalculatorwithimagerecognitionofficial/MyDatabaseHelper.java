package com.example.bodyfatcalculatorwithimagerecognitionofficial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME = "BOOKLibrary.db";
    public static final int DATABASE_VERSION = 4;

    public static final String TABLE_NAME = "stats";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_BMI = "bmi";
    public static final String COLUMN_TIMESTAMP = "timestamp";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
   //     this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                " CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_GENDER + " TEXT , " +
                        COLUMN_BMI + " TEXT, " +
                        COLUMN_TIMESTAMP + " TEXT) ; " ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public Boolean insertData(String gender, String bmi, String milis) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MyDatabaseHelper.COLUMN_GENDER, gender);
        cv.put(MyDatabaseHelper.COLUMN_BMI, bmi);
        cv.put(MyDatabaseHelper.COLUMN_TIMESTAMP, milis);

        long isOK = db.insert(TABLE_NAME, null, cv);
        return (isOK != -1);
    }
}