package com.example.typesofadapters.RecyclerViewpackage;

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

import com.example.typesofadapters.R;
import com.example.typesofadapters.SecondActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {

    ArrayList<RecyclerMOdel > userlist;
    Context context;

    public CustomRecyclerAdapter(ArrayList<RecyclerMOdel> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerforamte,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.MyViewHolder holder, int position) {

        RecyclerMOdel recyclerMOdel = userlist.get(position);

        holder.imageView.setImageResource(recyclerMOdel.getImageurlrecycler());
        holder.numbertext.setText(recyclerMOdel.getNamerecycler());
        holder.nametext.setText(recyclerMOdel.getNumberrecycler());

holder.submitbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, SecondActivity.class);
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

        ImageView imageView;
        TextView nametext,numbertext;
        Button submitbtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recyclerimageview);
            nametext = itemView.findViewById(R.id.recylcernameview);
            numbertext = itemView.findViewById(R.id.recylcernumberview);
            submitbtn = itemView.findViewById(R.id.clickitbtn);


        }
    }
}
