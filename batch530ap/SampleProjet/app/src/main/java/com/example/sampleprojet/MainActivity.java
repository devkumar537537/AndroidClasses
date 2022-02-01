package com.example.sampleprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

ListView listView;

String[] numbers = {"34234","India","4543563","4563453","345345","35345","345345","34234","435345","4543563","4563453","345345","35345","345345","34234","435345","4543563","4563453","345345","35345","345345",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
listView = findViewById(R.id.listview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),R.layout.itemlayout,numbers);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,listView);

                popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if(id == R.id.popupmenufirst)
                        {
                            String  text = numbers[position];
                            switch (text)
                            {
                                case "India":
                                    Toast.makeText(getApplicationContext(), "this is india", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        registerForContextMenu(listView);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.optionmenu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.firstoptionn)
        {
            sum();
        }else if(id == R.id.secondoption)
        {
            multi();
        }

        return super.onOptionsItemSelected(item);
    }

    public  void sum()
    {
        int a = 20;
        int b = 34;
        Toast.makeText(getApplicationContext(), "sum is "+(a+b), Toast.LENGTH_SHORT).show();
    }

    public void multi()
    {
        int a = 20;
        int b = 34;
        Toast.makeText(getApplicationContext(), "sum is "+(a*b), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.contextmenufile,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id)
        {
            case R.id.contextfirst:
                Toast.makeText(getApplicationContext(), "contextfirst selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextsecond:
                Toast.makeText(getApplicationContext(), "contextsecond selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}