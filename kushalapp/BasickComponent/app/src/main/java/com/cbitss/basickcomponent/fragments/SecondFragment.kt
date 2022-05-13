package com.cbitss.basickcomponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cbitss.basickcomponent.R

class SecondFragment : Fragment() {
lateinit var textview:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textview = view.findViewById(R.id.textviewsecond)
        if(arguments != null)
        {
           var emailvalue = requireArguments().getString("myemail")
            textview.text = emailvalue
        }
    }
}