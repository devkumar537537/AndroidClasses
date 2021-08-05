package com.cbitss.typesofadaptes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class BaseAdapterExample extends AppCompatActivity {
ListView listView;
int[]  imageslist = {R.drawable.arebic,R.drawable.background,R.drawable.cbitss,R.drawable.first,R.drawable.right};
String[] namlist = {"Dev","Yatin","Arpit","Rahoul","Amit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.base_listview);
        BaseADapter baseADapter = new BaseADapter(imageslist,getApplicationContext(),namlist);

        listView.setAdapter(baseADapter);
    }
}