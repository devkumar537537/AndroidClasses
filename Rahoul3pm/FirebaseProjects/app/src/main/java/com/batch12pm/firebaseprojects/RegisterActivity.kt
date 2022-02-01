package com.batch12pm.firebaseprojects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
lateinit var numberedit:EditText
lateinit var emailedit:EditText
lateinit var passwordedit:EditText
lateinit var namedit:EditText
lateinit var signupbtn:Button
lateinit var registerbar:ProgressBar
lateinit var firebaseAuth: FirebaseAuth
lateinit var mydb:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        conncetxml()

        firebaseAuth = FirebaseAuth.getInstance()
        mydb = FirebaseFirestore.getInstance()

        signupbtn.setOnClickListener {
            var emailtext = emailedit.text.toString()
            var passwordtext = passwordedit.text.toString()
            var nametext = namedit.text.toString()
            var numbertext = numberedit.text.toString()

            if(TextUtils.isEmpty(emailtext)){
                emailedit.error ="emapty email"
            }else if(TextUtils.isEmpty(passwordtext))
            {
                passwordedit.error = "empty password"
            }else if(TextUtils.isEmpty(nametext))
            {
                namedit.error ="empty name"
            }else if(TextUtils.isEmpty(numbertext))
            {
                numberedit.error="number is empty"
            }else
            {
                registerbar.visibility = View.VISIBLE
                createuser(emailtext,passwordtext,nametext,numbertext)
            }

        }
    }

    private fun createuser(
        emailtext: String,
        passwordtext: String,
        nametext: String,
        numbertext: String
    ) {
                 firebaseAuth.createUserWithEmailAndPassword(emailtext,passwordtext).addOnCompleteListener {task->
                     if(task.isSuccessful)
                     {

                         var userid = firebaseAuth.currentUser!!.uid
                         var usermap:HashMap<String,String> = HashMap()

                         usermap.put("emailText",emailtext)
                         usermap.put("passwordText",passwordtext)
                         usermap.put("nameText",nametext)
                         usermap.put("numberText",numbertext)
                         usermap.put("userid",userid)


                         mydb.collection("FourPmDatabase").document(userid).set(usermap).addOnCompleteListener {task->
                             if(task.isSuccessful){
                                 registerbar.visibility =View.GONE
                                 Toast.makeText(applicationContext,"success create",Toast.LENGTH_SHORT).show()
                                 startActivity(Intent(applicationContext,HomeActivity::class.java))
                                 finish()

                             }else{
                                 registerbar.visibility =View.GONE
                                 Toast.makeText(applicationContext,"error "+task.exception,Toast.LENGTH_SHORT).show()
                             }
                         }

                     }else
                     {
                         registerbar.visibility =View.GONE
                         Toast.makeText(applicationContext,"error "+task.exception,Toast.LENGTH_SHORT).show()
                     }
                 }
    }

    fun conncetxml()
    {
        numberedit = findViewById(R.id.numberlayoutregister);
        emailedit = findViewById(R.id.emailayoutregister);
        passwordedit = findViewById(R.id.passwordlayotlayoutregister);
        namedit = findViewById(R.id.namelayoutregister);
        signupbtn = findViewById(R.id.signuptbtn);
        registerbar = findViewById(R.id.registerprogress);
    }
}