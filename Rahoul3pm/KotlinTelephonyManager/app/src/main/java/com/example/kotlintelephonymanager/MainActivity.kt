package com.example.kotlintelephonymanager

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    lateinit var callbtn: Button
    lateinit var numberedit:EditText
    lateinit var movetosms:Button
    lateinit var movetoemail:Button
var permissons = arrayOf(android.Manifest.permission.CALL_PHONE,android.Manifest.permission.READ_SMS,android.Manifest.permission.SEND_SMS,android.Manifest.permission.INTERNET)
    var permissioncode= 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectxml()
        callbtn.setOnClickListener {
            val number_text = numberedit.text.toString()
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(permissons,permissioncode)
            } else {


                val callintent = Intent(Intent.ACTION_CALL)
                callintent.data = Uri.parse("tel:$number_text")
                startActivity(callintent)
            }

        }

movetoemail.setOnClickListener {
    startActivity(Intent(applicationContext,EmailActivity::class.java))
}

        movetosms.setOnClickListener {
            startActivity(Intent(applicationContext,SMSActivity::class.java))
        }
    }
    fun connectxml() {
        callbtn = findViewById<Button>(R.id.sendCall)
        numberedit = findViewById<EditText>(R.id.usern_number)
        movetosms = findViewById<Button>(R.id.move_t0_sms)
        movetoemail = findViewById<Button>(R.id.move_to_email)
    }
}