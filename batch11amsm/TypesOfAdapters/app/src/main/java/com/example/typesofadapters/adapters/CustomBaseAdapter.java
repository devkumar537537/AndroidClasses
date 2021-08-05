package com.example.typesofadapters.adapters;

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

import com.example.typesofadapters.R;
import com.example.typesofadapters.model.BaseModel;

import java.util.ArrayList;
import java.util.Random;

public class CustomBaseAdapter extends BaseAdapter {
    ArrayList<BaseModel> userlist;
    Context context;

    public CustomBaseAdapter(ArrayList<BaseModel> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @Override
    public Object getItem(int position) {

        return userlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = layoutInflater.inflate(R.layout.baseformate_layout,null);
        ImageView imageView = view.findViewById(R.id.baseimage);
        TextView emailview = view.findViewById(R.id.baseemail);
        RelativeLayout relativeLayout = view.findViewById(R.id.relativelayout);
        Button clickbtn = view.findViewById(R.id.clickbtn);
        BaseModel baseModel = userlist.get(position);
        imageView.setImageResource(baseModel.getImageurl());
        emailview.setText(baseModel.getEmail());
        clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255));

                relativeLayout.setBackgroundColor(color);
            }
        });


        return view;
    }
}
