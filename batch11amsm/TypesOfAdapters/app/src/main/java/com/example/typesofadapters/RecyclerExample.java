package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.typesofadapters.adapters.CustomRecyclerAdapter;
import com.example.typesofadapters.model.BaseModel;

import java.util.ArrayList;

public class RecyclerExample extends AppCompatActivity {
RecyclerView recyclerView;

    ArrayList<BaseModel> userlis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_example);
        recyclerView = findViewById(R.id.listrecyclerview);

       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        userlis = new ArrayList<>();


        userlis.add(new BaseModel("abc@gmail.com",R.drawable.car));
        userlis.add(new BaseModel("ab123@gmail.com",R.drawable.cartwo));
        userlis.add(new BaseModel("cbitss@gmail.com",R.drawable.carthree));
        userlis.add(new BaseModel("right@gmail.com",R.drawable.first));
        userlis.add(new BaseModel("five@gmail.com",R.drawable.heart));
        userlis.add(new BaseModel("abc@gmail.com",R.drawable.car));
        userlis.add(new BaseModel("ab123@gmail.com",R.drawable.cartwo));
        userlis.add(new BaseModel("cbitss@gmail.com",R.drawable.carthree));
        userlis.add(new BaseModel("right@gmail.com",R.drawable.first));

        userlis.add(new BaseModel("five@gmail.com",R.drawable.heart));
        userlis.add(new BaseModel("abc@gmail.com",R.drawable.car));
        userlis.add(new BaseModel("ab123@gmail.com",R.drawable.cartwo));
        userlis.add(new BaseModel("cbitss@gmail.com",R.drawable.carthree));
        userlis.add(new BaseModel("right@gmail.com",R.drawable.first));
        userlis.add(new BaseModel("five@gmail.com",R.drawable.heart));

        CustomRecyclerAdapter customRecyclerAdapter = new CustomRecyclerAdapter(userlis,getApplicationContext());
        recyclerView.setAdapter(customRecyclerAdapter);


    }
}