package com.example.typesadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.typesadapters.adapters.CustomBaseAdapter;
import com.example.typesadapters.models.ItemModel;

import java.util.ArrayList;

public class BaseAdapterExample extends AppCompatActivity {
ListView listView;
ArrayList<ItemModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_example);
        listView = findViewById(R.id.baselistview);
        userlist = new ArrayList<>();


        userlist.add(new ItemModel(R.drawable.arebic,"Arebic","2342423"));
        userlist.add(new ItemModel(R.drawable.background,"Background","2342423"));
        userlist.add(new ItemModel(R.drawable.download,"Download","2342423"));
        userlist.add(new ItemModel(R.drawable.naturetwo,"NatureTwo","2342423"));
        userlist.add(new ItemModel(R.drawable.right,"Right","2342423"));
        userlist.add(new ItemModel(R.drawable.weather,"Weather","2342423"));
        userlist.add(new ItemModel(R.drawable.arebic,"Arebic","2342423"));
        userlist.add(new ItemModel(R.drawable.background,"Background","2342423"));
        userlist.add(new ItemModel(R.drawable.download,"Download","2342423"));
        userlist.add(new ItemModel(R.drawable.naturetwo,"NatureTwo","2342423"));
        userlist.add(new ItemModel(R.drawable.right,"Right","2342423"));
        userlist.add(new ItemModel(R.drawable.weather,"Weather","2342423"));
        userlist.add(new ItemModel(R.drawable.arebic,"Arebic","2342423"));
        userlist.add(new ItemModel(R.drawable.background,"Background","2342423"));
        userlist.add(new ItemModel(R.drawable.download,"Download","2342423"));
        userlist.add(new ItemModel(R.drawable.naturetwo,"NatureTwo","2342423"));
        userlist.add(new ItemModel(R.drawable.right,"Right","2342423"));
        userlist.add(new ItemModel(R.drawable.weather,"Weather","2342423"));
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(userlist,getApplicationContext());
        listView.setAdapter(customBaseAdapter);

    }
}