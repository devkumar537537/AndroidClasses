package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.typesofadapters.adapters.CustomSimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterExample extends AppCompatActivity {
ListView listView;
ArrayList<HashMap<String,String >> data;

String[] name={"First","SEcond","third","fourth","FIve","First","SEcond","third","fourth","FIve","First","SEcond","third","fourth","FIve","First","SEcond","third","fourth","FIve"};
int[] imagest={R.drawable.bookone,R.drawable.booktwo,R.drawable.bookthree,R.drawable.heart,R.drawable.rivere, R.drawable.bookone,R.drawable.booktwo,R.drawable.bookthree,R.drawable.heart,R.drawable.rivere,R.drawable.bookone,R.drawable.booktwo,R.drawable.bookthree,R.drawable.heart,R.drawable.rivere,R.drawable.bookone,R.drawable.booktwo,R.drawable.bookthree,R.drawable.heart,R.drawable.rivere};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_example);
        listView = findViewById(R.id.simplelist);
        data = new ArrayList<>();

        for(int i = 0;i<name.length;i++)
        {
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("name",name[i]);
            hashMap.put("imageurl",imagest[i]+"");

            data.add(hashMap);
        }
        String[] from = {"name","imageurl"};

        int[] to = {R.id.nameveiwsimple,R.id.imageviewsimple};


        CustomSimpleAdapter customSimpleAdapter = new CustomSimpleAdapter(getApplicationContext(),data,R.layout.customsimplelayout,from,to);
        listView.setAdapter(customSimpleAdapter);


    }
}