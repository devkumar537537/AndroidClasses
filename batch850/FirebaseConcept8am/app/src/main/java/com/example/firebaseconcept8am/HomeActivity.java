package com.example.firebaseconcept8am;

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
TextView textView;
    TextView emailtext,numbertextview,ttitleview;
    ImageView profilepick;
   DatabaseReference databaseReference;
   String userid;
   RecyclerView recyclerView;
   ArrayList<MyitemModel> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        firebaseAuth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.textView);
        connectxml();
        userList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("User8amdata");
        userid = firebaseAuth.getCurrentUser().getUid();
        databaseReference.child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
               String emailvalue = snapshot.child("email").getValue().toString();
               String numbervalue = snapshot.child("number").getValue().toString();
               String imagevale = snapshot.child("imageurl").getValue().toString();

               if(imagevale.equals("default"))
               {
                   profilepick.setImageResource(R.drawable.ic_launcher_background);
               }else
               {
                   Glide.with(getApplicationContext()).load(imagevale).into(profilepick);
               }

               emailtext.setText(emailvalue);
               numbertextview.setText(numbervalue);
            }

            @Override
            public void onCancelled( DatabaseError error) {
                Toast.makeText(HomeActivity.this, "error "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        createrecycler();
    }

    private void createrecycler() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("User8amdata");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                userList.clear();
for(DataSnapshot dataSnapshot: snapshot.getChildren())
{
    MyitemModel myitemModel = dataSnapshot.getValue(MyitemModel.class);
    userList.add(myitemModel);
}

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
recyclerView.setLayoutManager(linearLayoutManager);
ItemAdaptes itemAdaptes = new ItemAdaptes(userList,getApplicationContext());
recyclerView.setAdapter(itemAdaptes);
            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.otheroptions,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.logoutoption)
        {
            firebaseAuth.signOut();
            startActivity(new Intent(HomeActivity.this,MainActivity.class));
            finish();
        }else if(id == R.id.update)
        {
            startActivity(new Intent(HomeActivity.this,UpdateActivity.class));
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