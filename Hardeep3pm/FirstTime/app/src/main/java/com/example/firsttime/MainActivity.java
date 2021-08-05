package com.example.firsttime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText emailedit;
Button login_btn;
    TextView textView;
    String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     attachview();
     login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             gettext();
            }
        });
        addfragment();


    }

    private void addfragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,new FirstFragment());
        fragmentTransaction.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onresumemethod clalled");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onstart method callled");
    }
    public void attachview()
    {
        textView =findViewById(R.id.textone);
        emailedit = findViewById(R.id.Enter_email);
        login_btn = findViewById(R.id.loginBtn);
    }
    public void gettext()
    {
        String email_text = emailedit.getText().toString().trim();
        if(TextUtils.isEmpty(email_text))
        {
            Toast.makeText(getApplicationContext(),"please enter email",Toast.LENGTH_SHORT).show();
        }else
        {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("first",email_text);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.logut)
        {
            Toast.makeText(this, "logout Clicker", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.myprofleid)
        {
            Toast.makeText(this, "myprofele btn clicke", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}