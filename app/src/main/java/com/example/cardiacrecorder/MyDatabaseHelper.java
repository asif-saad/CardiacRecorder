package com.example.cardiacrecorder;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME="HealthBee.db";
    public static final int DATABASE_VERSION=1;



    private static final String TABLE_NAME="record";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_SYSTOLIC="systolic_pressure";
    private static final String COLUMN_DIASTOLIC="diastolic_pressure";
    private static final String COLUMN_HEART="heart_beat";
    private static final String COLUMN_COMMENT="comment";
    private static final String COLUMN_DATE="date";
    private static final String COLUMN_TIME="time";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,
                null,
                DATABASE_VERSION);
        this.context=context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE " + TABLE_NAME + " ("+
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE + " TEXT, "+
                COLUMN_TIME + " TEXT, "+
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


    public void addRecord(String date,String time,int systolic, int diastolic, int heart, String comment)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_DATE,date);
        cv.put(COLUMN_TIME,time);
        cv.put(COLUMN_SYSTOLIC,systolic);
        cv.put(COLUMN_DIASTOLIC,diastolic);
        cv.put(COLUMN_HEART,heart);
        cv.put(COLUMN_COMMENT,comment);



        long result=db.insert(TABLE_NAME,null,cv);
        if(result==-1)
        {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Success!!",Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("Recycle")
    Cursor readAllData()
    {
        String query="SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=null;
        if(db!=null)
        {
            cursor=db.rawQuery(query,null);
        }

        return cursor;
    }


}
