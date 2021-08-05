package com.example.firebaseconcept;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ItemAdaptes extends RecyclerView.Adapter<ItemAdaptes.MyViewHolder> {

    ArrayList<MyModel> usserlist;
    Context context;

    public ItemAdaptes(ArrayList<MyModel> usserlist, Context context) {
        this.usserlist = usserlist;
        this.context = context;
    }

    @Override
    public ItemAdaptes.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producformat,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ItemAdaptes.MyViewHolder holder, int position) {
  MyModel myModel = usserlist.get(position);
  holder.emailview.setText(myModel.getEmail());
  holder.naameview.setText(myModel.getName());
  if(myModel.getImage().equals("defaul"))
  {
      holder.profiile.setImageResource(R.drawable.ic_launcher_background);
  }else
  {
      Glide.with(context).load(myModel.getImage()).into(holder.profiile);
  }
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
