package com.example.firsttime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
TextView textView;
String value_email;
    Button movebtn;
    ListView listView;
    String[] countrylist = {"India","USA","Australia","America","Delhi","Japan","china"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        value_email = getIntent().getStringExtra("first");

      
  listView = findViewById(R.id.listview);
  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,countrylist);
  arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
  listView.setAdapter(arrayAdapter);

 registerForContextMenu(listView);
 listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         Toast.makeText(SecondActivity.this, "clicke "+countrylist[position], Toast.LENGTH_SHORT).show();
     }
 });
        movebtn = findViewById(R.id.move_to_third);
    textView = findViewById(R.id.value_textview);
    textView.setText(value_email);
        movebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.contactusid)
        {
            Toast.makeText(this, "clicked "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }else if(id == R.id.treeid)
        {
            Toast.makeText(this, "clicked "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);

    }
}