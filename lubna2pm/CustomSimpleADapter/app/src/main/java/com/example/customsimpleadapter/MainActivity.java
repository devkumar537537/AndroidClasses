package com.example.customsimpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<HashMap<String,String>> data;

int[] imagelist= {R.drawable.download,R.drawable.heart,R.drawable.none,R.drawable.one,R.drawable.rivere,R.drawable.sky,R.drawable.two,R.drawable.download,R.drawable.heart,R.drawable.none,R.drawable.one,R.drawable.rivere,R.drawable.sky,R.drawable.two};
  String[] names={"Download","Heart","NOne","One","River","SKy","TWo","Download","Heart","NOne","One","River","SKy","TWo"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();

        listView = findViewById(R.id.listview);


        for(int i=0;i<imagelist.length;i++)
        {
            HashMap<String,String> usermap  =new HashMap<>();
            usermap.put("image",imagelist[i]+"");
            usermap.put("names",names[i]);

            data.add(usermap);
        }

        String[] from = {"image","names"};
        int[] to = {R.id.imageview,R.id.textview};

        CustomSimpleADatper customSimpleADatper = new CustomSimpleADatper(getApplicationContext(),data,R.layout.simpleadapter,from,to);

   listView.setAdapter(customSimpleADatper);
    }
}