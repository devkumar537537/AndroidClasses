package com.example.sqlitinkotlin

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText

    lateinit  var surname: EditText

    lateinit  var marks: EditText
    lateinit   var idedit: EditText
    lateinit  var insertbtn: Button
    lateinit var showbtn: Button
    lateinit var deletebtn: Button
    lateinit var updatebtn: Button
    private lateinit var sqliteHelperClass:SQliteHelperClass
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindview()

        sqliteHelperClass = SQliteHelperClass(applicationContext)
        insertbtn.setOnClickListener {
            val name_text = name.text.toString()
            val surnamet_text = surname.text.toString()
            val marks_text = marks.text.toString()
            insertvalues(name_text, surnamet_text, marks_text)
        }
        showbtn.setOnClickListener {
            showdata()
        }
        updatebtn.setOnClickListener {
            val name_text = name.text.toString()
            val surnamet_text = surname.text.toString()
            val marks_text = marks.text.toString()
            val userid = idedit.text.toString()
            updatevalues(name_text, surnamet_text, marks_text, userid)
        }
        deletebtn.setOnClickListener {
            val userid = idedit.text.toString()
            deletdata(userid)
        }
    }

    private fun deletdata(userid: String) {

        var restulr = sqliteHelperClass.deletedata(userid)
        if (restulr) {
            Toast.makeText(applicationContext, "value deleted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "value deletion failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updatevalues(
        nameText: String,
        surnametText: String,
        marksText: String,
        userid: String
    ) {

        var result = sqliteHelperClass.updatedata(userid,nameText,surnametText,marksText)
        if (result) {
            Toast.makeText(applicationContext, "value updated", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "value updation failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showdata() {
        var cursor = sqliteHelperClass.getalldata()
        if (cursor.count == 0) {
            showdialog("Error","No data found !")

        }else
        {


            var stringBuilder = StringBuilder()
            while (cursor.moveToNext())
            {
                stringBuilder.append(" Id is => ${cursor.getString(0)} \n")
                stringBuilder.append(" name is => ${cursor.getString(1)} \n")
                stringBuilder.append(" surname is => ${cursor.getString(2)} \n")
                stringBuilder.append("marks  is =>   ${cursor.getString(3)} \n\n")
            }
            textView.text = stringBuilder
        }

    }
fun showdialog(title:String,descripti:String){
    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
    builder.setMessage(descripti)
    builder.setCancelable(true)
    builder.show()
}
    private fun insertvalues(nameText: String, surnametText: String, marksText: String) {
        val res: Boolean = sqliteHelperClass.insertvalues(nameText,surnametText,marksText)
        if (res) {
            Toast.makeText(applicationContext, "value inserted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "value insertion failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun bindview() {
        name = findViewById(R.id.student_name)
        surname = findViewById(R.id.student_surnmae)
        marks = findViewById(R.id.student_marks)
        insertbtn = findViewById(R.id.insert_btn)
        showbtn = findViewById(R.id.Show_btn)
        idedit = findViewById(R.id.student_id)
        updatebtn = findViewById(R.id.updatebtn)
        deletebtn = findViewById(R.id.deletebtn)
        textView = findViewById(R.id.textview)
    }
}