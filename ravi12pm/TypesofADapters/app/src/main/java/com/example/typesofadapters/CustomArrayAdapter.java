package com.example.typesofadapters;

import android.content.Context;
import android.content.Intent;
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

public class CustomArrayAdapter extends ArrayAdapter<ModelClass> {

    ArrayList<ModelClass> userlist;
    Context context;


    public CustomArrayAdapter(@NonNull Context context, int resource,ArrayList<ModelClass> userlist) {
        super(context, resource);

        this.context = context;
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listvewformate,null,false);
        ImageView imageView = view.findViewById(R.id.imageview);
        TextView textView = view.findViewById(R.id.textview);
        ModelClass modelClass= userlist.get(position);
        imageView.setImageResource(modelClass.getImageurl());
        textView.setText(modelClass.getName());

        Button button = view.findViewById(R.id.clickbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String valueoftext = textView.getText().toString();
//                Toast.makeText(context, "selected "+valueoftext, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context,SecondAactivty.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }
}
