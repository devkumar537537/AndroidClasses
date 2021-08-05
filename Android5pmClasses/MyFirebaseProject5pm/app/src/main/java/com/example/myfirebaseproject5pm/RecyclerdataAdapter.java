package com.example.myfirebaseproject5pm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerdataAdapter extends RecyclerView.Adapter<RecyclerdataAdapter.MyViewHOlder> {
    ArrayList<UserDataModelClass> userDataModelClasseslist;

    Context context;

    public RecyclerdataAdapter(ArrayList<UserDataModelClass> userDataModelClasseslist, Context context) {
        this.userDataModelClasseslist = userDataModelClasseslist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerdataAdapter.MyViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_row,parent,false);

        return new MyViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerdataAdapter.MyViewHOlder holder, int position) {
            UserDataModelClass userDataModelClass = userDataModelClasseslist.get(position);

            holder.username.setText(userDataModelClass.getName());
            holder.usernumber.setText(userDataModelClass.getNumber());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,UpdateActivity.class);
                    intent.putExtra("email",userDataModelClass.getEmail());
                    intent.putExtra("name",userDataModelClass.getName());
                    intent.putExtra("number",userDataModelClass.getNumber());
                    intent.putExtra("password",userDataModelClass.getPassword());
                    intent.putExtra("userid",userDataModelClass.getUserId());

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return userDataModelClasseslist.size();
    }

    public class MyViewHOlder extends RecyclerView.ViewHolder {
        TextView username,usernumber;

        public MyViewHOlder(@NonNull View itemView) {
            super(itemView);

            usernumber = itemView.findViewById(R.id.user_number_id_item);
            username = itemView.findViewById(R.id.user_name_item);

        }
    }
}
