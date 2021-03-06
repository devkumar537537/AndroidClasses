package com.example.androidspreadsheeexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
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
            public void onClick(View v) {
                String  name_text = nameEdit.getText().toString().trim();
                String  numbet_text = numberEdit.getText().toString().trim();
                progressBar.setVisibility(View.VISIBLE);
                insertdata(name_text,numbet_text);
            }
        });
        shomovebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Studentlist.class));
            }
        });
    }

    private void insertdata(String name_text, String numbet_text) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbwlniG4q6LMBQMt788aU_Iw9AH4Mp9pGYBsX2yfjI2Y5N8WfRp2EgHMmNhmKI0oF1_Wxw/exec"
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "erroro "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> params = new HashMap<>();
                params.put("action","addItem");
                params.put("name",name_text);
                params.put("number",numbet_text);
                return params;
            }
        };

        int soketTimeout = 50000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(soketTimeout,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

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