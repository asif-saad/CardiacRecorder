package com.example.cardiacrecorder;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addButton;



    MyDatabaseHelper myDB;
    ArrayList<Integer> systolic,diastolic, heart;
    ArrayList<String> comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.MainRecycler);
        addButton=findViewById(R.id.addButton);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });


        myDB=new MyDatabaseHelper(MainActivity.this);
        systolic=new ArrayList<Integer>();
        diastolic=new ArrayList<Integer>();
        heart=new ArrayList<Integer>();
        comment=new ArrayList<String>();

        storeData();
    }







    void storeData()
    {
        Cursor cursor= myDB.readAllData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }

        else
        {


            while(cursor.moveToNext())
            {
                systolic.add(Integer.valueOf(cursor.getString(0)));
                diastolic.add(Integer.valueOf(cursor.getString(1)));
                heart.add(Integer.valueOf(cursor.getString(2)));
                comment.add(cursor.getString(3));


            }
        }
    }
}