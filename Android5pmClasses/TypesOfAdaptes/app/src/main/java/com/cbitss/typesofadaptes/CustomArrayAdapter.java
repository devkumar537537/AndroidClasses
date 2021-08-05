package com.cbitss.typesofadaptes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<Item> {
    ArrayList<Item> userlist;
    public CustomArrayAdapter(@NonNull Context context, int resource,ArrayList<Item> userlist) {
        super(context, resource);
        this.userlist = userlist;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = layoutInflater.inflate(R.layout.list_formate,null);
        ImageView iconimageview  = v.findViewById(R.id.list_format_imagvview);
        TextView name = v.findViewById(R.id.listview_text);

        iconimageview.setImageResource(userlist.get(position).getImage());
        name.setText(userlist.get(position).getName());


        return v;
    }
}
