package com.example.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
String[] numbers= {"5645665456","234234234","78576756756","3452432342","5464564564","78567674564","4534534534","53453453","5645665456","234234234","78576756756","3452432342","5464564564","78567674564","4534534534","53453453","5645665456","234234234","78576756756","3452432342","5464564564","78567674564","4534534534","53453453","5645665456","234234234","78576756756","3452432342","5464564564","78567674564","4534534534","53453453","5645665456","234234234","78576756756","3452432342","5464564564","78567674564","4534534534","53453453"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.listviewformate,numbers);


        listView.setAdapter(arrayAdapter);

           listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   String text = numbers[position];
                   Toast.makeText(getApplicationContext(), "selected vlaue "+text, Toast.LENGTH_SHORT).show();
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

        if(id == R.id.firstcontext)
        {
            sum();
        }else if(id == R.id.secondcontext)
        {
            multi();
        }
        return true;
    }

    private void sum()
    {
        Toast.makeText(getApplicationContext(), "mulitis is "+(2+3), Toast.LENGTH_SHORT).show();
    }
    private void multi()
    {
        Toast.makeText(getApplicationContext(), "mulitis is "+(2*3), Toast.LENGTH_SHORT).show();
    }
}