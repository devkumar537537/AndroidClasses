package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterExample extends AppCompatActivity {
ListView listView;
ArrayList<HashMap<String,String>> usermaps;
String[] numberlist = {"4353453","453453","45345345","67675765","4564563453","785675467","345345","45345345","2342342"};
int[] imageurl = {R.drawable.car,R.drawable.cartwo,R.drawable.carthree,R.drawable.heart,R.drawable.car,R.drawable.cartwo,R.drawable.carthree,R.drawable.heart,R.drawable.first};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_example);
        listView = findViewById(R.id.simpleisview);
usermaps = new ArrayList<>();

for(int i = 0;i<numberlist.length;i++)
{
    HashMap<String,String> usermap =new HashMap<>();
    usermap.put("number",numberlist[i]);
    usermap.put("image",imageurl[i]+"");

    usermaps.add(usermap);
}
String[] from ={"number","image"};
int[] to = {R.id.UserNumber,R.id.arrayimage};
        SimpleAdapter sone = new SimpleAdapter(getApplicationContext(),usermaps,R.layout.listformate,from,to);
listView.setAdapter(sone);
    }
}