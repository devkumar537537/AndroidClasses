package com.example.myadavanceview;

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
import android.widget.Toast;

public class LIstViewExample extends AppCompatActivity {
ListView listView;
String[] numbers={"45345345","34234234","678567575","2342342","3424234","23423423","34534534","345345345","342342","45345345","34234234","678567575","2342342","3424234","23423423","34534534","345345345","342342","45345345","34234234","678567575","2342342","3424234","23423423","34534534","345345345","342342","45345345","34234234","678567575","2342342","3424234","23423423","34534534","345345345","342342","45345345","34234234","678567575","2342342","3424234","23423423","34534534","345345345","342342","45345345","34234234","678567575","2342342","3424234","23423423","34534534","345345345","342342"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(LIstViewExample.this,R.layout.listviewformate,numbers);
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
String text = numbers[position];

                Toast.makeText(getApplicationContext(), "selected text"+text, Toast.LENGTH_SHORT).show();
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
            case R.id.firstioption:
                Toast.makeText(getApplicationContext(), "this is firstoption", Toast.LENGTH_SHORT).show();
                break;
            case R.id.seconoption:
                Toast.makeText(getApplicationContext(), "this is second otpin ", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
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
            case R.id.contextfirst:
              sum(34,45);
                break;
            case R.id.contextsecond:
         multi(34,56);
                break;
        }
        return true;

    }
    private void sum(int a,int b)
    {
        Toast.makeText(getApplicationContext(), "sum is "+(a+b), Toast.LENGTH_SHORT).show();
    }
    private void multi(int a,int b)
    {
        Toast.makeText(getApplicationContext(), "sum is "+(a*b), Toast.LENGTH_SHORT).show();
    }
}