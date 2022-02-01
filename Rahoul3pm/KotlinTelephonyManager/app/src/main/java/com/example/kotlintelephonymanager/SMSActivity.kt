package com.example.kotlintelephonymanager

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SMSActivity : AppCompatActivity() {

    lateinit var numberedit:EditText
    lateinit var messageedit:EditText
    lateinit var sendsmsbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smsactivity)

        numberedit = findViewById<EditText>(R.id.user_sms_number)
        messageedit = findViewById<EditText>(R.id.sms_body)
        sendsmsbtn = findViewById<Button>(R.id.send_sms_btn)

        sendsmsbtn.setOnClickListener {
            var numbertext = numberedit.text.toString()
            var messagetext = messageedit.text.toString()

//            val intent = Intent(this@SMSActivity, MainActivity::class.java)
//
//            val sms = SmsManager.getDefault()
//            val pendingIntent = PendingIntent.getActivity(
//                applicationContext,
//                requestcode,
//                intent,
//                PendingIntent.FLAG_UPDATE_CURRENT
//            )
//            sms.sendTextMessage(number_text, null, message_text, pendingIntent, null)
//            Toast.makeText(applicationContext, "sms sended", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@SMSActivity,MainActivity::class.java)

            val smsintent = PendingIntent.getActivity(applicationContext,234,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            var smsmanager = SmsManager.getDefault()
            smsmanager.sendTextMessage(numbertext,null,messagetext,smsintent,null)
            Toast.makeText(applicationContext,"message send successfully",Toast.LENGTH_SHORT).show()
        }
    }
}