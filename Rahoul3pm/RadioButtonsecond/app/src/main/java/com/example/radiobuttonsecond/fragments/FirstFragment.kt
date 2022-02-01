package com.example.radiobuttonsecond.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.radiobuttonsecond.R


class FirstFragment : Fragment() {
lateinit var movetosecond: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movetosecond = view.findViewById(R.id.movetosecondbtn)
        movetosecond.setOnClickListener {

            var emailtext = "abc@gmail.com"
            var nametext = "abc@124"
            var fragement: Fragment = SecondFragmet()
            var bundle= Bundle()
            bundle.putString("email",emailtext)
            bundle.putString("name",nametext)
            fragement.arguments = bundle


            var fragmentmanage = parentFragmentManager
            var fragmenttransciton = fragmentmanage!!.beginTransaction()
            fragmenttransciton.replace(R.id.fragmentcontainer,fragement)
            fragmenttransciton.addToBackStack(null)
            fragmenttransciton.commit()
        }
    }

}