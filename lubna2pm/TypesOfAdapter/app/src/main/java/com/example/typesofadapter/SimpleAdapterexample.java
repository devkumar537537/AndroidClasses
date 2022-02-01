package com.example.typesofadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterexample extends AppCompatActivity {
ListView listView;
ArrayList<HashMap<String,String>> usermapelist;

String[] username={"Abc","abc2","Abc3","abc4","abc5"};
int[] imageurl = {R.drawable.bookone,R.drawable.booktwo,R.drawable.bookthree,R.drawable.sky,R.drawable.download};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapterexample);
        listView = findViewById(R.id.listveiewismple);
        usermapelist=new ArrayList<>();

        for(int i=0;i<username.length;i++)
        {
            HashMap<String,String> newmap = new HashMap<>();
            newmap.put("image",imageurl[i]+"");
            newmap.put("name",username[i]);

            usermapelist.add(newmap);
        }
        String[] from = {"image","name"};
        int[] to = {R.id.imageview123,R.id.textview};

        CustomSimpleAdapter customSimpleAdapter = new CustomSimpleAdapter(getApplicationContext(),usermapelist,R.layout.simplformate,from,to);
        listView.setAdapter(customSimpleAdapter);
    }
}