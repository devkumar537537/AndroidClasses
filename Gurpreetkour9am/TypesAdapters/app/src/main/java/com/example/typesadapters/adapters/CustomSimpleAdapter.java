package com.example.typesadapters.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.typesadapters.R;
import com.example.typesadapters.RecyclerViewActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomSimpleAdapter  extends SimpleAdapter {

ArrayList<HashMap<String,String>> data;
Context context;

    public CustomSimpleAdapter(Context context, ArrayList<HashMap<String,String>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.data = data;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =  super.getView(position, convertView, parent);
      Button button = view.findViewById(R.id.formate_button);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
//          int sum =calculatesum(data.get(position).get("number"));
//              Toast.makeText(context, "sum of digit is => "+sum, Toast.LENGTH_SHORT).show();
              Intent intent = new Intent(context, RecyclerViewActivity.class);
              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              context.startActivity(intent);
          }
      });
        return  view;
    }

    private int calculatesum(String number) {
        char[] numberr = number.toCharArray();
        int sum = 0;
        for(int i=0;i<numberr.length;i++)
        {

            sum = sum+Integer.parseInt(numberr[i]+"");

        }
        return sum;
    }


    @Override
    public int getCount() {
        return data.size();
    }
}
