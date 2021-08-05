package com.example.myadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterExample extends AppCompatActivity {
ListView simplelistver;
ArrayList<HashMap<String,String>> arrayList;
String[] nameString = {"India","USA","UK","China","Shrilanka","Austrelia"};
int[] imagedata = {R.drawable.right,R.drawable.sample,R.drawable.download,R.drawable.weather,R.drawable.third,R.drawable.right};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_example);
        simplelistver = findViewById(R.id.simplelistview);
        arrayList = new ArrayList<>();

        for(int i=0;i<nameString.length;i++)
        {
            HashMap<String,String> hashMap = new HashMap<>();

            hashMap.put("name",nameString[i]);
            hashMap.put("image",imagedata[i]+"");

            arrayList.add(hashMap);
        }

        String[] from = {"name","image"};

        int[] to = {R.id.user_image,R.id.array_image};

        CustomSimpleAdapter customSimpleAdapter = new CustomSimpleAdapter(getApplicationContext(),arrayList,R.layout.array_format,from,to);

        simplelistver.setAdapter(customSimpleAdapter);

    }
}