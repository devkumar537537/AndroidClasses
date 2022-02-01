package com.example.typesofadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ArrayModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        userlist = new ArrayList<>();


        userlist.add(new ArrayModel("Righthere",R.drawable.download));
        userlist.add(new ArrayModel("Rightwo",R.drawable.fragemtlifescyre));
        userlist.add(new ArrayModel("Righthree",R.drawable.none));
        userlist.add(new ArrayModel("Rightfour",R.drawable.one));
        userlist.add(new ArrayModel("Rightfive",R.drawable.two));
        userlist.add(new ArrayModel("Righthere",R.drawable.download));
        userlist.add(new ArrayModel("Rightwo",R.drawable.fragemtlifescyre));
        userlist.add(new ArrayModel("Righthree",R.drawable.none));
        userlist.add(new ArrayModel("Rightfour",R.drawable.one));
        userlist.add(new ArrayModel("Rightfive",R.drawable.two));
        userlist.add(new ArrayModel("Righthere",R.drawable.download));
        userlist.add(new ArrayModel("Rightwo",R.drawable.fragemtlifescyre));
        userlist.add(new ArrayModel("Righthree",R.drawable.none));
        userlist.add(new ArrayModel("Rightfour",R.drawable.one));
        userlist.add(new ArrayModel("Rightfive",R.drawable.two));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),R.layout.arraylayout,userlist);
        listView.setAdapter(customArrayAdapter);


    }
}