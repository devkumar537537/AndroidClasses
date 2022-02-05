package com.example.googlespreasheeexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.util.HashMap

class MainActivity : AppCompatActivity() {
    lateinit var nameEdit:EditText
    lateinit var numberEdit:EditText
    lateinit var adddatabtn:Button
    lateinit var progressBar:ProgressBar
    lateinit var shomovebtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindxml()
        adddatabtn.setOnClickListener {
            var namtext = nameEdit.text.toString()
            var numbertext = numberEdit.text.toString()
            insertdata(namtext,numbertext)
        }
        shomovebtn.setOnClickListener {
            startActivity(Intent(this@MainActivity,MyPasswordlist::class.java))
        }
    }

    private fun insertdata(namtext: String, numbertext: String) {
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST,
            "https://script.google.com/macros/s/AKfycbxCraFOxZ6tyecjd2V_2XQg-CGJEsUmc0olDVXmtvo_5VOclA94E-Ot3We2be2aMUhbwA/exec",
            Response.Listener { response ->
                progressBar.visibility = View.GONE
                Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { error ->
                progressBar.visibility = View.GONE
                Toast.makeText(
                    this@MainActivity,
                    "error " + error.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            override fun getParams(): Map<String, String>? {
                val values: MutableMap<String, String> = HashMap()
                values.put("action","addItems")
                values.put("username",namtext)
                values.put("userpassword",numbertext)
                return values
            }
        }


        val soketimeout = 50000

        val retryPolicy: RetryPolicy =
            DefaultRetryPolicy(soketimeout, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        stringRequest.retryPolicy = retryPolicy
        val requestQueue = Volley.newRequestQueue(this@MainActivity)

        requestQueue.add(stringRequest)

    }

    private fun bindxml() {
        nameEdit = findViewById(R.id.name)
        numberEdit = findViewById(R.id.password)
        adddatabtn = findViewById(R.id.insertdata)
        progressBar = findViewById(R.id.progress_insert)
        shomovebtn = findViewById(R.id.move_to_detaillist)
    }
}