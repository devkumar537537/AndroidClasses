package com.example.typesadapters.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.typesadapters.BaseAdapterExample;
import com.example.typesadapters.R;
import com.example.typesadapters.models.ItemModel;

import java.util.ArrayList;
import java.util.Random;

public class CustomArrayAdapter extends ArrayAdapter<ItemModel> {

    ArrayList<ItemModel> itemlist;
    Context context;
    public CustomArrayAdapter(@NonNull Context context, int resource,ArrayList<ItemModel> itemlist) {
        super(context, resource);
        this.itemlist = itemlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemlist.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        //connection xml with adapter
        LayoutInflater layoutInflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.formate,null);

        //connection view  with adapter
        ImageView imageView = view.findViewById(R.id.formateImage);
        TextView nametext = view.findViewById(R.id.format_name);
        TextView numbertext = view.findViewById(R.id.format_number);
        Button clickbtn = view.findViewById(R.id.formate_button);
        RelativeLayout relativeLayout = view.findViewById(R.id.reallayout);
        //setting data on view
        ItemModel itemModel = itemlist.get(position);
        nametext.setText(itemModel.getName());
        numbertext.setText(itemModel.getNumber());

        imageView.setImageResource(itemModel.getImageUrl());

        clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();

                int color = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255));

                relativeLayout.setBackgroundColor(color);
                Intent intent = new Intent(context, BaseAdapterExample.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                Toast.makeText(context, "candiate name is => "+itemModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
