package com.example.sharedpreferenceinkotlinrahoulr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var insertbtn: Button
    lateinit var showbtn: Button
    lateinit var deleltbtn: Button
    lateinit var movetorecyclerview: Button
    lateinit var showtext: TextView
    lateinit var editvalue: EditText
    lateinit var editkey: EditText
    lateinit var keytext: String
    lateinit var sharedoperation :SharePreferenceOperation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       connectxml()
      sharedoperation = SharePreferenceOperation(applicationContext)
       insertbtn.setOnClickListener {
           keytext = editkey.text.toString()
           val valuetext = editvalue.text.toString()
           sharedoperation.insetvalue(keytext,valuetext)
       }
        showbtn.setOnClickListener {
            keytext = editkey.text.toString()
              var res = sharedoperation.showvalue(keytext)
            showtext.text = res
        }

        deleltbtn.setOnClickListener {
            keytext  = editkey.text.toString()
            sharedoperation.deletekey(keytext)
        }
    }

    private fun connectxml() {

        insertbtn = findViewById(R.id.insertbtn)
        showbtn = findViewById(R.id.Showbtn)
        showtext = findViewById(R.id.valuetextview)
        editvalue = findViewById(R.id.value)
        editkey = findViewById(R.id.keyedit)
        deleltbtn = findViewById(R.id.deletebtn)
        movetorecyclerview = findViewById(R.id.movetoanotherbtn)
    }
}