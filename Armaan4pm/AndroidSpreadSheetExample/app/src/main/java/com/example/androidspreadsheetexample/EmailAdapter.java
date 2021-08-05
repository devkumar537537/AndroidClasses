package com.example.androidspreadsheetexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.MyViewholder> {
    ArrayList<EamilModels> arraylist;
    Context context;



    public EmailAdapter(ArrayList<EamilModels> arraylist, Context context) {
        this.arraylist = arraylist;
        this.context = context;

    }
    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        final EamilModels student = arraylist.get(position);

        holder.name.setText(student.getUsername());
        holder.number.setText(student.getUserNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,UserDetail.class);
                intent.putExtra("name",student.getUsername());
                intent.putExtra("number",student.getUserNumber());
                intent.putExtra("id",student.getUserId());
                intent.putExtra("date",student.getUserdate());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView name,number;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.list_user_name);
            number =itemView.findViewById(R.id.list_user_number);
        }
    }
}
