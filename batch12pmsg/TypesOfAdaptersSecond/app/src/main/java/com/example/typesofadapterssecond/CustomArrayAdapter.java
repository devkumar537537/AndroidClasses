package com.example.typesofadapterssecond;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<MyModel> {

    ArrayList<MyModel>  userlist;
    Context context;
    public CustomArrayAdapter(@NonNull Context context, int resource,ArrayList<MyModel> userlist) {
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.arrayformate,null,false);

        ImageView imageView = view.findViewById(R.id.imageview);
        TextView textView = view.findViewById(R.id.nameview);
        Button button = view.findViewById(R.id.clickbtn);
        MyModel myModel = userlist.get(position);

        imageView.setImageResource(myModel.getImageurl());
        textView.setText(myModel.getName());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "clicked "+position+ " position item", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
