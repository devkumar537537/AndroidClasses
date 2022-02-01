package com.example.typesofadapters.RecyclerViewpackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.typesofadapters.R;

import java.util.ArrayList;

public class RecyclerExampleAcivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<RecyclerMOdel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_example_acivity);
        recyclerView = findViewById(R.id.recyclerviw);
userlist = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        userlist.add(new RecyclerMOdel("First","345345",R.drawable.download));
        userlist.add(new RecyclerMOdel("Second","676576",R.drawable.heart));
        userlist.add(new RecyclerMOdel("third","63456576",R.drawable.none));
        userlist.add(new RecyclerMOdel("fourth","6766786576",R.drawable.one));
        userlist.add(new RecyclerMOdel("five","6765567576",R.drawable.rivere));
        userlist.add(new RecyclerMOdel("Six","676345576",R.drawable.sky));
        userlist.add(new RecyclerMOdel("Seven","676345534534",R.drawable.two));
        userlist.add(new RecyclerMOdel("First","345345",R.drawable.download));
        userlist.add(new RecyclerMOdel("Second","676576",R.drawable.heart));
        userlist.add(new RecyclerMOdel("third","63456576",R.drawable.none));
        userlist.add(new RecyclerMOdel("fourth","6766786576",R.drawable.one));
        userlist.add(new RecyclerMOdel("five","6765567576",R.drawable.rivere));
        userlist.add(new RecyclerMOdel("Six","676345576",R.drawable.sky));
        userlist.add(new RecyclerMOdel("Seven","676345534534",R.drawable.two));
        userlist.add(new RecyclerMOdel("First","345345",R.drawable.download));
        userlist.add(new RecyclerMOdel("Second","676576",R.drawable.heart));
        userlist.add(new RecyclerMOdel("third","63456576",R.drawable.none));
        userlist.add(new RecyclerMOdel("fourth","6766786576",R.drawable.one));
        userlist.add(new RecyclerMOdel("five","6765567576",R.drawable.rivere));
        userlist.add(new RecyclerMOdel("Six","676345576",R.drawable.sky));
        userlist.add(new RecyclerMOdel("Seven","676345534534",R.drawable.two));

        CustomRecyclerAdapter customRecyclerAdapter = new CustomRecyclerAdapter(userlist,getApplicationContext());

        recyclerView.setAdapter(customRecyclerAdapter);
    }
}