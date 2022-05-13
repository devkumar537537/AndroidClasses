package com.example.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
String[] numberlist = {"324234","3545453","7868768","3324342","435435","6654535","34534534","345345634","324234","3545453","7868768","3324342","435435","6654535","34534534","345345634","324234","3545453","7868768","3324342","435435","6654535","34534534","345345634","324234","3545453","7868768","3324342","435435","6654535","34534534","345345634"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.numberlistview);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,R.layout.listviewformate,numberlist);
   listView.setAdapter(arrayAdapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String text = numberlist[position];
Intent intent =new Intent(MainActivity.this,SecondActivity.class);
intent.putExtra("myvalue",text);
intent.putExtra("number",34453);
startActivity(intent);
        Toast.makeText(MainActivity.this,"selected "+text,Toast.LENGTH_LONG).show();
    }
});

    }
}