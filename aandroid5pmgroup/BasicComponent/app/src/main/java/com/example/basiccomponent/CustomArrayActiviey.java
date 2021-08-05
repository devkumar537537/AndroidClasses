package com.example.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomArrayActiviey extends AppCompatActivity {
ListView listView;
ArrayList<Item> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_array_activiey);
        listView = findViewById(R.id.list_items);

        userlist = new ArrayList<>();


        userlist.add(new Item(R.drawable.arebic,"Arebic"));
        userlist.add(new Item(R.drawable.download,"Download"));
        userlist.add(new Item(R.drawable.naturetwo,"NatureTwo"));
        userlist.add(new Item(R.drawable.right,"Right"));
        userlist.add(new Item(R.drawable.arebic,"Arebic"));
        userlist.add(new Item(R.drawable.download,"Download"));
        userlist.add(new Item(R.drawable.naturetwo,"NatureTwo"));
        userlist.add(new Item(R.drawable.right,"Right"));
        userlist.add(new Item(R.drawable.arebic,"Arebic"));
        userlist.add(new Item(R.drawable.download,"Download"));
        userlist.add(new Item(R.drawable.naturetwo,"NatureTwo"));
        userlist.add(new Item(R.drawable.right,"Right"));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.arrayal_list_formate,userlist);
        listView.setAdapter(customArrayAdapter);
    }
}