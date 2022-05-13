package com.cbitss.myfirstapplicationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var datePicker: DatePicker
    lateinit var datepickerbtn:Button
    lateinit var datetextview:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        connectXml()
        workingoflisteners()
    }

    private fun workingoflisteners() {
        datepickerbtn.setOnClickListener {
            var datetext =getDate()
            datetextview.text = datetext
        }
    }

    fun getDate():String{
        var date = datePicker.dayOfMonth
        var month = datePicker.month+1
        var year = datePicker.year

        return "Update Date $date:$month:$year"
    }
    fun connectXml()
    {
        datePicker = findViewById(R.id.datepickerlayout)
        datepickerbtn = findViewById(R.id.datepickerbtn)
        datetextview = findViewById(R.id.thirdtextiveiw)
    }
}