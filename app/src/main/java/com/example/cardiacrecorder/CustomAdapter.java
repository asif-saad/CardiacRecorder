package com.example.cardiacrecorder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<String> date, time, comment, id;
    private ArrayList<Integer> systolic, diastolic, heart;
    Animation translate_anim;

    CustomAdapter(Activity activity,
                  Context context,
                  ArrayList id,
                  ArrayList date,
                  ArrayList time,
                  ArrayList systolic,
                  ArrayList diastolic,
                  ArrayList heart,
                  ArrayList comment) {
        this.activity=activity;
        this.context = context;
        this.id = id;
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heart = heart;
        this.comment = comment;
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

        // holder.index.setText("# " + String.valueOf(position + 1));
        holder.index.setText("#" + id.get(position));
        holder.date_text.setText(String.valueOf(date.get(position)));
        holder.time_text.setText(String.valueOf(time.get(position)));
        holder.systolic_text.setText(String.valueOf(systolic.get(position)));
        holder.diastolic_text.setText(String.valueOf(diastolic.get(position)));
        holder.heart_text.setText(String.valueOf(heart.get(position)));
        holder.comment.setText(String.valueOf(comment.get(position)));

<<<<<<< HEAD
        if((systolic.get(position)<90 || systolic.get(position)>140) || (diastolic.get(position)<60 || diastolic.get(position)>90))
        {
            holder.imageView.setImageResource(R.drawable.error);
        }
=======
        /*if(systolic.get(position)<90 && systolic.get(position)>140 &&
                diastolic.get(position)<60 && diastolic.get(position)>90)
        {
            holder.image.setImageResource(R.drawable.error);
        }*/

>>>>>>> saad


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("Date", String.valueOf(date.get(holder.getAdapterPosition())));
                intent.putExtra("Time", String.valueOf(time.get(holder.getAdapterPosition())));
                intent.putExtra("Systolic", systolic.get(holder.getAdapterPosition()));
                intent.putExtra("Diastolic", diastolic.get(holder.getAdapterPosition()));
                intent.putExtra("Heart Rate", heart.get(holder.getAdapterPosition()));
                intent.putExtra("Comment", String.valueOf(comment.get(holder.getAdapterPosition())));
                intent.putExtra("Id",String.valueOf(id.get(holder.getAdapterPosition())));
                //Toast.makeText(context, String.valueOf(id.get(holder.getAdapterPosition())), Toast.LENGTH_SHORT).show();
                activity.startActivityForResult(intent,1);
            }
        });

    }





    @Override
    public int getItemCount() {
        return date.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date_text, time_text, systolic_text, diastolic_text, heart_text, index, comment;
<<<<<<< HEAD
        ImageView imageView;
=======
        ImageView image;
>>>>>>> saad
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
<<<<<<< HEAD
            imageView=itemView.findViewById(R.id.ImageView);
=======
            image=itemView.findViewById(R.id.ImageView);
>>>>>>> saad
            index = itemView.findViewById(R.id.IndexCard);
            date_text = itemView.findViewById(R.id.DateCard);
            time_text = itemView.findViewById(R.id.TimeCard);
            systolic_text = itemView.findViewById(R.id.systolicCard);
            diastolic_text = itemView.findViewById(R.id.diastolicCard);
            heart_text = itemView.findViewById(R.id.heartCard);
            linearLayout = itemView.findViewById(R.id.LinearLayoutRow);
            comment = itemView.findViewById(R.id.CommentMyRow);
            translate_anim= AnimationUtils.loadAnimation(itemView.getContext(), R.anim.translate_anim);
            linearLayout.setAnimation(translate_anim);
        }
    }
}
