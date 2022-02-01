package com.batch12pm.firebaseprojects

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream
import java.util.HashMap

class UpdateActivyt : AppCompatActivity() {
    lateinit var imageView: ImageView
   lateinit var choosefromCamera: Button
   lateinit var chooseFromgallary :Button
   lateinit var uploadimagebtn:Button
   lateinit var progressBar: ProgressBar
   lateinit var imageuri:Uri
   lateinit var keyedit:EditText
   lateinit var valueedit:EditText
   lateinit var updatebtn:Button
   lateinit var deletebtn:Button



   lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_activyt)
        conncetc()
        firebaseAuth = FirebaseAuth.getInstance()
        imageView.setOnClickListener {
            choosefromCamera.visibility= View.VISIBLE
            chooseFromgallary.visibility = View.VISIBLE
            uploadimagebtn.visibility = View.VISIBLE
        }
        chooseFromgallary.setOnClickListener {
            choosefromCamera.visibility= View.GONE
            choosefromCamera.visibility = View.GONE


            var intent = Intent()
            intent.action  = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            GallaryResultlaunchre.launch(intent)
        }

        choosefromCamera.setOnClickListener {
            chooseFromgallary.visibility = View.GONE

            val intent = Intent()

            intent.action = MediaStore.ACTION_IMAGE_CAPTURE

            CamerResultLauncher.launch(intent)
        }

        uploadimagebtn.setOnClickListener {
if(imageuri != null)
{
    progressBar.visibility = View.VISIBLE
//    uploadimage(imageuri)
    uploaimage(imageuri)
}

            deletebtn.setOnClickListener {
                var userid  = firebaseAuth.currentUser!!.uid
                var db = FirebaseFirestore.getInstance()
                db.collection("FourPmDatabase").document(userid).delete().addOnSuccessListener {

                        firebaseAuth.signOut()
                        startActivity(Intent(applicationContext,LOgInActivity::class.java))
                        Toast.makeText(applicationContext,"value deleted",Toast.LENGTH_SHORT).show()
                        finish()

                }

            }
        }


        updatebtn.setOnClickListener {
            var userid = firebaseAuth.currentUser!!.uid;
            var ketext = keyedit.text.toString()
            var valuetext = valueedit.text.toString()
                  var db = FirebaseFirestore.getInstance()


            val usermap: MutableMap<String, Any> = HashMap()
            usermap[ketext] = valuetext
            db.collection("FourPmDatabase").document(userid).update(usermap).addOnCompleteListener {
                if(it.isSuccessful)
                {
                    Toast.makeText(applicationContext,"value updated",Toast.LENGTH_SHORT).show()
                }else
                {
                    Toast.makeText(applicationContext,"error",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }


    private fun uploaimage(imageuri: Uri) {
        val usrid = firebaseAuth.currentUser!!.uid
        val storageReference = FirebaseStorage.getInstance().getReference("Userimage").child(usrid)
        storageReference.putFile(imageuri).addOnSuccessListener {
            storageReference.downloadUrl.addOnSuccessListener { uri ->
                val imageurl = uri.toString()
                val firebaseFirestore = FirebaseFirestore.getInstance()
                val usermapeimage = java.util.HashMap<String, String>()
                usermapeimage["imageUrl"] = imageurl
                usermapeimage["userId"] = usrid
                firebaseFirestore.collection("UserImagedata").document(usrid).set(usermapeimage)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            progressBar.visibility = View.GONE
                            Toast.makeText(
                                applicationContext,
                                "image uploaded Successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            progressBar.visibility = View.GONE
                            Toast.makeText(
                                applicationContext,
                                "error " + task.exception,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    }

    var GallaryResultlaunchre = registerForActivityResult(
        StartActivityForResult()){restults ->
        if(restults.resultCode == Activity.RESULT_OK)
        {

             imageuri = restults.data!!.data!!
            imageView.setImageURI(imageuri)
        }
    }
    var CamerResultLauncher = registerForActivityResult(
        StartActivityForResult()){restult ->
        if(restult.resultCode == Activity.RESULT_OK)
        {
            val bitmap =restult.data!!.extras!!["data"] as Bitmap?
            imageuri =converttoimageuri(bitmap,applicationContext)
            imageView.setImageBitmap(bitmap)

        }
    }

    private fun converttoimageuri(bitmap: Bitmap?, applicationContext: Context?): Uri {

//

        var ouptupstram = ByteArrayOutputStream()
        bitmap!!.compress(Bitmap.CompressFormat.PNG,100,ouptupstram)
        var path = MediaStore.Images.Media.insertImage(applicationContext!!.contentResolver,bitmap,"something","this is image")
        return Uri.parse(path)
    }


    fun conncetc()
    {
        imageView = findViewById(R.id.selectedimage)
        choosefromCamera = findViewById(R.id.choosefromcamera)
        chooseFromgallary = findViewById(R.id.choosefromgallary)
        uploadimagebtn = findViewById(R.id.upload_imagebtn)
        progressBar = findViewById(R.id.imageprogressbar)

        keyedit = findViewById(R.id.keyeidt)
        updatebtn = findViewById(R.id.updatebtn)
        valueedit = findViewById(R.id.valueeidt)
        deletebtn= findViewById(R.id.deletebtn)
    }
}