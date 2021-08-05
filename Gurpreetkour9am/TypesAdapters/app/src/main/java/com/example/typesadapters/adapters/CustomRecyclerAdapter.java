package com.example.typesadapters.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.typesadapters.MainActivity;
import com.example.typesadapters.R;
import com.example.typesadapters.models.RecyclerModel;

import java.util.ArrayList;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {

    ArrayList<RecyclerModel> userlist;
    Context context;

    public CustomRecyclerAdapter(ArrayList<RecyclerModel> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerformate,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.MyViewHolder holder, int position) {
  RecyclerModel recyclerModel = userlist.get(position);

  holder.profileimage.setImageResource(recyclerModel.getImageurl());
  holder.usereamil.setText(recyclerModel.getEmail());
  int pincode = recyclerModel.getPincode();
  holder.userpincode.setText(String.valueOf(pincode));
  holder.userbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Intent intent = new Intent(context, MainActivity.class);
          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          context.startActivity(intent);
      }
  });


    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView profileimage;
        TextView usereamil,userpincode;
        Button userbtn;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profileimage = itemView.findViewById(R.id.image_recycler);
            userbtn = itemView.findViewById(R.id.recycer_btn);
            usereamil = itemView.findViewById(R.id.recycer_email);
            userpincode = itemView.findViewById(R.id.recyer_pincode);


        }
    }
}
