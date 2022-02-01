package com.batch12pm.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class CustomToast extends AppCompatActivity {
TextInputEditText editemail,editpasswrod;
ExtendedFloatingActionButton loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);

        connectxml();


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = editemail.getText().toString();
                String passwordtext = editpasswrod.getText().toString();
                String newone = emailtext+" "+passwordtext;


                Snackbar.make(loginbtn,newone,Snackbar.LENGTH_SHORT)
                        .setAction("Revers", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                View view = layoutInflater.inflate(R.layout.customtoastviewshsld,null);
                                TextView textView = view.findViewById(R.id.nameview);
                                textView.setText(newone);
                                Toast customtoast = new Toast(getApplicationContext());
                                customtoast.setDuration(Toast.LENGTH_SHORT);
                                customtoast.setGravity(Gravity.CENTER_HORIZONTAL,0,-400);
                                customtoast.setView(view);
                                customtoast.show();
                            }
                        }).show();


            }
        });
    }
    public void connectxml()
    {
        editemail = findViewById(R.id.emailedit);
        editpasswrod = findViewById(R.id.passwordedit);

        loginbtn = findViewById(R.id.loginfabbtn);
    }
}