package com.cbitss.typesofadaptes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdatperExample extends AppCompatActivity {
ListView listView;
    int[]  imageslist = {R.drawable.arebic,R.drawable.background,R.drawable.cbitss,R.drawable.first,R.drawable.right};
    String[] namlist = {"Dev","Yatin","Arpit","Rahoul","Amit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adatper_example);

        listView = findViewById(R.id.listview_simple_adtapter);
        ArrayList<HashMap<String,String>> arrayulist = new ArrayList<>();


        for(int i =0;i<imageslist.length;i++)
        {
            HashMap<String,String> hashMap = new HashMap<>();

            hashMap.put("name",namlist[i]);
            hashMap.put("image",imageslist[i]+"");
            arrayulist.add(hashMap);
        }

        String[] from = {"name","image"};
        int[] to = {R.id.list_format_imagvview,R.id.listview_text};
        CustomSimpleAdatper customSimpleAdatper = new CustomSimpleAdatper(getApplicationContext(),arrayulist,R.layout.list_formate,from,to);
        listView.setAdapter(customSimpleAdatper);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SimpleAdatperExample.this, namlist[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}