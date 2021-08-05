package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.typesofadapters.adapters.CustomSimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterExample extends AppCompatActivity {
ListView listView;
ArrayList<HashMap<String,String>> userlist;
String[] name = {"first","Second","Third","Fourth","Fifth","Sixth","Seven"};
int[] images = {R.drawable.naturetwo,R.drawable.sample,R.drawable.third,R.drawable.weather,
        R.drawable.arebic,R.drawable.background,R.drawable.weather};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_example);
        listView = findViewById(R.id.simplelistvew);
        userlist = new ArrayList<>();

        for(int i = 0;i<name.length;i++)
        {
            HashMap<String,String> usermap = new HashMap<>();
            usermap.put("name",name[i]);
            usermap.put("image",images[i]+"");

          userlist.add(usermap);
        }

        String[] from = {"name","image"};
        int[] to = {R.id.username,R.id.imageview};

        CustomSimpleAdapter customSimpleAdapter = new CustomSimpleAdapter(getApplicationContext(),
                userlist,R.layout.arrayformate,from,to);

    listView.setAdapter(customSimpleAdapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            startActivity(new Intent(SimpleAdapterExample.this,BaseAdapterExample.class));
        }
    });

    }
}