package com.example.tyesofmenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ContextMenuExample extends AppCompatActivity {

    ListView listView;
    String[] name = {"Newton","Albert","Marry","CB Raman","Newton","Albert","Marry","CB Raman","Newton","Albert","Marry","CB Raman","Newton","Albert","Marry","CB Raman"};
    String[] number ={"12312","324234","34244","3423423","12312","324234","34244","3423423","12312","324234","34244","3423423","12312","324234","34244","3423423"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_example);
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.listitem,name);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu popupMenu = new PopupMenu(ContextMenuExample.this,view);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId() == R.id.popupfirstmenu)
                        {
                            Toast.makeText(getApplicationContext(), item.getTitle()+" Selected ", Toast.LENGTH_SHORT).show();
                        }else if(item.getItemId() == R.id.popupsecondmeny)
                        {
                            Toast.makeText(getApplicationContext(), item.getTitle()+" Selected ", Toast.LENGTH_SHORT).show();
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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.firstcontext)
        {
            Toast.makeText(this, item.getTitle()+" Selected ", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.secondcontext)
        {
            Toast.makeText(this, item.getTitle()+" Selected ", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}