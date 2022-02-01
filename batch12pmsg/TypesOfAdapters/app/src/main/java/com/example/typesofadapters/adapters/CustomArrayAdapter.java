package com.example.typesofadapters.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.typesofadapters.R;
import com.example.typesofadapters.SimpleAdapterExample;
import com.example.typesofadapters.models.ArrayModel;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<ArrayModel> {

    ArrayList<ArrayModel> userlist;
    Context context;
    public CustomArrayAdapter(@NonNull Context context, int resource,ArrayList<ArrayModel> userlist) {
        super(context, resource);

        this.userlist = userlist;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view = layoutInflater.inflate(R.layout.customarraylayout,null,false);

       ArrayModel arrayModel = userlist.get(position);

        ImageView imageView = view.findViewById(R.id.imageviewrcycler);
        TextView nameview = view.findViewById(R.id.nameveiw);
        TextView numberview = view.findViewById(R.id.numberviw);

        Button clickbtn = view.findViewById(R.id.clickbtnrecyler);

        nameview.setText(arrayModel.getName());
        numberview.setText(arrayModel.getNumber());
       imageView.setImageResource(arrayModel.getImageurl());
clickbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       Intent intent = new Intent(context, SimpleAdapterExample.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       context.startActivity(intent);
    }
});

        return view;
    }

    @Override
    public int getCount() {
        return userlist.size() ;
    }
}
