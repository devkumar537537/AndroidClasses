package com.cbitss.basickcomponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.cbitss.basickcomponent.R


class FirstFragment : Fragment() {

lateinit var movebtn:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movebtn =view.findViewById(R.id.movetosecond)

        movebtn.setOnClickListener {

            val email = "abc@gmail.com"
             val fragment = SecondFragment()
             val bundle = Bundle()
            bundle.putString("myemail",email)
            fragment.arguments = bundle

            val fragmentmanager = parentFragmentManager
            val fragmenttransction = fragmentmanager.beginTransaction()
            fragmenttransction.replace(R.id.fragmentcontainer,fragment)
            fragmenttransction.commit()
        }
    }
}