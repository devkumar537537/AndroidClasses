package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.typesofadapters.adapters.CustomBaseAdapter;
import com.example.typesofadapters.models.ItemModel;

import java.util.ArrayList;

public class BaseAdapterExample extends AppCompatActivity {
    ListView listView;
    ArrayList<ItemModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_example);
        listView = findViewById(R.id.listviewbase);
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


        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(userlist,getApplicationContext());
        listView.setAdapter(customBaseAdapter);


    }
}