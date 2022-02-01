package com.example.typesofadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<ModelClass> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userlist = new ArrayList<>();
        listView = findViewById(R.id.listview);

        userlist.add(new ModelClass("Download",R.drawable.download));
        userlist.add(new ModelClass("Hear",R.drawable.heart));
        userlist.add(new ModelClass("None",R.drawable.none));
        userlist.add(new ModelClass("One",R.drawable.one));
        userlist.add(new ModelClass("River",R.drawable.rivere));
        userlist.add(new ModelClass("Sky",R.drawable.sky));
        userlist.add(new ModelClass("Sky",R.drawable.sky));


        CustomArrayAdatper customArrayAdatper = new CustomArrayAdatper(getApplicationContext(),R.layout.arrayformate,userlist);
        listView.setAdapter(customArrayAdatper);


    }
}