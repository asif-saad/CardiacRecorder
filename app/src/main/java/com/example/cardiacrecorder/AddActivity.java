package com.example.cardiacrecorder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class AddActivity extends AppCompatActivity {

    private TextInputEditText systolic, diastolic, heart_rate, comment;
    private boolean flag = false;
    private EditText date, time;
    Button add;

    /**
     * This function get executed in the creation of add activity intent.
     * It initiates the instances of different components of add activity page.
     * @param savedInstanceState
     */
    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        date = findViewById(R.id.Data);
        time = findViewById(R.id.Time);
        systolic = findViewById(R.id.systolic_pressure);
        diastolic = findViewById(R.id.diastolic_pressure);
        heart_rate = findViewById(R.id.heart_rate);
        comment = findViewById(R.id.comment);
        add = findViewById(R.id.add);


        date.setEnabled(false);
        time.setEnabled(false);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String date1 = dateFormat.format(calendar.getTime());
        date.setText(date1);

        dateFormat = new SimpleDateFormat("HH:mm aaa");
        String time1 = dateFormat.format(calendar.getTime());
        time.setText(time1);


        /**
         * This function takes input from systolic textfield and assigns the value to a variable
         */
        systolic.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(Objects.requireNonNull(systolic.getText()).toString());

            }
        });
        /**
         * This function takes input from diastolic textfield and assigns the value to a variable
         */
        diastolic.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(Objects.requireNonNull(diastolic.getText()).toString());

            }
        });

        /**
         * This function takes input from heart_rate textfield and assigns the value to a variable
         */
        heart_rate.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(Objects.requireNonNull(heart_rate.getText()).toString());

            }
        });

        /**
         * Clicking this button confirms the entries of the user and stores the collected data to the database.
         */
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addRecord(Objects.requireNonNull(date.getText().toString().trim()),
                        Objects.requireNonNull(time.getText().toString().trim()),
                        Integer.parseInt(Objects.requireNonNull(systolic.getText()).toString().trim()),
                        Integer.parseInt(Objects.requireNonNull(diastolic.getText()).toString().trim()),
                        Integer.parseInt(Objects.requireNonNull(Objects.requireNonNull(heart_rate).getText()).toString().trim()),
                        comment.getText().toString().trim());
                Intent intent=new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}