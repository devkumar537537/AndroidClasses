package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<ModelClass> userlsit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        userlsit = new ArrayList<>();

        userlsit.add(new ModelClass("Download",R.drawable.download));
        userlsit.add(new ModelClass("Heart",R.drawable.heart));
        userlsit.add(new ModelClass("None",R.drawable.none));
        userlsit.add(new ModelClass("One",R.drawable.one));
        userlsit.add(new ModelClass("River",R.drawable.rivere));
        userlsit.add(new ModelClass("Sky",R.drawable.sky));
        userlsit.add(new ModelClass("Two",R.drawable.two));
        userlsit.add(new ModelClass("Download",R.drawable.download));
        userlsit.add(new ModelClass("Heart",R.drawable.heart));
        userlsit.add(new ModelClass("None",R.drawable.none));
        userlsit.add(new ModelClass("One",R.drawable.one));
        userlsit.add(new ModelClass("River",R.drawable.rivere));
        userlsit.add(new ModelClass("Sky",R.drawable.sky));
        userlsit.add(new ModelClass("Two",R.drawable.two));
        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.listvewformate,userlsit);
        listView.setAdapter(customArrayAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(MainActivity.this,SecondAactivty.class);
//                startActivity(intent);
//            }
//        });



    }
}