package com.example.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
ArrayList<Item> userlist;
Context context;

    public CustomBaseAdapter(ArrayList<Item> userlist, Context context) {
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

        LayoutInflater layoutInflater =(LayoutInflater)  parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
       View view = layoutInflater.inflate(R.layout.baselayout,null);

       Item item = userlist.get(position);

        TextView number = view.findViewById(R.id.textviewbase);
        ImageView imageView = view.findViewById(R.id.imageviewbase);


        number.setText(item.getNumber());
        imageView.setImageResource(item.getImageurl());

        return view;
    }
}
