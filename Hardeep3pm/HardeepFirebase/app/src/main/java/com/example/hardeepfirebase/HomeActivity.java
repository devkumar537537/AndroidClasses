package com.example.hardeepfirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
 EditText numbereidt;
Button logoutbtn,updatebtn,deletedbtn;
FirebaseAuth firebaseAuth;
DatabaseReference databaseReference;
TextView emailtext,numbertext,nametext;
    String userid;
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        emailtext =findViewById(R.id.emailread);
        numbertext =findViewById(R.id.numberread);
        nametext = findViewById(R.id.nameread);
        logoutbtn = findViewById(R.id.logout);
        updatebtn = findViewById(R.id.update);
        numbereidt = findViewById(R.id.updatenumber);
        deletedbtn = findViewById(R.id.deletedata);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number_text = numbereidt.getText().toString().trim();
                updatedata(number_text);
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
         userid = firebaseAuth.getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("UserData").child("");
        FirebaseDatabase.getInstance().getReference("UserData").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(userid))
                {
                    UserData userData = snapshot.getValue(UserData.class);
                    emailtext.setText(userData.getEmail());
                    nametext.setText(userData.getName());
                    numbertext.setText(userData.getNumber());
                    number = userData.getNumber();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Toast.makeText(HomeActivity.this, "You Signout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();
            }
        });
        deletedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         DatabaseReference databaseReference =FirebaseDatabase.getInstance().getReference("UserData").child(userid);
         databaseReference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
             @Override
             public void onComplete(@NonNull Task<Void> task) {
            if(task.isSuccessful())
            {
               startActivity(new Intent(HomeActivity.this,MainActivity.class));
               finish();
            }else
            {

            }
             }
         });

            }
        });
    }

    private void updatedata(String number_text) {
        Map<String,Object> hashMap = new HashMap<>();

        hashMap.put("number",number_text);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserData").child(userid);

        databaseReference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(HomeActivity.this, "Number Updated", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(HomeActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}