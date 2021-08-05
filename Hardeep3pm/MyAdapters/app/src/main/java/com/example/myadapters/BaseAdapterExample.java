package com.example.myadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BaseAdapterExample extends AppCompatActivity {

    ListView listView;
    ArrayList<Item> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_example);
        listView = findViewById(R.id.baselistview);
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

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(arrayList,getApplicationContext());

        listView.setAdapter(customBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              startActivity(new Intent(BaseAdapterExample.this,SimpleAdapterExample.class));
            }
        });
    }
}