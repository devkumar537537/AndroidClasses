package com.example.myfirebaseproject5pm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class UploadImageActivity extends AppCompatActivity {
ImageView selectimage,readimages;
Button slectimagebtn,upladimagebtn;
Uri imagUri;
ProgressBar progressBar;
int GALLARY_REQUEST = 12;
int permissiion_REaues = 24;
FirebaseAuth firebaseAuth;
String[] permission = {Manifest.permission.INTERNET,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        bindviews();
        setimage();
     firebaseAuth = FirebaseAuth.getInstance();
        slectimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                    {
                        requestPermissions(permission,permissiion_REaues);
                    }else
                    {
                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent,GALLARY_REQUEST);
                    }
                }else
                {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent,GALLARY_REQUEST);
                }

            }
        });
        upladimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imagUri == null)
                {
                    Toast.makeText(UploadImageActivity.this, "Please selct image", Toast.LENGTH_SHORT).show();
                }else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    sendimage();
                }
            }
        });
    }

    private void setimage() {
        String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Imagedata").child(userid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String imagevale = snapshot.child("imageurl").getValue().toString();

                Glide.with(getApplicationContext()).load(imagevale).into(readimages);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UploadImageActivity.this, "error "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendimage() {
        String userid = firebaseAuth.getCurrentUser().getUid();

        StorageReference storageReference = FirebaseStorage.getInstance().getReference("UserImages").child(userid).child(userid+".jpg");
      storageReference.putFile(imagUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
          @Override
          public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String url = uri.toString();
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Imagedata").child(userid);
                    HashMap<String ,String> hashMap = new HashMap<>();

                    hashMap.put("imageurl",url);

                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                               progressBar.setVisibility(View.GONE);
                                Toast.makeText(UploadImageActivity.this, "Image Uploadde Successfully", Toast.LENGTH_SHORT).show();
                            }else
                            {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(UploadImageActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });
          }
      });
    }


    private void bindviews() {
        selectimage = findViewById(R.id.imagview_upload);
        slectimagebtn = findViewById(R.id.selectimagebtn);
        upladimagebtn = findViewById(R.id.uploadimagebtn);
        readimages = findViewById(R.id.imagview_read);
        progressBar = findViewById(R.id.imagprogessbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLARY_REQUEST && resultCode == RESULT_OK  && data!= null)
        {
            imagUri = data.getData();
            selectimage.setImageURI(imagUri);
        }
    }
}