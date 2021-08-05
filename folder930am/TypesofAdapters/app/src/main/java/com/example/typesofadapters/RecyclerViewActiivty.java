package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.typesofadapters.adapters.ReccylerAdapter;
import com.example.typesofadapters.models.ReccylerModel;

import java.util.ArrayList;

public class RecyclerViewActiivty extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<ReccylerModel> imagelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_actiivty);
        recyclerView = findViewById(R.id.recyclerviewimage);
        imagelist = new ArrayList<>();
      // LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
       GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        imagelist.add(new ReccylerModel(R.drawable.arebic));
        imagelist.add(new ReccylerModel(R.drawable.background));
        imagelist.add(new ReccylerModel(R.drawable.naturetwo));
        imagelist.add(new ReccylerModel(R.drawable.right));
        imagelist.add(new ReccylerModel(R.drawable.sample));
        imagelist.add(new ReccylerModel(R.drawable.third));
        imagelist.add(new ReccylerModel(R.drawable.weather));
        imagelist.add(new ReccylerModel(R.drawable.arebic));
        imagelist.add(new ReccylerModel(R.drawable.background));
        imagelist.add(new ReccylerModel(R.drawable.naturetwo));
        imagelist.add(new ReccylerModel(R.drawable.right));
        imagelist.add(new ReccylerModel(R.drawable.sample));
        imagelist.add(new ReccylerModel(R.drawable.third));
        imagelist.add(new ReccylerModel(R.drawable.weather));

        ReccylerAdapter reccylerAdapter = new ReccylerAdapter(imagelist,getApplicationContext());

        recyclerView.setAdapter(reccylerAdapter);
    }
}