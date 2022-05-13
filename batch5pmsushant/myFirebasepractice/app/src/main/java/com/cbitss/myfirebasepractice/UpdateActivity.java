package com.cbitss.myfirebasepractice;

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
import android.util.Log;
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
    private static final String TAG = "UpdateActivity";
    ImageView imageView;
    Button chooseFromgallary,choosefromCamera,uploadimagebtn;

    ProgressBar progressBar;
String[]  permissinons = {Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.INTERNET,Manifest.permission.CAMERA};
int permissioncode = 123;
Uri uri;
FirebaseAuth firebaseAuth;
    EditText keyedit,valueedit;
    Button submitvalue,deleteuserbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        combine();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(permissinons,permissioncode);
            }
        }

        firebaseAuth = FirebaseAuth.getInstance();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                choosefromCamera.setVisibility(View.VISIBLE);
                chooseFromgallary.setVisibility(View.VISIBLE);
                uploadimagebtn.setVisibility(View.VISIBLE);
            }
        });

        choosefromCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFromgallary.setVisibility(View.GONE);

                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

          CameraResultLauncher.launch(intent);
            }
        });
        chooseFromgallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefromCamera.setVisibility(View.GONE);
Intent intent = new Intent();
intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        GalleryResultLauncher.launch(intent);

            }
        });

        uploadimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     if(uri == null)
                     {
                         Toast.makeText(UpdateActivity.this, "pls select the image", Toast.LENGTH_SHORT).show();
                     }else
                     {
                         progressBar.setVisibility(View.VISIBLE);
                         uploadimage();
                        // uploaimage(uri);
                     }
            }
        });
        submitvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = firebaseAuth.getCurrentUser().getUid();
                String keytext  = keyedit.getText().toString().trim();
                String valutetext = valueedit.getText().toString().trim();

                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                Map<String,Object> usermap =new HashMap<>();
                usermap.put(keytext,valutetext);


                firebaseFirestore.collection("AllUser").document(userid).update(usermap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.e(TAG, "Inside firebasefire store query" );
                        if(task.isSuccessful())
                        {
                            Toast.makeText(UpdateActivity.this, "value update", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(UpdateActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        deleteuserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = firebaseAuth.getCurrentUser().getUid();
                String keytext  = keyedit.getText().toString().trim();
                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                firebaseFirestore.collection("AllUser").document(userid).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        firebaseAuth.signOut();
                        startActivity(new Intent(UpdateActivity.this,MainActivity.class));
                        finish();
                    }
                });
            }
        });
    }

    private void uploadimage() {

        String userid = firebaseAuth.getCurrentUser().getUid();
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("UserImage").child(userid);
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String imageurl = uri.toString();
                        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                        HashMap<String,String> userimage = new HashMap<>();
                        userimage.put("userid",userid);
                        userimage.put("userImageUrl",imageurl);

                        firebaseFirestore.collection("UserImage").document(userid).set(userimage).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(UpdateActivity.this, "Image Uploaded Successfully", Toast.LENGTH_SHORT).show();
                                }else
                                {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(UpdateActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
            }
        });
    }



    ActivityResultLauncher<Intent> CameraResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK)
                    {
                        Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                        imageView.setImageBitmap(bitmap);
                        uri = getUrifromBitmap(bitmap,getApplicationContext());
                    }
                }
            }
    );

    private Uri getUrifromBitmap(Bitmap bitmap, Context applicationContext) {

          ByteArrayOutputStream byobj = new ByteArrayOutputStream();
          bitmap.compress(Bitmap.CompressFormat.PNG,100,byobj);
          String path = MediaStore.Images.Media.insertImage(applicationContext.getContentResolver(),bitmap,"FirstImage ","Some is better");
return Uri.parse(path);


    }

    ActivityResultLauncher<Intent> GalleryResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK)
                    {
                        uri = result.getData().getData();
                        imageView.setImageURI(uri);


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