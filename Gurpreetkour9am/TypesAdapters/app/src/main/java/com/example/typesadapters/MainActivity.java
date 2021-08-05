package com.example.typesadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.typesadapters.adapters.CustomArrayAdapter;
import com.example.typesadapters.models.ItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView arraylistview;
ArrayList<ItemModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arraylistview = findViewById(R.id.listivewaarray);
        userlist = new ArrayList<>();


        userlist.add(new ItemModel(R.drawable.arebic,"Arebic","2342423"));
        userlist.add(new ItemModel(R.drawable.background,"Background","2342423"));
        userlist.add(new ItemModel(R.drawable.download,"Download","2342423"));
        userlist.add(new ItemModel(R.drawable.naturetwo,"NatureTwo","2342423"));
        userlist.add(new ItemModel(R.drawable.right,"Right","2342423"));
        userlist.add(new ItemModel(R.drawable.weather,"Weather","2342423"));
        userlist.add(new ItemModel(R.drawable.arebic,"Arebic","2342423"));
        userlist.add(new ItemModel(R.drawable.background,"Background","2342423"));
        userlist.add(new ItemModel(R.drawable.download,"Download","2342423"));
        userlist.add(new ItemModel(R.drawable.naturetwo,"NatureTwo","2342423"));
        userlist.add(new ItemModel(R.drawable.right,"Right","2342423"));
        userlist.add(new ItemModel(R.drawable.weather,"Weather","2342423"));
        userlist.add(new ItemModel(R.drawable.arebic,"Arebic","2342423"));
        userlist.add(new ItemModel(R.drawable.background,"Background","2342423"));
        userlist.add(new ItemModel(R.drawable.download,"Download","2342423"));
        userlist.add(new ItemModel(R.drawable.naturetwo,"NatureTwo","2342423"));
        userlist.add(new ItemModel(R.drawable.right,"Right","2342423"));
        userlist.add(new ItemModel(R.drawable.weather,"Weather","2342423"));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.formate,userlist);
        arraylistview.setAdapter(customArrayAdapter);


    }
}