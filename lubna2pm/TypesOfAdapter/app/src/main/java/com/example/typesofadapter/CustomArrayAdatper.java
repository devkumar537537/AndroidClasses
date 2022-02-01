package com.example.typesofadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomArrayAdatper extends ArrayAdapter<ModelClass> {
    ArrayList<ModelClass> userlist;
    Context context;
    public CustomArrayAdatper(@NonNull Context context, int resource,ArrayList<ModelClass> userlist) {
        super(context, resource);

        this.context = context;
        this.userlist= userlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.arrayformate,parent,false);
        ImageView imageView = view.findViewById(R.id.imageview);
        TextView username = view.findViewById(R.id.textview);
        Button cickbtn = view.findViewById(R.id.clickbtn);


        ModelClass modelClass = userlist.get(position);
        imageView.setImageResource(modelClass.getImageurl());
        username.setText(modelClass.getName());

        cickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  text = username.getText().toString();

                Toast.makeText(context,"selected text "+text,Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }



}
