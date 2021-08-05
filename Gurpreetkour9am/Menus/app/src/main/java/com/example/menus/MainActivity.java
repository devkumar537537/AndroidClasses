package com.example.menus;

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
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Spinner spinner;

String[] countries ={"Select Countries","India","Nepal","Canada","USA","Australia","NewZland","Shri lanka","Dubai","UAE"};
String[] contacts ={"324234234","34453654645","6586783556","34654654345","56753645","34523452345","657456757634","67457777562"};
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
listView = findViewById(R.id.contacts);

//spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listitem,countries);
        arrayAdapter.setDropDownViewResource(R.layout.listitem);

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if( position == 0)
               {

               }else
               {
                   String values = countries[position];
                   Toast.makeText(MainActivity.this, "Selected countryn => "+values, Toast.LENGTH_SHORT).show();
               }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//listview
        ArrayAdapter<String> contactadapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.listitem,contacts);

        listView.setAdapter(contactadapter);
        //register forn context menu
        registerForContextMenu(listView);
        // listview click
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String value = contacts[position];
        Toast.makeText(MainActivity.this, "selected number => "+value, Toast.LENGTH_SHORT).show();
    }
});

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.callbtn)
        {
            Toast.makeText(this, "Yes it call btn", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.SMS)
        {
            Toast.makeText(this, "yes it is smsm btn", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionsmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.logout)
        {
          add(2,4);


        }else if(id == R.id.updateprofitle)
        {
            multi(2,4);
        }
        return true;

    }

    private void add(int a,int b)
    {
        Toast.makeText(this, "sum is "+(a+b), Toast.LENGTH_SHORT).show();
    }

    private void multi(int a,int b)
    {
        Toast.makeText(this, "multi is "+(a*b), Toast.LENGTH_SHORT).show();
    }
}