package com.batch12pm.firebaseconcepts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
FirebaseAuth firebaseAuth;
TextView nameview,numberview;
ArrayList<ModelClass> userlist;
ArrayList<ImageMOdel> imagelis;
ImageView imageView;
Toolbar toolbar;
    private static final String TAG = "HomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userlist = new ArrayList<>();
        imagelis = new ArrayList<>();

imageView = findViewById(R.id.imageview);

        nameview = findViewById(R.id.nameview);
        numberview = findViewById(R.id.numberview);

        firebaseAuth = FirebaseAuth.getInstance();
       fetchasingledata();
        fetchinlist();
        fetchimage();

    }

    private void fetchimage() {

String userid = firebaseAuth.getCurrentUser().getUid();
FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

firebaseFirestore.collection("UserImagedata").document(userid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {


        DocumentSnapshot document = task.getResult();
        if (document.exists()) {
            String imageurltext = document.get("imageUrl").toString();

            Glide.with(getApplicationContext()).load(imageurltext).into(imageView);



        } else {
            Toast.makeText(getApplicationContext(), "error "+task.getException(), Toast.LENGTH_SHORT).show();
        }

    }
});
    }

    private void fetchinlist() {
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("TenamBatchData").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                       ModelClass modelClass = document.toObject(ModelClass.class);
                       userlist.add(modelClass);
                    }

firebaseFirestore.collection("UserImagedata").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        for (QueryDocumentSnapshot document : task.getResult()) {
            if(document.exists())
            {
                ImageMOdel modelClass = document.toObject(ImageMOdel.class);
                imagelis.add(modelClass);

            }

        }
        for (ImageMOdel imageMOdel : imagelis)
        {
            Log.e(TAG, "onComplete "+imageMOdel.getImageUrl());
        }
    }
});
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });

    }

    private void fetchasingledata() {
        String userid = firebaseAuth.getCurrentUser().getUid();
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("TenamBatchData").document(userid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
               if (document.exists()) {
                         String name = document.get("nameText").toString();
                         String number = document.get("number").toString();

                         nameview.setText(name);
                         numberview.setText(number);

                } else {
                    Toast.makeText(getApplicationContext(), "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id  = item.getItemId();

        switch (id)
        {
            case R.id.logoutbtn:
                firebaseAuth.signOut();
                startActivity(new Intent(HomeActivity.this, LogInActivity.class));
                finish();
                break;
            case R.id.movetoupdate:
                startActivity(new Intent(HomeActivity.this,UpdateActivity.class));
                break;
        }
        return true;
    }
}