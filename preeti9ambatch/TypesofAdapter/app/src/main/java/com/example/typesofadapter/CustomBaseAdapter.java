package com.example.typesofadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {

    ArrayList<ItemModel> userlist;
    Context context;

    public CustomBaseAdapter(ArrayList<ItemModel> userlist, Context context) {
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

        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.itemformate,null,false);
        ImageView imageView = view.findViewById(R.id.imageview);
        TextView textView = view.findViewById(R.id.usernumber);
        ItemModel itemModel = userlist.get(position);

        textView.setText(itemModel.getNumber());

        imageView.setImageResource(itemModel.getImageurl());

        return view;
    }
}
