package com.example.googlespreasheeexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class MyPasswordlist : AppCompatActivity() {
  lateinit  var recyclerView: RecyclerView
   lateinit var userlist: ArrayList<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_passwordlist)
        recyclerView = findViewById(R.id.userrecyclerview)
        userlist = ArrayList()
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager
        showuserlist()
    }

    private fun showuserlist() {
        val stringRequest = StringRequest(
            Request.Method.GET,
            "https://script.google.com/macros/s/AKfycbxCraFOxZ6tyecjd2V_2XQg-CGJEsUmc0olDVXmtvo_5VOclA94E-Ot3We2be2aMUhbwA/exec?action=getItems",
            { response ->
                parsresponse(response)
                Toast.makeText(this@MyPasswordlist, response, Toast.LENGTH_SHORT).show()
            }
        ) { error ->
            Toast.makeText(
                applicationContext,
                "error " + error.message,
                Toast.LENGTH_SHORT
            ).show()
        }
        val soketimeout = 50000
        val retryPolicy: RetryPolicy =
            DefaultRetryPolicy(soketimeout, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        stringRequest.retryPolicy = retryPolicy
        val requestQueue = Volley.newRequestQueue(this@MyPasswordlist)
        requestQueue.add(stringRequest)
    }

    private fun parsresponse(response: String) {
        try {
            val jsonObject = JSONObject(response)

            val jsonArray = jsonObject.getJSONArray("items")
            for (i in 0 until jsonArray.length()) {
                val jsonObject1 = jsonArray.getJSONObject(i)
                val item = Item()
                item.userdate=jsonObject1.getString("userdate")
                item.username = jsonObject1.getString("username")
                item.userId = jsonObject1.getString("userId")
                item.userpassword =jsonObject1.getString("userpassword")
                userlist.add(item)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val myPasswordAdapter = MyPasswordAdapter(
            userlist,
            applicationContext
        )
        recyclerView.adapter = myPasswordAdapter
    }
}