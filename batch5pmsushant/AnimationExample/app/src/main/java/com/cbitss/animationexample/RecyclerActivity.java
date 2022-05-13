package com.cbitss.animationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<RecyclerModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recycelview);
        userlist = new ArrayList<>();
        GridLayoutManager gridLayoutManager =new GridLayoutManager(getApplicationContext(),1,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        adddata();
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(userlist,getApplicationContext());
        recyclerView.setAdapter(recyclerAdapter);





    }
    public void adddata(){
        userlist.add(new RecyclerModel(R.drawable.bookone,"Book One"));
        userlist.add(new RecyclerModel(R.drawable.booktwo,"Book two"));
        userlist.add(new RecyclerModel(R.drawable.bookthree,"Book three"));
        userlist.add(new RecyclerModel(R.drawable.none,"None"));
        userlist.add(new RecyclerModel(R.drawable.one,"One"));
        userlist.add(new RecyclerModel(R.drawable.rivere,"River"));
        userlist.add(new RecyclerModel(R.drawable.sky,"Sky"));
        userlist.add(new RecyclerModel(R.drawable.univers,"Univers"));
        userlist.add(new RecyclerModel(R.drawable.universfour,"UniverseFour"));
        userlist.add(new RecyclerModel(R.drawable.universthree,"UniverseThree"));
        userlist.add(new RecyclerModel(R.drawable.bookone,"Book One"));
        userlist.add(new RecyclerModel(R.drawable.booktwo,"Book two"));
        userlist.add(new RecyclerModel(R.drawable.bookthree,"Book three"));
        userlist.add(new RecyclerModel(R.drawable.none,"None"));
        userlist.add(new RecyclerModel(R.drawable.one,"One"));
        userlist.add(new RecyclerModel(R.drawable.rivere,"River"));
        userlist.add(new RecyclerModel(R.drawable.sky,"Sky"));
        userlist.add(new RecyclerModel(R.drawable.univers,"Univers"));
        userlist.add(new RecyclerModel(R.drawable.universfour,"UniverseFour"));
        userlist.add(new RecyclerModel(R.drawable.universthree,"UniverseThree"));
        userlist.add(new RecyclerModel(R.drawable.bookone,"Book One"));
        userlist.add(new RecyclerModel(R.drawable.booktwo,"Book two"));
        userlist.add(new RecyclerModel(R.drawable.bookthree,"Book three"));
        userlist.add(new RecyclerModel(R.drawable.none,"None"));
        userlist.add(new RecyclerModel(R.drawable.one,"One"));
        userlist.add(new RecyclerModel(R.drawable.rivere,"River"));
        userlist.add(new RecyclerModel(R.drawable.sky,"Sky"));
        userlist.add(new RecyclerModel(R.drawable.univers,"Univers"));
        userlist.add(new RecyclerModel(R.drawable.universfour,"UniverseFour"));
        userlist.add(new RecyclerModel(R.drawable.universthree,"UniverseThree"));
    }

}