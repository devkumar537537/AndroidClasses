package com.example.typesofadapter;

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



        userlist.add(new ItemModel(R.drawable.car,"987937430"));
        userlist.add(new ItemModel(R.drawable.carthree,"987956456"));
        userlist.add(new ItemModel(R.drawable.cartwo,"4564937430"));
        userlist.add(new ItemModel(R.drawable.first,"987937430"));
        userlist.add(new ItemModel(R.drawable.heart,"987937430"));
        userlist.add(new ItemModel(R.drawable.car,"987937430"));
        userlist.add(new ItemModel(R.drawable.carthree,"987956456"));
        userlist.add(new ItemModel(R.drawable.cartwo,"4564937430"));
        userlist.add(new ItemModel(R.drawable.first,"987937430"));
        userlist.add(new ItemModel(R.drawable.heart,"987937430"));
        userlist.add(new ItemModel(R.drawable.car,"987937430"));
        userlist.add(new ItemModel(R.drawable.carthree,"987956456"));
        userlist.add(new ItemModel(R.drawable.cartwo,"4564937430"));
        userlist.add(new ItemModel(R.drawable.first,"987937430"));
        userlist.add(new ItemModel(R.drawable.heart,"987937430"));

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(userlist,getApplicationContext());
        listView.setAdapter(customBaseAdapter);
    }


}