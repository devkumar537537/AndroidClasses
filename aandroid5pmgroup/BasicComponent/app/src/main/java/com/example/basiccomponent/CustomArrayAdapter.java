package com.example.basiccomponent;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class CustomArrayAdapter  extends ArrayAdapter<Item> {
    ArrayList<Item> userlist;
    Context context;

    public CustomArrayAdapter(@NonNull Context context, int resource,ArrayList<Item> userlist ) {
        super(context, resource);

        this.context = context;
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.arrayal_list_formate,null);
        ImageView imageView = view.findViewById(R.id.arrayimaages);
        TextView textView = view.findViewById(R.id.nametext);
        Button button = view.findViewById(R.id.clickbtn);
        LinearLayout linearLayout = view.findViewById(R.id.linearlayout);

        Item item = userlist.get(position);

        imageView.setImageResource(item.getImageurl());
        textView.setText(item.getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();

                int color = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255));
           linearLayout.setBackgroundColor(color);

            }
        });
        return view;
    }


    @Override
    public int getCount() {
        return userlist.size();
    }
}
