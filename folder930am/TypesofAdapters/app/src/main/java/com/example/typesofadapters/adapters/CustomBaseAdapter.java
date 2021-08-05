package com.example.typesofadapters.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.typesofadapters.R;
import com.example.typesofadapters.models.ItemModel;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
    ArrayList<ItemModel>  userlist;
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

        View view = convertView;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = layoutInflater.inflate(R.layout.arrayformate,null);
        ImageView imageView = view.findViewById(R.id.imageview);
        TextView textView = view.findViewById(R.id.username);

        ItemModel itemModel = userlist.get(position);
        textView.setText(itemModel.getName());
        imageView.setImageResource(itemModel.getImageurl());
        return view;
    }
}
