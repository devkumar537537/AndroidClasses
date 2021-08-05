package com.example.typesadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.typesadapters.adapters.CustomSimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterExample extends AppCompatActivity {
ListView listView;
ArrayList<HashMap<String,String>> userlis;
String[] name ={"Newton","Albert","Gurpreet","Dev","Robert","Ritu","kireet","Mobile"};
String[] number={"324234","342342","3452342","443534","453453","674564","345354","34543534"};
int[] imagese= {R.drawable.arebic,R.drawable.background,R.drawable.download,R.drawable.naturetwo,R.drawable.right,R.drawable.sample,R.drawable.third,R.drawable.weather};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_example);

        listView =findViewById(R.id.simplelistview);

        userlis = new ArrayList<>();


        for(int i =0;i<name.length;i++)
        {
            HashMap<String,String> userdata = new HashMap<>();
            userdata.put("name",name[i]);
            userdata.put("number",number[i]);
            userdata.put("image",imagese[i]+"");

            userlis.add(userdata);
        }

String[] fromm = {"name","number","image"};
        int[] to ={R.id.format_name,R.id.format_number,R.id.formateImage};

        CustomSimpleAdapter customSimpleAdapter = new CustomSimpleAdapter(getApplicationContext(),userlis,R.layout.formate,fromm,to);

        listView.setAdapter(customSimpleAdapter);

    }
}