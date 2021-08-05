package com.example.baseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<Item> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.baselsitview);
        userlist = new ArrayList<>();

    userlist.add(new Item("32423423",R.drawable.arebic));
    userlist.add(new Item("64564654",R.drawable.download));
    userlist.add(new Item("098079",R.drawable.right));
        userlist.add(new Item("32423423",R.drawable.arebic));
        userlist.add(new Item("64564654",R.drawable.download));
        userlist.add(new Item("098079",R.drawable.right));
        userlist.add(new Item("32423423",R.drawable.arebic));
        userlist.add(new Item("64564654",R.drawable.download));
        userlist.add(new Item("098079",R.drawable.right));

        CustomBaseAdapter cone = new CustomBaseAdapter(userlist,getApplicationContext());
        listView.setAdapter(cone);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              startActivity(new Intent(MainActivity.this,SimpleAdapterActivity.class));
            }
        });
    }
}