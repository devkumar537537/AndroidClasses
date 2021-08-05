package com.cbitss.typesofadaptes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ArrayAdapterExample extends AppCompatActivity {
ListView listView;
ArrayList<Item>  userlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_example);

        listView = findViewById(R.id.listview_array_adtapter);

        userlist.add(new Item("Lion",R.drawable.arebic));
        userlist.add(new Item("Tiger",R.drawable.sample));
        userlist.add(new Item("Lion",R.drawable.arebic));
        userlist.add(new Item("Lion",R.drawable.arebic));
        userlist.add(new Item("Lion",R.drawable.arebic));
        userlist.add(new Item("Tiger",R.drawable.sample));
        userlist.add(new Item("Lion",R.drawable.arebic));
        userlist.add(new Item("Lion",R.drawable.arebic));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.list_formate,userlist);
        listView.setAdapter(customArrayAdapter);




    }
}