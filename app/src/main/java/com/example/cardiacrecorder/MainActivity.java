package com.example.cardiacrecorder;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addButton;
    ConstraintLayout constraintLayout;
    CustomAdapter customAdapter;


    MyDatabaseHelper myDB;
    ArrayList<Integer> systolic, diastolic, heart;
    ArrayList<String> comment, date, time, id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.MainRecycler);
        addButton = findViewById(R.id.addButton);
        constraintLayout = findViewById(R.id.MainPageConstrain);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });


        myDB = new MyDatabaseHelper(MainActivity.this);
        systolic = new ArrayList<Integer>();
        diastolic = new ArrayList<Integer>();
        heart = new ArrayList<Integer>();
        comment = new ArrayList<String>();
        date = new ArrayList<String>();
        time = new ArrayList<String>();
        id = new ArrayList<String>();


        storeData();


        customAdapter = new CustomAdapter(MainActivity.this, this, id, date, time, systolic, diastolic, heart, comment);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void storeData() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {


            while (cursor.moveToNext()) {

                date.add(cursor.getString(1));
                time.add(cursor.getString(2));
                systolic.add(Integer.valueOf(cursor.getString(3)));
                diastolic.add(Integer.valueOf(cursor.getString(4)));
                heart.add(Integer.valueOf(cursor.getString(5)));
                comment.add(cursor.getString(6));
                id.add(cursor.getString(0));


            }
        }
    }
}