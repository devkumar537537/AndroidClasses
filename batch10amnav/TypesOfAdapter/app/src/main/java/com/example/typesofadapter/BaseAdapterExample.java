package com.example.typesofadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class BaseAdapterExample extends AppCompatActivity {
ListView listView ;
ArrayList<ArrayModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_example);
        listView = findViewById(R.id.baselitview);


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

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(userlist,getApplicationContext());
        listView.setAdapter(customBaseAdapter);
    }
}