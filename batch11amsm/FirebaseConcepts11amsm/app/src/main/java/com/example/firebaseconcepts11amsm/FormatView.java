package com.example.firebaseconcepts11amsm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FormatView extends RecyclerView.Adapter<FormatView.MyViewHolder> {
    ArrayList<MyModel> usserlist;
    Context context;

    public FormatView(ArrayList<MyModel> usserlist, Context context) {
        this.usserlist = usserlist;
        this.context = context;
    }
    @Override
    public FormatView.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producformat,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( FormatView.MyViewHolder holder, int position) {
        MyModel myModel = usserlist.get(position);
        holder.emailview.setText(myModel.getUserEamil());
        holder.naameview.setText(myModel.getUserNumber());
        if(myModel.getImageurl().equals("default"))
        {
            holder.profiile.setImageResource(R.drawable.ic_launcher_background);
        }else
        {
            Glide.with(context).load(myModel.getImageurl()).into(holder.profiile);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("userid",myModel.getUderId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usserlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView naameview,emailview;
        ImageView profiile;
        public MyViewHolder( View itemView) {
            super(itemView);
            naameview = itemView.findViewById(R.id.namedittext);
            emailview = itemView.findViewById(R.id.numberlayout);
            profiile = itemView.findViewById(R.id.recyclrimage);
        }
    }
}
