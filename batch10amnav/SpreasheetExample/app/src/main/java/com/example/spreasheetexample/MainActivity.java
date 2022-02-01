package com.example.spreasheetexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
        startActivity(new Intent(MainActivity.this,MyPasswordlist.class));
    }
});
    }

    private void insertdata(String name_text, String numbet_text) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbxOQ-A_egwFNSWYD1KJUpXevpPSmGg4ZF3kaWTHKr5e-0p8X5PdgMPFREGTqw2Nzo5j/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "error "+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> values = new HashMap<>();
                values.put("action","addItems");
                values.put("username",name_text);
                values.put("userpassword",numbet_text);
                return values;
            }
        };


        int soketimeout= 50000;

        RetryPolicy retryPolicy = new DefaultRetryPolicy(soketimeout,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

        requestQueue.add(stringRequest);

    }

    private void bindxml() {
        nameEdit = findViewById(R.id.name);
        numberEdit = findViewById(R.id.password);
        adddatabtn = findViewById(R.id.insertdata);
        progressBar = findViewById(R.id.progress_insert);
        shomovebtn = findViewById(R.id.move_to_detaillist);

    }
}