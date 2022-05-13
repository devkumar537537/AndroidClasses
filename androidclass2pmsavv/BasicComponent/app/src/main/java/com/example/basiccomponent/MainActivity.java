package com.example.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
int number;
Button clickbtn;
TextView textView;
String[] numberslist={"45345345","234234","34234234","123424234","45345345","3453454","435345345","45345345","234234","34234234","123424234","45345345","3453454","435345345","45345345","234234","34234234","123424234","45345345","3453454","435345345","45345345","234234","34234234","123424234","45345345","3453454","435345345","45345345","234234","34234234","123424234","45345345","3453454","435345345","45345345","234234","34234234","123424234","45345345","3453454","435345345"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        clickbtn = findViewById(R.id.clickbtn);
        textView =findViewById(R.id.textview);


        ArrayAdapter<String> mynumberlistadapter= new ArrayAdapter<String>(getApplicationContext(),R.layout.listviewformat,numberslist);

        listView.setAdapter(mynumberlistadapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
             String text = numberslist[position];
             number = Integer.parseInt(text);
                Toast.makeText(getApplicationContext(), "selected number"+text, Toast.LENGTH_SHORT).show();
            }
        });

        clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number%2==0)
                {
                    textView.setText(number +" is even");
                }else
                {
                    textView.setText(number+" is odd");
                }
            }
        });
    }
}