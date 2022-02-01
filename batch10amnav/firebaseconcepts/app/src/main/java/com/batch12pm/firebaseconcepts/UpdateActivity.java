package com.batch12pm.firebaseconcepts;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {

    ImageView imageView;
    Button chooseFromgallary,choosefromCamera,uploadimagebtn;

    ProgressBar progressBar;

    String[] permiissons = {Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA,Manifest.permission.INTERNET};

int permssioncode = 2132;
Uri imageuri;
FirebaseAuth firebaseAuth;
    EditText keyedit,valueedit;
    Button submitvalue,deleteuserbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        combine();
       // Build.VERSION.SDK_INT >= Build.VERSION_CODES.M


        firebaseAuth = FirebaseAuth.getInstance();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(permiissons,permssioncode);

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

                GalleryResultLauncher.launch(intent);
            }
        });

        choosefromCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFromgallary.setVisibility(View.GONE);
                Intent intent = new Intent();

                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

                CamereResultLauncher.launch(intent);
            }
        });
uploadimagebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(imageuri != null)
        {
            progressBar.setVisibility(View.VISIBLE);
            uploaimage(imageuri);
        }else
        {
            Toast.makeText(getApplicationContext(), "pls select image", Toast.LENGTH_SHORT).show();
        }
    }
});

submitvalue.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String userid = firebaseAuth.getCurrentUser().getUid();
        String keytext  = keyedit.getText().toString().trim();
        String valutetext = valueedit.getText().toString().trim();

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        Map<String,Object> usermap =new HashMap<>();
        usermap.put(keytext,valutetext);

        firebaseFirestore.collection("TenamBatchData").document(userid).update(usermap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
             if(task.isSuccessful())
             {
                 Toast.makeText(getApplicationContext(), "value updated", Toast.LENGTH_SHORT).show();
             }else {
                 Toast.makeText(getApplicationContext(),"error "+task.getException(),Toast.LENGTH_SHORT).show();
             }
            }
        });


    }


});
deleteuserbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String userid = firebaseAuth.getCurrentUser().getUid();
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("TenamBatchData").document(userid).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "data deleted", Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();
                    startActivity(new Intent(UpdateActivity.this,LogInActivity.class));
                    finish();
                }else
                {
                    Toast.makeText(getApplicationContext(), "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
});


    }

    private void uploaimage(Uri imageuri) {
        String usrid = firebaseAuth.getCurrentUser().getUid();
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("Userimage").child(usrid);
        storageReference.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String imageurl = uri.toString();
                        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

                        HashMap<String,String> usermapeimage =new HashMap<>();

                        usermapeimage.put("imageUrl",imageurl);
                        usermapeimage.put("userId",usrid);

                        firebaseFirestore.collection("UserImagedata").document(usrid).set(usermapeimage).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                           if(task.isSuccessful())
                           {
                               progressBar.setVisibility(View.GONE);
                               Toast.makeText(getApplicationContext(), "image uploaded Successfully", Toast.LENGTH_SHORT).show();
                           }else {
                               progressBar.setVisibility(View.GONE);
                               Toast.makeText(getApplicationContext(), "error "+task.getException(), Toast.LENGTH_SHORT).show();
                           }
                            }
                        });
                    }
                });
            }
        });

    }

    ActivityResultLauncher<Intent> CamereResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                   if(result.getResultCode() == Activity.RESULT_OK)
                   {

                   Bitmap bitmap = (Bitmap)    result.getData().getExtras().get("data");

                       imageView.setImageBitmap(bitmap);
                       imageuri = getimageurifrombitmap(getApplicationContext(),bitmap);
                   }


                }
            }
    );

    private Uri getimageurifrombitmap(Context applicationContext, Bitmap bitmap) {

        ByteArrayOutputStream bytobj = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bytobj);

        String path = MediaStore.Images.Media.insertImage(applicationContext.getContentResolver(),bitmap,"anything","this  is somthing else");

        return Uri.parse(path);
    }

    ActivityResultLauncher<Intent> GalleryResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK)
                    {

                        imageuri = result.getData().getData();

                        imageView.setImageURI(imageuri);
                    }


                }
            }
    );

    private void combine() {
        imageView = findViewById(R.id.selectedimage);
        choosefromCamera = findViewById(R.id.choosefromcamera);
        chooseFromgallary = findViewById(R.id.choosefromgallary);
        uploadimagebtn = findViewById(R.id.upload_imagebtn);
        progressBar = findViewById(R.id.imageprogressbar);

        keyedit = findViewById(R.id.keyeidt);
        submitvalue = findViewById(R.id.updatebtn);
        valueedit = findViewById(R.id.valueeidt);
        deleteuserbtn = findViewById(R.id.deletebtn);

    }
}