package com.example.restapiexampleonjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.restapiexampleonjava.models.Results;
import com.example.restapiexampleonjava.utils.Commonfunctions;

import java.util.ArrayList;

public class CustomMoviewAdapter extends RecyclerView.Adapter<CustomMoviewAdapter.MyViewHOlder> {
    ArrayList<Results> movielist;
    Context context;

    public CustomMoviewAdapter(ArrayList<Results> movielist, Context context) {
        this.movielist = movielist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomMoviewAdapter.MyViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerformate,parent,false);

        return new MyViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomMoviewAdapter.MyViewHOlder holder, int position) {
        Results results = movielist.get(position);
        Glide.with(context).load(Commonfunctions.IMAGEBASE_URL+results.getPoster_path()).into(holder.imageView);
        holder.title.setText(results.getTitle());
        holder.overview.setText(results.getOverview());
    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }

    public class MyViewHOlder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,overview;

        public MyViewHOlder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.movieimage);
            title = itemView.findViewById(R.id.movietitle);
            overview = itemView.findViewById(R.id.movieoverview);

        }
    }
}
