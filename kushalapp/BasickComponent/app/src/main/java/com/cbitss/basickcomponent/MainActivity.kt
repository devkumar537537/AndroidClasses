package com.cbitss.basickcomponent

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var pickcity:Button
    lateinit var cityview:TextView
    lateinit var cityspinner:Spinner
var selectedcity="right"
    var citylist = arrayOf("Ambala","Mohali","Chandigarh","Panchkula","Zirakpur","Derabassi","Nvaganv","Dhnas","Ambala","Mohali","Chandigarh","Panchkula","Zirakpur","Derabassi","Nvaganv","Dhnas")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickcity = findViewById(R.id.pickcitname)
        cityview = findViewById(R.id.selectedcity)
        cityspinner = findViewById(R.id.cityselecter)


        val arrayadapter = ArrayAdapter<String>(applicationContext,R.layout.spinner_layout,citylist)
        arrayadapter.setDropDownViewResource(R.layout.spinner_layout)
       cityspinner.adapter = arrayadapter
cityspinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        selectedcity = citylist.get(position)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

})


        pickcity.setOnClickListener {
            cityview.text = selectedcity
        }




    }
}