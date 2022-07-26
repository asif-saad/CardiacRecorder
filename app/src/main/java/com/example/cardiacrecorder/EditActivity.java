package com.example.cardiacrecorder;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {


    EditText Systolic, Diastolic, HeartRate, Comment;
    Button Save, Delete;
    private String Date, Time, Comment1, Comment2;
    private Integer Systolic1, Diastolic1, HeartRate1,id, Systolic2, Diastolic2, HeartRate2;

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


        /**
         * Clicking this button will store the edited data in the database
         * The EditActivity intent is also closed
         * It navigates the user back to MainActivity Page where the data is displayed
         */
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Systolic2=Integer.parseInt(String.valueOf(Systolic.getText()));
                Diastolic2=Integer.parseInt(String.valueOf(Diastolic.getText()));
                HeartRate2=Integer.parseInt(String.valueOf(HeartRate.getText()));
                Comment2=String.valueOf(Comment.getText());

                MyDatabaseHelper MyDb = new MyDatabaseHelper(EditActivity.this);
                MyDb.updateData(id,
                        Date,
                        Time,
                        Systolic2,
                        Diastolic2,
                        HeartRate2,
                        Comment2);

                Intent intent=new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });


        /**
         * This button lets the user delete the entire data of the corresponding record
         * It opens up a confirm dialog box
         */
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
            id=Integer.parseInt(getIntent().getStringExtra("Id"));
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

    /**
     * This dialog box opens up when the user press 'Delete' button
     * If the user wants to delete the data, he can confirm here and the corresponding record in database will be deleted.
     */
    void ConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Would you like to delete this entry?");
        builder.setMessage("Are you sure you want to delete?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper MyDb = new MyDatabaseHelper(EditActivity.this);
                MyDb.deleteOneRow(String.valueOf(id));
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