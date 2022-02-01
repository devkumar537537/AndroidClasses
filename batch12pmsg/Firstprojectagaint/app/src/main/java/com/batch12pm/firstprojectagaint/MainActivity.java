package com.batch12pm.firstprojectagaint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ageedit;
    Button submitbtn,movebtn;

ListView listView;
String[] numbers={"345345","56564","5464564","4656546","345453","465465","3453453","34534535","5465464","345345","56564","5464564","4656546","345453","465465","3453453","34534535","5465464"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ageedit = findViewById(R.id.ageeditt);
        submitbtn = findViewById(R.id.submitbtnn);
         movebtn = findViewById(R.id.movetosecond);
         listView = findViewById(R.id.listview);


        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.customlistviewformate,numbers);
        listView.setAdapter(myadapter);
 listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
String numbertext = numbers[position];
         Toast.makeText(getApplicationContext(), numbertext+" present at "+position, Toast.LENGTH_SHORT).show();



     }
 });
submitbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String agetext = ageedit.getText().toString();

       int age =  Integer.parseInt(agetext);

       if(age >= 18)
       {
           Toast.makeText(MainActivity.this,"you can vote",Toast.LENGTH_SHORT).show();
       }else
       {
           Toast.makeText(MainActivity.this, "you can not vote", Toast.LENGTH_LONG).show();
       }
    }
});
movebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent movetintent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(movetintent);
    }
});

    }
}