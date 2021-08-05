package com.example.advancewidget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewExample extends AppCompatActivity {
ListView listView;
Spinner spinner;
String[] names = {"Ravi","Rahoul","Raj","Albert","Newton","Merry","Ravi","Rahoul","Raj","Albert","Newton","Merry","Ravi","Rahoul","Raj","Albert","Newton","Merry"};
  String[] numbers = {"435345","8907897","456456","4564564","564654","45645645","435345","8907897","456456","4564564","564654","45645645","435345","8907897","456456","4564564","564654","45645645"} ;
RadioGroup radioGroup;
RadioButton radioButton;
Button checkbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.listviewname);
       radioGroup = findViewById(R.id.radiogroup);
       checkbtn = findViewById(R.id.checkbtn);
           spinner = findViewById(R.id.spinner);
       checkbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int id = -1;
                id = radioGroup.getCheckedRadioButtonId();
                if(id > 0)
                {
                    radioButton = findViewById(id);
                    String ans_Text = radioButton.getText().toString();

                    if(ans_Text.equals("Nine"))
                    {
                        Toast.makeText(ListViewExample.this, "You are right", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(ListViewExample.this, "You are wrong", Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(ListViewExample.this, "please select one option", Toast.LENGTH_SHORT).show();
                }

           }
       });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),R.layout.listviewlayout,names);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = numbers[position];
                //get the number at such as a

                Toast.makeText(ListViewExample.this, "selected "+text, Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> spinneradatper = new ArrayAdapter<>(getApplicationContext(),R.layout.listviewlayout,names);
        spinneradatper.setDropDownViewResource(R.layout.listviewlayout);
        spinner.setAdapter(spinneradatper);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name = names[position];
                Toast.makeText(ListViewExample.this, "selected vlaue "+name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
            Toast.makeText(this, "titile "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }else if(id == R.id.seconcontext)
        {
            Toast.makeText(this, "titile "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

}