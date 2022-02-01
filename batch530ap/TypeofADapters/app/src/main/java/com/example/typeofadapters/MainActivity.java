package com.example.typeofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<ItemModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        userlist = new ArrayList<>();


        userlist.add(new ItemModel("4353453",R.drawable.download));
        userlist.add(new ItemModel("456564",R.drawable.heart));
        userlist.add(new ItemModel("9807893",R.drawable.none));
        userlist.add(new ItemModel("12312313",R.drawable.one));
        userlist.add(new ItemModel("76676567",R.drawable.rivere));
        userlist.add(new ItemModel("4345354345",R.drawable.sky));
        userlist.add(new ItemModel("985603485",R.drawable.two));
        userlist.add(new ItemModel("4353453",R.drawable.download));
        userlist.add(new ItemModel("456564",R.drawable.heart));
        userlist.add(new ItemModel("9807893",R.drawable.none));
        userlist.add(new ItemModel("12312313",R.drawable.one));
        userlist.add(new ItemModel("76676567",R.drawable.rivere));
        userlist.add(new ItemModel("4345354345",R.drawable.sky));
        userlist.add(new ItemModel("985603485",R.drawable.two));
        userlist.add(new ItemModel("4353453",R.drawable.download));
        userlist.add(new ItemModel("456564",R.drawable.heart));
        userlist.add(new ItemModel("9807893",R.drawable.none));
        userlist.add(new ItemModel("12312313",R.drawable.one));
        userlist.add(new ItemModel("76676567",R.drawable.rivere));
        userlist.add(new ItemModel("4345354345",R.drawable.sky));
        userlist.add(new ItemModel("985603485",R.drawable.two));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.customarrayformate,userlist);
        listView.setAdapter(customArrayAdapter);

    }
}