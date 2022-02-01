package com.example.parallaxeeffectinkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText


class BottomSheetExample : BottomSheetDialogFragment() {

    lateinit var editText: EditText
    lateinit var button: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.bottomsheet,container,false)
        editText = view.findViewById(R.id.emailedit)
        button = view.findViewById(R.id.submitbtnbottom)

        button.setOnClickListener {

            var  emailtext = editText.text.toString()
            Toast.makeText(context,"email is "+emailtext,Toast.LENGTH_SHORT).show()

        }

        return view
    }
}