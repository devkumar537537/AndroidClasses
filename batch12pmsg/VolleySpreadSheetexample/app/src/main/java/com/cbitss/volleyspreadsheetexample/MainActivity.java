package com.cbitss.volleyspreadsheetexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText nameEdit,numberEdit;
    Button adddatabtn,shomovebtn;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindxml();

        adddatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  name_text = nameEdit.getText().toString().trim();
                String  numbet_text = numberEdit.getText().toString().trim();
                progressBar.setVisibility(View.VISIBLE);
                insertdata(name_text,numbet_text);
            }
        });
    }

    private void insertdata(String name_text, String numbet_text) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbyHXhUJuKtRc1zgXsQzeeliIMNmK83lGIkVKTNw1nuO3aMncvYXnGUtmARkL3ExDXtYQQ/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "response "+response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "error "+error, Toast.LENGTH_SHORT).show();
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> myvalues = new HashMap<>();
                myvalues.put("action","addItems");
                myvalues.put("username",name_text);
                myvalues.put("usernumber",numbet_text);
                return myvalues;

            }
        };
int socktimeout = 50000;
RetryPolicy retryPolicy  = new DefaultRetryPolicy(socktimeout,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
stringRequest.setRetryPolicy(retryPolicy);
RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
requestQueue.add(stringRequest);


    }

    private void bindxml() {
        nameEdit = findViewById(R.id.name);
        numberEdit = findViewById(R.id.number);
        adddatabtn = findViewById(R.id.insertdata);
        progressBar = findViewById(R.id.progress_insert);
        shomovebtn = findViewById(R.id.move_to_detaillist);

    }
}