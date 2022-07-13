package com.example.cardiacrecorder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> date, time;
    private ArrayList<Integer> systolic, diastolic, heart;

    CustomAdapter(Context context,
                  ArrayList date,
                  ArrayList time,
                  ArrayList systolic,
                  ArrayList diastolic,
                  ArrayList heart) {
        this.context = context;
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heart = heart;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.index.setText("# " +String.valueOf(position + 1));
        holder.date_text.setText(String.valueOf(date.get(position)));
        holder.time_text.setText(String.valueOf(time.get(position)));
        holder.systolic_text.setText(String.valueOf(systolic.get(position)));
        holder.diastolic_text.setText(String.valueOf(diastolic.get(position)));
        holder.heart_text.setText(String.valueOf(heart.get(position)));

    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date_text, time_text, systolic_text, diastolic_text, heart_text, index;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.IndexCard);
            date_text = itemView.findViewById(R.id.DateCard);
            time_text = itemView.findViewById(R.id.TimeCard);
            systolic_text = itemView.findViewById(R.id.systolicCard);
            diastolic_text = itemView.findViewById(R.id.diastolicCard);
            heart_text = itemView.findViewById(R.id.heartCard);
        }
    }
}
