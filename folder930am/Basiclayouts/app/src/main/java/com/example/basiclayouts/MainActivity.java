package com.example.basiclayouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basiclayouts.fragements.FirstFrament;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.emailedit)
    EditText emailedit;


    @BindView(R.id.passwordlayout)
            EditText passwordedit;

    @BindView(R.id.login)
            Button loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        Log.e(TAG, "onCreate: " );
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_text = emailedit.getText().toString();
                String password_text = passwordedit.getText().toString();


                Toast.makeText(getApplicationContext()," email => "+email_text +"\n  password  =>"+password_text,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                intent.putExtra("email",email_text);

                startActivity(intent);


            }
        });
      //firsttime fragment add krne ka code
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentcontainer,new FirstFrament());
        fragmentTransaction.commit();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

}