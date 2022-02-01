package com.example.typesofadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
    ArrayList<ArrayModel> userlsit;
    Context context;

    public CustomBaseAdapter(ArrayList<ArrayModel> userlsit, Context context) {
        this.userlsit = userlsit;
        this.context = context;
    }

    @Override
    public int getCount() {
        return userlsit.size();
    }

    @Override
    public Object getItem(int i) {
        return userlsit.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View vieww = LayoutInflater.from(context).inflate(R.layout.arraylayout,null,false);

        Button bone =vieww.findViewById(R.id.submit);
        ImageView imageView = vieww.findViewById(R.id.imageview);
        EditText edit = vieww.findViewById(R.id.valueedit);
        TextView textview = vieww.findViewById(R.id.numbertext);

        ArrayModel arrayModel = userlsit.get(position);

        imageView.setImageResource(arrayModel.getImageurl());
        textview.setText(arrayModel.getName());
        return vieww;
    }
}
