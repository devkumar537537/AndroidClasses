package com.example.texttospeechinkotlin

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.util.*

class MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener {
    lateinit var textedit: EditText
    lateinit var movetoother: Button
    lateinit var convertbtn: Button
    lateinit var toSpeech: TextToSpeech
    var perms = arrayOf(Manifest.permission.INTERNET, Manifest.permission.RECORD_AUDIO)
    var permissionconstan = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectviews()
toSpeech = TextToSpeech(this,this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.RECORD_AUDIO
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(perms, permissionconstan)
            }
        }

        convertbtn.setOnClickListener {
            var speechtext= textedit.text.toString()
            speakout(speechtext)
        }
        movetoother.setOnClickListener {
            startActivity(Intent(applicationContext,SpeechToText::class.java))

        }
    }

    private fun speakout(speechtext: String) {
        toSpeech.speak(speechtext,TextToSpeech.QUEUE_FLUSH,null,null)
    }

    private fun connectviews() {
        textedit = findViewById(R.id.speech_Text_edit)
        movetoother = findViewById(R.id.speechtotextmove)
        convertbtn = findViewById(R.id.covert_btn)
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {


            var result = toSpeech.setLanguage(Locale.UK)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(applicationContext, "Language is not supported", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}