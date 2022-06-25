package com.example.cardiacrecorder;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    private EditText date,time;
    private TextInputEditText systolic,diastolic,heart_rate, comment;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String Date, Time;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);



        date = findViewById(R.id.Data);
        time = findViewById(R.id.Time);
        systolic=findViewById(R.id.systolic_pressure);
        diastolic=findViewById(R.id.diastolic_pressure);
        heart_rate=findViewById(R.id.heart_rate);
        comment=findViewById(R.id.comment);






        date.setEnabled(false);
        time.setEnabled(false);

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date = dateFormat.format(calendar.getTime());
        date.setText(Date);

        dateFormat = new SimpleDateFormat("HH:MM aaa");
        Time = dateFormat.format(calendar.getTime());
        time.setText(Time);




        systolic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(systolic.getText().toString());
                if(a<60 || a>240)
                {
                    systolic.getText().clear();
                    Toast.makeText(AddActivity.this,
                            "Invalid value for Systolic Pressure!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        diastolic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(diastolic.getText().toString());

                if(a<30 || a>150)
                {
                    diastolic.getText().clear();
                    Toast.makeText(AddActivity.this,
                            "Invalid value for Diastolic Pressure!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        heart_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(heart_rate.getText().toString());


                if(a>220 || a<35)
                {
                    heart_rate.getText().clear();
                    Toast.makeText(AddActivity.this, "Invalid value for Heart rate", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}