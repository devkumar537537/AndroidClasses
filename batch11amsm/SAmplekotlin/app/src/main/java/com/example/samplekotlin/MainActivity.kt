package com.example.samplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editemail:EditText
    lateinit var passwor:EditText
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
editemail = findViewById(R.id.email)
        passwor = findViewById(R.id.password)
        button = findViewById(R.id.loginbtn)

        button.setOnClickListener {
            var emailtext = editemail.text.toString()
            var passwordtext = passwor.text.toString()

            Toast.makeText(applicationContext,"errro ${emailtext} and ${passwordtext}",Toast.LENGTH_LONG).show()

        }


    }
}