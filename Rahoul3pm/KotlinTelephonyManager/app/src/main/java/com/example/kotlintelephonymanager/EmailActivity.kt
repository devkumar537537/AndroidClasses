package com.example.kotlintelephonymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText

class EmailActivity : AppCompatActivity() {
    lateinit var sendemail:Button
    lateinit var receiveremail:EditText
    lateinit var subjecttext:EditText
    lateinit var mssage:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        sendemail = findViewById<Button>(R.id.send_email)
        receiveremail = findViewById<EditText>(R.id.receiver_email)
        subjecttext = findViewById<EditText>(R.id.email_subject)
        mssage = findViewById<EditText>(R.id.email_body)

        sendemail.setOnClickListener {

            val email_text = receiveremail.text.toString()
            val subject_text = subjecttext.text.toString()
            val message_text = mssage.text.toString()

            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf(email_text))
            email.putExtra(Intent.EXTRA_SUBJECT, subject_text)
            email.putExtra(Intent.EXTRA_TEXT, message_text)
            email.type = "message/rfc822"

            startActivity(Intent.createChooser(email, "Choose an Email client :"))
        }
    }
}