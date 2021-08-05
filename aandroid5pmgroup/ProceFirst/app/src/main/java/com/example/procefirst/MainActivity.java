package com.example.procefirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
    Button email_btn,movebtn;
    EditText emailedit;
    String[] namelist={"Albert","Newton","Marry","Manmohan Sing","Maxwell","Dhoni","Kholi","book","Albert","Newton","Marry","Manmohan Sing","Maxwell","Dhoni","Kholi","book"};

    String[] numberlist={"324324","234234","34234","234234","3542342","34234","546546","234234","234235","324324","234234","34234","234234","3542342","34234","546546","234234","234235"};
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectxml();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.listtiem,namelist);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String number_text =numberlist[position];

                PopupMenu popupMenu = new PopupMenu(MainActivity.this,view);

                popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "title"+item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
                Toast.makeText(MainActivity.this, "selected vlaue"+number_text, Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(listView);
        email_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String email_text = emailedit.getText().toString().trim();

                Toast.makeText(MainActivity.this,"email => "+email_text,Toast.LENGTH_SHORT).show();

            }
        });

        movebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = emailedit.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this,RelativeExample.class);
                intent.putExtra("email",emailtext);

                startActivity(intent);
            }
        });
    }

    private void connectxml() {
        email_btn = findViewById(R.id.showemailbtn);
        emailedit = findViewById(R.id.email_edit);
        movebtn = findViewById(R.id.movetosecond);
        listView = findViewById(R.id.listview);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opotionsmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.firstoptionmenu)
        {
            add(3,4);
        }else if(id == R.id.subitem)
        {
            multi(3,4);
        }else if(id== R.id.subitemtwo)
        {
            Toast.makeText(this, "title is "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    private  void add(int a,int b)
    {
        int sum = a+b;
        Toast.makeText(this, "sum is "+sum, Toast.LENGTH_SHORT).show();
    }

    private  void multi(int a,int b)
    {
        int multi = a*b;
        Toast.makeText(this, "multi"+multi, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.firstcontext:
                Toast.makeText(this, "title is "+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.secondcontext:
                Toast.makeText(this, "title is "+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}