package com.example.typesofadapters.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.typesofadapters.models.ItemModel;
import com.example.typesofadapters.R;

import java.util.ArrayList;

public class CustomArrayAdapter  extends ArrayAdapter<ItemModel> {
    ArrayList<ItemModel> userlist;
    Context context;
    public CustomArrayAdapter(@NonNull Context context, int resource, ArrayList<ItemModel> userlist) {
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

        View view = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.arrayformate,null);


        ImageView imageView = view.findViewById(R.id.imageview);
        TextView textView = view.findViewById(R.id.username);
ItemModel itemModel = userlist.get(position);
textView.setText(itemModel.getName());
imageView.setImageResource(itemModel.getImageurl());

imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(context, "name is "+itemModel.getName(), Toast.LENGTH_SHORT).show();
    }
});
        return view;
    }
}
