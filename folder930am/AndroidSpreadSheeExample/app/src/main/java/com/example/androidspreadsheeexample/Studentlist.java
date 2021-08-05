package com.example.androidspreadsheeexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Studentlist extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist);
        recyclerView = findViewById(R.id.userlisrtrecyclerview);
        progressBar = findViewById(R.id.progressbare);
        progressBar.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        getlist();
    }

    private void getlist() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET
                , "https://script.google.com/macros/s/AKfycbw22g0A33atIyhSWWl9mICR_2HACYxjHf_d7REd4TYIN0rtDUDagIrTLDgBpHVWvjubxQ/exec?action=getItems"
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parsresponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(Studentlist.this, "error"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        int soketTimeout = 50000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(soketTimeout,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue requestQueue = Volley.newRequestQueue(Studentlist.this);
        requestQueue.add(stringRequest);
    }

    private void parsresponse(String response) {

        ArrayList<EamilModels> arraylist = new ArrayList<>();
        JSONObject jobj = null;

        try {
            jobj = new JSONObject(response);

            JSONArray jsonArray = jobj.getJSONArray("items");

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jo = jsonArray.getJSONObject(i);

                EamilModels student = new EamilModels();
                student.setDate(jo.getString("date"));
                student.setID(jo.getString("Id"));
                student.setName(jo.getString("name"));
                student.setNumber(jo.getString("number"));


                arraylist.add(student);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        progressBar.setVisibility(View.GONE);
        EmailAdapter studentAdapter = new EmailAdapter(arraylist,getApplicationContext());

        recyclerView.setAdapter(studentAdapter);

    }
}