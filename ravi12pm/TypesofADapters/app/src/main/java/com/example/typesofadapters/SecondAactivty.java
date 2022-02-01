package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondAactivty extends AppCompatActivity {
ListView listView;
ArrayList<ModelClass> userlsit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_aactivty);
        listView = findViewById(R.id.listviewbase);
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

        CustomBaseAdapter customBaseAdapter  = new CustomBaseAdapter(userlsit,getApplicationContext());

        listView.setAdapter(customBaseAdapter);
    }
}