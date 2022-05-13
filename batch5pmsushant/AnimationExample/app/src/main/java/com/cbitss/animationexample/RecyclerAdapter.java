package com.cbitss.animationexample;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
ArrayList<RecyclerModel> userlist;
Context context;

    public RecyclerAdapter(ArrayList<RecyclerModel> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclr_formate,parent,false);

        MyViewHolder myViewHolder =new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
             RecyclerModel recyclerModel = userlist.get(position);
             holder.textView.setText(recyclerModel.getName());
             holder.imageView.setImageResource(recyclerModel.getImageurl());
             holder.button.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Random random =new Random();
                     int color = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255));
                     holder.relativeLayout.setBackgroundColor(color);
                 }
             });

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
           ImageView imageView;
           TextView textView;
           Button button;
           RelativeLayout relativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageRecycler);
            textView = itemView.findViewById(R.id.textvewrecyer);
            button = itemView.findViewById(R.id.colorbtn);
            relativeLayout= itemView.findViewById(R.id.relativelayot);
        }
    }
}
