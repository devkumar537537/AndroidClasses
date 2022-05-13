package com.example.relativelayouexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.relativelayouexample.fragments.FirstFragment;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //adding frist fragme
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentcontainer,new FirstFragment());
        fragmentTransaction.commit();
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
            case R.id.firstoption:

                sum(4,5);
                break;
            case R.id.secondoption:
                multi(4,5);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void sum(int a,int b)
    {
        Toast.makeText(getApplicationContext(), "sum is "+(a+b), Toast.LENGTH_SHORT).show();
    }
    public void multi(int a,int b)
    {
        Toast.makeText(getApplicationContext(), "multi is "+(a*b), Toast.LENGTH_SHORT).show();
    }
}