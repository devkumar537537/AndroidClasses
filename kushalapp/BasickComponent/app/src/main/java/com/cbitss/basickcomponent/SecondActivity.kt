package com.cbitss.basickcomponent


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class SecondActivity : AppCompatActivity() {
    lateinit var  listview:ListView
    var text="some"
    var numberlist = arrayOf("324324","34234234","667675","3453453","242342","45345345","235345345","4534534","324324","34234234","667675","3453453","242342","45345345","235345345","4534534","324324","34234234","667675","3453453","242342","45345345","235345345","4534534","324324","34234234","667675","3453453","242342","45345345","235345345","4534534","324324","34234234","667675","3453453","242342","45345345","235345345","4534534","324324","34234234","667675","3453453","242342","45345345","235345345","4534534")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        listview = findViewById(R.id.listview)

        var listadapter = ArrayAdapter<String>(applicationContext,R.layout.spinner_layout,numberlist)
        listview.adapter = listadapter

      listview.setOnItemClickListener(object : AdapterView.OnItemClickListener{
          override fun onItemClick(p0: AdapterView<*>?, p1: View?, postion: Int, p3: Long) {
              text = numberlist.get(postion)
              var popupmenuexaple = PopupMenu(this@SecondActivity,listview)
              popupmenuexaple.menuInflater.inflate(R.menu.contextmenufile,popupmenuexaple.menu)
              popupmenuexaple.show()
              popupmenuexaple.setOnMenuItemClickListener {
                  val id = it.itemId
                  when(id)
                  {
                      R.id.logutbtn ->{
                          Toast.makeText(applicationContext,"Log Out Clicked",Toast.LENGTH_SHORT).show()
                      }
                      R.id.updateprofitle ->{
                          Toast.makeText(applicationContext,"Update Clicked"+text,Toast.LENGTH_SHORT).show()
                      }
                      R.id.aboutbtn ->{
                          val cardintent = Intent(this@SecondActivity,CardVIewExample::class.java)
                          startActivity(cardintent)
                      }
                  }
                  true
              }

          }
      })

        registerForContextMenu(listview)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        when(id)
        {
            R.id.logutbtn ->{
                Toast.makeText(applicationContext,"Log Out Clicked",Toast.LENGTH_SHORT).show()
            }
            R.id.updateprofitle ->{
                Toast.makeText(applicationContext,"selected value "+text,Toast.LENGTH_SHORT).show()
            }
            R.id.aboutbtn ->{
               val cardintent = Intent(this@SecondActivity,CardVIewExample::class.java)
                startActivity(cardintent)
            }
        }
        return true
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.contextmenufile,menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when(id)
        {
            R.id.logutbtn ->{
                Toast.makeText(applicationContext,"Log Out Clicked",Toast.LENGTH_SHORT).show()
            }
            R.id.updateprofitle ->{
                Toast.makeText(applicationContext,"Update Clicked"+text,Toast.LENGTH_SHORT).show()
            }
            R.id.aboutbtn ->{
                val cardintent = Intent(this@SecondActivity,CardVIewExample::class.java)
                startActivity(cardintent)
            }
        }
        return true

    }

}