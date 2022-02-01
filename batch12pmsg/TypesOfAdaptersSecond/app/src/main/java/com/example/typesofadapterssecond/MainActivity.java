package com.example.typesofadapterssecond;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<MyModel> uselist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        uselist = new ArrayList<>();


        uselist.add(new MyModel("BookOne",R.drawable.bookone));
        uselist.add(new MyModel("BookTwo",R.drawable.booktwo));
        uselist.add(new MyModel("BookThree",R.drawable.bookthree));
        uselist.add(new MyModel("BookFour",R.drawable.univers));
        uselist.add(new MyModel("UniverFour",R.drawable.universfour));
        uselist.add(new MyModel("BookOne",R.drawable.bookone));
        uselist.add(new MyModel("BookTwo",R.drawable.booktwo));
        uselist.add(new MyModel("BookThree",R.drawable.bookthree));
        uselist.add(new MyModel("BookFour",R.drawable.univers));
        uselist.add(new MyModel("UniverFour",R.drawable.universfour));
        uselist.add(new MyModel("BookOne",R.drawable.bookone));
        uselist.add(new MyModel("BookTwo",R.drawable.booktwo));
        uselist.add(new MyModel("BookThree",R.drawable.bookthree));
        uselist.add(new MyModel("BookFour",R.drawable.univers));
        uselist.add(new MyModel("UniverFour",R.drawable.universfour));
        uselist.add(new MyModel("BookOne",R.drawable.bookone));
        uselist.add(new MyModel("BookTwo",R.drawable.booktwo));
        uselist.add(new MyModel("BookThree",R.drawable.bookthree));
        uselist.add(new MyModel("BookFour",R.drawable.univers));
        uselist.add(new MyModel("UniverFour",R.drawable.universfour));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.arrayformate,uselist);
        listView.setAdapter(customArrayAdapter);
    }
}