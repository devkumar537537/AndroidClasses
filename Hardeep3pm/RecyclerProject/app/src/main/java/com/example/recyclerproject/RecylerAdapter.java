package com.example.recyclerproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.MyViewHolder> {
    ArrayList<ItemModel> arrayList;
    Context context;

    public RecylerAdapter(ArrayList<ItemModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecylerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerformat,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerAdapter.MyViewHolder holder, int position) {
      ItemModel itemModel = arrayList.get(position);
      holder.userimage.setImageResource(itemModel.imageurl);
      holder.username.setText(itemModel.getName());
      holder.cardviewbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(context, "clicked item "+itemModel.getName(), Toast.LENGTH_SHORT).show();
          }
      });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
         ImageView userimage;
         TextView username;
         CardView cardviewbtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userimage = itemView.findViewById(R.id.recyerl_image);
            username = itemView.findViewById(R.id.recyelr_name);
            cardviewbtn = itemView.findViewById(R.id.click_btn);

        }
    }
}
