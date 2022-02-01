package com.example.typesofadapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<ArrayModel> {
    ArrayList<ArrayModel> userlist;
    Context context;
    public CustomArrayAdapter(@NonNull Context context, int resource, ArrayList<ArrayModel> userlist) {
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

        View view = LayoutInflater.from(context).inflate(R.layout.arraylayout,null);

        Button bone = view.findViewById(R.id.submit);
        ImageView imageView = view.findViewById(R.id.imageview);
        EditText edit = view.findViewById(R.id.valueedit);
        TextView textview = view.findViewById(R.id.numbertext);

        ArrayModel arrayModel = userlist.get(position);
bone.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context,BaseAdapterExample.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent
        );
    }
});
        imageView.setImageResource(arrayModel.getImageurl());
        textview.setText(arrayModel.getName());
        return view;
    }
}
