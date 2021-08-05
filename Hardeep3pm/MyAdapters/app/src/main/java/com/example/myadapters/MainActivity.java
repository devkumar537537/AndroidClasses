package com.example.myadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<Item> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.arraylistview);
        arrayList = new ArrayList<>();

        arrayList.add(new Item("First",R.drawable.right));
        arrayList.add(new Item("Second",R.drawable.naturetwo));
        arrayList.add(new Item("Third",R.drawable.sample));
        arrayList.add(new Item("First",R.drawable.right));
        arrayList.add(new Item("Second",R.drawable.naturetwo));
        arrayList.add(new Item("Third",R.drawable.sample));
        arrayList.add(new Item("First",R.drawable.right));
        arrayList.add(new Item("Second",R.drawable.naturetwo));
        arrayList.add(new Item("Third",R.drawable.sample));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.array_format,arrayList);
        listView.setAdapter(customArrayAdapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this,BaseAdapterExample.class);
        startActivity(intent);
    }
});


    }
}