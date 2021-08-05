package com.example.baseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterActivity extends AppCompatActivity {
ListView listView;
ArrayList<HashMap<String,String>>  userlist;


    String[] number={"324234","342342","3452342","443534","453453","674564","345354","34543534"};
    int[] imagese= {R.drawable.arebic,R.drawable.naturetwo,R.drawable.download,R.drawable.naturetwo,R.drawable.right,R.drawable.sample,R.drawable.weather,R.drawable.weather};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        listView = findViewById(R.id.listviewsimple);
        userlist = new ArrayList<>();
          for(int i=0;i<number.length;i++)
          {
              HashMap<String,String> hashMap = new HashMap<>();
              hashMap.put("number",number[i]);
              hashMap.put("image",imagese[i]+"");

              userlist.add(hashMap);
          }

          String[] from = {"number","image"};
          int[] to = {R.id.textviewbase,R.id.imageviewbase};

          CustomSimpleAdapter customSimpleAdapter = new CustomSimpleAdapter(getApplicationContext(),userlist,R.layout.baselayout,from,to);
          listView.setAdapter(customSimpleAdapter);

    }
}