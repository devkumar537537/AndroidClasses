package com.example.typesofadapters.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.typesofadapters.R;
import com.example.typesofadapters.models.RecyclerModle;

import java.util.ArrayList;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {
    ArrayList<RecyclerModle> userlist;
    Context context;

    public CustomRecyclerAdapter(ArrayList<RecyclerModle> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerformate,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.MyViewHolder holder, int position) {
              RecyclerModle recyclerModle = userlist.get(position);
              holder.imageView.setImageResource(recyclerModle.getImageurl());
              holder.textView.setText(recyclerModle.getEmail());
              holder.clickbtn.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                     String emailtext = holder.editText.getText().toString();
                     holder.textView.setText(emailtext);
                  }
              });
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        EditText editText;
        Button clickbtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageviewrcycler);
            textView = itemView.findViewById(R.id.nameviewrecyler);
            editText = itemView.findViewById(R.id.editemailrecycler);
            clickbtn = itemView.findViewById(R.id.clickbtnrecyler);
        }
    }
}
