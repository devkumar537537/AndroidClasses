package com.example.radiobuttonsecond.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.radiobuttonsecond.R


class SecondFragmet : Fragment() {
lateinit var textView: TextView
lateinit var emailvale:String
lateinit var namevalue:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_fragmet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.sampletwo)

       emailvale =  requireArguments().getString("email")!!
        namevalue = requireArguments().getString("name")!!

        textView.text = " $emailvale \n $namevalue"
    }
}