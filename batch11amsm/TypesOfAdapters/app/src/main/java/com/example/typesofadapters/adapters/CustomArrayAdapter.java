package com.example.typesofadapters.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.typesofadapters.R;
import com.example.typesofadapters.model.MyItem;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<MyItem> {
    ArrayList<MyItem> userlist;
    Context context;

    public CustomArrayAdapter(@NonNull Context context, int resource,ArrayList<MyItem> userlist) {
        super(context, resource);
        this.context = context;
        this.userlist = userlist;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


         view = layoutInflater.inflate(R.layout.listformate,null);

        ImageView imageView = view.findViewById(R.id.arrayimage);
        TextView usernumber = view.findViewById(R.id.UserNumber);
        MyItem myItem = userlist.get(position);

        imageView.setImageResource(myItem.getImageUrl());
        usernumber.setText(myItem.getNumber());


        return view;
    }
}
