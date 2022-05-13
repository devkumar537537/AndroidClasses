package com.cbitss.anotherprojectrestapi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class ShowAllUser extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Item> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_user);
        recyclerView = findViewById(R.id.userrecyclerview);
        userlist =new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        showuserlist();
    }

    private void showuserlist() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://script.google.com/macros/s/AKfycbyHXhUJuKtRc1zgXsQzeeliIMNmK83lGIkVKTNw1nuO3aMncvYXnGUtmARkL3ExDXtYQQ/exec?action=getItems", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parsresponse(response);
                Toast.makeText(ShowAllUser.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "error => "+error.networkResponse, Toast.LENGTH_SHORT).show();
            }
        });

        int socktimeout = 50000;
        RetryPolicy retryPolicy  = new DefaultRetryPolicy(socktimeout,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        RequestQueue requestQueue = Volley.newRequestQueue(ShowAllUser.this);
        requestQueue.add(stringRequest);
    }

    private void parsresponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);

            JSONArray jsonArray = jsonObject.getJSONArray("items");
            for(int i =0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Item item = new Item();
                item.setUserDate(jsonObject1.getString("userDate"));
            item.setUserName(jsonObject1.getString("userName"));
            item.setUserId(jsonObject1.getString("userId"));
            item.setUserNumber(jsonObject1.getString("userNumber"));
            userlist.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        MyPasswordAdapter myPasswordAdapter =new MyPasswordAdapter(userlist,getApplicationContext());
        recyclerView.setAdapter(myPasswordAdapter);
    }
}