package com.example.radiobuttonsecond

import android.content.Intent
import android.graphics.RadialGradient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.radiobuttonsecond.fragments.FirstFragment

class MainActivity : AppCompatActivity() {
    var questions = arrayOf("Who is the primeminister of India ?")
    var firstoptions = arrayOf("Paranab Mukerg")
    var seconoptions = arrayOf("Narendra Modi")
    var thirdoptions = arrayOf("Nehru")
    var fourthptions = arrayOf("Rahoul Gandhi")
    var rightoptions = arrayOf("Narendra Modi")

    lateinit var optA:RadioButton
    lateinit var optb:RadioButton
    lateinit var optc:RadioButton
    lateinit var optd:RadioButton
    lateinit var optr:RadioButton
    lateinit var grouptquestion: RadioGroup
    lateinit var questionview:TextView
    lateinit var clickbtn:Button
    lateinit var movebtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connctxml()
        createoptionmenu()

        //first fragment open
        var fragmentManager = supportFragmentManager
        var fragemnttransction  = fragmentManager.beginTransaction()
        fragemnttransction.add(R.id.fragmentcontainer,FirstFragment())
        fragemnttransction.commit()

movebtn.setOnClickListener {
    var emailtext = "abc@gmail.com"
    var nametext = "abc@124"
    var intetnt = Intent(applicationContext,SecondActivity::class.java)
    intetnt.putExtra("email",emailtext)
    intetnt.putExtra("name",nametext)

    startActivity(intetnt)
}

    }
private fun createoptionmenu()
{
    //setting content on options and questions
    questionview.text = questions[0]
    optA.text = firstoptions[0]
    optb.text = seconoptions[0]
    optc.text = thirdoptions[0]
    optd.text = fourthptions[0]


    clickbtn.setOnClickListener {
        var id = -1;
        id = grouptquestion.checkedRadioButtonId
        if(id >0)
        {
            optr = findViewById(id)
            var responsetext = optr.text.toString()
            if(responsetext.equals(rightoptions[0]))
            {
                Toast.makeText(applicationContext,"You are right",Toast.LENGTH_SHORT).show()
            }else
            {
                Toast.makeText(applicationContext,"You are wrong",Toast.LENGTH_SHORT).show()
            }

        }else
        {
            Toast.makeText(applicationContext,"select option first",Toast.LENGTH_SHORT).show()
        }

    }
}
    private fun connctxml() {

        optA = findViewById(R.id.firstoptionbtn)
        optb = findViewById(R.id.secondoptionbtn)
        optc = findViewById(R.id.thirdoptionbtn)
        optd = findViewById(R.id.fourthoptionbtn)
        grouptquestion = findViewById(R.id.qustiongroup)
        clickbtn = findViewById(R.id.checkbtn)
        questionview = findViewById(R.id.sampltext)
        movebtn = findViewById(R.id.movetosecondactivity)
    }
}