package com.example.myfirebaseproject5pm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
Button logoutbtn,movebtn;
FirebaseAuth firebaseAuth;
TextView emailview,numberview,nameview,passwordview,useridview;
DatabaseReference databaseReference;
ArrayList<UserDataModelClass> userlist;
RecyclerView recyclerView;
   static CharSequence name = "my_channel";
   static String Description = "This is my channel";
    static final String NOTIFICATION_ID = "201";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
     userlist = new ArrayList<>();
        bindviews();
        firebaseAuth = FirebaseAuth.getInstance();
       setdata();
setinrecycelrview();
        firebaseAuth = FirebaseAuth.getInstance();
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();
            }
        });
        movebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UploadImageActivity.class));
            }
        });
    }

    private void setinrecycelrview() {
        databaseReference = FirebaseDatabase.getInstance().getReference("UserData");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userlist.clear();
              for(DataSnapshot snapshot1: snapshot.getChildren())
              {
                  UserDataModelClass userDataModelClass = snapshot1.getValue(UserDataModelClass.class);
                  userlist.add(userDataModelClass);

              }
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
              recyclerView.setLayoutManager(layoutManager);
              RecyclerdataAdapter recyclerdataAdapter = new RecyclerdataAdapter(userlist,getApplicationContext());
              recyclerView.setAdapter(recyclerdataAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "error"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setdata() {
        String userid = firebaseAuth.getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("UserData").child(userid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserDataModelClass userDataModelClass = snapshot.getValue(UserDataModelClass.class);

                emailview.setText(userDataModelClass.getEmail());
                nameview.setText(userDataModelClass.getName());
                numberview.setText(userDataModelClass.getNumber());
                passwordview.setText(userDataModelClass.getPassword());
                useridview.setText(userDataModelClass.getUserId());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "error"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void bindviews() {
        logoutbtn = findViewById(R.id.logoutbtn);
        emailview = findViewById(R.id.textemail);
        numberview = findViewById(R.id.textnumber);
        nameview = findViewById(R.id.textname);
        passwordview = findViewById(R.id.textpassword);
        useridview = findViewById(R.id.textuserid);
        recyclerView = findViewById(R.id.recyclerview);
        movebtn = findViewById(R.id.gotouploadimage);
    }
}