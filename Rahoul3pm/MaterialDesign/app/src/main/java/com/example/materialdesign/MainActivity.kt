package com.example.materialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var button:ExtendedFloatingActionButton
    lateinit var emailedit:TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.floatingbtn)
        emailedit = findViewById(R.id.emailedit)

        button.setOnClickListener {
            var emaitlext = emailedit.text.toString()


            Snackbar.make(button,"email is $emaitlext",Snackbar.LENGTH_SHORT)
                .setAction("Revers", View.OnClickListener {
                    Toast.makeText(applicationContext,"this is toast",Toast.LENGTH_SHORT).show()
                })
                .show()
        }
    }
}