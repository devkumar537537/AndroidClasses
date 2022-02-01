package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.typesofadapters.adapters.CustomArrayAdapter;
import com.example.typesofadapters.models.ArrayModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<ArrayModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.arraylistview);
        userlist = new ArrayList<>();



        userlist.add(new ArrayModel(R.drawable.bookone,"BookOne","3453453453"));
        userlist.add(new ArrayModel(R.drawable.booktwo,"BookTWo","3453453453"));
        userlist.add(new ArrayModel(R.drawable.bookthree,"River","345546456"));
        userlist.add(new ArrayModel(R.drawable.heart,"Hear","2342342453"));
        userlist.add(new ArrayModel(R.drawable.rivere,"Boothre","768567853453"));
        userlist.add(new ArrayModel(R.drawable.bookone,"BookOne","3453453453"));
        userlist.add(new ArrayModel(R.drawable.booktwo,"BookTWo","3453453453"));
        userlist.add(new ArrayModel(R.drawable.bookthree,"River","345546456"));
        userlist.add(new ArrayModel(R.drawable.heart,"Hear","2342342453"));
        userlist.add(new ArrayModel(R.drawable.rivere,"Boothre","768567853453"));
        userlist.add(new ArrayModel(R.drawable.bookone,"BookOne","3453453453"));
        userlist.add(new ArrayModel(R.drawable.booktwo,"BookTWo","3453453453"));
        userlist.add(new ArrayModel(R.drawable.bookthree,"River","345546456"));
        userlist.add(new ArrayModel(R.drawable.heart,"Hear","2342342453"));
        userlist.add(new ArrayModel(R.drawable.rivere,"Boothre","768567853453"));
        userlist.add(new ArrayModel(R.drawable.bookone,"BookOne","3453453453"));
        userlist.add(new ArrayModel(R.drawable.booktwo,"BookTWo","3453453453"));
        userlist.add(new ArrayModel(R.drawable.bookthree,"River","345546456"));
        userlist.add(new ArrayModel(R.drawable.heart,"Hear","2342342453"));
        userlist.add(new ArrayModel(R.drawable.rivere,"Boothre","768567853453"));


        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.customarraylayout,userlist);

       listView.setAdapter(customArrayAdapter);

    }
}