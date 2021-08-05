package com.example.typesofadapters.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.typesofadapters.R;
import com.example.typesofadapters.model.BaseModel;

import java.util.ArrayList;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {
  ArrayList<BaseModel> userlist;
  Context context;

    public CustomRecyclerAdapter(ArrayList<BaseModel> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @Override
    public CustomRecyclerAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyler_formate,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( CustomRecyclerAdapter.MyViewHolder holder, int position) {


        BaseModel baseModel = userlist.get(position);
        holder.usertextview.setText(baseModel.getEmail());

        holder.userimageveiw.setImageResource(baseModel.getImageurl());
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       ImageView userimageveiw;
       TextView usertextview;
        public MyViewHolder( View itemView) {
            super(itemView);
            userimageveiw = itemView.findViewById(R.id.recyclerimage);
            usertextview = itemView.findViewById(R.id.recycleremail);

        }
    }
}
