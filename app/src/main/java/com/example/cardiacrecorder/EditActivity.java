package com.example.cardiacrecorder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {


    EditText Systolic, Diastolic, HeartRate, Comment;
    Button Save;
    private String Date, Time, Comment1;
    private Integer Systolic1, Diastolic1, HeartRate1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        Systolic = findViewById(R.id.SystolicPressureEdit);
        Diastolic = findViewById(R.id.DiastolicPressureEdit);
        HeartRate = findViewById(R.id.HeartRateEdit);
        Comment = findViewById(R.id.CommentEdit);
        Save = findViewById(R.id.SaveEdit);

        GetAndSetIntentData();

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    void GetAndSetIntentData() {
        if (getIntent().hasExtra("Date") &&
                getIntent().hasExtra("Time") &&
                getIntent().hasExtra("Systolic") &&
                getIntent().hasExtra("Diastolic") &&
                getIntent().hasExtra("Heart Rate") &&
                getIntent().hasExtra("Comment")) {

            Date = getIntent().getStringExtra("Date");
            Time = getIntent().getStringExtra("Time");
            Comment1 = getIntent().getStringExtra("Comment");
            Systolic1 = getIntent().getIntExtra("Systolic", 0);
            Diastolic1 = getIntent().getIntExtra("Diastolic", 0);
            HeartRate1 = getIntent().getIntExtra("Heart Rate", 0);
            Comment1 = getIntent().getStringExtra("Comment");


            Systolic.setText(String.valueOf(Systolic1));
            Diastolic.setText(String.valueOf(Diastolic1));
            HeartRate.setText(String.valueOf(HeartRate1));
            Comment.setText(Comment1);
            Toast.makeText(this, "Found data", Toast.LENGTH_SHORT).show();


        } else {


            Toast.makeText(this, "NO data found", Toast.LENGTH_SHORT).show();


        }
    }
}