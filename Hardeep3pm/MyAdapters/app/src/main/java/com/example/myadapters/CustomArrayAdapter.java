package com.example.myadapters;

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

public class CustomArrayAdapter extends ArrayAdapter<Item> {
    ArrayList<Item> arrayList;
    Context context;
    public CustomArrayAdapter(@NonNull Context context, int resource,ArrayList<Item> arrayList) {
        super(context, resource);
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater layoutInflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       view = layoutInflater.inflate(R.layout.array_format,null);

        ImageView imageView = view.findViewById(R.id.array_image);
        TextView textView = view.findViewById(R.id.user_image);

        imageView.setImageResource(arrayList.get(position).getImageurl());
        textView.setText(arrayList.get(position).getName());

        return view;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
