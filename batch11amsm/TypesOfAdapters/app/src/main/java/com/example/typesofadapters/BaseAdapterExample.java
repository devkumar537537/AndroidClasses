package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.typesofadapters.adapters.CustomBaseAdapter;
import com.example.typesofadapters.model.BaseModel;

import java.util.ArrayList;

public class BaseAdapterExample extends AppCompatActivity {
ListView listView;

ArrayList<BaseModel> userlis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_example);
        listView = findViewById(R.id.baselistview);
        userlis = new ArrayList<>();


        userlis.add(new BaseModel("abc@gmail.com",R.drawable.car));
        userlis.add(new BaseModel("ab123@gmail.com",R.drawable.cartwo));
        userlis.add(new BaseModel("cbitss@gmail.com",R.drawable.carthree));
        userlis.add(new BaseModel("right@gmail.com",R.drawable.first));
        userlis.add(new BaseModel("five@gmail.com",R.drawable.heart));
        userlis.add(new BaseModel("abc@gmail.com",R.drawable.car));
        userlis.add(new BaseModel("ab123@gmail.com",R.drawable.cartwo));
        userlis.add(new BaseModel("cbitss@gmail.com",R.drawable.carthree));
        userlis.add(new BaseModel("right@gmail.com",R.drawable.first));

        userlis.add(new BaseModel("five@gmail.com",R.drawable.heart));
        userlis.add(new BaseModel("abc@gmail.com",R.drawable.car));
        userlis.add(new BaseModel("ab123@gmail.com",R.drawable.cartwo));
        userlis.add(new BaseModel("cbitss@gmail.com",R.drawable.carthree));
        userlis.add(new BaseModel("right@gmail.com",R.drawable.first));
        userlis.add(new BaseModel("five@gmail.com",R.drawable.heart));

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(userlis,getApplicationContext());

        listView.setAdapter(customBaseAdapter);
    }
}