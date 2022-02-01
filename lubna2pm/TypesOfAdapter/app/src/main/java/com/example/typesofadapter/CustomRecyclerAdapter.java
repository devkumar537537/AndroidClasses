package com.example.typesofadapter;

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

import java.util.ArrayList;
import java.util.Random;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {

    ArrayList<RecylerModel> userlist;
    Context context;

    public CustomRecyclerAdapter(ArrayList<RecylerModel> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerformate,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.MyViewHolder holder, int position) {

        RecylerModel recyclerModel = userlist.get(position);
        holder.imageView.setImageResource(recyclerModel.getImageurl());
        holder.numberview.setText(recyclerModel.getName());
        holder.clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Random random = new Random();

                    int color = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));

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
