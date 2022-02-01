package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.typesofadapters.adapters.CustomBaseAdapter;
import com.example.typesofadapters.models.ArrayModel;
import com.example.typesofadapters.models.SimpleModel;

import java.util.ArrayList;
import java.util.LinkedList;

public class BaseAdapterExample extends AppCompatActivity {

    private ArrayList<SimpleModel> userlist;
ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_example);
listView = findViewById(R.id.baselistview);
userlist = new ArrayList<>();
        userlist.add(new SimpleModel(R.drawable.bookone,"BookOne"));
        userlist.add(new SimpleModel(R.drawable.booktwo,"Booktwo"));
        userlist.add(new SimpleModel(R.drawable.bookthree,"Bookthree"));
        userlist.add(new SimpleModel(R.drawable.heart,"Heart"));
        userlist.add(new SimpleModel(R.drawable.rivere,"BookOne"));
        userlist.add(new SimpleModel(R.drawable.univers,"Booktwo"));
        userlist.add(new SimpleModel(R.drawable.universfour,"Bookthree"));
        userlist.add(new SimpleModel(R.drawable.universthree,"Heart"));
        userlist.add(new SimpleModel(R.drawable.universtwo,"Heart"));
        userlist.add(new SimpleModel(R.drawable.bookone,"BookOne"));
        userlist.add(new SimpleModel(R.drawable.booktwo,"Booktwo"));
        userlist.add(new SimpleModel(R.drawable.bookthree,"Bookthree"));
        userlist.add(new SimpleModel(R.drawable.heart,"Heart"));
        userlist.add(new SimpleModel(R.drawable.rivere,"BookOne"));
        userlist.add(new SimpleModel(R.drawable.univers,"Booktwo"));
        userlist.add(new SimpleModel(R.drawable.universfour,"Bookthree"));
        userlist.add(new SimpleModel(R.drawable.universthree,"Heart"));
        userlist.add(new SimpleModel(R.drawable.universtwo,"Heart"));
        userlist.add(new SimpleModel(R.drawable.bookone,"BookOne"));
        userlist.add(new SimpleModel(R.drawable.booktwo,"Booktwo"));
        userlist.add(new SimpleModel(R.drawable.bookthree,"Bookthree"));
        userlist.add(new SimpleModel(R.drawable.heart,"Heart"));
        userlist.add(new SimpleModel(R.drawable.rivere,"BookOne"));
        userlist.add(new SimpleModel(R.drawable.univers,"Booktwo"));
        userlist.add(new SimpleModel(R.drawable.universfour,"Bookthree"));
        userlist.add(new SimpleModel(R.drawable.universthree,"Heart"));
        userlist.add(new SimpleModel(R.drawable.universtwo,"Heart"));
        userlist.add(new SimpleModel(R.drawable.bookone,"BookOne"));
        userlist.add(new SimpleModel(R.drawable.booktwo,"Booktwo"));
        userlist.add(new SimpleModel(R.drawable.bookthree,"Bookthree"));
        userlist.add(new SimpleModel(R.drawable.heart,"Heart"));
        userlist.add(new SimpleModel(R.drawable.rivere,"BookOne"));
        userlist.add(new SimpleModel(R.drawable.univers,"Booktwo"));
        userlist.add(new SimpleModel(R.drawable.universfour,"Bookthree"));
        userlist.add(new SimpleModel(R.drawable.universthree,"Heart"));
        userlist.add(new SimpleModel(R.drawable.universtwo,"Heart"));

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(userlist,getApplicationContext());
        listView.setAdapter(customBaseAdapter);
    }
}