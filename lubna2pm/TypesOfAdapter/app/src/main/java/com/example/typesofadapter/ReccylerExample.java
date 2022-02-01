package com.example.typesofadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ReccylerExample extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<RecylerModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reccyler_example);
        
        userlist = new ArrayList<>();
        recyclerView = findViewById(R.id.recyerview);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,RecyclerView.VERTICAL,true);

        recyclerView.setLayoutManager(gridLayoutManager);

        userlist.add(new RecylerModel("Download",R.drawable.download));
        userlist.add(new RecylerModel("Heart",R.drawable.heart));
        userlist.add(new RecylerModel("None",R.drawable.none));
        userlist.add(new RecylerModel("one",R.drawable.one));
        userlist.add(new RecylerModel("River",R.drawable.rivere));
        userlist.add(new RecylerModel("Sky",R.drawable.sky));
        userlist.add(new RecylerModel("Two",R.drawable.two));
        userlist.add(new RecylerModel("Corona",R.drawable.corona));
        userlist.add(new RecylerModel("UniverOne",R.drawable.univers));
        userlist.add(new RecylerModel("UniversTwo",R.drawable.universetwo));
        userlist.add(new RecylerModel("UniversFour",R.drawable.universfour));
        userlist.add(new RecylerModel("UniverThree",R.drawable.universthree));
        userlist.add(new RecylerModel("BookOne",R.drawable.bookone));
        userlist.add(new RecylerModel("BookTwo",R.drawable.booktwo));
        userlist.add(new RecylerModel("BookThree",R.drawable.bookthree));

        CustomRecyclerAdapter customRecyclerAdapter = new CustomRecyclerAdapter(userlist,getApplicationContext());
        recyclerView.setAdapter(customRecyclerAdapter);

    }
}