package com.cbitss.basickcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.cbitss.basickcomponent.fragments.FirstFragment
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.snackbar.Snackbar

class CardVIewExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view_example)


        //Fragement open code
        val fragmentManager = supportFragmentManager
        val fragmenttrasction = fragmentManager.beginTransaction()
        fragmenttrasction.add(R.id.fragmentcontainer,FirstFragment())
        fragmenttrasction.commit()
    }
}