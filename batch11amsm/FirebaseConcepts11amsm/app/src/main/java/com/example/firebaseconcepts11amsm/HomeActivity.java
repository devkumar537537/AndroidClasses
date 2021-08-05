package com.example.firebaseconcepts11amsm;

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
    RecyclerView recyclerView;
    String userid;
    ArrayList<MyModel> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        connectxml();
        userlist = new ArrayList<>();
        firebaseAuth = FirebaseAuth.getInstance();
         userid = firebaseAuth.getCurrentUser().getUid();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        fetchsingldata();
        getdatainlist();
    }

    private void getdatainlist() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserData");
databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange( DataSnapshot snapshot) {
for(DataSnapshot snapshot1: snapshot.getChildren())
{
    MyModel myModel = snapshot1.getValue(MyModel.class);
    userlist.add(myModel);
}

FormatView formatView = new FormatView(userlist,getApplicationContext());
recyclerView.setAdapter(formatView);
    }

    @Override
    public void onCancelled( DatabaseError error) {
        Toast.makeText(HomeActivity.this, "error "+error.getMessage(), Toast.LENGTH_SHORT).show();
    }
});
    }

    private void fetchsingldata() {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserData").child(userid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
if(snapshot.hasChild("imageurl")){
    String imageurlstring = snapshot.child("imageurl").getValue().toString();
    String name = snapshot.child("userName").getValue().toString();
    String number = snapshot.child("userNumber").getValue().toString();
    String email = snapshot.child("userEamil").getValue().toString();
    emailtext.setText(email);
    numbertextview.setText(number);
    ttitleview.setText(name);
    if(imageurlstring.equals("default"))
    {
        profilepick.setImageResource(R.drawable.ic_launcher_background);

    }else
    {
        Glide.with(getApplicationContext()).load(imageurlstring).into(profilepick);
    }
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
        getMenuInflater().inflate(R.menu.optionsmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.logoutoption)
        {
            firebaseAuth.signOut();
            startActivity(new Intent(HomeActivity.this,MainActivity.class));
            finish();
        }else if(item.getItemId() == R.id.updateactivity)
        {
            startActivity(new Intent(HomeActivity.this,UpadateProfile.class));
        }
        return true;
    }
    public void connectxml()
    {
        emailtext = findViewById(R.id.textView);
        numbertextview = findViewById(R.id.textView2);
        profilepick = findViewById(R.id.profilepick);
           recyclerView = findViewById(R.id.listreycleriview);
        ttitleview = findViewById(R.id.textViewtitle);
    }
}