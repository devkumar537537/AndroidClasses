package com.example.firebaseconcept930pm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.firebaseconcept930pm.models.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

FirebaseAuth firebaseAuth;
TextView emailview,nameview;
ImageView priofileimage;
String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      connextcmls();
        firebaseAuth = FirebaseAuth.getInstance();
        userid = firebaseAuth.getCurrentUser().getUid();
loaddata();
    }


    private void loaddata()
    {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("RegisterData").child(userid);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    UserModel userModel = snapshot.getValue(UserModel.class);

                    emailview.setText(userModel.getEmail());
                    nameview.setText(userModel.getName());

                    if(userModel.getImage().equals("default"))
                    {
                        priofileimage.setImageResource(R.drawable.ic_launcher_background);
                    }else
                    {
                        Glide.with(getApplicationContext()).load(userModel.getImage()).into(priofileimage);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "eroror "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void connextcmls() {
        emailview = findViewById(R.id.emailview);
        nameview = findViewById(R.id.nameview);
        priofileimage = findViewById(R.id.profileimage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
switch (item.getItemId())
{
    case R.id.logout:
        firebaseAuth.signOut();
        startActivity(new Intent(HomeActivity.this,MainActivity.class));
        finish();
        break;
    case R.id.uploadimgae:
        startActivity(new Intent(HomeActivity.this,UplodadImage.class));
        break;
    case R.id.alluser:
        startActivity(new Intent(HomeActivity.this,AllUsers.class));
        break;
    case R.id.notification:
        startActivity(new Intent(HomeActivity.this,AndroidNotificationExample.class));
        break;


}
        return super.onOptionsItemSelected(item);
    }
}