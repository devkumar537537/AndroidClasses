package com.example.myadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
    ArrayList<Item> arrayList;
    Context context;

    public CustomBaseAdapter(ArrayList<Item> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

       convertView = layoutInflater.inflate(R.layout.array_format,null);

        ImageView imageView = convertView.findViewById(R.id.array_image);
        TextView username = convertView.findViewById(R.id.user_image);

        imageView.setImageResource(arrayList.get(position).getImageurl());
        username.setText(arrayList.get(position).getName());
        return convertView;
    }
}
