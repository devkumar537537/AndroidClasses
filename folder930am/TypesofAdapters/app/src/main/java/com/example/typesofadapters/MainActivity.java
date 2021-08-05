package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.typesofadapters.adapters.CustomArrayAdapter;
import com.example.typesofadapters.models.ItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<ItemModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listviewarray);
        userlist = new ArrayList<>();



        userlist.add(new ItemModel(R.drawable.arebic,"Arebic"));
        userlist.add(new ItemModel(R.drawable.right,"Right"));
        userlist.add(new ItemModel(R.drawable.naturetwo,"NatureTwo"));
        userlist.add(new ItemModel(R.drawable.sample,"Sample"));
        userlist.add(new ItemModel(R.drawable.third,"Third"));
        userlist.add(new ItemModel(R.drawable.weather,"Weather"));
        userlist.add(new ItemModel(R.drawable.arebic,"Arebic"));
        userlist.add(new ItemModel(R.drawable.right,"Right"));
        userlist.add(new ItemModel(R.drawable.naturetwo,"NatureTwo"));
        userlist.add(new ItemModel(R.drawable.sample,"Sample"));
        userlist.add(new ItemModel(R.drawable.third,"Third"));
        userlist.add(new ItemModel(R.drawable.weather,"Weather"));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.arrayformate,userlist);
        listView.setAdapter(customArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicked on whole item", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,SimpleAdapterExample.class));
            }
        });
    }
}