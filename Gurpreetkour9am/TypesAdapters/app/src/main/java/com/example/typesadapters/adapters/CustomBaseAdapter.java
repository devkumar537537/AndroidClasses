package com.example.typesadapters.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.typesadapters.R;
import com.example.typesadapters.SimpleAdapterExample;
import com.example.typesadapters.models.ItemModel;

import java.util.ArrayList;
import java.util.Random;

public class CustomBaseAdapter extends BaseAdapter {
    ArrayList<ItemModel> itemlist;
    Context context;
  public CustomBaseAdapter(ArrayList<ItemModel> itemlist, Context context)
    {
        this.itemlist = itemlist;
        this.context = context;
    }



    @Override
    public int getCount() {
        return itemlist.size();
    }

    @Override
    public Object getItem(int position) {
        return itemlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.formate,null);

        //connection view  with adapter
        ImageView imageView = view.findViewById(R.id.formateImage);
        TextView nametext = view.findViewById(R.id.format_name);
        TextView numbertext = view.findViewById(R.id.format_number);
        Button clickbtn = view.findViewById(R.id.formate_button);
        RelativeLayout relativeLayout = view.findViewById(R.id.reallayout);

        ItemModel itemModel = itemlist.get(position);
        imageView.setImageResource(itemModel.getImageUrl());
        nametext.setText(itemModel.getName());
        numbertext.setText(itemModel.getNumber());

        clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Random random = new Random();
//
//                int color = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255));
//
//                relativeLayout.setBackgroundColor(color);
                Intent intent = new Intent(context, SimpleAdapterExample.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
