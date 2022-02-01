package com.example.typeofmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
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
String[] numberlist = {"2342342","4535435","5464564","3243234","23424","2334242","324234234","2342342","4535435","5464564","3243234","23424","2334242","324234234","2342342","4535435","5464564","3243234","23424","2334242","324234234","2342342","4535435","5464564","3243234","23424","2334242","324234234"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> numberadapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,numberlist);


        listView.setAdapter(numberadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),listView);
                popupMenu.getMenuInflater().inflate(R.menu.contextmenu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();

                        switch (id)
                        {
                            case R.id.callbtn:
                                genereal(2,3,'+');
                                break;
                            case R.id.smsbtn:
                                genereal(2,3,'-');
                                break;
                            case R.id.videocalbtn:
                                genereal(2,3,'*');
                                break;
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
        getMenuInflater().inflate(R.menu.optionsmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.whatweboption:
                genereal(2,3,'+');
                break;
            case R.id.updatebtn:
                genereal(2,3,'-');
                break;
            case R.id.settingbtn:
                genereal(2,3,'*');
                break;
        }
        return true;
    }
    public void genereal(int a,int b,char operation)
    {
        switch (operation)
        {
            case '+':
                int sum = a+b;
                Toast.makeText(getApplicationContext(), "sum is "+sum, Toast.LENGTH_SHORT).show();
                break;
            case '-':
                int minus = a-b;
                Toast.makeText(getApplicationContext(), "minus is "+minus, Toast.LENGTH_SHORT).show();
                break;
            case '*':
                int multi = a*b;
                Toast.makeText(getApplicationContext(), "multi is "+multi, Toast.LENGTH_SHORT).show();
                break;
        }
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
            case R.id.callbtn:
                genereal(2,3,'+');
                break;
            case R.id.smsbtn:
                genereal(2,3,'-');
                break;
            case R.id.videocalbtn:
                genereal(2,3,'*');
                break;
        }
        return true;
    }
}