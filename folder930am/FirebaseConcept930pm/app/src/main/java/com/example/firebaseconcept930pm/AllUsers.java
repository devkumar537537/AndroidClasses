package com.example.firebaseconcept930pm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.firebaseconcept930pm.adapters.UserAdapters;
import com.example.firebaseconcept930pm.models.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AllUsers extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<UserModel> userlists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        userlists = new ArrayList<>();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("RegisterData");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    UserModel userModel = snapshot1.getValue(UserModel.class);

                    userlists.add(userModel);
                }
                UserAdapters userAdapters = new UserAdapters(getApplicationContext(),userlists);
                recyclerView.setAdapter(userAdapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AllUsers.this, "error "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}