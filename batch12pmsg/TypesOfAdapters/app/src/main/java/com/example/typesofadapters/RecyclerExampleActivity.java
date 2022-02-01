package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;

import com.example.typesofadapters.adapters.CustomRecyclerAdapter;
import com.example.typesofadapters.models.RecyclerModle;

import java.util.ArrayList;

public class RecyclerExampleActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<RecyclerModle> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_example);
        recyclerView = findViewById(R.id.recylerviewcomponent);
userlist = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,RecyclerView.VERTICAL,true);
        recyclerView.setLayoutManager(gridLayoutManager);


        userlist.add(new RecyclerModle("abc@gmail.com",R.drawable.heart));
        userlist.add(new RecyclerModle("abc2@gmail.com",R.drawable.bookone));
        userlist.add(new RecyclerModle("abc3@gmail.com",R.drawable.booktwo));
        userlist.add(new RecyclerModle("abc4@gmail.com",R.drawable.bookthree));
        userlist.add(new RecyclerModle("abc5@gmail.com",R.drawable.rivere));
        userlist.add(new RecyclerModle("abc6@gmail.com",R.drawable.univers));
        userlist.add(new RecyclerModle("abc7@gmail.com",R.drawable.universtwo));
        userlist.add(new RecyclerModle("abc8@gmail.com",R.drawable.universthree));
        userlist.add(new RecyclerModle("abc9@gmail.com",R.drawable.universfour));

        userlist.add(new RecyclerModle("abc1@gmail.com",R.drawable.heart));
        userlist.add(new RecyclerModle("abc21@gmail.com",R.drawable.bookone));
        userlist.add(new RecyclerModle("abc31@gmail.com",R.drawable.booktwo));
        userlist.add(new RecyclerModle("abc41@gmail.com",R.drawable.bookthree));
        userlist.add(new RecyclerModle("abc51@gmail.com",R.drawable.rivere));
        userlist.add(new RecyclerModle("abc61@gmail.com",R.drawable.univers));
        userlist.add(new RecyclerModle("abc71@gmail.com",R.drawable.universtwo));
        userlist.add(new RecyclerModle("abc81@gmail.com",R.drawable.universthree));
        userlist.add(new RecyclerModle("abc91@gmail.com",R.drawable.universfour));

        userlist.add(new RecyclerModle("abc2@gmail.com",R.drawable.heart));
        userlist.add(new RecyclerModle("abc22@gmail.com",R.drawable.bookone));
        userlist.add(new RecyclerModle("abc32@gmail.com",R.drawable.booktwo));
        userlist.add(new RecyclerModle("abc42@gmail.com",R.drawable.bookthree));
        userlist.add(new RecyclerModle("abc52@gmail.com",R.drawable.rivere));
        userlist.add(new RecyclerModle("abc62@gmail.com",R.drawable.univers));
        userlist.add(new RecyclerModle("abc72@gmail.com",R.drawable.universtwo));
        userlist.add(new RecyclerModle("abc82@gmail.com",R.drawable.universthree));
        userlist.add(new RecyclerModle("abc92@gmail.com",R.drawable.universfour));

        CustomRecyclerAdapter customRecyclerAdapter =new CustomRecyclerAdapter(userlist,getApplicationContext());
        recyclerView.setAdapter(customRecyclerAdapter);

    }
}