package com.example.googlespreassheetsagain;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecylcerAdpater extends RecyclerView.Adapter<MyRecylcerAdpater.MyViewHolder> {
Context context ;
ArrayList<EamilModels> userlist;

    public MyRecylcerAdpater(Context context, ArrayList<EamilModels> userlist) {
        this.context = context;
        this.userlist = userlist;
    }

    @Override
    public MyRecylcerAdpater.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyRecylcerAdpater.MyViewHolder holder, int position) {
        final EamilModels student = userlist.get(position);

        holder.name.setText(student.getUseremail());
        holder.number.setText(student.getUserNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,Detail.class);
                intent.putExtra("email",student.getUseremail());
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
        return userlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,number;

        public MyViewHolder( View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.list_user_name);
            number =itemView.findViewById(R.id.list_user_number);
        }
    }
}
