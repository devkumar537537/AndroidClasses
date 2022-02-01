package com.example.typesofadapters.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.typesofadapters.R;
import com.example.typesofadapters.models.SimpleModel;

import java.util.ArrayList;
import java.util.Random;

public class CustomBaseAdapter extends BaseAdapter {

    ArrayList<SimpleModel> userlist ;
    Context context;

    public CustomBaseAdapter(ArrayList<SimpleModel> userlist, Context context) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.customsimplelayout,null,false);
        ImageView imageView = view.findViewById(R.id.imageviewsimple);
        TextView textView = view.findViewById(R.id.nameveiwsimple);
        Button clickbtn = view.findViewById(R.id.clickbtnbase);
        RelativeLayout relativeLayout = view.findViewById(R.id.relativelayout);
        clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255));
            relativeLayout.setBackgroundColor(color);

            }
        });
        SimpleModel simpleModel = userlist.get(position);
        imageView.setImageResource(simpleModel.getImageurl());
        textView.setText(simpleModel.getName());
        return view;
    }
}
