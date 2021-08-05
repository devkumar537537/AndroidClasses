package com.example.firebaseconcept;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
FirebaseAuth firebaseAuth;
    TextView emailtext,numbertextview,ttitleview;
    ImageView profilepick;
    DatabaseReference databaseReference;
RecyclerView recyclerView;
ArrayList<MyModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        firebaseAuth = FirebaseAuth.getInstance();
        connectxml();
        userlist = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        fetchdata();
        inialiserecylerview();
    }

    private void inialiserecylerview() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserData");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                userlist.clear();
               for(DataSnapshot snapshot1: snapshot.getChildren())
               {
                   MyModel myModel = snapshot1.getValue(MyModel.class);
                   userlist.add(myModel);
               }
               ItemAdaptes itemAdaptes = new ItemAdaptes(userlist,getApplicationContext());
               recyclerView.setAdapter(itemAdaptes);
            }

            @Override
            public void onCancelled( DatabaseError error) {
                Toast.makeText(HomeActivity.this, "error "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchdata() {
        databaseReference = FirebaseDatabase.getInstance().getReference("UserData").child(firebaseAuth.getCurrentUser().getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {

                String name  = snapshot.child("name").getValue().toString();
                String imageurl = snapshot.child("image").getValue().toString();
                emailtext.setText(name);
                if(imageurl.equals("default"))
                {
                    profilepick.setImageResource(R.drawable.ic_launcher_background);
                }else
                {
                    Glide.with(getApplicationContext()).load(imageurl).into(profilepick);
                }
            }

            @Override
            public void onCancelled( DatabaseError error) {
                Toast.makeText(HomeActivity.this, "error "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mysdidemenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.logoutbtn)
        {
            firebaseAuth.signOut();
            startActivity(new Intent(HomeActivity.this,MainActivity.class));
            finish();
        }else if(item.getItemId() == R.id.movetoupdate)
        {
            startActivity(new Intent(HomeActivity.this,UpdateProfile.class));
        }else if(item.getItemId() == R.id.movetolocalandroid)
        {
            startActivity(new Intent(HomeActivity.this,SampleAdnoridNotification.class));
        }
        return super.onOptionsItemSelected(item);
    }
    private void connectxml()
    {
        emailtext = findViewById(R.id.textView);
        numbertextview = findViewById(R.id.textView2);
        profilepick = findViewById(R.id.profilepick);
         recyclerView = findViewById(R.id.recyclerview);
        ttitleview = findViewById(R.id.textViewtitle);
    }
}