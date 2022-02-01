package com.example.recyclerivewadatper;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class CustomRecylerAdapter extends RecyclerView.Adapter<CustomRecylerAdapter.MyViewHolder> {
ArrayList<RecylerModel> userlist;
Context context;
    boolean res = false;
    public CustomRecylerAdapter(ArrayList<RecylerModel> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomRecylerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerformate,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecylerAdapter.MyViewHolder holder, int position) {
        RecylerModel recylerModel = userlist.get(position);
        holder.imageView.setImageResource(recylerModel.getImageurl());
        holder.numberview.setText(recylerModel.getName());

        int a = holder.getAdapterPosition();
holder.clickbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        RecylerModel recylerModel = userlist.get(holder.getAdapterPosition());
        holder.imageView.setImageResource(recylerModel.getImageurl());
        holder.numberview.setText(recylerModel.getName());
            userlist.remove(a);


//
//            Random random = new Random();
//
//            int color = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));
//            int color2 = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));
//            holder.relativeLayout.setBackgroundColor(color);
//            holder.numberview.setTextColor(color2);


    }
});

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        EditText numberedit;
        TextView numberview;
         Button clickbtn;
RelativeLayout relativeLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            numberedit = itemView.findViewById(R.id.numbereidt);
            numberview = itemView.findViewById(R.id.numberview);
         clickbtn = itemView.findViewById(R.id.clickit);
relativeLayout = itemView.findViewById(R.id.realivielayotu);
        }
    }
}
