package com.example.typeofadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<ItemModel> {
    ArrayList<ItemModel> userlist;
    Context context;

    public CustomArrayAdapter(@NonNull Context context, int resource,ArrayList<ItemModel> userlist) {
        super(context, resource);
        this.userlist = userlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.customarrayformate,null,false);

        TextView textView = view.findViewById(R.id.numberview);
        ImageView imageView = view.findViewById(R.id.imageeview);

        ItemModel itemModel = userlist.get(position);

        textView.setText(itemModel.getNumber());
        imageView.setImageResource(itemModel.getImageurl());

        return view;
    }
}
