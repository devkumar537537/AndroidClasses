package com.example.spreasheetexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyPasswordAdapter extends RecyclerView.Adapter<MyPasswordAdapter.MyViewHolder> {
    ArrayList<Item> items ;
    Context context;

    public MyPasswordAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MyPasswordAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyPasswordAdapter.MyViewHolder holder, int position) {
         Item item = items.get(position);
         holder.name.setText(item.getUserdate());
         holder.date.setText(item.getUsername());
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context,MyCretdialDetail.class);
                 intent.putExtra("mydetail",item);
                 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 context.startActivity(intent);
             }
         });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.list_user_name);
            date = itemView.findViewById(R.id.list_user_number);

        }
    }
}
