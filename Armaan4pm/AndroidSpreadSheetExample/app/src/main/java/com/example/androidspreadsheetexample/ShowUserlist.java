package com.example.androidspreadsheetexample;

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

public class ShowUserlist extends AppCompatActivity {
RecyclerView recyclerView;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_userlist);
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressbare);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        getList();
    }

    private void getList() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://script.google.com/macros/s/AKfycbz9qyzBylZ428EAyPpvvJiPOnods6ifNBfLSziiLstW53apHjoWNFJUWIN2bLzcw38MLw/exec?action=getItems",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       parseresponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ShowUserlist.this, "error"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        int soketTimeout = 50000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(soketTimeout,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue requestQueue = Volley.newRequestQueue(ShowUserlist.this);

        requestQueue.add(stringRequest);
    }

    private void parseresponse(String response) {
        ArrayList<EamilModels> arraylist = new ArrayList<>();
        JSONObject jobj = null;
        progressBar.setVisibility(View.GONE);

        try {
            jobj = new JSONObject(response);
            JSONArray  jsonArray = jobj.getJSONArray("items");

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jo = jsonArray.getJSONObject(i);
                EamilModels student = new EamilModels();
                student.setUsername(jo.getString("username"));
                student.setUserNumber(jo.getString("userNumber"));
                student.setUserId(jo.getString("userId"));
                student.setUserdate(jo.getString("userdate"));

                arraylist.add(student);
            }
            EmailAdapter emailAdapter = new EmailAdapter(arraylist,getApplicationContext());
            recyclerView.setAdapter(emailAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}