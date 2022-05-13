package com.cbitss.myfirebasepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
FirebaseAuth firebaseAuth;
TextView emailview,numberview;
ImageView profileimage;
FirebaseFirestore db;
ArrayList<UserModel> userlist;
    private static final String TAG = "HomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        firebaseAuth = FirebaseAuth.getInstance();
       db = FirebaseFirestore.getInstance();
       userlist =new ArrayList<>();
        connectxml();
        fetchdata();
        fetchdatainlist();
        fetchimagedata();
    }

    private void fetchimagedata() {
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        String userid = firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore.collection("UserImage").document(userid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot documentSnapshot = task.getResult();
                if(documentSnapshot.exists())
                {
                    String image  = documentSnapshot.get("userImageUrl").toString();

                    Glide.with(getApplicationContext()).load(image).into(profileimage);
                }else
                {
                    Toast.makeText(HomeActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fetchdatainlist() {
        db.collection("AllUser").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                for(QueryDocumentSnapshot document: task.getResult())
                {
                    UserModel userModel = document.toObject(UserModel.class);
                    userlist.add(userModel);
                }
                for(UserModel userModel:userlist)
                {
                    Log.e(TAG, "Coming Values "+userModel.getUserEmail()+"\n "+userModel.getUserId() );
                }

            }
        });
    }

    private void fetchdata() {
        String userid = firebaseAuth.getCurrentUser().getUid();
        db.collection("AllUser").document(userid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
DocumentSnapshot documentSnapshot = task.getResult();
if(documentSnapshot.exists())
{
    String email  = documentSnapshot.get("userEmail").toString();
    String number = documentSnapshot.get("userNumber").toString();

    emailview.setText(email);
    numberview.setText(number);
}else
{
    Toast.makeText(HomeActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
}

            }
        });
    }

    private void connectxml() {
        emailview =findViewById(R.id.nameview);
        numberview =findViewById(R.id.numberview);
        profileimage = findViewById(R.id.imageview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logoutbtn:
                firebaseAuth.signOut();
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();
                break;
            case R.id.updateinfo:
                startActivity(new Intent(HomeActivity.this,UpdateActivity.class));
                break;
        }
        return true;
    }
}