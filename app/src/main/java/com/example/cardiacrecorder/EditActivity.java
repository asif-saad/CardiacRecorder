package com.example.cardiacrecorder;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {


    EditText Systolic, Diastolic, HeartRate, Comment;
    Button Save, Delete;
    private String Date, Time, Comment1, id;
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
        Delete = findViewById(R.id.DeleteEdit);


        GetAndSetIntentData();


        //actionbar being implemented after genandsetintendata()
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Edit Menu");
        }


        //Toast.makeText(EditActivity.this, id, Toast.LENGTH_SHORT).show();

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper MyDb = new MyDatabaseHelper(EditActivity.this);
                MyDb.updateData(id,
                        Date,
                        Time,
                        Systolic1,
                        Diastolic1,
                        HeartRate1,
                        Comment1);

            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmDialog();
            }
        });
    }


    void GetAndSetIntentData() {
        if (getIntent().hasExtra("Date") &&
                getIntent().hasExtra("Time") &&
                getIntent().hasExtra("Systolic") &&
                getIntent().hasExtra("Diastolic") &&
                getIntent().hasExtra("Heart Rate") &&
                getIntent().hasExtra("Comment") &&
                getIntent().hasExtra("Id")) {

            Date = getIntent().getStringExtra("Date");
            Time = getIntent().getStringExtra("Time");
            Systolic1 = getIntent().getIntExtra("Systolic", 0);
            Diastolic1 = getIntent().getIntExtra("Diastolic", 0);
            HeartRate1 = getIntent().getIntExtra("Heart Rate", 0);
            Comment1 = getIntent().getStringExtra("Comment");
            id = getIntent().getStringExtra("Id");
            //Toast.makeText(this, getIntent().getStringExtra("Id"), Toast.LENGTH_SHORT).show();


            Systolic.setText(String.valueOf(Systolic1));
            Diastolic.setText(String.valueOf(Diastolic1));
            HeartRate.setText(String.valueOf(HeartRate1));
            Comment.setText(Comment1);
            Toast.makeText(this, "Found data", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "NO data found", Toast.LENGTH_SHORT).show();
        }
    }


    void ConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Would you like to delete this entry?");
        builder.setMessage("Are you sure you want to delete?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper MyDb = new MyDatabaseHelper(EditActivity.this);
                MyDb.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.create().show();
    }
}