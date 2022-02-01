package com.batch12pm.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ConstraintLayoutSecondExample extends AppCompatActivity {

    ListView listView;
    String[] numberlist = {"543453","4353453","435345","56756765","674545646","2342342341","456465345","43241234","34534252","543453","4353453","435345","56756765","674545646","2342342341","456465345","43241234","34534252","56756765","674545646","2342342341","456465345","43241234","34534252"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout_second_example);
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ConstraintLayoutSecondExample.this,R.layout.listviewformate,numberlist);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String numbertext = numberlist[position];

                Toast.makeText(getApplicationContext(), "number is "+numbertext, Toast.LENGTH_SHORT).show();
            }
        });

    }
}