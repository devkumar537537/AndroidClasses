package com.example.typesofadapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class CustomBaseAdapter extends BaseAdapter {
    ArrayList<ModelClass> userlist;
    Context context;

    public CustomBaseAdapter(ArrayList<ModelClass> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @Override
    public Object getItem(int i) {
        return  userlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View viewe = LayoutInflater.from(context).inflate(R.layout.listvewformate,null,false);

        ImageView imageView = viewe.findViewById(R.id.imageview);
        TextView textView = viewe.findViewById(R.id.textview);
        Button button = viewe.findViewById(R.id.clickbtn);
        RelativeLayout relativeLayout = viewe.findViewById(R.id.realtivlayout);
        ModelClass modelClass = userlist.get(position);

        imageView.setImageResource(modelClass.getImageurl());
        textView.setText(modelClass.getName());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
            int color = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255));
            relativeLayout.setBackgroundColor(color);
            }
        });
        return viewe;
    }
}
