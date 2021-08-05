package com.example.firebaseconcepts11amsm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {
String userid;
EditText editvalue;
Button submintbtn,deletebtn;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if(getIntent() != null)
        {
            userid = getIntent().getStringExtra("userid");
        }
firebaseAuth = FirebaseAuth.getInstance();
        editvalue = findViewById(R.id.valueedit);
        submintbtn = findViewById(R.id.submitbtbtn);
        deletebtn = findViewById(R.id.deletebtn);
        submintbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valuetext =editvalue.getText().toString().trim();

                updatevalue(valuetext);

            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserData");
                databaseReference.child(userid).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(DetailActivity.this, "value removed", Toast.LENGTH_SHORT).show();
                            firebaseAuth.signOut();
                            startActivity(new Intent(DetailActivity.this, MainActivity.class));
                            finish();
                        }else
                        {
                            Toast.makeText(DetailActivity.this, "error in deleting", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }

    private void updatevalue(String valuetext) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserData").child(userid);
        Map<String ,Object> updatempa = new HashMap<>();
        updatempa.put("userNumber",valuetext);
        databaseReference.updateChildren(updatempa).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete( Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(DetailActivity.this, "Value updated", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(DetailActivity.this, "Value updation failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}