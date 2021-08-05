package com.example.firebaseconcept8am;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("deprecation")
public class UpdateActivity extends AppCompatActivity {
EditText anyedit;
Button submit,deletebtn;
FirebaseAuth firebaseAuth;
DatabaseReference databaseReference;
    ImageView imageView;
    Button chooseFromgallary,choosefromCamera,uploadimagebtn;
    ProgressBar progressBar;
    String[] permissios = {Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.INTERNET};
    int permissionCode = 345;
    private int gallaryrequest = 567;
    private int camerarequest = 888;
    private Uri imageuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        firebaseAuth = FirebaseAuth.getInstance();
        connextit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valuttextg = anyedit.getText().toString().trim();

                updatevlaue(valuttextg);
            }
        });


        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
        {
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(permissios,permissionCode);

            }
        }


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosefromCamera.setVisibility(View.VISIBLE);
                chooseFromgallary.setVisibility(View.VISIBLE);
                uploadimagebtn.setVisibility(View.VISIBLE);
            }
        });
        chooseFromgallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosefromCamera.setVisibility(View.GONE);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,gallaryrequest);
            }
        });

        choosefromCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFromgallary.setVisibility(View.GONE);
                Intent intent = new Intent();
                intent.setAction(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent,camerarequest);
            }
        });
        uploadimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageuri != null)
                {
                    progressBar.setVisibility(View.VISIBLE);
                   uploadimage(imageuri);
                }else
                {
                    Toast.makeText(UpdateActivity.this, "please selct image", Toast.LENGTH_SHORT).show();
                }
            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = firebaseAuth.getCurrentUser().getUid();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("User8amdata").child(userid);
                databaseReference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete( Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            firebaseAuth.signOut();
                            startActivity(new Intent(UpdateActivity.this,MainActivity.class));
                            finish();
                            Toast.makeText(UpdateActivity.this, "value deleted", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(UpdateActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void uploadimage(Uri imageuri) {
String userid = firebaseAuth.getCurrentUser().getUid();
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("User8amimages").child(userid).child(System.currentTimeMillis()+".png");
   storageReference.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
       @Override
       public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
           storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
               @Override
               public void onSuccess(Uri uri) {
                   String url = uri.toString();
                   DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("User8amdata").child(userid);

                   Map<String,Object> imagemap = new HashMap<>();
                   imagemap.put("imageurl",url);
                   databaseReference.updateChildren(imagemap).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete( Task<Void> task) {
                           if(task.isSuccessful())
                           {
                               progressBar.setVisibility(View.GONE);
                               Toast.makeText(UpdateActivity.this, "Image Uploaded Successfully", Toast.LENGTH_SHORT).show();
                           }else
                           {
                               progressBar.setVisibility(View.GONE);
                               Toast.makeText(UpdateActivity.this, "Error "+task.getException(), Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
           });
       }
   });

    }

    private void connextit() {
        imageView = findViewById(R.id.selectedimage);
        choosefromCamera = findViewById(R.id.choosefromcamera);
        chooseFromgallary = findViewById(R.id.choosefromgallary);
        uploadimagebtn = findViewById(R.id.upload_imagebtn);
        progressBar = findViewById(R.id.imageprogressbar);
        anyedit = findViewById(R.id.passwordupdate);
        submit = findViewById(R.id.submitbtnupdate);
        deletebtn = findViewById(R.id.deletebtn);
    }

    private void updatevlaue(String valuttextg) {
        databaseReference = FirebaseDatabase.getInstance().getReference("User8amdata");
        String userid = firebaseAuth.getCurrentUser().getUid();
        Map<String,Object> updatemap = new HashMap<>();

        updatemap.put("number",valuttextg);
        databaseReference.child(userid).updateChildren(updatemap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete( Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(UpdateActivity.this, "Number Updated", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(UpdateActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == camerarequest && resultCode == Activity.RESULT_OK && data != null)
        {
            Bitmap bitmap =(Bitmap) data.getExtras().get("data");



            imageView.setImageBitmap(bitmap);

            imageuri = getUriFromBitmap(bitmap,getApplicationContext());
        }else if(requestCode == gallaryrequest && resultCode == Activity.RESULT_OK && data != null)
        {
            imageuri = data.getData();
            imageView.setImageURI(imageuri);
        }

    }
    private Uri getUriFromBitmap(Bitmap bitmap, Context context){
        ByteArrayOutputStream bytobj = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bytobj);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(),bitmap,"Title","anything");
        return Uri.parse(path);
    }
}