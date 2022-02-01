package com.example.samllcomponent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
    String text;
String[] number={"56456456","324242","7867867","234232","5674564","234242","32423423","324234234","56456456","324242","7867867","234232","5674564","234242","32423423","324234234","56456456","324242","7867867","234232","5674564","234242","32423423","324234234"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this,R.layout.listformate,number);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                 text = number[position];

                PopupMenu popupMenu = new PopupMenu(MainActivity.this,listView);

                popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if(id == R.id.firstoption)
                        {
                            Toast.makeText(getApplicationContext(), "firstoption select", Toast.LENGTH_SHORT).show();
                        }else if(id == R.id.scondoption)
                        {
                            Toast.makeText(getApplicationContext(), "secondoption ", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });


                popupMenu.show();
                Toast.makeText(getApplicationContext(), "selected number"+text, Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.contextmenu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.firstcontext:
                Toast.makeText(getApplicationContext(), "selected number"+text, Toast.LENGTH_SHORT).show();
                break;
            case R.id.secondcontext:
                Toast.makeText(getApplicationContext(), "this is second menu", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.firstoption:
                Toast.makeText(getApplicationContext(), "selected number"+text, Toast.LENGTH_SHORT).show();
                break;
            case R.id.secondoption:
                Toast.makeText(getApplicationContext(), "this is second menu", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}