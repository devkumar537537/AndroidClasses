package com.cbitss.myfirstapplicationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editValue:EditText
    lateinit var clickButton:Button
    lateinit var textResult:TextView
    lateinit var movetonext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editValue = findViewById(R.id.valuedit)
        clickButton =findViewById(R.id.clickbtn)
          textResult =findViewById(R.id.resutl)
        movetonext =findViewById(R.id.movetonext)
        movetonext.setOnClickListener {
            var intent = Intent(this@MainActivity,SecondActivity::class.java)
            startActivity(intent)
        }

        clickButton.setOnClickListener {
            var textValue = editValue.text.toString()
              var value =  textValue.toInt()
            var sum =0
            for(i in 1..value)
            {
                sum += i
            }

            textResult.text=" $sum"
        }
    }
}