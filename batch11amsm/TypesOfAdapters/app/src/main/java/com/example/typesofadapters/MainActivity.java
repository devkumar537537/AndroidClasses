package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.typesofadapters.adapters.CustomArrayAdapter;
import com.example.typesofadapters.model.MyItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<MyItem> userlist;
Button movebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        userlist = new ArrayList<>();
movebtn = findViewById(R.id.movetobaseadatper);
movebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,BaseAdapterExample.class));
    }
});

        userlist.add(new MyItem("34535434",R.drawable.car));
        userlist.add(new MyItem("456456456",R.drawable.cartwo));
        userlist.add(new MyItem("7675675",R.drawable.carthree));
        userlist.add(new MyItem("678686756",R.drawable.first));
        userlist.add(new MyItem("676756",R.drawable.heart));
        userlist.add(new MyItem("34535434",R.drawable.car));
        userlist.add(new MyItem("456456456",R.drawable.cartwo));
        userlist.add(new MyItem("7675675",R.drawable.carthree));
        userlist.add(new MyItem("678686756",R.drawable.first));
        userlist.add(new MyItem("676756",R.drawable.heart));
        userlist.add(new MyItem("34535434",R.drawable.car));
        userlist.add(new MyItem("456456456",R.drawable.cartwo));
        userlist.add(new MyItem("7675675",R.drawable.carthree));
        userlist.add(new MyItem("678686756",R.drawable.first));
        userlist.add(new MyItem("676756",R.drawable.heart));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.listformate,userlist);
        listView.setAdapter(customArrayAdapter);
    }
}