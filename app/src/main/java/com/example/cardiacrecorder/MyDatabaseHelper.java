package com.example.cardiacrecorder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME="CardiacRecorder.db";
    public static final int DATABASE_VERSION=1;



    private static final String TABLE_NAME="record";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_SYSTOLIC="systolic_pressure";
    private static final String COLUMN_DIASTOLIC="diastolic_pressure";
    private static final String COLUMN_HEART="heart_beat";
    private static final String COLUMN_COMMENT="comment";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE " + TABLE_NAME + " ("+ COLUMN_ID +
                "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SYSTOLIC + " INTEGER, "+
                COLUMN_DIASTOLIC + " INTEGER, "+
                COLUMN_HEART + " INTEGER, "+
                COLUMN_COMMENT + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);


    }
}
