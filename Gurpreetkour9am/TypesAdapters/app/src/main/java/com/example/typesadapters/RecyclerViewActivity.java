package com.example.typesadapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.typesadapters.adapters.CustomRecyclerAdapter;
import com.example.typesadapters.models.RecyclerModel;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<RecyclerModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerview);
        userlist = new ArrayList<>();


        userlist.add(new RecyclerModel(R.drawable.arebic,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.background,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.download,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.naturetwo,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.right,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.arebic,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.background,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.download,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.naturetwo,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.right,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.arebic,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.background,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.download,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.naturetwo,"abac@gmail.com",123123));
        userlist.add(new RecyclerModel(R.drawable.right,"abac@gmail.com",123123));

        CustomRecyclerAdapter customRecyclerAdapter = new CustomRecyclerAdapter(userlist,getApplicationContext());

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(linearLayoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(customRecyclerAdapter);
    }
}