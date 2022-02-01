package com.batch12pm.firebaseprojects

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import java.util.jar.Manifest

class HomeActivity : AppCompatActivity() {
    lateinit var nameview:TextView
    lateinit var numberview:TextView
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var userlist:MutableList<MyUserMOdel>
    lateinit var imagelist:MutableList<ImageModel>
    lateinit var imageView:ImageView
    private val TAG = "HomeActivity"
    var permissons = arrayOf(android.Manifest.permission.CAMERA,android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE,android.Manifest.permission.INTERNET)
    var permissioncode= 345
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        nameview = findViewById(R.id.nameview)
        numberview = findViewById(R.id.numberview)
        imageView = findViewById(R.id.imageview)
        userlist = ArrayList<MyUserMOdel>()
        imagelist = ArrayList<ImageModel>()
        firebaseAuth = FirebaseAuth.getInstance()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if(ContextCompat.checkSelfPermission(applicationContext,android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(permissons,permissioncode)
            }
        }
        fetchsingldata()

        fetchdatainlist()

        fetchingimage()
        fetchimageinlist()
    }

    private fun fetchimageinlist() {

        var db = FirebaseFirestore.getInstance()
        db.collection("UserImagedata").get().addOnCompleteListener { quersnapshot->

            if(quersnapshot.isSuccessful) {
                for(document in quersnapshot.result!!) {

                    var myimageMOdel:ImageModel =document.toObject(ImageModel::class.java)
                    imagelist.add(myimageMOdel)
                }

                //print or make object of your recycle adpter


                for(usermode in imagelist)
                {
                    Log.e(TAG, "userid is ${usermode.userId} and image is ${usermode.imageUrl}  " )
                }

            }else {
                Toast.makeText(applicationContext,"error ${quersnapshot.exception}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchingimage() {
          var userid = firebaseAuth.currentUser!!.uid
        var db = FirebaseFirestore.getInstance()
        db.collection("UserImagedata").document(userid).get().addOnSuccessListener { documentsnapshot ->
            var document = documentsnapshot.data
            if(document != null)
            {
                var imagestring = document.get("imageUrl").toString()
                Glide.with(applicationContext).load(imagestring).into(imageView)
            }
        }
    }

    private fun fetchdatainlist() {
        var alldocument = FirebaseFirestore.getInstance();
        alldocument.collection("FourPmDatabase").get().addOnCompleteListener(OnCompleteListener { task ->
            if(task.isSuccessful) {
                for(document in task.result!!) {

                var myUserMOdel:MyUserMOdel =document.toObject(MyUserMOdel::class.java)
                userlist.add(myUserMOdel)
                }

                //print or make object of your recycle adpter


                for(usermode in userlist)
                {
                    Log.e(TAG, "name is ${usermode.nameText} and emai is ${usermode.emailText}  " )
                }

            }else {
               Toast.makeText(applicationContext,"error ${task.exception}",Toast.LENGTH_SHORT).show()
            }
        })


        }


    private fun fetchsingldata() {
        var userid = firebaseAuth.currentUser!!.uid
        var firebasefirestore = FirebaseFirestore.getInstance()
            firebasefirestore.collection("FourPmDatabase").document(userid).get().addOnSuccessListener { documentsnapshot->

                var document = documentsnapshot.data
                if(document != null)
            {
                  var name = document.get("nameText").toString()

                var number = document.get("numberText").toString()

                nameview.text = name
                numberview.text = number
            }else
            {
                Toast.makeText(applicationContext,"empty data",Toast.LENGTH_SHORT).show()
            }


        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionsmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        when(id)
        {
            R.id.logoutbtn->{
                firebaseAuth.signOut()
                startActivity(Intent(applicationContext,LOgInActivity::class.java))
                finish()
            }
            R.id.updatedetailbtn->{
                startActivity(Intent(applicationContext,UpdateActivyt::class.java))
            }
        }
        return true
    }
}