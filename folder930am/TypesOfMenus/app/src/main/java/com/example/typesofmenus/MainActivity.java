package com.example.typesofmenus;

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

    String[] namelist={"Divyam","Vikash","Aksay","Dev","Android","Divyam","Vikash","Aksay","Dev","Android"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        ArrayAdapter<String>  arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,namelist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

         listView.setAdapter(arrayAdapter);


         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 PopupMenu popupMenu = new PopupMenu(MainActivity.this,listView);

               popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());

               popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       switch (item.getItemId())
                       {
                           case R.id.first:
                               sum(34,56);
                               break;
                           case R.id.second:
                               multi(34,56);
                               break;
                           default:
                               Toast.makeText(MainActivity.this, "this is message", Toast.LENGTH_SHORT).show();

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
        switch (item.getItemId())
        {
            case R.id.logout:
                sum(34,56);
                break;
            case R.id.about:
                multi(34,56);

                break;
            default:
                Toast.makeText(this, "This is default toast", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    private void sum(int a,int b)
    {
        Toast.makeText(this, "sum is "+(a+b), Toast.LENGTH_SHORT).show();
    }

    private void multi(int a,int b)
    {
        Toast.makeText(this, "times is "+(a*b), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmeny,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.call:
                Toast.makeText(this, "This is call ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sms:
                Toast.makeText(this, "this is sms", Toast.LENGTH_SHORT).show();
            case R.id.subone:
                Toast.makeText(this, "this is subone", Toast.LENGTH_SHORT).show();
            case R.id.subtow:
                Toast.makeText(this, "this is subtwo", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}