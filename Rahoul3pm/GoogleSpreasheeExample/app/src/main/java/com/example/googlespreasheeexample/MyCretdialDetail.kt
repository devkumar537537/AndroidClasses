package com.example.googlespreasheeexample

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

class MyCretdialDetail : AppCompatActivity() {

  lateinit  var editname: EditText
    lateinit   var editnumber:EditText
    lateinit   var editid:EditText
    lateinit  var editdate:EditText
    lateinit  var updatebtn: Button
    lateinit var deletebtn:Button

    lateinit  var item: Item
    lateinit  var detailProgressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cretdial_detail)
      bindviews()
      getdata()
      updatviews()
      updatebtn.setOnClickListener {
        detailProgressBar.visibility = View.VISIBLE
        updatedata()
      }
      deletebtn.setOnClickListener {
        detailProgressBar.visibility = View.VISIBLE
        deletedata()
      }
    }
  private fun deletedata() {
    val idText = editid.text.toString()
    val stringRequest = StringRequest(
      Request.Method.GET,
      "https://script.google.com/macros/s/AKfycbxCraFOxZ6tyecjd2V_2XQg-CGJEsUmc0olDVXmtvo_5VOclA94E-Ot3We2be2aMUhbwA/exec?action=delete&id=$idText",
      { response ->
        detailProgressBar.visibility = View.GONE
        Toast.makeText(this@MyCretdialDetail, response, Toast.LENGTH_SHORT).show()
      }
    ) { error ->
      detailProgressBar.visibility = View.GONE
      Toast.makeText(
        this@MyCretdialDetail,
        "errror " + error.localizedMessage,
        Toast.LENGTH_SHORT
      ).show()
    }
    val soketimeout = 50000
    val retryPolicy: RetryPolicy =
      DefaultRetryPolicy(soketimeout, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
    stringRequest.retryPolicy = retryPolicy
    val requestQueue = Volley.newRequestQueue(this@MyCretdialDetail)
    requestQueue.add(stringRequest)
  }

  private fun updatedata() {
    val email_text = editname.text.toString()
    val number_text = editnumber.text.toString()
    val id_text = editid.text.toString()
    val date_text = editdate.text.toString()
    val stringRequest: StringRequest = object : StringRequest(
      Method.POST,
      "https://script.google.com/macros/s/AKfycbxCraFOxZ6tyecjd2V_2XQg-CGJEsUmc0olDVXmtvo_5VOclA94E-Ot3We2be2aMUhbwA/exec",
      Response.Listener { response ->
        detailProgressBar.visibility = View.GONE
        Toast.makeText(this@MyCretdialDetail, response, Toast.LENGTH_SHORT).show()
      },
      Response.ErrorListener { error ->
        detailProgressBar.visibility = View.GONE
        Toast.makeText(
          this@MyCretdialDetail,
          "errror " + error.localizedMessage,
          Toast.LENGTH_SHORT
        ).show()
      }
    ) {
      @Throws(AuthFailureError::class)
      override fun getParams(): Map<String, String>? {
        val params: MutableMap<String, String> = HashMap()
        params["action"] = "update"
        params["username"] = email_text
        params["userpassword"] = number_text
        params["id"] = id_text
        params["date"] = date_text
        return params
      }
    }
    val soketimeout = 50000
    val retryPolicy: RetryPolicy =
      DefaultRetryPolicy(soketimeout, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
    stringRequest.retryPolicy = retryPolicy
    val requestQueue = Volley.newRequestQueue(this@MyCretdialDetail)
    requestQueue.add(stringRequest)
  }

  private fun updatviews() {
    editname.setText(item.username)
    editnumber.setText(item.userpassword)
    editid.setText(item.userId)
    editdate.setText(item.userdate)
  }

  private fun getdata() {
    if (intent != null) {
      item = (intent.getSerializableExtra("myname") as Item)
    }
  }
  private fun bindviews() {
    editname = findViewById(R.id.updateemail)
    editnumber = findViewById(R.id.update_user_number)
    detailProgressBar = findViewById(R.id.detail_progressbar)
    updatebtn = findViewById(R.id.update_btn)
    deletebtn = findViewById(R.id.delete_btn)
    editid = findViewById(R.id.update_user_id)
    editdate = findViewById(R.id.update_user_date)
  }
}