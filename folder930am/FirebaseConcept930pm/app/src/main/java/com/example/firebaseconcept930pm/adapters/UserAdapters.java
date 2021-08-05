package com.example.firebaseconcept930pm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.firebaseconcept930pm.R;
import com.example.firebaseconcept930pm.models.UserModel;

import java.util.ArrayList;

public class UserAdapters extends RecyclerView.Adapter<UserAdapters.MyViewHolder> {
    Context context;
    ArrayList<UserModel> userlist;

    public UserAdapters(Context context, ArrayList<UserModel> userlist) {
        this.context = context;
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public UserAdapters.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerformat,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapters.MyViewHolder holder, int position) {
        UserModel userModel = userlist.get(position);

holder.email.setText(userModel.getEmail());
holder.number.setText(userModel.getNumber());
        if(userModel.getImage().equals("default"))
        {
            holder.profileimage.setImageResource(R.drawable.ic_launcher_background);
        }else
        {
            Glide.with(context).load(userModel.getImage()).into(holder.profileimage);
        }
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView email,number;
        ImageView profileimage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.namedittext);
            number = itemView.findViewById(R.id.numberlayout);
            profileimage = itemView.findViewById(R.id.recyclrimage);
        }
    }
}
